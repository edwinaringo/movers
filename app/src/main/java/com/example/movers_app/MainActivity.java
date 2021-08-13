package com.example.movers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View .OnClickListener {
    TextView mLoginbutton;
    TextView mSigninbutton;
    Button mGetStarted;
    ProgressBar mProgressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        mLoginbutton = (TextView) findViewById(R.id.login);
        mSigninbutton = (TextView) findViewById(R.id.signin);
        mGetStarted = (Button) findViewById(R.id.getStarted);

        mLoginbutton.setOnClickListener(this);
        mSigninbutton.setOnClickListener(this);
        mGetStarted.setOnClickListener(this);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);


    }

    @Override
    public void onClick(View v) {
        if(v == mLoginbutton){
            mProgressBar.setVisibility(View.VISIBLE);
            startActivity(new Intent(MainActivity.this,LoginChoice.class));
        }

        if (v == mSigninbutton){
            mProgressBar.setVisibility(View.VISIBLE);
            startActivity(new Intent(MainActivity.this,ChoiceActivity.class));
        }

        if (v == mGetStarted) {
            mProgressBar.setVisibility(View.VISIBLE);
            startActivity(new Intent(MainActivity.this,HouseActivity.class));
        }
    }
}