package com.example.myapplication;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class Splash_Activity extends AppCompatActivity {

//    SharedPreferences preferences;
//    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
//        preferences= PreferenceManager.getDefaultSharedPreferences(Splash_Activity.this);
//        editor=preferences.edit();
//
//        FirebaseMessaging.getInstance().getToken()
//                .addOnCompleteListener(new OnCompleteListener<String>() {
//                    @Override
//                    public void onComplete(@NonNull Task<String> task) {
//                        if (!task.isSuccessful()) {
//                            Toast.makeText(Splash_Activity.this,"Fetching FCM registration token Failed ",Toast.LENGTH_SHORT).show();
//
//                            return;
//                        }
//
//                        // Get new FCM registration token
//                        String token1 = task.getResult();
//                        editor.putString("token",token1).commit();
//
//                        // Log and toast
//
//                       // Toast.makeText(Splash_Activity.this,token1, Toast.LENGTH_SHORT).show();
//                    }
//                });




        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
              Intent i = new Intent(Splash_Activity.this, LoginActivity2.class);
                startActivity(i);
                finish();
            }
        },4200);
    }}