package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MussleBlazefatHM extends AppCompatActivity {

    Button buy1;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mussle_blazefat_hm);

        buy1=findViewById(R.id.wellcarebtn);

        buy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MussleBlazefatHM.this, Order_PlacedActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}