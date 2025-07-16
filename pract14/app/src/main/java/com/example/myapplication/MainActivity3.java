package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.myapplication.Design.GridviewAdapter;
import com.example.myapplication.model.AlphabetModel;
import com.example.myapplication.model.ArrayListName;

public class MainActivity3 extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        GridView gridView = findViewById(R.id.gridView);
        GridviewAdapter gridviewAdapter = new GridviewAdapter(MainActivity3.this,new ArrayListName().setListData());

        gridView.setAdapter(gridviewAdapter);
        gridView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {

        AlphabetModel model = (AlphabetModel) parent.getItemAtPosition(position);
        Toast.makeText(MainActivity3.this, "Clicked On : "+model.getLetters(), Toast.LENGTH_SHORT).show();

    }
}