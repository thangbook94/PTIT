package com.example.ck2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import DbHelper.DbHelper;
import entity.User;

public class MainActivity extends AppCompatActivity {
    Button them, sua, xoa, xem, thongke;
    EditText id, hoTen,
            namSinh,
            queQuan,
            hocVan,
            chuyenMon,
            daoTao,
            lamViec,
            status,
            vaiTro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DbHelper db = new DbHelper(getApplicationContext());
        them = findViewById(R.id.them);
        sua = findViewById(R.id.sua);
        xoa = findViewById(R.id.xoa);
        xem = findViewById(R.id.xem);
        thongke = findViewById(R.id.thongke);

        id = findViewById(R.id.id);
        hoTen = findViewById(R.id.hoten);
        namSinh = findViewById(R.id.namsinh);
        chuyenMon = findViewById(R.id.chuyenmon);
        queQuan = findViewById(R.id.quequan);
        hocVan = findViewById(R.id.hocvan);
        daoTao = findViewById(R.id.daotao);
        lamViec = findViewById(R.id.lamviec);
        vaiTro = findViewById(R.id.vaitro);
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
        thongke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ThongKe.class);
                startActivity(i);
            }
        });
        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User u = new User();
                u.setVaiTro(vaiTro.getText().toString());
                u.setHocVan(hocVan.getText().toString());
                u.setHoTen(hoTen.getText().toString());
                u.setLamViec(lamViec.getText().toString());
                u.setDaoTao(daoTao.getText().toString());
                u.setQueQuan(queQuan.getText().toString());
                u.setChuyenMon(chuyenMon.getText().toString());
                u.setNamSinh(namSinh.getText().toString());
                db.addUser(u);
            }
        });
        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User u = new User();
                u.setId(Integer.parseInt(id.getText().toString()));
                u.setVaiTro(vaiTro.getText().toString());
                u.setHocVan(hocVan.getText().toString());
                u.setHoTen(hoTen.getText().toString());
                u.setLamViec(lamViec.getText().toString());
                u.setDaoTao(daoTao.getText().toString());
                u.setQueQuan(queQuan.getText().toString());
                u.setChuyenMon(chuyenMon.getText().toString());
                u.setNamSinh(namSinh.getText().toString());
                db.updateUser(u);
            }
        });
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User u = new User();
                u.setId(Integer.parseInt(id.getText().toString()));
                u.setVaiTro(vaiTro.getText().toString());
                u.setHocVan(hocVan.getText().toString());
                u.setHoTen(hoTen.getText().toString());
                u.setLamViec(lamViec.getText().toString());
                u.setDaoTao(daoTao.getText().toString());
                u.setQueQuan(queQuan.getText().toString());
                u.setChuyenMon(chuyenMon.getText().toString());
                u.setNamSinh(namSinh.getText().toString());
                db.deleteUser(u);
            }
        });
        xem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<User> list = db.getAllUser();
                Toast.makeText(getApplicationContext(), list.size() + "", Toast.LENGTH_SHORT).show();
                for (User u : list) {
                    if (id.getText().toString().equals(u.getId() + "")) {
                        id.setText(u.getId() + "");
                        hoTen.setText(u.getHoTen());
                    }
                }
            }
        });

    }
}