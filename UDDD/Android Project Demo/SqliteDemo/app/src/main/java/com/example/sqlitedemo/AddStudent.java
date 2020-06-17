package com.example.sqlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {

    Button btAdd, btReset;
    EditText editTextID,editTextName,editTextTel, editTextEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        btAdd=findViewById(R.id.btAdd);
        btReset=findViewById(R.id.btRedo);
        editTextID=findViewById(R.id.edtAddID);
        editTextEmail=findViewById(R.id.edtAdEmal);
        editTextName=findViewById(R.id.edtAddName);
        editTextTel=findViewById(R.id.edtAddTel);



        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper db1 = new DatabaseHelper(getBaseContext());
                String svName = editTextName.getText().toString();
                String svTel = editTextTel.getText().toString();
                String svEmail = editTextEmail.getText().toString();

                Student addStudent = new Student(svName,svTel,svEmail);

                db1.addStudent(addStudent);
                Toast.makeText(getBaseContext(),"Thêm dữ liệu thành công",Toast.LENGTH_SHORT).show();
                Reset();
                setResult(RESULT_OK, null);
                finish();

            }
        });

        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Reset();

            }
        });


    }



    protected  void Reset()
    {
        editTextTel.setText("");
        editTextName.setText("");
        editTextEmail.setText("");
    }


}
