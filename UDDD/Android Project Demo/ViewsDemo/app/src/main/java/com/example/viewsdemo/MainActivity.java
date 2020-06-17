package com.example.viewsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    EditText ed1;
    Button bt1;
    CheckBox cb1;
    ToggleButton toggleButton1;
    RadioGroup group1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Textview
        tv1=findViewById(R.id.tv1);
        tv1.setText("Thiet lap Textview");
        //Edit texxt


        //button
        bt1=findViewById(R.id.bt1);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ed1=findViewById(R.id.edt1);
                String text1=ed1.getText().toString();

                int i = Integer.parseInt(text1);

                Toast.makeText(MainActivity.this,String.valueOf(i),Toast.LENGTH_SHORT).show();
            }
        });

        //check box
        cb1=findViewById(R.id.checkbox1);

        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb1.isChecked()==false) {
                    Toast.makeText(MainActivity.this, "un check", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(MainActivity.this,"Checked", Toast.LENGTH_SHORT).show();

                }
            }
        });

        //Toggle Button
        toggleButton1 = findViewById(R.id.toggle1);

        toggleButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "button On", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Button OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });




        //Radio Group
        group1=findViewById(R.id.group1);

        int idCheck = group1.getCheckedRadioButtonId();

        if (idCheck==R.id.rb1)
            Toast.makeText(MainActivity.this,"1 selected",Toast.LENGTH_SHORT).show();
        if (idCheck==R.id.rb2)
            Toast.makeText(MainActivity.this,"2 selected",Toast.LENGTH_SHORT).show();
        if (idCheck==R.id.rb3)
            Toast.makeText(MainActivity.this,"3 selected",Toast.LENGTH_SHORT).show();
        if (idCheck==R.id.rb4)
            Toast.makeText(MainActivity.this,"4 selected",Toast.LENGTH_SHORT).show();

        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.rb1)
                    Toast.makeText(MainActivity.this,"1 selected",Toast.LENGTH_SHORT).show();
                if (checkedId==R.id.rb2)
                    Toast.makeText(MainActivity.this,"2 selected",Toast.LENGTH_SHORT).show();
                if (checkedId==R.id.rb3)
                    Toast.makeText(MainActivity.this,"3 selected",Toast.LENGTH_SHORT).show();
                if (checkedId==R.id.rb4)
                    Toast.makeText(MainActivity.this,"4 selected",Toast.LENGTH_SHORT).show();
            }
        });















    }
}
