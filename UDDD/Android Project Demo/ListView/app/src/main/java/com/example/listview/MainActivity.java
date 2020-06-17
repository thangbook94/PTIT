package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1 = findViewById(R.id.listview1);

        final String[] students = {"Nam", "Lan", "Hoa", "Hanh", "Thanh",
                "Trung", "Son", "Dung", "Van", "Manh", "Thang"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, students);

        listView1.setAdapter(adapter1);

        // Bat su kien Click
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "position: " +
                        position + " - value: " + students[position], Toast.LENGTH_LONG
                ).show();

                Intent intent = new Intent();
                //   intent.setClass(th);
                intent.putExtra("id", position);


            }
        });


    }
}
