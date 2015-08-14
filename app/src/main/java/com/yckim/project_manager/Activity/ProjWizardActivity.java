package com.yckim.project_manager.Activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.yckim.project_manager.R;


public class ProjWizardActivity extends ActionBarActivity implements View.OnClickListener{
    Button submit;
    Spinner category;
    EditText briefy;
    EditText startDate;
    EditText endDate;
    EditText startMoney;
    EditText endMoney;
    EditText startMoneyDate;
    EditText endMoneyDate;
    EditText ProjName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proj_wizard);
        submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_proj_wizard, menu);
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
    public void onClick(View v){
        //하나라도 비어있다면, 알림창 띄워 안내
        /*if(ProjName.getText().toString() == "" ||
                endMoneyDate.getText().toString() == ""||
                briefy.getText().toString() == ""||
                startDate.getText().toString() == ""||
                endDate.getText().toString() == ""|
                startMoney.getText().toString() == ""||
                endMoney.getText().toString() == ""||
                startMoneyDate.getText().toString()== "")
            Toast.makeText("")*/
        //submit 누르면 날짜가 유효한지 확인하고 서버로 전송되고
        //확인이 되면 회원가입 완료.
    }
}
