package com.AAU.bakery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    TextView tv_profile;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setTitle("Settings");

        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        editor=preferences.edit();

        Toast.makeText(this, ""+preferences.getString("name1",""), Toast.LENGTH_SHORT).show();

        tv_profile=findViewById(R.id.tv_profile);

        tv_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(SettingActivity.this, ProfileActivity.class);
                editor.putString("name1",preferences.getString("name1","")).commit();
                startActivity(i);
            }
        });
    }


}