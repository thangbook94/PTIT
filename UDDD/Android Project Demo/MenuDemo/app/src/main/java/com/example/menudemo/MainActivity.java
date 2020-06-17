package com.example.menudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_demo,menu);


        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

       // Toast.makeText(MainActivity.this,"selected",Toa)
        switch (item.getItemId()){
            case R.id.menuSetting:
                Toast.makeText(MainActivity.this,"Setting selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuSearch:
                Toast.makeText(MainActivity.this,"Search selected",Toast.LENGTH_SHORT).show();

                break;
            case R.id.menuShare:
                Toast.makeText(MainActivity.this,"Share selected",Toast.LENGTH_SHORT).show();

                break;
            case R.id.sharePicMenu:
                break;
            case R.id.menuExit:
                MainActivity.this.finish();
                break;

        }


        return super.onOptionsItemSelected(item);
    }
}
