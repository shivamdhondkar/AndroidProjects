package com.AAU.bakery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class SplashActivity extends AppCompatActivity {

    TextView tv_title;
    TextView t_title;
    TextView txt_name;
    Animation fadeinAnim;
    Animation moves;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences= PreferenceManager.getDefaultSharedPreferences(SplashActivity.this);
        editor= preferences.edit();

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                           Toast.makeText(SplashActivity.this, "Fetching FCM registration token failed", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        // Get new FCM registration token
                        String t1 = task.getResult();
                        editor.putString("token",t1).commit();

                        // Log and toast
                        Toast.makeText(SplashActivity.this, t1, Toast.LENGTH_SHORT).show();


                    }
                });

        t_title = findViewById(R.id.t_main_heading);
        tv_title = findViewById(R.id.tv_main_title);
        txt_name = findViewById(R.id.txt_main_subtitle);

        fadeinAnim = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.fadein);
        t_title.setAnimation(fadeinAnim);
        tv_title.setAnimation(fadeinAnim);

        moves = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.move);
        txt_name.startAnimation(moves);

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent I = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(I);
                finish();
            }
        }, 3000);
    }
}