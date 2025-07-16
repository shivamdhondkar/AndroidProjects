package com.example.pract_17;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button explicitIntentButton = findViewById(R.id.explicitIntentButton);
        Button implicitIntentButton = findViewById(R.id.implicitIntentButton);

        explicitIntentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent explicitIntent = new Intent(MainActivity.this, Home_Screen.class);
                startActivity(explicitIntent);
            }
        });

        implicitIntentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent implicitIntent = new Intent(Intent.ACTION_VIEW);
                implicitIntent.setData(android.net.Uri.parse("https://drpdpolyamt.org/"));
                startActivity(implicitIntent);
            }
        });
    }
}
