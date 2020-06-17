package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public final class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "student_list";
    private static final String TABLE_NAME = "student";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String NUMBER = "number";

    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        Log.d("DB Manager", "DB Manager");

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                ID + " integer primary key, " +
                NAME + " TEXT, " +
                EMAIL + " TEXT, " +
                NUMBER + " TEXT)";
        db.execSQL(sqlQuery);
        Toast.makeText(context, "Create Database successfully", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
        Toast.makeText(context, "Drop successfully", Toast.LENGTH_SHORT).show();

    }

    public void addStudent(Student student) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, student.getName());
        values.put(NUMBER, student.getNumber());
        values.put(EMAIL, student.getEmail());


        //Neu de null thi khi value bang null thi loi
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Student getSdtudentById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{ID,
                        NAME, EMAIL, NUMBER}, ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Student student = new Student(cursor.getString(1), cursor.getString(2), cursor.getString(3));
        cursor.close();
        db.close();
        return student;
    }

    public int Update(Student student) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME, student.getName());
        values.put(NUMBER, student.getNumber());
        values.put(EMAIL, student.getEmail());


        return db.update(TABLE_NAME, values, ID + "=?", new String[]{String.valueOf(student.getId())});
    }

    public int Delete(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME, student.getName());
        values.put(NUMBER, student.getNumber());
        values.put(EMAIL, student.getEmail());


        return db.delete(TABLE_NAME, ID + "=?", new String[]{String.valueOf(student.getId())});
    }

    public List<Student> getAllStudent() {

        List<Student> listStudent = new ArrayList<Student>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setId(cursor.getInt(0));
                student.setName(cursor.getString(1));
                student.setEmail(cursor.getString(2));
                student.setNumber(cursor.getString(3));
                listStudent.add(student);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listStudent;
    }

    public int getStudentsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        cursor.getColumnCount();
        return cursor.getCount();
    }
}
