package com.example.movers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChoiceActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSignUpUser;
    Button btnSignUpMover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        btnSignUpMover = (Button) findViewById(R.id.signUpMover);
        btnSignUpUser = (Button) findViewById(R.id.signUpUser);

        btnSignUpUser.setOnClickListener(this);
        btnSignUpMover.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnSignUpMover){
            //mProgressBar.setVisibility(View.VISIBLE);
            startActivity(new Intent(ChoiceActivity.this,Movers_SignUp.class));
        }

        if(v == btnSignUpUser){
            //mProgressBar.setVisibility(View.VISIBLE);
            startActivity(new Intent(ChoiceActivity.this,Sign_Up.class));
        }
    }
}