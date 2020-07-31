package com.example.ck2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DbHelper.DbHelper;
import entity.User;

public class ThongKe extends AppCompatActivity {
    Button dotuoi, gioitinh, chuyenmon;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);
        dotuoi = findViewById(R.id.dotuoi);
        gioitinh = findViewById(R.id.gioitinh);
        chuyenmon = findViewById(R.id.chuyenmontk);
        lv = findViewById(R.id.listview);
        final List<User> list = (new DbHelper(getApplicationContext())).getAllUser();
        dotuoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, Integer> map = new HashMap<>();
                for (User u : list) {
                    if (map.containsKey(u.getNamSinh())) {
                        int temp = map.get(u.getNamSinh());
                        temp++;
                        map.put(u.getNamSinh(), temp);
                    } else {
                        map.put(u.getNamSinh(), 1);
                    }
                }
                ArrayList<String> list1 = new ArrayList<>();
                for (String i : map.keySet()) {
                    list1.add(i + "    " + map.get(i));
                }
                UserAdapter userAdapter = new UserAdapter(ThongKe.this, list1);
                lv.setAdapter(userAdapter);
            }
        });

        chuyenmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, Integer> map = new HashMap<>();
                for (User u : list) {
                    if (map.containsKey(u.getChuyenMon())) {
                        int temp = map.get(u.getChuyenMon());
                        temp++;
                        map.put(u.getChuyenMon(), temp);
                    } else {
                        map.put(u.getChuyenMon(), 1);
                    }
                }
                ArrayList<String> list1 = new ArrayList<>();
                for (String i : map.keySet()) {
                    list1.add(i + "  " + map.get(i));
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, list1);
                lv.setAdapter(adapter);
            }
        });
        gioitinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, Integer> map = (new DbHelper(getApplicationContext())).getChuyenMon();
                Toast.makeText(getApplicationContext(), map.size() + "", Toast.LENGTH_SHORT).show();
            }
        });
    }
}