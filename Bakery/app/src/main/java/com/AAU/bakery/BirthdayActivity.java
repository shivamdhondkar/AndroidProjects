package com.AAU.bakery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class BirthdayActivity extends AppCompatActivity {
    ImageView img_birthday_chocolate,img_birthday_vanilla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
        img_birthday_chocolate=findViewById(R.id.img_chocolate_birthday_cake);
        img_birthday_vanilla=findViewById(R.id.img_vanilla_birthday_cake);
        img_birthday_chocolate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(BirthdayActivity.this, OrderActivity.class);
                startActivity(i);
            }
        });
        img_birthday_vanilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(BirthdayActivity.this, OrderActivity.class);
                startActivity(i);
            }
        });
    }


}