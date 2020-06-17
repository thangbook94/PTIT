package com.example.sqlitedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Stutudent_detail extends AppCompatActivity {

    Button btCancel,btUpdate;
    CheckBox cbUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stutudent_detail);



        Intent intent1= Stutudent_detail.this.getIntent();
        String test= intent1.getStringExtra("idSinhVien");

        final EditText editTextID =(EditText)findViewById(R.id.edID);
        final EditText editName =(EditText)findViewById(R.id.edName);
        final EditText editEmail = (EditText)findViewById(R.id.edEmail);
        final EditText editNumber =(EditText)findViewById(R.id.edTel);

        editTextID.setText(test);
        editName.setText(intent1.getStringExtra("tenSV"));
        editEmail.setText(intent1.getStringExtra("email"));
        editNumber.setText(intent1.getStringExtra("number"));


        editTextID.setEnabled(false);
        editName.setEnabled(false);
        editEmail.setEnabled(false);
        editNumber.setEnabled(false);

        btCancel=findViewById(R.id.btCancel);
        btUpdate=findViewById(R.id.btUpdate);
        cbUpdate=findViewById(R.id.checkboxChange);

        cbUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editTextID.setEnabled(false);
                editName.setEnabled(true);
                editEmail.setEnabled(true);
                editNumber.setEnabled(true);
            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sStudentID = editTextID.getText().toString();
                int idStudent = Integer.parseInt(sStudentID);

                Student student1= new Student();
                DatabaseHelper db1 = new DatabaseHelper(getBaseContext());
                student1.setId(idStudent);
                student1.setNumber(editNumber.getText().toString());
                student1.setName(editName.getText().toString());;
                student1.setNumber(editNumber.getText().toString());
                student1.setEmail(editEmail.getText().toString());
                int j= db1.Update(student1);
                if (j>0)
                {
                    Toast.makeText(getBaseContext(), "Update successfylly", Toast.LENGTH_SHORT).show();
                }
                else {

                    Toast.makeText(getBaseContext(), "Update Unsuccessfylly", Toast.LENGTH_SHORT).show();
                }

                setResult(RESULT_OK, null);
                finish();
            }
        });

    }



}
