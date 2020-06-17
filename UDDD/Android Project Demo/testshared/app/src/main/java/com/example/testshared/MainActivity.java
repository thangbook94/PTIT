package com.example.testshared;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editText, editText1;
    Button button;
    TextView textView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        editText1 = findViewById(R.id.editText3);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView2);
        final SharedPreferences sharedPreferences = this.getSharedPreferences("shared1", MODE_PRIVATE);
        if (60 != sharedPreferences.getInt("color", 60)) {
            int c = sharedPreferences.getInt("color", Color.GRAY);
            c = Color.RED;
            textView.setTextColor(c);
            int s = sharedPreferences.getInt("size", 60);
            textView.setTextSize(s);
            button.setEnabled(false);
            Toast.makeText(getApplicationContext(), "Get size and color success ", Toast.LENGTH_LONG).show();

        } else {
            textView.setText("Please fill size and color!!!!!!");

        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                int color = Integer.parseInt(editText1.getText().toString());
                editor.putInt("color", color);
                int size = Integer.parseInt(editText.getText().toString());
                editor.putInt("size", size);
                editor.apply();
            }
        });
    }
}
