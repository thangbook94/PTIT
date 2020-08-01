package com.example.ck2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends BaseAdapter {
    Activity activity;
    List<String> list;

    public UserAdapter(Activity activity, List<String> list) {
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
        view = inflater.inflate(R.layout.user_adapter, null);
        TextView ngaysinh = view.findViewById(R.id.namsinhad);
        TextView soluong = view.findViewById(R.id.soluongad);
        soluong.setText("adapter custom " + list.get(i).split("\\s+")[1]);
        ngaysinh.setText(list.get(i).split("\\s+")[0]);
        return view;
    }
}
