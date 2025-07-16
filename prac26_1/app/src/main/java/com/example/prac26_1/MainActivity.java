package com.example.prac26_1;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText branchEditText;
    private Button insertButton;
    private ListView dataListView;

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.name_edit_text);
        branchEditText = findViewById(R.id.branch_edit_text);
        insertButton = findViewById(R.id.insert_button);
        dataListView = findViewById(R.id.data_list_view);

        dbHelper = new DatabaseHelper(this);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

        new FetchDataTask().execute();
    }

    private void insertData() {
        String name = nameEditText.getText().toString().trim();
        String branch = branchEditText.getText().toString().trim();

        if (name.isEmpty() || branch.isEmpty()) {
            Toast.makeText(this, "Please enter both name and branch.", Toast.LENGTH_SHORT).show();
            return;
        }

        InsertDataTask insertDataTask = new InsertDataTask();
        insertDataTask.execute(name, branch);
    }

    private class InsertDataTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {
            String name = params[0];
            String branch = params[1];

            dbHelper.insertData(name, branch);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(MainActivity.this, "Data inserted successfully.", Toast.LENGTH_SHORT).show();
            nameEditText.setText("");
            branchEditText.setText("");

            new FetchDataTask().execute();
        }
    }

    private class FetchDataTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... params) {
            return dbHelper.getAllData();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            super.onPostExecute(cursor);

            // Create an adapter for the ListView
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                    MainActivity.this,
                    android.R.layout.simple_list_item_2,
                    cursor,
                    new String[] { DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_BRANCH },
                    new int[] { android.R.id.text1, android.R.id.text2 },
                    0
            );

            // Set the adapter to the ListView
            dataListView.setAdapter(adapter);
        }
    }
}

