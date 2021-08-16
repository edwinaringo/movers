package com.example.movers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConfirmOrder extends AppCompatActivity {
    @BindView(R.id.imageView5)
    ImageView mImageView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        getSupportActionBar().hide();
        ButterKnife.bind(this);

        YoYo.with(Techniques.FadeIn)
                .duration(700)
                .repeat(5)
                .playOn(findViewById(R.id.imageView5));


    }
}