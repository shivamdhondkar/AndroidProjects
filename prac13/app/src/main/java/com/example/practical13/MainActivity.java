package com.example.practical13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    TextView txt1;
    EditText et1,et2,et3;
    Button btn1;
    ProgressBar progressBar,progressBar1;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = findViewById(R.id.txt1);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        btn1 = findViewById(R.id.submit);
        progressBar = findViewById(R.id.progress);
        progressBar1 = findViewById(R.id.progress2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = et1.getText().toString().trim();
                String phone = et2.getText().toString().trim();
                String email = et3.getText().toString().trim();

                progressBar.setVisibility(View.VISIBLE);
                progressBar1.setVisibility(View.VISIBLE);

                Timer timer = new Timer();
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        counter++;

                        progressBar.setProgress(counter);
                        progressBar1.setProgress(counter);

                        if (counter == 100)
                        {
                            timer.cancel();

                            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                            intent.putExtra("key1",name);
                            intent.putExtra("key2",phone);
                            intent.putExtra("key3",email);
                            startActivity(intent);
                        }
                    }
                };
                timer.schedule(timerTask,100,100);


            }
        });

    }
}