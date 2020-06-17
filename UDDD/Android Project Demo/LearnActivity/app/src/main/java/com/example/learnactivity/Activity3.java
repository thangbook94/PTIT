package com.example.learnactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity3 extends AppCompatActivity {

    Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        bt1 = findViewById(R.id.btToA2);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Activity3.this,Activity2.class);
                intent.putExtra("toA2","msg from A3");
                startActivity(intent);
            }
        });
    }
}
