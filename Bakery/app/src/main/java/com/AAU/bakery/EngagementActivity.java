package com.AAU.bakery;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class EngagementActivity extends AppCompatActivity {
    ImageView img_engage_chocolate,img_engage_vanilla;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engagement);
        img_engage_chocolate=findViewById(R.id.img_chocolate_engagement_cake);
        img_engage_vanilla=findViewById(R.id.img_vanilla_engagement_cake);

        img_engage_chocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(EngagementActivity.this,OrderActivity.class);
                startActivity(i);
            }
        });
        img_engage_vanilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(EngagementActivity.this,OrderActivity.class);
                startActivity(i);
            }
        });
    }
}