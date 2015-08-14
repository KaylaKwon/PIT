package com.yckim.project_manager.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yckim.project_manager.Manager.MyApplication;
import com.yckim.project_manager.Manager.NetworkManager;
import com.yckim.project_manager.R;


public class LoginActivity extends ActionBarActivity implements View.OnClickListener{

    private Button login;
    private Button join;
    private EditText Email;
    private EditText Password;
    public String Emails = "3";
    public String Passwords = "3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button)findViewById(R.id.Login_btn);
        join = (Button)findViewById(R.id.Join_btn);
        Email = (EditText)findViewById(R.id.Login_Email);
        Password = (EditText)findViewById(R.id.Login_PassWord);

        login.setOnClickListener(this);
        join.setOnClickListener(this);

        //login.setOnClickListener();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    //@Override
    //private class NewsThreads extends AsyncTask<Object,Object,Object>{
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.Login_btn:

                Emails = Email.getText().toString();
                Passwords = Password.getText().toString();
                boolean islogin = false;
                Log.e("testline", "79");
                Log.e("testline", "81");

                NetworkManager nm = NetworkManager.getInstnace();
                Log.e("testline", "84");

                int n;
                nm.Login_sendData(MyApplication.getContext(), Emails, Passwords, new NetworkManager.OnResultListener<Boolean>() {
                    @Override
                    public void onSuccess(Boolean result) {
                        //Log.e("testline", result);
                        Log.e("testline", "88");
                    }

                    @Override
                    public void onFail(int code) {
                        Log.e("testline", "93");

                        Toast.makeText(LoginActivity.this, "회원정보가 틀렸습니다.", Toast.LENGTH_SHORT).show();
                    }
                });

                MyApplication.Email = Emails;
                intent = new Intent(LoginActivity.this, MainActivity.class);
                   startActivity(intent);
                break;
            case R.id.Join_btn:
                intent = new Intent(LoginActivity.this, JoinActivity.class);
                startActivityForResult(intent, 0);
                //onActivityResult(0, 0, null);
                //Toast.makeText(LoginActivity.this, "회원가입을 축하드립니다.", Toast.LENGTH_SHORT).show();

                break;
        }

    }
}
