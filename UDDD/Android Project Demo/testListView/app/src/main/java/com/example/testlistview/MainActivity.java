package com.example.testlistview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String[] name;
    String[] desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.listView);
        name = getResources().getStringArray(R.array.pieces);
        desc = getResources().getStringArray(R.array.descriptions);
        ArrayList<ChessPiece> chessPieces=new ArrayList<>();
        for(int i=0;i<name.length;i++){
            chessPieces.add(new ChessPiece("",name[i],desc[i]));
        }

        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, name);
        ChessAdapter chessAdapter=new ChessAdapter(this, chessPieces);
        lv.setAdapter(chessAdapter);
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
//                intent.putExtra("name", name[position]);
//                intent.putExtra("desc", desc[position]);
//                startActivity(intent);
//            }
//        });
    }
}
