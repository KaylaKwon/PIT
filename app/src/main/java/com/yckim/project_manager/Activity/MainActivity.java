/**
 * @author Ben Pitts
 * Timeline Calendar project from CS495 (Android app development)
 * Won't do much in emulator, as it needs calendar data and multitouch.
 * email me if you do anything cool with this idea: methodermis@gmail.com
 */
package com.yckim.project_manager.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.yckim.project_manager.InfoClass.ProjectBean;
import com.yckim.project_manager.InfoClass.ToDoBean;
import com.yckim.project_manager.Manager.MyApplication;
import com.yckim.project_manager.R;
import com.yckim.project_manager.Timeline.CalStuff;
import com.yckim.project_manager.Timeline.TLEvent;
import com.yckim.project_manager.Timeline.TLView;

import java.util.ArrayList;
import java.util.Vector;

public class MainActivity extends ActionBarActivity
{
    private static final String LogTag = "drgn";

    // TODO move timer thing to view itself
    Handler handler = new Handler();
    Runnable runnable = new Runnable()
    {
        public void run()
        {
            contentView.postInvalidate();
            handler.postDelayed(runnable, 250);
        }
    };

    private TLView contentView;
    private CalStuff calstuff;
    private ArrayList<TLEvent> ourEvents;
    private Vector<ToDoBean> ToDoList;
    private ProjectBean projectinfo;

    //private Spinner memo;

    private String Email;
    private String CateName;
    private String ProjectName;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Email = MyApplication.Email;
        CateName = MyApplication.Category;
        ProjectName = MyApplication.ProjectName;




        calstuff = new CalStuff(this);

        setContentView(R.layout.activity_main);

        contentView = (TLView) findViewById(R.id.fullscreen_content);


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);

        calstuff.LoadCalendars();
        Log.d(LogTag, "calendars loaded: " + calstuff.ourCalendars.size());

        calstuff.LoadEvents();
        Log.d(LogTag, "events loaded: " + calstuff.ourEvents.size());
		
		calstuff.LoadInstances();
		//Log.d(LogTag, "instances loaded: " + calstuff.ourInstances.size());

        contentView.SetCalStuff(calstuff);
/*
        Intent intent = getIntent();
        if(intent != null) {
            Email = intent.getStringExtra("Email");
            CateName = intent.getStringExtra("CateName");
            ProjectName = intent.getStringExtra("ProjectName");
        }
        Email = "admin";
        CateName = "android";
        ProjectName = "PIT";

        RequestParams params = new RequestParams();
        params.put("Email",Email);
        params.put("CateName", CateName);
        params.put("ProjectName",ProjectName);

        ProjectManager.getInstnace().Proitem_sendData(MyApplication.getContext(), params, new ProjectManager.OnResultListener<ProjectBean>() {
            @Override
            public void onSuccess(ProjectBean result) {
                projectinfo = result;
            }

            @Override
            public void onFail(int code) {
            }
        });

        ToDoList = new Vector<ToDoBean>();
        ToDoManager.getInstnace().ToDolist_sendData(MyApplication.getContext(), params, new ToDoManager.OnResultListener<Vector>() {
            @Override
            public void onSuccess(Vector result) {
                Log.e("TAG resultsize", " " + result.size());
                for(int i=0;i<result.size();i++){
                    ToDoList = result;//.add(result.elementAt(i));
                }
            }

            @Override
            public void onFail(int code) {

            }
        });
        //통신의 결과로 받아온 값들을 Projectinfo과 ToDoList에 저장....되어있다고 가정

        Log.e("TAG", " " + ToDoList.size());
        for(int i=0;i<ToDoList.size();i++){
            Log.e("TAG", " zz " + ToDoList.elementAt(i).getToDoName());
        }
        loadList();
        contentView.SetOurEvents(ourEvents);*/
    }

    private void loadList(){
        //DB에서 받아온 ToDoBean를 이용하여 ourEvents에 원소 삽입.
        ourEvents = new ArrayList<TLEvent>();

        for(int i=0;i<ToDoList.size(); i++){
            ToDoBean bean = ToDoList.elementAt(i);
            TLEvent e = new TLEvent(bean.getToDoName(), bean.getToDoStartDate(), bean.getToDoEndDate());
            ourEvents.add(e);
            Log.e("TAG", "e.dtstart = "+e.dtstart + " e.dtend = " + e.dtend);
        }
/*
        String t = "a";
        String s = "20150503000000";
        String end = "20150814000000";
        ourEvents.add(new TLEvent(t,s,end));
        t = "b";
        s = "20150803000000";
        end = "20151014000000";
        ourEvents.add(new TLEvent(t,s,end));
        t = "dddddd";
        s = "20150403000000";
        end = "20150814000000";
        ourEvents.add(new TLEvent(t,s,end));
        t = "c";
        s = "20150801000000";
        end = "20150829000000";
        ourEvents.add(new TLEvent(t,s,end));
        t = "e";
        s = "20150703000000";
        end = "20151014000000";
        ourEvents.add(new TLEvent(t,s,end));
*/
    }

    @Override
    protected void onPause()
    {
        Log.d(LogTag, "pause");
        super.onPause();

        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onResume()
    {
        Log.d(LogTag, "resume");
        super.onResume();
        contentView.requestFocus();
        runnable.run();
    }
}
