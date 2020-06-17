package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.TextView;
import android.widget.Button;

import android.os.Bundle;
public class Activity2 extends AppCompatActivity {

    TextView tvWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        tvWelcome= findViewById(R.id.tvWelcome);
        Intent intent=getIntent();

        String name =intent.getStringExtra("toActivity2");
        tvWelcome.setText(name+", welcome to Activity 2");




    }
}
