package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.dbhelper.DbHelper;
import com.example.myapplication.entity.User;


public class MainActivity extends AppCompatActivity {
    Button them, sua, xem;
    EditText ho, ten, namSinh, id, queQuan, phong, chuyenMon, daoTao, lamViec, hocVan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        them = findViewById(R.id.button);
        sua = findViewById(R.id.button2);
        xem = findViewById(R.id.button3);
        ho = findViewById(R.id.ho);
        ten = findViewById(R.id.ten);
        id = findViewById(R.id.userId);
        queQuan = findViewById(R.id.queQuan);
        phong = findViewById(R.id.phong);
        namSinh = findViewById(R.id.namSinh);
        chuyenMon = findViewById(R.id.chuyenMon);
        daoTao = findViewById(R.id.daoTao);
        lamViec = findViewById(R.id.lamViec);
        hocVan = findViewById(R.id.hocVan);
        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper db = new DbHelper(getApplicationContext());
                User u = new User();
                u.setId(Integer.parseInt(id.getText().toString()));
                u.setTen(ten.getText().toString());
                u.setHo(ho.getText().toString());
                u.setNam_sinh(namSinh.getText().toString());
                u.setQue_quan(queQuan.getText().toString());
                u.setPhong(phong.getText().toString());
                u.setChuyen_mon(chuyenMon.getText().toString());
                u.setDao_tao(daoTao.getText().toString());
                u.setLam_viec(lamViec.getText().toString());
                u.setHoc_van(hocVan.getText().toString());
                db.addUser(u);
            }
        });
    }
}