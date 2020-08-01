package com.example.ck3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import dbhelper.DbHelper;
import entity.Phong;

public class PhongChiTiet extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phong_chi_tiet);
        Intent intent = getIntent();
        String tang = intent.getStringExtra("tang");
        lv = findViewById(R.id.lstView);
        List<Phong> list = (new DbHelper(getApplicationContext())).getPhong();
        for (Phong i : list) {
            if (!i.getTang().equals(tang)) {
                list.remove(i);
            }
        }
        PhongAdapter p = new PhongAdapter(this, list);
        lv.setAdapter(p);
    }
}