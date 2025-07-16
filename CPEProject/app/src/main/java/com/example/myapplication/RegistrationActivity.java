package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Comman.Urls;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class RegistrationActivity extends AppCompatActivity {


    ImageView img_logo;
    EditText et_name;
    EditText et_number;
    EditText et_id;
    EditText et_username;
    EditText et_password;
    Button btn_registration;
    EditText et_c_pass;

    CheckBox chk_show_hide;
//    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        img_logo=findViewById(R.id.img_regs_logo);
        btn_registration=findViewById(R.id.btn_regs_registration);
        et_name=findViewById(R.id.et_regs_name);
        et_number=findViewById(R.id.et_regs_number);
        et_id=findViewById(R.id.et_regs_id);
        et_username=findViewById(R.id.et_regs_username);
        et_password=findViewById(R.id.et_regs_password);
        chk_show_hide=findViewById(R.id.chk_regs_show);
        et_c_pass=findViewById(R.id.et_regs_con_password);




        chk_show_hide.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if (isChecked)
                {
                    et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                }
                else {
                    et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });


        btn_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                if(et_name.getText().toString().isEmpty())

                {
                    et_name.setError("Please Enter your Name");
                } else if (et_name.getText().toString().length()<8) {

                    et_name.setError("Text must be greater than 8 ");
                    
                } else if (et_number.getText().toString().isEmpty()) {
                    et_number.setError("Please enter your Mobile Number");

                } else if (et_number.getText().toString().length()!=10 ) {
                    et_number.setError("Please enter Valid mobile number");


                } else if (et_id.getText().toString().isEmpty()) {

                    et_id.setError("Please Enter Email ID");

                } else if (!et_id.getText().toString().contains("@") || !et_id.getText().toString().contains(".com") ) {

                    et_id.setError("Invalid Email ID");




                    
                } else if (et_username.getText().toString().isEmpty()) {

                    et_username.setError("Please Enter your Username");

                } else if (et_username.getText().toString().length()<8) {

                    et_username.setError("Username must be greater than 8");

                } else if (!et_password.getText().toString().matches("(.*[a-z].*)")) {

                    et_password.setError("Password must contains at least one Lowercase");

                } else if (!et_password.getText().toString().matches(".*[A-Z].*")) {

                    et_password.setError("Password must contains at least one Uppercase");

                } else if (!et_password.getText().toString().matches(".*[0-9].*")) {

                    et_password.setError("Password must contains at least one Number");

                } else if (!et_password.getText().toString().matches(".*[!,@,#,$,%,^,&,*].*")) {
                    
                    et_password.setError("Password must contains at least one Special Symbol");
                    
                } else if (et_password.getText().toString().isEmpty()) {
                    et_password.setError("Please enter your Password");

                } else if (et_password.getText().toString().length()<8) {

                    et_password.setError("Password must be greater than 8");

                } else if (!et_password.getText().toString().equals(et_c_pass.getText().toString())) {

                    Toast.makeText(RegistrationActivity.this,"Password does not Matches",Toast.LENGTH_SHORT).show();

                    
                }

                else {

//                    progressDialog=new ProgressDialog(RegistrationActivity.this);
//                    progressDialog.setTitle("Registering User");
//                    progressDialog.setCancelable(true);
//                    progressDialog.setCanceledOnTouchOutside(true);
//                    progressDialog.setMessage("Please Wait...");
//                    progressDialog.show();

                    Toast.makeText(RegistrationActivity.this, "Registration Successfully Done", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(RegistrationActivity.this,LoginActivity2.class);
                    startActivity(intent);
                    finish();

                    register_user();

                }


            }
        });


        

    }

    private void register_user() {

        AsyncHttpClient client= new AsyncHttpClient();
        RequestParams params=new RequestParams();

        params.put("name",et_name.getText().toString());
        params.put("mobile_no",et_number.getText().toString());
        params.put("email_id",et_id.getText().toString());
        params.put("username",et_username.getText().toString());
        params.put("password",et_password.getText().toString());

        client.post(Urls.register_user,params,new JsonHttpResponseHandler()
                {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
//                        progressDialog.dismiss();


                        try{
                            String status=response.getString("success");


                            if (status.equals("1"))
                            {

                                Toast.makeText(RegistrationActivity.this, "Registration Successfully Done", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(RegistrationActivity.this,LoginActivity2.class);
                                startActivity(intent);
                                finish();
                            }
                            else
                            {

                                Toast.makeText(RegistrationActivity.this, "Already Registration Done", Toast.LENGTH_SHORT).show();
                            }


                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
//                        progressDialog.dismiss();

                        Toast.makeText(RegistrationActivity.this, "Server Not Found", Toast.LENGTH_SHORT).show();
                        Toast.makeText(RegistrationActivity.this, errorResponse.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }





}
