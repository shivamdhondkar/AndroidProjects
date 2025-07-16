package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class FrontActivity extends AppCompatActivity {
    LottieAnimationView profile;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
        profile=findViewById(R.id.lottie);



        profile.animate().translationY(2000).setDuration(2000).setStartDelay(99900);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


            }
        },5000);





        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(FrontActivity.this, LoginActivity2.class);
                startActivity(i);
                finish();
            }
        },4300);
    }
}