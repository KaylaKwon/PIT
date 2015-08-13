package mm.pit.myapplication10;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.content.Intent;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mGroupList = null;
    private ArrayList<ArrayList<String>> mChildList = null;
    private ArrayList<String> mChildListContent = null;
    private ExpandableListView mListView;

    private ExpandableListView catePick;
    private ExpandableListView projPick;

    int indexing = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setLayout();

        mGroupList = new ArrayList<String>();
        mChildList = new ArrayList<ArrayList<String>>();
        mChildListContent = new ArrayList<String>();

//        mGroupList.add("가위");
//        mGroupList.add("바위");
//        mGroupList.add("보");
//
//        mChildListContent.add("1");
//        mChildListContent.add("2");
//        mChildListContent.add("3");
//
//        mChildList.add(mChildListContent);
//        mChildList.add(mChildListContent);
//        mChildList.add(mChildListContent);

        //mListView.setAdapter(new BaseExpandableAdapter(this, mGroupList, mChildList));

        mListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                //Toast.makeText(getApplicationContext(), "g click = " + groupPosition, Toast.LENGTH_SHORT).show();
                return false;
            }
        });


        mListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                //Toast.makeText(getApplicationContext(), "c click = " + childPosition, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        mListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                //Toast.makeText(getApplicationContext(), "g Collapse = " + groupPosition, Toast.LENGTH_SHORT).show();
            }
        });

        mListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                //Toast.makeText(getApplicationContext(), "g Expand = " + groupPosition, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu){

        return super.onPrepareOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cate) {

            Intent intent = new Intent(this, CateWizard.class);
            startActivity(intent);

            mGroupList.add("카테" + indexing++);
            mListView.setAdapter(new BaseExpandableAdapter(this, mGroupList, mChildList));
            return true;
        }
        else if(id == R.id.action_proj){

            BaseExpandableAdapter BEA = new BaseExpandableAdapter(this, mGroupList, mChildList);

            //int tgCate = 1;
            //int  = BEA.;


            Intent intent = new Intent(this, ProjWizardActivity.class);
            startActivity(intent);



            //mChildListContent.add("플젝" + indexing++);

            //mChildList.add(mChildListContent);
            mListView.setAdapter(new BaseExpandableAdapter(this, mGroupList, mChildList));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setLayout(){
        mListView = (ExpandableListView)findViewById(R.id.elv);
    }
}
