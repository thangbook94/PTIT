package com.example.explicitintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtName;
    Button btnAct2, btnAct3;
    TextView textViewResult;
    final int ACTIVITY3 =3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        btnAct2= findViewById(R.id.btnActiviy2);
        btnAct3=findViewById(R.id.btnActiviy3);
        textViewResult=findViewById(R.id.tvResult);

        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtName.getText().toString().trim()=="")
                {
                    Toast.makeText(MainActivity.this,"Please insert some Text",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String name = edtName.getText().toString();
                   // Intent intent = new Intent(MainActivity.this,com.example.explicitintent.Activity2.class);

                    Intent intent=new Intent();
                    intent.setClass(MainActivity.this,Activity2.class);



                    intent.putExtra("toActivity2",name);

                    startActivity(intent);

                }

            }
        });

        btnAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent =new Intent(MainActivity.this,com.example.explicitintent.Activity3.class);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Activity3.class);

                //startActivity(intent);

                startActivityForResult(intent,ACTIVITY3);


            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==ACTIVITY3)
        {
            if(resultCode==RESULT_OK)
            {
                String dataReceive = data.getStringExtra("surName");
                textViewResult.setText(dataReceive);
            }
            else if (resultCode==RESULT_CANCELED)
            {
                textViewResult.setText("Nothing received!");

            }

        }
    }
}
