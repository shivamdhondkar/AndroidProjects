package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.airbnb.lottie.LottieAnimationView;

public class MyProfileActivity extends AppCompatActivity {

    String str_username,str_password;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    TextView tv_username,tv_password,tv_token;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        setTitle("My Profile");
        preferences = PreferenceManager.getDefaultSharedPreferences(MyProfileActivity.this);
        editor = preferences.edit();



        Intent intent=getIntent();
        str_username=intent.getStringExtra("username");
        str_password=intent.getStringExtra("password");
        Toast.makeText(MyProfileActivity.this,str_username+""+str_password,Toast.LENGTH_SHORT).show();

        tv_username=findViewById(R.id.tv_my_profile_username);
        tv_password=findViewById(R.id.tv_my_profile_password);
        tv_token=findViewById(R.id.tv_my_profile_token);

        tv_username.setText(preferences.getString("user",""));
        tv_password.setText(preferences.getString("pass",""));

        AppCompatButton backButton = findViewById(R.id.btn_back);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyProfileActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });





        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


            }
        },5000);


    }
}