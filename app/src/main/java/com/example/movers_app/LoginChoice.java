package com.example.movers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginChoice extends AppCompatActivity implements View.OnClickListener {
    Button user_btn;
    Button btn_Mover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_choice);

        user_btn = (Button) findViewById(R.id.userLogIn);
        btn_Mover = (Button) findViewById(R.id.logInMover);

        user_btn.setOnClickListener(this);
        btn_Mover.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btn_Mover){
            //mProgressBar.setVisibility(View.VISIBLE);
            startActivity(new Intent(LoginChoice.this,MoversLogIn.class));
        }

        if(v == user_btn){
            //mProgressBar.setVisibility(View.VISIBLE);
            startActivity(new Intent(LoginChoice.this,LoginActivity.class));
        }
    }
}