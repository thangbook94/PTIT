package com.example.recyclerview1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Person> people;


        recyclerView=findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        manager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(manager);

        people= new ArrayList<Person>();

        people.add(new Person("Hoang Anh","Nguyen","bus"));
        people.add(new Person("Nam","Le","bus"));
        people.add(new Person("Xuan Anh","Minh","fly"));
        people.add(new Person("Minh","PHam","bus"));
        people.add(new Person("Quang Anh","Tran","bus"));
        people.add(new Person("Nam","Le","bus"));
        people.add(new Person("Xuan Anh","Minh","fly"));
        people.add(new Person("Minh","PHam","bus"));
        people.add(new Person("Quang Anh","Tran","bus"));
        people.add(new Person("Nam","Le","bus"));
        people.add(new Person("Xuan Anh","Minh","fly"));
        people.add(new Person("Minh","PHam","bus"));
        people.add(new Person("Quang Anh","Tran","bus"));

        int count = people.size();

        PersonAdapter myAdapter = new PersonAdapter(this,people);

        recyclerView.setAdapter(myAdapter);

    }
}
