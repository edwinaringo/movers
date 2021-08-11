package com.example.movers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HouseActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView studioText, oneBedroomText, twoBedRoomText, threeBedRoomText;
    String userName;

    String[] orderInfo= new String[4];


    @BindView(R.id.studioImage) ImageView mStudioImage;
    @BindView(R.id.oneBedRoomImage) ImageView mOneBedRoomImage;
    @BindView(R.id.twoBedRoomImage) ImageView mTwoBedRoomImage;
    @BindView(R.id.threeBedRoomsImage) ImageView mThreeBedRoomImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        userName = intent.getStringExtra("username");

        Picasso.get().load(R.drawable.bedsitter).into(mThreeBedRoomImage);
        Picasso.get().load(R.drawable.studio).into(mStudioImage);
        Picasso.get().load(R.drawable.onebedroom).into(mOneBedRoomImage);
        Picasso.get().load(R.drawable.twobedrooms).into(mTwoBedRoomImage);

        mStudioImage.setOnClickListener(this);
        mOneBedRoomImage.setOnClickListener(this);
        mTwoBedRoomImage.setOnClickListener(this);
        mThreeBedRoomImage.setOnClickListener(this);


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

        String inventory;

        if(v==studioText || v==mStudioImage){
            Intent intent =new Intent(HouseActivity.this,LocationActivity.class);
            inventory=studioText.getText().toString();
            orderInfo[0]=userName;
            orderInfo[1]= inventory;

            intent.putExtra("orderInfo",orderInfo);
            startActivity(intent);
        }
        if(v==oneBedroomText || v==mOneBedRoomImage){
            Intent intent =new Intent(HouseActivity.this,LocationActivity.class);
            inventory=oneBedroomText.getText().toString();
            orderInfo[0]=userName;
            orderInfo[1]= inventory;

            intent.putExtra("orderInfo",orderInfo);
            startActivity(intent);
        }
        if(v==twoBedRoomText || v==mTwoBedRoomImage){
            Intent intent =new Intent(HouseActivity.this,LocationActivity.class);
            inventory=twoBedRoomText.getText().toString();
            orderInfo[0]=userName;
            orderInfo[1]= inventory;

            intent.putExtra("orderInfo",orderInfo);
            startActivity(intent);
        }
        if(v==threeBedRoomText || v==mThreeBedRoomImage){
            Intent intent =new Intent(HouseActivity.this,LocationActivity.class);
            inventory=threeBedRoomText.getText().toString();
            orderInfo[0]=userName;
            orderInfo[1]= inventory;

            intent.putExtra("orderInfo",orderInfo);
            startActivity(intent);

        }

    }
}