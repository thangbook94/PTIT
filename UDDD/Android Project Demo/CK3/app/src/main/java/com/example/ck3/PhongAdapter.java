package com.example.ck3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import entity.Phong;

public class PhongAdapter extends BaseAdapter {
    Activity activity;
    List<Phong> list;

    public PhongAdapter(Activity activity, List<Phong> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.phong_adapter, null);
        TextView ten = view.findViewById(R.id.tenPhongD);
        TextView so = view.findViewById(R.id.soPhongD);
        TextView tang = view.findViewById(R.id.tangPhongD);
        TextView loai = view.findViewById(R.id.loaiPhongD);
        TextView gia = view.findViewById(R.id.giaPhongD);
        TextView status = view.findViewById(R.id.statusPhongD);
        ten.setText(list.get(i).getId()+"");
        so.setText(list.get(i).getSo());
        tang.setText(list.get(i).getTang());
        loai.setText(list.get(i).getLoai());
        gia.setText(list.get(i).getGia());
        status.setText(list.get(i).getStatus());
        return view;
    }
}
