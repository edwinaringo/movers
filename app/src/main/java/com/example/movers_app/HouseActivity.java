package com.example.movers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HouseActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView studioText, oneBedroomText, twoBedRoomText, threeBedRoomText;
   // @BindView(R.id.studioText) TextView mStudioText;
    //@BindView(R.id.oneBedroomText) TextView mOneBedroomText;
    //@BindView(R.id.twoBedRoomsText) TextView mTwoBedRoomText;
    //@BindView(R.id.threeBedRoomsText) TextView mThreeBedRoomText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);

        studioText = (TextView) findViewById(R.id.studioText);
        studioText.setOnClickListener(this);

        oneBedroomText = (TextView) findViewById(R.id.oneBedroomText);
        oneBedroomText.setOnClickListener(this);

        twoBedRoomText = (TextView) findViewById(R.id.twoBedRoomsText);
        twoBedRoomText.setOnClickListener(this);

        threeBedRoomText = (TextView) findViewById(R.id.threeBedRoomsText);
        threeBedRoomText.setOnClickListener(this);



    }


    //setting Toast when button is clicked
    @Override
    public void onClick(View v) {

        if(v==studioText){
            startActivity(new Intent(HouseActivity.this,LocationActivity.class));
        }
        if(v==oneBedroomText){
            startActivity(new Intent(HouseActivity.this,LocationActivity.class));
        }
        if(v==twoBedRoomText){
            startActivity(new Intent(HouseActivity.this,LocationActivity.class));
        }
        if(v==threeBedRoomText){
            startActivity(new Intent(HouseActivity.this,LocationActivity.class));

        }

    }
}