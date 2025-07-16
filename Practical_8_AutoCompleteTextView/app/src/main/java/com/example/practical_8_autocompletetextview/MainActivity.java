

package com.example.practical_8_autocompletetextview;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String[] NAMES = new String[]
                    {  "Jawaharlal Nehru", "Gulzarilal Nanda", "Lal Bahadur Shastri", "Gulzarilal Nanda", "Indira Gandhi",
                    "Morarji Desai", "Charan Singh", "Rajiv Gandhi", "Vishwanath Pratap Singh", "Chandra Shekhar",
                    "P. V. Narasimha Rao", "Atal Bihari Vajpayee", "H. D. Deve Gowda", "I. K. Gujral", "Atal Bihari Vajpayee",
                    "Manmohan Singh", "Narendra Modi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, NAMES);

        autoCompleteTextView.setAdapter(adapter);
    }
}
