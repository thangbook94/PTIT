package com.example.ck3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dbhelper.DbHelper;
import entity.Phong;

public class viewPhong extends AppCompatActivity {
    ListView lv;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_phong);
        lv = findViewById(R.id.lsttang);
        DbHelper db = new DbHelper(getApplicationContext());
        List<Phong> list;
        list = db.getPhong();
        final HashMap<String, Integer> map = new HashMap<>();
        for (Phong i : list) {
            if (map.containsKey(i.getTang())) {
                int temp = map.get(i.getTang());
                temp++;
                map.put(i.getTang(), temp);
            } else {
                map.put(i.getTang(), 1);
            }
        }
        ArrayList<String> lst = new ArrayList<>();
        arrayList = new ArrayList<>();
        for (String i : map.keySet()) {
            lst.add("tang " + i + " co so phong la: " + map.get(i));
            arrayList.add(i);
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, lst);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(viewPhong.this, PhongChiTiet.class);

                intent.putExtra("tang", arrayList.get(i));
                startActivity(intent);
            }
        });
    }
}