package com.example.movers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ChoiceActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_User;
    TextView tv_movingCompany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        tv_movingCompany = (TextView) findViewById(R.id.tv_movingCompany);
        tv_User = (TextView) findViewById(R.id.tv_User);

        tv_User.setOnClickListener(this);
        tv_movingCompany.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == tv_movingCompany){
            //mProgressBar.setVisibility(View.VISIBLE);
            startActivity(new Intent(ChoiceActivity.this,MovingCompanyOrdersActivity.class));
        }

        if(v == tv_User){
            //mProgressBar.setVisibility(View.VISIBLE);
            startActivity(new Intent(ChoiceActivity.this,Sign_Up.class));
        }
    }
}