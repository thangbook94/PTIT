package com.example.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1=findViewById(R.id.spinner1);

        final String goods[] = {"TV","Labtop","SmartPhone", "Watch","Book"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,goods);

        adapter1.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);

        spinner1.setAdapter(adapter1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"position:"+position +"values"+goods[position],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        /*
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"position: "+ position+"-value:"+goods[position],Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/


    }
}
