package com.yckim.project_manager.Activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yckim.project_manager.Manager.MyApplication;
import com.yckim.project_manager.Manager.NetworkManager;
import com.yckim.project_manager.R;


public class JoinActivity extends ActionBarActivity implements View.OnClickListener{

    private EditText Email;
    private EditText pw;
    private EditText pwc;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        Email = (EditText)findViewById(R.id.Login_Email);
        pw = (EditText)findViewById(R.id.Login_PassWord);
        pwc = (EditText)findViewById(R.id.Login_PassWord_cer);
        signup = (Button)findViewById(R.id.Join_btn);

        signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String Emails = Email.getText().toString();
        String PassWords = pw.getText().toString();
        String Confirm = pwc.getText().toString();

        if(!PassWords.equals(Confirm)) {
            Toast.makeText(JoinActivity.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            return;
        }

        NetworkManager.getInstnace().Join_sendData(MyApplication.getContext(), Emails, PassWords, new NetworkManager.OnResultListener<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                Log.e("testine", "success");
            }

            @Override
            public void onFail(int code) {
                Log.e("testine", "fail");
            }
        });
        finish();
    }
}
