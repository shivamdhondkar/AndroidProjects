package com.AAU.bakery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ContactUsActivity extends AppCompatActivity {
    TextView tv_contacts;
    TextView tv_emails;
    EditText et_mob_no, et_message;
    Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        setTitle("Contact Us");
        ActivityCompat.requestPermissions(ContactUsActivity.this, new String[]{Manifest.permission.SEND_SMS}, 999);

        tv_contacts = findViewById(R.id.tv_contact);
        tv_emails = findViewById(R.id.tv_email);

        et_mob_no = findViewById(R.id.et_enter_your_number);
        et_message = findViewById(R.id.et_contact_message);
        btn_send = findViewById(R.id.btn_contact);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile_no = et_mob_no.getText().toString();
                String message = et_message.getText().toString();
                Intent i = new Intent(ContactUsActivity.this, HomePageActivity.class);
                PendingIntent pi = PendingIntent.getActivity(ContactUsActivity.this, 0, i, PendingIntent.FLAG_IMMUTABLE);
                //for sms
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(mobile_no, null, message, pi, null);
                Toast.makeText(ContactUsActivity.this, "SMS Sends Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}







