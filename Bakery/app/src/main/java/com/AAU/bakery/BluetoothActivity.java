package com.AAU.bakery;

import static android.R.layout.simple_spinner_dropdown_item;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class BluetoothActivity extends AppCompatActivity {
    Button btn_turn_on,btn_get_visible,btn_paired_devices,btn_turn_off;
    ListView lv_paired_devices;
    BluetoothAdapter bluetoothAdapter;
    Set<BluetoothDevice> bluetoothDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        btn_turn_on=findViewById(R.id.btn_buetooth_turn_on);
        btn_get_visible=findViewById(R.id.btn_bluetooth_get_visible);
        btn_paired_devices=findViewById(R.id.btn_bluetooth_paired_devices);
        btn_turn_off=findViewById(R.id.btn_bluetooth_turn_off);
        lv_paired_devices=findViewById(R.id.lv_bluetooth_pd);

        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();

    }

    @SuppressLint("MissingPermission")
    public void turnOn(View view) {
        if (!bluetoothAdapter.isEnabled())
        {
            Intent i= new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(i,100);
        }
    }
    @SuppressLint("MissingPermission")
    public void getVisible(View view) {
        Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivityForResult(i,200);
    }
    @SuppressLint("MissingPermission")
    public void pairedDevices(View view) {
        bluetoothDevice=bluetoothAdapter.getBondedDevices();
        ArrayList list=new ArrayList();
        for(BluetoothDevice bd:bluetoothDevice){
            list.add(bd.getName());
            ArrayAdapter adapter= new ArrayAdapter(BluetoothActivity.this,
                    android.R.layout.simple_dropdown_item_1line,list);
            lv_paired_devices.setAdapter(adapter);
        }
    }
    @SuppressLint("MissingPermission")
    public void turnOff(View view) {
        bluetoothAdapter.disable();
    }
}