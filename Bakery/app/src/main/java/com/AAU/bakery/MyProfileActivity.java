package com.AAU.bakery;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;
import android.widget.Toast;
public class MyProfileActivity extends AppCompatActivity {
    String s_username, s_password,s_name,s_mob,s_about;
    TextView name, mob_no, about, username, password,token;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        setTitle("My profile");
        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        editor=preferences.edit();
        name=findViewById(R.id.tv_profile_name);
        mob_no=findViewById(R.id.tv_profile_mob_no);
        about=findViewById(R.id.tv_profile_about);
        username=findViewById(R.id.tv_profile_username);
        password=findViewById(R.id.tv_profile_password);
        token=findViewById(R.id.token_my_profile);

        Intent i=getIntent();
        s_name=i.getStringExtra("name");
        s_mob=i.getStringExtra("mobile_no");
        s_about=i.getStringExtra("about");
        s_username=i.getStringExtra("username");
        s_password=i.getStringExtra("password");

        Toast.makeText(this, "Name is "+preferences.getString("name1",""), Toast.LENGTH_SHORT).show();
        name.setText(preferences.getString("name1",""));
        mob_no.setText(preferences.getString("mobile_no1",""));
        about.setText(preferences.getString("about1",""));
        username.setText(preferences.getString("user",""));
        password.setText(preferences.getString("pass",""));
        token.setText(preferences.getString("token",""));

        Toast.makeText(MyProfileActivity.this,s_username+" "+s_password,Toast.LENGTH_SHORT).show();
    }

}