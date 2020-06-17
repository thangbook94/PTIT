package com.example.learnactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity1 extends AppCompatActivity {

    Button btClick,btToA3;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity1);

        btClick=findViewById(R.id.buttonLearn);
        textView= findViewById(R.id.textView);
        btToA3 = findViewById(R.id.btToA3);

        btClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = textView.getText().toString();//lay gia tri Textview, gan vao bien name

              //  Toast.makeText(Activity1.this,name,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();

                intent.setClass(Activity1.this,Activity2.class);


                intent.putExtra("dataA1", name);

               // startActivity(intent);
                startActivityForResult(intent,Activity2.RESULT_TO_A1);

            }
        });

        btToA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Activity1.this,Activity3.class);

                startActivity(intent);
            }
        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==Activity2.RESULT_TO_A1)
       // if (resultCode==RE)
        {
            String s = data.getStringExtra("data2");
            textView.setText(s);

        }
    }
}
