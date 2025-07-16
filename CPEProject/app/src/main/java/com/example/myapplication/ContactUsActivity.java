package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class ContactUsActivity extends AppCompatActivity {

    EditText et_mobile_no,et_message;
    Button btn_send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        ActivityCompat.requestPermissions(ContactUsActivity.this,new String[]{Manifest.permission.SEND_SMS},9);

        setTitle("Contact Us");


        et_mobile_no=findViewById(R.id.et_contact_us_number);
        et_message=findViewById(R.id.et_contact_us_message);
        btn_send=findViewById(R.id.btn_contact_us_send);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_mobile_no.getText().toString().isEmpty())
                {
                    et_mobile_no.setError("Section must not be Empty");
                } else if (et_mobile_no.getText().toString().length()!=10) {
                    et_mobile_no.setError("Invalid Number");

                } else if (et_message.getText().toString().isEmpty()) {
                    et_message.setError("Section Must not be Empty");

                }
                else
                {
                    String mobile_no=et_mobile_no.getText().toString();
                    String message=et_message.getText().toString();

                    Intent i=new Intent(ContactUsActivity.this,HomeActivity.class);
                    PendingIntent pi= PendingIntent.getActivity(ContactUsActivity.this,9,i,PendingIntent.FLAG_IMMUTABLE);

                    SmsManager sms=SmsManager.getDefault();
                    sms.sendTextMessage(mobile_no,null,message,pi,null);
                    Toast.makeText(ContactUsActivity.this, "Sms Sent Successfully", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
