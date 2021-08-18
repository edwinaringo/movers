package com.example.movers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginChoice extends AppCompatActivity implements View.OnClickListener {
    Button btn_User;
    Button btn_Mover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        btn_User = (Button) findViewById(R.id.signUpUser);
        btn_Mover = (Button) findViewById(R.id.signUpMover);

        btn_User.setOnClickListener(this);
        btn_Mover.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btn_Mover){
            //mProgressBar.setVisibility(View.VISIBLE);
            startActivity(new Intent(LoginChoice.this,MoversLogIn.class));
        }

        if(v == btn_User){
            //mProgressBar.setVisibility(View.VISIBLE);
            startActivity(new Intent(LoginChoice.this,LoginActivity.class));
        }
    }
}