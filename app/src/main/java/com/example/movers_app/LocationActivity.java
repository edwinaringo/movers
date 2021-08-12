package com.example.movers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LocationActivity extends AppCompatActivity implements View.OnClickListener {
//initializing viriables
    EditText etSource,etDestination;
    Button btTrack,moversList;
    TextView mPickUpsbutton;

    String userName;
    String inventory;
    String sSource;
    String sDestination;

    String[] orderInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

//        Intent intent = getIntent();
//        inventory = intent.getStringExtra("inventory");
//        userName= intent.getStringExtra("username");



        mPickUpsbutton = findViewById(R.id.pickups);

        etSource = findViewById(R.id.et_source);
        etDestination = findViewById(R.id.et_destination);
        btTrack = findViewById(R.id.bt_track);
        mPickUpsbutton.setOnClickListener(this);

         sSource = etSource.getText().toString().trim();
         sDestination = etDestination.getText().toString().trim();



        btTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sSource = etSource.getText().toString().trim();
                sDestination = etDestination.getText().toString().trim();
                if (sSource.equals("") && sDestination.equals("")){
                    Toast.makeText(getApplicationContext(),"Enter both Location",Toast.LENGTH_LONG);
                }else {
                    DisplayTrack(sSource,sDestination);
                }
            }
        });
    }
    private void DisplayTrack(String sSource, String sDestination) {
        try {
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + sSource + "/" + sDestination);
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }catch (ActivityNotFoundException e){
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);


            startActivity(intent);

        }


            }

    @Override
    public void onClick(View v) {
        if(v == mPickUpsbutton){
            sSource = etSource.getText().toString().trim();
            sDestination = etDestination.getText().toString().trim();
//            String array[] = {userName,inventory,sSource,sDestination};
            Bundle extras = getIntent().getExtras();
            orderInfo = extras.getStringArray("orderInfo");
            orderInfo[2] = sSource;
            orderInfo[3]=sDestination;
            Intent intent2 =new Intent(LocationActivity.this,MoversList.class);

            intent2.putExtra("orderInfo",orderInfo);
            startActivity(intent2);
        }
        //set an intent on price id button
//        if(v== moversList){
//            startActivity(new Intent(LocationActivity.this,MoversList.class));
//        }
    }
}