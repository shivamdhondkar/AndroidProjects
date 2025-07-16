package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

package listview.studytonightexample.com.listview;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    TextView textView;
    String[] carBrands = {
            "Ferrari",
            "McLaren",
            "Jaguar",
            "Skoda",
            "Suzuki",
            "Hyundai",
            "Toyota",
            "Renault",
            "Mercedes",
            "BMW",
            "Ford",
            "Honda",
            "Chevrolet",
            "Volkswagon",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView)findViewById(R.id.gridView);
        textView = (TextView)findViewById(R.id.textView);

        final ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.grid_item, android.R.id.textView, carBrands);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub

                /* appending I Love with car brand names */
                String value = "I Love " + adapter.getItem(position);
                /* Display the Toast */
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}