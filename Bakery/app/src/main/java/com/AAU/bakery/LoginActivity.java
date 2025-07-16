package com.AAU.bakery;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    EditText et_username;
    EditText et_password;
    CheckBox chk_show_hide;
    Button bt1;
    TextView tv_registered;
    ImageView img_google;
    ImageView img_facebook;
    TextView tv_terms;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
        editor = preferences.edit();

        if (preferences.getBoolean("Login", false)) {
            Intent i = new Intent(LoginActivity.this, HomePageActivity.class);
            startActivity(i);
            finish();
        }
        et_username = findViewById(R.id.et_login_username);
        et_password = findViewById(R.id.et_login_password);
        chk_show_hide = findViewById(R.id.check_box_show_hide);
        bt1 = findViewById(R.id.butt_login_b1);
        tv_registered = findViewById(R.id.tv_login_not_yet_registered);
        img_google = findViewById(R.id.img_login_google);
        img_facebook = findViewById(R.id.img_login_facebook);
        tv_terms = findViewById(R.id.tv_terms_condition);
        chk_show_hide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (et_username.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Enter valid Username", Toast.LENGTH_SHORT).show();
                } else if (et_username.getText().toString().length() < 8) {
                    Toast.makeText(LoginActivity.this, "Username should be greater than 8 characters", Toast.LENGTH_SHORT).show();
                } else if (!et_username.getText().toString().matches("(.*[a-z].*)")) {
                    et_username.setError("Must contains atleast 1 lower case");
                } else if (!et_username.getText().toString().matches("(.*[A-Z].*)")) {
                    et_username.setError("Must contains atleast 1 UPPER CASE");
                } else if (!et_username.getText().toString().matches("(.*[!,@,#,$,%,^,&,_].*)")) {
                    et_username.setError("Must contains atleast 1 Special Symbol");
                } else if (!et_username.getText().toString().matches("(.*[0-9].*)")) {
                    et_username.setError("Must contains atleast 1 digit");
                } else if (et_password.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Enter valid password", Toast.LENGTH_SHORT).show();
                } else if (et_password.getText().toString().length() < 8) {
                    et_password.setError("Password should be greater than 8 characters");
                } else if (!et_password.getText().toString().matches("(.*[!,@,#,$,%,^,&,_].*)")) {
                    et_password.setError("Must contains atleast 1 Special Symbol");
                } else if (!et_password.getText().toString().matches("(.*[0-9].*)")) {
                    et_password.setError("Must contains atleast 1 digit");
                } else {
                    Toast.makeText(LoginActivity.this, "Login Successful!!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this, LoadingActivity.class);
                    i.putExtra("username", et_username.getText().toString());
                    i.putExtra("password", et_password.getText().toString());
                    editor.putString("user", et_username.getText().toString()).commit();
                    editor.putString("pass", et_password.getText().toString()).commit();
                    editor.putBoolean("Login", true).commit();
                    startActivity(i);
                }
            }
        });
        tv_registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(i);
                finish();
            }
        });
        img_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://accounts.google.com"));
                startActivity(i1);
            }
        });
        img_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com"));
                startActivity(i2);
            }
        });
        tv_terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://policies.google.com/terms?hl=en-IN"));
                startActivity(i);
            }
        });
    }
}
