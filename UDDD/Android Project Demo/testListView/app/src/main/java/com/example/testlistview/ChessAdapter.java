package com.example.testlistview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ChessAdapter extends BaseAdapter {
    ArrayList<ChessPiece> chessPieces;
    Activity activity;

    public ChessAdapter(Activity activity, ArrayList<ChessPiece> chessPieces) {
        this.activity = activity;
        this.chessPieces = chessPieces;
    }

    @Override
    public int getCount() {
        return chessPieces.size();
    }

    @Override
    public Object getItem(int position) {
        return chessPieces.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        view = layoutInflater.inflate(R.layout.activity_info, null);
        TextView tv = view.findViewById(R.id.textView12);
        tv.setText(chessPieces.get(position).getDesc());
        return view;
    }
}
