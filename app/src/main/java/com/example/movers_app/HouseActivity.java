package com.example.movers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
   // @BindView(R.id.studioText) TextView mStudioText;
    //@BindView(R.id.oneBedroomText) TextView mOneBedroomText;
    //@BindView(R.id.twoBedRoomsText) TextView mTwoBedRoomText;
    //@BindView(R.id.threeBedRoomsText) TextView mThreeBedRoomText;
    @BindView(R.id.studioImage) ImageView mStudioImage;
    @BindView(R.id.oneBedRoomImage) ImageView mOneBedRoomImage;
    @BindView(R.id.twoBedRoomsImage) ImageView mTwoBedRoomImage;
    @BindView(R.id.bedsitterImage) ImageView mBedsitterImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);
        ButterKnife.bind(this);

        Picasso.get().load(R.drawable.bedsitter).into(mBedsitterImage);
        Picasso.get().load(R.drawable.studio).into(mStudioImage);
        Picasso.get().load(R.drawable.onebedroom).into(mOneBedRoomImage);
        Picasso.get().load(R.drawable.twobedrooms).into(mTwoBedRoomImage);

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