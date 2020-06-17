package com.example.learnactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    Button btFinish;
    TextView textView2;
    EditText editText2;
    public static int RESULT_TO_A1 =200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        final Intent intent=getIntent();


        String name = intent.getStringExtra("dataA1");


        btFinish= findViewById(R.id.btFinish);
        textView2=findViewById(R.id.textView1);

        textView2.setText(name);
        editText2 = findViewById(R.id.edA2);

        btFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //get text from edittext
                String toA1 = editText2.getText().toString();

                Intent intent1= new Intent();
                intent1.setClass(Activity2.this,Activity1.class);

                intent1.putExtra("data2",toA1);

                setResult(RESULT_TO_A1,intent1);

                finish();
            }
        });
    }
}
