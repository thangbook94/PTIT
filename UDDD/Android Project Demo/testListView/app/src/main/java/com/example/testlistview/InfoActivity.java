package com.example.testlistview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {
    String name;
    String desc;
    TextView tv;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        tv = findViewById(R.id.textView12);
        iv = findViewById(R.id.imageView);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        desc = intent.getStringExtra("desc");
        tv.setText(desc);
        switch (name) {
            case "Chess Piece - King": {
                iv.setImageResource(R.drawable.king);
            }
            case "Chess Piece - Queen": {
                iv.setImageResource(R.drawable.queen);
            }
            case "Chess Piece - Bishop": {
                iv.setImageResource(R.drawable.bishop);
            }
            case "Chess Piece - Knight": {
                iv.setImageResource(R.drawable.knigh);
            }
            case "Chess Piece - Rook": {
                iv.setImageResource(R.drawable.rook);
            }
            case "Chess Piece - Pawn": {
                iv.setImageResource(R.drawable.rook);
            }
        }

    }
}
