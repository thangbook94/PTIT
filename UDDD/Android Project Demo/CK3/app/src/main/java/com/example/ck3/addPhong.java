package com.example.ck3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import dbhelper.DbHelper;
import entity.Phong;

public class addPhong extends AppCompatActivity {
    Button them, sua, xoa;
    EditText id, so, tang, loai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_phong);
        them = findViewById(R.id.them);
        sua = findViewById(R.id.sua);
        xoa = findViewById(R.id.xoa);
        id = findViewById(R.id.idPhong);
        so = findViewById(R.id.soPhong);
        tang = findViewById(R.id.tangPhong);
        loai = findViewById(R.id.loaiPhong);
        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper db = new DbHelper(getApplicationContext());
                Phong p = new Phong();
                p.setStatus("yes");
                p.setLoai(loai.getText().toString());
                if (loai.getText().toString().equals("vip")) {
                    p.setGia("200");
                } else p.setGia("100");
                p.setTang(tang.getText().toString());
                p.setSo(so.getText().toString());
                int i = db.addPhong(p);
                Toast.makeText(getApplicationContext(), i + "", Toast.LENGTH_SHORT).show();
            }
        });
    }
}