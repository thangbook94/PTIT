package com.example.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.ListItemClicked {

    TextView tvDescription;

    //Part 1
    //ArrayList<String> descriptions;

    //Part2
    String [] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Map

        tvDescription = findViewById(R.id.tvDetail);

        // array string -> Part
       // descriptions = new ArrayList<String>();
       // descriptions.add("1. Detail Click");
       // descriptions.add("2. Detail Click");
       // descriptions.add("3. Detail Click");

        //Part2
        descriptions = getResources().getStringArray(R.array.descriptions);
        //landscape mode
        if (findViewById(R.id.layout_land) !=null)
        {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();

        }
        // Portrait mode
        if (findViewById(R.id.layout_portrait)!=null)
        {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();

        }





    }

    @Override
    public void onItemSelected(int index) {
       //Part1
        // tvDescription.setText(descriptions.get(index));

        //Part 2
        tvDescription.setText(descriptions[index]);

        if (findViewById(R.id.layout_portrait)!=null) {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .hide(manager.findFragmentById(R.id.listFrag))
                    .addToBackStack(null)
                    .commit();
        }
    }
}
