package com.AAU.bakery;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class WeddingActivity extends AppCompatActivity {
    ImageView img_wedding_chocolate,img_wedding_vanilla;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wedding);
        img_wedding_chocolate=findViewById(R.id.img_chocolate_wedding_cake);
        img_wedding_vanilla=findViewById(R.id.img_vanilla_wedding_cake);

        img_wedding_chocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(WeddingActivity.this,OrderActivity.class);
                startActivity(i);
            }
        });
        img_wedding_vanilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(WeddingActivity.this,OrderActivity.class);
                startActivity(i);
            }
        });
    }
}