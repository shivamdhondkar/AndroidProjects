package com.AAU.bakery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class Payment extends AppCompatActivity {

ImageView cash_on_delivery, onine_payment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        cash_on_delivery = findViewById(R.id.lottie_cash_on_delivery);
    }
}