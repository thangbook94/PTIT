package com.example.ck3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button view, add;
    EditText username, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.viewPhong);
        add = findViewById(R.id.addPhong);
        username = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("admin") && pass.getText().toString().equals("admin")) {
                    Intent i = new Intent(MainActivity.this, addPhong.class);
                    startActivity(i);
                }
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("admin") && pass.getText().toString().equals("admin")) {
                    Intent i = new Intent(MainActivity.this, viewPhong.class);
                    startActivity(i);
                }
            }
        });
    }
}