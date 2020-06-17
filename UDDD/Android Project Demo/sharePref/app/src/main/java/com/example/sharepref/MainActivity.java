package com.example.sharepref;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import java.util.Set;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // context
        Context context= MainActivity.this;

        // create sharepref
        SharedPreferences sharedPreferences=context.getSharedPreferences("test",MODE_PRIVATE);


        SharedPreferences sharedPreferences1=context.getSharedPreferences("N04",MODE_PRIVATE);

        // create editor
     //   SharedPreferences.Editor editor=sharedPreferences.edit();


        SharedPreferences.Editor editor1= sharedPreferences1.edit();



     //   editor.putInt("age",70);

     //   editor.putString("surName","Hello N03");

     //   editor.putBoolean("yes_or_no",true);

      //  editor1.put
        editor1.putString("hello","xin chao cac ban nhom N04 abcd");
        editor1.putInt("Number",1000);
        editor1.putBoolean("co_dieu_hoa",true);

        Set<String> stringSet = new HashSet<>();
        stringSet.add("SetOne");
        stringSet.add("SetTwo");
        stringSet.add("SetThree");

       // editor1.pu

        editor1.putStringSet("set",stringSet);


     //   editor.commit();
        editor1.commit();

        int realAge= sharedPreferences1.getInt("Number",0);

        String s=sharedPreferences1.getString("hello","");

        Toast.makeText(MainActivity.this,String.valueOf( realAge),Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();



    }
}
