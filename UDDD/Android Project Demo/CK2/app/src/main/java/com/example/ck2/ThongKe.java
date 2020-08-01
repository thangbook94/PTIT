package com.example.ck2;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
                List<String> map = getChuyenMon();
                Toast.makeText(getApplicationContext(), map.size() + "", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public List<String> getChuyenMon() {
//        HashMap<String, Integer> map = new HashMap<>();
//        Cursor c = this.getReadableDatabase().rawQuery("select namSinh, count(id) from user group by namSinh;", null);
//        if (c.moveToFirst()) {
//            while (c.moveToNext()) {
//                String namsinh = c.getString(0);
//                int soluong = c.getInt(1);
//                map.put(namsinh, soluong);
//            }
//        }
//        for (String i : map.keySet()) {
//            Log.v("ffasfasfasfasf", i + " XXXXXX " + map.get(i));
//        }
        Uri uri = Uri.parse("content://contacts/people");
        ArrayList<String> list = new ArrayList<>();
        Cursor c1 = this.getContentResolver().query(uri, null, null, null, null);
        if (c1.moveToFirst()) {
            do {
                String id = ContactsContract.Contacts._ID;
                String s = "";
                int idIndex = c1.getColumnIndex(id);
                s = c1.getString(idIndex) + "--";
                String nameCol = ContactsContract.Contacts.DISPLAY_NAME;
                int nameIndex = c1.getColumnIndex(nameCol);
                s += c1.getString(nameIndex);
                list.add(s);
            } while (c1.moveToNext());
            for (String i : list) {
                Log.v("asadsad", i);
            }
        }
        c1.close();
        return list;
//        return map;
    }
}