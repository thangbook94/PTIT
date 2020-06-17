package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;

public class Activity3 extends AppCompatActivity {

    Button btOK, btCancel;
    TextView tvSurName;
    EditText editTextSurName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);


        btOK=findViewById(R.id.btnSubmit);
        btCancel=findViewById(R.id.btnCancel);
      //  tvSurName=findViewById(R.id.edtSurName);
        editTextSurName = findViewById(R.id.edtHello);

        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editTextSurName.getText().toString().isEmpty())
                {
                    Toast.makeText(Activity3.this,"Please enter some Text", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String surName= editTextSurName.getText().toString();

                    Intent intent = new Intent();
                    intent.putExtra("surName", surName);

                    setResult(RESULT_OK,intent);

                    Activity3.this.finish();
                }
            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                Activity3.this.finish();
            }
        });

    }
}
