package com.example.movers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View .OnClickListener {
    TextView mLoginbutton;
    TextView mSigninbutton;
    TextView mTextView6,mTextView;
    ProgressBar mProgressBar;

    Animation topAnimation,bottomAnimation,popupAnimation,popoutAnimation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        //hooks
        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        popoutAnimation = AnimationUtils.loadAnimation(this,R.anim.pop_out);
        popupAnimation = AnimationUtils.loadAnimation(this,R.anim.popup_in);

        mTextView6 = (TextView) findViewById(R.id.textView6);
        mTextView6.setAnimation(popoutAnimation);
        mTextView = (TextView) findViewById(R.id.textView);
        mTextView.setAnimation(topAnimation);
        mLoginbutton = (TextView) findViewById(R.id.login);
        mLoginbutton.setAnimation(bottomAnimation);
        mSigninbutton = (TextView) findViewById(R.id.signin);
        mSigninbutton.setAnimation(bottomAnimation);

        mLoginbutton.setOnClickListener(this);
        mSigninbutton.setOnClickListener(this);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);


    }

    @Override
    public void onClick(View v) {
        if(v == mLoginbutton){
            startActivity(new Intent(MainActivity.this,LoginChoice.class));
        }

        if (v == mSigninbutton){
            startActivity(new Intent(MainActivity.this,ChoiceActivity.class));
        }
    }

}