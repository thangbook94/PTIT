package com.example.sqlitedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btAddSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btAddSV = findViewById(R.id.btAddStudent);

        btAddSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOpenAddActivity();

            }
        });
        LoadListStudents();


    }

    protected void LoadListStudents() {

        DatabaseHelper db1 = new DatabaseHelper(getBaseContext());
        final List<Student> list1 = db1.getAllStudent();
        ListView lv1 = findViewById(R.id.listSinhVien);
        ArrayAdapter<Student> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list1);
        // Student[] adapterStudent = list1.toArray(new Student[list1.size()]);

        // ArrayAdapter<Student> adapter1 = adapterStudent;

        lv1.setAdapter(adapter);

        //Click listView
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(getBaseContext(), "Position :" + arg2 + " - Value = " + list1.get(arg2).getName(),
                        Toast.LENGTH_LONG).show();
                doOpenChildActivity(list1.get(arg2).getId(), list1.get(arg2).getNumber(), list1.get(arg2).getName(), list1.get(arg2).getEmail());

            }

        });
        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {


                return false;
            }
        });

        registerForContextMenu(lv1);

    }

    public void doOpenChildActivity(int idSV, String number, String name, String email) {
        Intent myIntent = new Intent(this, Stutudent_detail.class);
        String xxx = Integer.toString(idSV);
        myIntent.putExtra("idSinhVien", xxx);
        myIntent.putExtra("tenSV", name);
        myIntent.putExtra("number", number);
        myIntent.putExtra("email", email);
        startActivityForResult(myIntent, 2);
    }

    public void doOpenAddActivity() {
        Intent intentAdd = new Intent(this, AddStudent.class);
        //startActivity(intentAdd);
        startActivityForResult(intentAdd, 1);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((resultCode == RESULT_OK) && (requestCode == 1)) {
            Intent refresh = new Intent(this, MainActivity.class);
            //LoadListView();
            //Toast.makeText(MainActivity.this,"Update thanh cong",Toast.LENGTH_SHORT).show();
            startActivity(refresh);
            this.finish();
        }

        if ((resultCode == RESULT_OK) && (requestCode == 2)) {
            Intent refresh = new Intent(this, MainActivity.class);
            //LoadListView();
            // Toast.makeText(MainActivity.this,"Them DL thanh cong",Toast.LENGTH_SHORT).show();
            startActivity(refresh);
            this.finish();
        }

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.listSinhVien) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.example_menu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        if (item.getItemId() == R.id.menuDelete) {

            DatabaseHelper db = new DatabaseHelper(getBaseContext());
            ListView lv1 = findViewById(R.id.listSinhVien);
            Student student = (Student) lv1.getAdapter().getItem(info.position);
            int id = student.getId();


            Toast.makeText(MainActivity.this, "You are deleting idStudent: " +
                    id, Toast.LENGTH_SHORT).show();
            db.Delete(student);
            Intent refresh = new Intent(this, MainActivity.class);
            //LoadListView();
            //Toast.makeText(MainActivity.this,"Update thanh cong",Toast.LENGTH_SHORT).show();
            startActivity(refresh);
            this.finish();
        }
        if (item.getItemId() == R.id.menuQuickShow) {
            DatabaseHelper db = new DatabaseHelper(getBaseContext());
            ListView lv1 = findViewById(R.id.listSinhVien);
            Student student = (Student) lv1.getAdapter().getItem(info.position);
            int id = student.getId();
            Toast.makeText(MainActivity.this, "You are QuickShow: " +
                    id, Toast.LENGTH_SHORT).show();

        }
        return super.onContextItemSelected(item);
    }
}
