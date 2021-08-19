package com.example.movers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginChoice extends AppCompatActivity implements View.OnClickListener {
    Button btnLoginUser;
    Button btnLogInMover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_choice);

        btnLoginUser = (Button) findViewById(R.id.userLogIn);
        btnLogInMover = (Button) findViewById(R.id.logInMover);

        btnLoginUser.setOnClickListener(this);
        btnLogInMover.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnLogInMover){
            //mProgressBar.setVisibility(View.VISIBLE);
            startActivity(new Intent(LoginChoice.this,MoversLogIn.class));
        }

        if(v == btnLoginUser){
            //mProgressBar.setVisibility(View.VISIBLE);
            startActivity(new Intent(LoginChoice.this,LoginActivity.class));
        }
    }
}