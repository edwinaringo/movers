package com.example.movers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChoiceActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnUser;
    Button btnMover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        btnMover = (Button) findViewById(R.id.signUpMover);
        btnUser = (Button) findViewById(R.id.signUpUser);

        btnUser.setOnClickListener(this);
        btnMover.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnMover){
            //mProgressBar.setVisibility(View.VISIBLE);
            startActivity(new Intent(ChoiceActivity.this,Movers_SignUp.class));
        }

        if(v == btnUser){
            //mProgressBar.setVisibility(View.VISIBLE);
            startActivity(new Intent(ChoiceActivity.this,Sign_Up.class));
        }
    }
}