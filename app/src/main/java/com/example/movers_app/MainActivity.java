package com.example.movers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View .OnClickListener {
    Button mLoginbutton;
    Button mSigninbutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mLoginbutton = (Button)findViewById(R.id.login);
        mSigninbutton = (Button) findViewById(R.id.signin);

        mLoginbutton.setOnClickListener(this);
        mSigninbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mLoginbutton){
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
            Toast.makeText(MainActivity.this, "login to your account", Toast.LENGTH_SHORT).show();
        }

        if (v == mSigninbutton){
            startActivity(new Intent(MainActivity.this,Sign_Up.class));
            Toast.makeText(MainActivity.this, "create your account", Toast.LENGTH_SHORT).show();
        }


    }
}