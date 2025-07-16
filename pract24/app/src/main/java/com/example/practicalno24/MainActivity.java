package com.example.practicalno24;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_ENABLE_BT= 0;
    private static final int REQUEST_DISABLE_BT= 1;
    TextView mStatusBlueTv,mPaired;
    ImageView mBlueTv;
    Button mOnBtn,mOffBtn,mDiscoverableBtn,mPairedBtn;
    BluetoothAdapter mBlueAdapter;
    private Object msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStatusBlueTv = findViewById(R.id.statusBluetoothTV);
        mPaired = findViewById(R.id.pairedTv);
        mBlueTv = findViewById(R.id.bluetoothTv);
        mOnBtn = findViewById(R.id.onBtn);
        mOffBtn = findViewById(R.id.offBtn);
        mDiscoverableBtn = findViewById(R.id.discoveravleBtn);
        mPairedBtn = findViewById(R.id.pairedBtn);

        mBlueAdapter = BluetoothAdapter.getDefaultAdapter();

        if (mBlueAdapter==null){
            mStatusBlueTv.setText("Bluetooth is Not Available");
        }else {
            mStatusBlueTv.setText("Bluetooth is Available");
        }

        if(mBlueAdapter.isEnabled()){
            mBlueTv.setImageResource(R.drawable.ic_action_on);
        }else{
            mBlueTv.setImageResource(R.drawable.ic_action_off);
        }
        mOnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mBlueAdapter.isEnabled()){
                    showToast("Turning ON Bluetooth");

                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(intent,REQUEST_ENABLE_BT);
                }else {
                    showToast("Bluetooth is Already ON");
                }
            }
        });

        mDiscoverableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mBlueAdapter.isDiscovering()){
                    showToast("Make Your Device Discoverable");
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(intent,REQUEST_DISABLE_BT);
                }
            }
        });

        mOffBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View view) {
                if (!mBlueAdapter.isEnabled()){
                    mBlueAdapter.disable();

                }
            }
        });

        mPairedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case REQUEST_ENABLE_BT:
                if(resultCode==RESULT_OK){
                    mBlueTv.setImageResource(R.drawable.ic_action_on);
                    showToast("Bluetooth os ON");
                }else {
                    showToast("Bluetooth os OFF");
                }
        }
        super.onActivityResult(requestCode,resultCode,data);
    }

    private void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}