package com.AAU.bakery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class LoadingActivity extends AppCompatActivity {
    LottieAnimationView lot3_load;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String str_username,str_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        editor= preferences.edit();

       Intent i=getIntent();
       str_username=i.getStringExtra("username");
       str_password=i.getStringExtra("password");

        lot3_load = findViewById(R.id.loading_lottie);
        lot3_load.animate().translationY(2000).setDuration(2000).setStartDelay(9000);

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(LoadingActivity.this, HomePageActivity.class);
                i.putExtra("username",str_username);
                i.putExtra("password",str_password);
                editor.putString("user",str_username).commit();
                editor.putString("pass",str_password).commit();
                startActivity(i);
                finish();
            }
        }, 3200);
    }
}