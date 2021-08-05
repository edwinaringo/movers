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
    @BindView(R.id.studioImage) ImageView mStudioImage;
    @BindView(R.id.oneBedRoomImage) ImageView mOneBedRoomImage;
    @BindView(R.id.twoBedRoomsImage) ImageView mTwoBedRoomImage;
    @BindView(R.id.bedsitterImage) ImageView mBedsitterImage;
    @BindView(R.id.bedsitterText) TextView mBedsitterText;
    @BindView(R.id.studioText) TextView mStudioText;
    @BindView(R.id.oneBedRoomImageText) TextView mOneBedRoomText;
    @BindView(R.id.twoBedRoomsText) TextView mTwoBedRoomText;
    Button mLocationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);

        mLocationButton = (Button) findViewById(R.id.location);
        mLocationButton.setOnClickListener(this);


        ButterKnife.bind(this);
        //image listeners
        mStudioImage.setOnClickListener(this);
        mOneBedRoomImage.setOnClickListener(this);
        mTwoBedRoomImage.setOnClickListener(this);
        mBedsitterImage.setOnClickListener(this);
    }


    //setting Toast when button is clicked
    @Override
    public void onClick(View v) {
        if(v == mLocationButton){
            startActivity(new Intent(HouseActivity.this,LocationActivity.class));
            Toast.makeText(HouseActivity.this, "lets choose a location", Toast.LENGTH_SHORT).show();
        }

        if(v==mStudioImage){
            Toast.makeText(this, "clicked1", Toast.LENGTH_SHORT).show();
        }
        if(v==mOneBedRoomImage){
            Toast.makeText(this, "Clicked2", Toast.LENGTH_SHORT).show();
        }
        if(v==mTwoBedRoomImage){
            Toast.makeText(this, "clicked3", Toast.LENGTH_SHORT).show();
        }
        if(v==mBedsitterImage){
            Toast.makeText(this, "clicked4", Toast.LENGTH_SHORT).show();
        }

    }
}