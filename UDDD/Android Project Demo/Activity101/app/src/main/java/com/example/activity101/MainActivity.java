package com.example.activity101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import  android.util.Log;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String tag="N04 LifeCycle ";

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.new_layout);

        button = findViewById(R.id.button3);

        if(button!=null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, Activity_Second.class);
                    startActivity(intent);

                }
            });
        }


        Log.d(tag,"In the onCreate() event");
    }


    public void  onStart()
    {
        super.onStart();
        Log.d(tag,"in the onStart() event");
    }

    public void onRestart()
    {
        super.onRestart();
        Log.d(tag,"in the onRestart() event");
    }

    public  void onResume()
    {
        super.onResume();
        Log.d(tag,"in the onResume event");
    }

    public  void onPause()
    {
        super.onPause();
        Log.d(tag,"in the onPause() event");
    }
    public  void onStop()
    {
        super.onStop();
        Log.d(tag,"in the onStop() event");
    }
    public  void onDestroy()
    {
        super.onDestroy();
        Log.d(tag,"in the onDestroy() event");
    }



}
