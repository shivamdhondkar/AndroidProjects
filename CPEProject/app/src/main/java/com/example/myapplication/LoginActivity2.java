package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity2 extends AppCompatActivity {


    ImageView img_google;
    ImageView img_twitter;
    EditText et_username, et_password;
    CheckBox chk_show_hide;
    Button btn_login,btn_login_google;
    TextView tv_new_user;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    LottieAnimationView profile;
    TextView tv_terms_and_condition;
    GoogleSignInClient client;

    FirebaseDatabase database;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);


        et_username = findViewById(R.id.et_login_username);
        et_password = findViewById(R.id.et_login_password);

        setTitle("Login Page");



        preferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity2.this);
        editor = preferences.edit();

        if (preferences.getBoolean("Login", false)) {
            Intent i = new Intent(LoginActivity2.this, HomeActivity.class);
            startActivity(i);
            finish();



        }







        img_google = findViewById(R.id.img_google_logo);
        img_twitter = findViewById(R.id.img_twitter_logo);
        et_username = findViewById(R.id.et_login_username);
        et_password = findViewById(R.id.et_login_password);
        chk_show_hide = findViewById(R.id.chk_login_show_hide);
        btn_login = findViewById(R.id.btn_login_login);
        btn_login_google=findViewById(R.id.btn_login_google);
        tv_new_user = findViewById(R.id.tv_login_new_user);
        tv_terms_and_condition=findViewById(R.id.tv_login_terms_and_condition);
        profile = findViewById(R.id.lottie);

        GoogleSignInOptions options= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail().build();

        client=GoogleSignIn.getClient(LoginActivity2.this,options);

        database=FirebaseDatabase.getInstance();

        btn_login_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =client.getSignInIntent();
                startActivityForResult(i,999);
            }
        });



        profile.animate().translationY(2000).setDuration(2000).setStartDelay(512100);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


            }
        }, 5000);


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


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (et_username.getText().toString().isEmpty()) {
                    et_username.setError("Please Enter Your Username");
                } else if (et_username.getText().toString().length() < 8) {
                    et_username.setError("Text must be Greater than 8");
                } else if (et_password.getText().toString().isEmpty()) {
                    et_password.setError("Please Enter the Password");
                } else if (et_password.getText().toString().length() < 8) {
                    et_password.setError("Please Enter Password Greater than 8");
                } else {

                    Toast.makeText(LoginActivity2.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity2.this, HomeActivity.class);
                    i.putExtra("username",et_username.getText().toString());
                    i.putExtra("password",et_password.getText().toString());
                    editor.putString("user",et_username.getText().toString()).commit();
                    editor.putString("pass",et_password.getText().toString()).commit();
                    editor.putBoolean("Login", true).commit();
                    startActivity(i);
                    finish();
                }
            }
        });


        tv_new_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity2.this, RegistrationActivity.class);
                startActivity(i);
            }
        });


        tv_terms_and_condition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://policies.google.com/terms?hl=en-IN"));
                startActivity(i);
            }
        });

        img_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gotoUrl("https://accounts.google.com/");
            }

        });

        img_twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gotoUrl("https://twitter.com/?lang=en-in");
            }
        });

    }



    private void gotoUrl(String s) {

        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }


    }




