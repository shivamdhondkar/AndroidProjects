package com.AAU.bakery;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
    CircleImageView circular_icon;
    EditText et_name,et_mob_no,et_email,et_address,et_dob,et_about;
    Button btn_save;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private final int CAMERA_REQ_CODE = 1000;
    private final int GALLERY_REQ_CODE = 1005;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        preferences= PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this);
        editor=preferences.edit();
        circular_icon=findViewById(R.id.profile_icon);
        et_name=findViewById(R.id.et_name);
        et_mob_no=findViewById(R.id.et_mob);
        et_about=findViewById(R.id.et_profile_about);
        et_email=findViewById(R.id.et_email);
        et_address=findViewById(R.id.et_address);
        et_dob=findViewById(R.id.et_dob);
        btn_save=findViewById(R.id.btn_profile_save);

        String str_name = preferences.getString("name1","");
        String str_mobile_no = preferences.getString("mobile_no1","");
        String str_about = preferences.getString("about1","");
        Toast.makeText(this, "Profile Activity Name is "+str_name, Toast.LENGTH_SHORT).show();
        et_name.setText(str_name);
        et_mob_no.setText(str_mobile_no);
        et_about.setText(str_about);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ProfileActivity.this, MyProfileActivity.class);
                editor.putString("name1",et_name.getText().toString()).commit();
                editor.putString("mobile_no1",et_mob_no.getText().toString()).commit();
                editor.putString("about1",et_about.getText().toString()).commit();
                Toast.makeText(ProfileActivity.this, ""+et_name.getText().toString(),Toast.LENGTH_SHORT).show();
                startActivity(i);
                finish();
            }
        });

        circular_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ad= new AlertDialog.Builder(ProfileActivity.this);
                ad.setTitle("Profile Photo");
                ad.setMessage("Choose picture");
                ad.setNegativeButton("Camera", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent ic= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(ic,CAMERA_REQ_CODE);
                    }
                }).create().show();
                ad.setNegativeButton("Gallery", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent ig=new Intent(Intent.ACTION_PICK);
                        ig.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(ig,GALLERY_REQ_CODE);
                    }
                }).create().show();
                Toast.makeText(ProfileActivity.this, "My Profile Click", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if (requestCode==CAMERA_REQ_CODE){
                Bitmap img=(Bitmap)data.getExtras().get("data");
                circular_icon.setImageBitmap(img);
            }
        } else if (resultCode==RESULT_OK) {
            if (requestCode==GALLERY_REQ_CODE){
                circular_icon.setImageURI(data.getData());
            }
        }
    }
}