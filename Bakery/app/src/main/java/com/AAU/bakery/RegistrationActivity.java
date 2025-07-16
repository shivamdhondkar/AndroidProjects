package com.AAU.bakery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class RegistrationActivity extends AppCompatActivity {
    EditText fullname;
    EditText email;
    EditText mob_no;
    EditText username;
    EditText pass;
    EditText c_password;
    Button bt2;
    CheckBox cb_show_hide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        fullname = findViewById(R.id.et_regis_full_name);
        email = findViewById(R.id.et_regis_email);
        mob_no = findViewById(R.id.et_regis_mob_no);
        username=findViewById(R.id.et_regis_username);
        pass=findViewById(R.id.et_regis_password);
        c_password=findViewById(R.id.et_regis_confirm_password);
        bt2 = findViewById(R.id.butt_regis_bt2);
        cb_show_hide=findViewById(R.id.chk_regis_show_hide);
        cb_show_hide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fullname.getText().toString().isEmpty()) {
                    fullname.setError("Please enter full name for complete registration");
                } else if (email.getText().toString().isEmpty()) {
                    email.setError("Please enter your email id");
                } else if (!email.getText().toString().contains("@") || !email.getText().toString().contains(".com")) {
                    email.setError("Please enter valid email ID");
                } else if (mob_no.getText().toString().isEmpty()) {
                    mob_no.setError("Please enter your mobile number");
                } else if (mob_no.getText().toString().length()!=10) {
                    mob_no.setError("Please enter valid mobile number");
                } else if (username.getText().toString().isEmpty()) {
                    username.setError("Username is compulsory");
                } else if (username.getText().toString().length()>10 && username.getText().toString().length()<8) {
                   username.setError("Username should not be less than 8 characters and do not exceed more than 10 characters");
                }  else if (!username.getText().toString().matches("(.*[a-z].*)"))  {
                    username.setError("Must contains atleast 1 lower case");
                }else if (!username.getText().toString().matches("(.*[A-Z].*)"))  {
                    username.setError("Must contains atleast 1 UPPER CASE");
                }else if (!username.getText().toString().matches("(.*[!,@,#,$,%,^,&,_].*)"))  {
                    username.setError("Must contains atleast 1 Special Symbol");
                }else if (!username.getText().toString().matches("(.*[0-9].*)"))  {
                    username.setError("Must contains atleast 1 digit");
                }else if (pass.getText().toString().isEmpty()) {
                    pass.setError("Please enter Password to be set");
                } else if (pass.getText().toString().length()<8) {
                    pass.setError("Password should not be less than 8 characters");
                } else if (!pass.getText().toString().matches("(.*[!,@,#,$,%,^,&,_].*)"))  {
                    pass.setError("Must contains atleast 1 Special character");
                }else if (!pass.getText().toString().equals(c_password.getText().toString())) {
                    c_password.setError("Password does not match");
                } else {
                    Toast.makeText(RegistrationActivity.this, "Registered Successfully!!", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(RegistrationActivity.this, LoginActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}




