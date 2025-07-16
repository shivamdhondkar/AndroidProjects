package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.MediaController;
import android.widget.VideoView;

import com.airbnb.lottie.LottieAnimationView;

public class AboutUsActivity extends AppCompatActivity {




    VideoView videoView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);


        videoView=findViewById(R.id.videoview);

        String videopath="android.resource://"+getPackageName()+"/raw/food_delivery";
        videoView.setVideoPath(videopath);
        videoView.start();

        MediaController mediaController=new MediaController(AboutUsActivity.this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(mediaController);




        setTitle("About Us");










    }
}