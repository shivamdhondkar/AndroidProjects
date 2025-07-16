package com.AAU.bakery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.MediaController;
import android.widget.VideoView;

import com.airbnb.lottie.LottieAnimationView;
public class AboutUsActivity extends AppCompatActivity {
    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        setTitle("About Us");

        video=findViewById(R.id.video_view_about_us);
        String str_videopath="android.resource://"+getPackageName()+"/raw/tuhaitomujhefiraukuachahiye";

        video.setVideoPath(str_videopath);
        video.start();

        MediaController media=new MediaController(AboutUsActivity.this);
        video.setMediaController(media);
    }
}