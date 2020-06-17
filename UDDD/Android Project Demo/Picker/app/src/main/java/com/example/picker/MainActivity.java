package com.example.picker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker1;
    DatePicker datePicker1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker1=findViewById(R.id.timePicker1);
        //timePicker1.setIs24HourView(true);
        Toast.makeText(getBaseContext(),"time: "+timePicker1.getCurrentHour()+" : "+timePicker1.getCurrentMinute(),Toast.LENGTH_SHORT).show();

        datePicker1=findViewById(R.id.datePiker1);
        Toast.makeText(getBaseContext(),"date:" +datePicker1.getDayOfMonth()+":"
        + (datePicker1.getMonth()-1)+":"+datePicker1.getYear(),Toast.LENGTH_SHORT).show();
    }
}
