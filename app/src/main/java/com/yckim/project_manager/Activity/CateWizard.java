package com.yckim.project_manager.Activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.yckim.project_manager.R;

public class CateWizard extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cate_wizard);
        final EditText nCateName = (EditText) findViewById(R.id.cateName);

    }
    /*
    Button.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            input = nCateName.getText().toString();
            if(input != null){

                RequestParams params = new RequestParams();
                params.put("Email",Email);        //넣을 값은 오른쪽. 새 카테고리 추가
                params.put("CateName", input);

                ProjectManager.getInstnace().Proitem_sendData(MyApplication.getContext(), params, new ProjectManager.OnResultListener<ProjectBean>() {
                    @Override
                    public void onSuccess(ProjectBean result) {
                        projectinfo = result;
                    }

                    @Override
                    public void onFail(int code) {
                    }
                }
            });


            ToDoManager.getInstnace().ToDolist_sendData(MyApplication.getContext(), params, new ToDoManager.OnResultListener<Vector>() {
                @Override
                public void onSuccess(Vector result) {
                    for (int i = 0; i < result.size(); i++) {
                        ourEvents.add((TLEvent) result.elementAt(i));
                    }
                }

                @Override
                public void onFail(int code) {

                }
            });

        }
    };*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cate_wizard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
