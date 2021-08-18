package com.example.movers_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HouseActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.UserProfile){
            userProfile();
            return true;
        }
        if (id == R.id.UserLogout){
            userLogout();
        }
        return super.onOptionsItemSelected(item);
    }

    private void userLogout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(HouseActivity.this,SplashScreenActivity.class);
        //destroy running states
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
        //kill the activity
        finish();
    }

    private void userProfile() {
        startActivity(new Intent(HouseActivity.this,ProfileActivity.class));
        Toast.makeText(this, "My account", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.profile,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private TextView studioText, oneBedroomText, twoBedRoomText, threeBedRoomText;
    String userName;

    String[] orderInfo= new String[6];
    String[] userInfo;

    @BindView(R.id.cardView) CardView mCardView;
    @BindView(R.id.cardView2) CardView mCardView2;
    @BindView(R.id.cardView3) CardView mCardView3;
    @BindView(R.id.cardView4) CardView mCardView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house);
        ButterKnife.bind(this);

//        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        userInfo = extras.getStringArray("userinfo");
        Log.i("userinfo",userInfo[0]+""+userInfo[1]);
//        userName = intent.getStringExtra("userinfo");



        mCardView.setOnClickListener(this);
        mCardView2.setOnClickListener(this);
        mCardView3.setOnClickListener(this);
        mCardView4.setOnClickListener(this);


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

        if(v==studioText || v==mCardView){
            Intent intent =new Intent(HouseActivity.this,LocationActivity.class);
            inventory=studioText.getText().toString();
            orderInfo[0]=userInfo[0];
            orderInfo[1]= userInfo[1];
            orderInfo[2]= inventory;

            intent.putExtra("orderInfo",orderInfo);
            startActivity(intent);
        }
        if(v==oneBedroomText || v==mCardView2){
            Intent intent =new Intent(HouseActivity.this,LocationActivity.class);
            inventory=oneBedroomText.getText().toString();
            orderInfo[0]=userInfo[0];
            orderInfo[1]= userInfo[1];
            orderInfo[2]= inventory;

            intent.putExtra("orderInfo",orderInfo);
            startActivity(intent);
        }
        if(v==twoBedRoomText || v==mCardView3){
            Intent intent =new Intent(HouseActivity.this,LocationActivity.class);
            inventory=twoBedRoomText.getText().toString();
            orderInfo[0]=userInfo[0];
            orderInfo[1]= userInfo[1];
            orderInfo[2]= inventory;

            intent.putExtra("orderInfo",orderInfo);
            startActivity(intent);
        }
        if(v==threeBedRoomText || v==mCardView4){
            Intent intent =new Intent(HouseActivity.this,LocationActivity.class);
            inventory=threeBedRoomText.getText().toString();
            orderInfo[0]=userInfo[0];
            orderInfo[1]= userInfo[1];
            orderInfo[2]= inventory;

            intent.putExtra("orderInfo",orderInfo);
            startActivity(intent);

        }

    }
}