package com.example.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    Button btCall, btCallFriend, btOpenWeb, btOpenMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCall= findViewById(R.id.btnCall);
        btCallFriend=findViewById(R.id.btnCallFriend);
        btOpenMap=findViewById(R.id.btnOpenApp);
        btOpenWeb=findViewById(R.id.btnOpenWeb);

        btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);

            }
        });

        btCallFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0936461828"));
                startActivity(intent);

            }
        });

        btOpenWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.ptit.edu.vn"));
                startActivity(intent);

            }
        });

        btOpenMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q= Vo chi Cong, Tay Ho, Ha Noi"));
                startActivity(intent);

            }
        });
    }
}
