package com.example.autocomplete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView textView1;
    MultiAutoCompleteTextView textViewMulti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1=findViewById(R.id.autoCompleteTextview1);
        textViewMulti=findViewById(R.id.multiAutoCOmplete1);

        // Ket noi CSDL hoac API
        // Lay ds tra ve
        // Cho vao Mang
        // Gan vao listview, spinner, autocomplete

        String[] students = {"Nam","Lan","Hoa","Hanh","Thanh","Trung","Son","Dung","Van","Manh","Thang"};

       // textView1.addTextChangedListener((TextWatcher) this);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,students);

        textView1.setAdapter(adapter1);
        textView1.setThreshold(2);

        //Multi
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,students);
        textViewMulti.setAdapter(adapter2);
        textViewMulti.setThreshold(1);
        textViewMulti.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
