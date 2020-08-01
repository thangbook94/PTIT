package com.example.myapplication.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.entity.User;

public class DbHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DB_NAME = "user";
    private static final String ID = "id";
    private static final String HO = "ho";
    private static final String TEN = "ten";
    private static final String NAM_SINH = "nam_sinh";
    private static final String QUE_QUAN = "que_quan";
    private static final String TRINH_DO = "trinh_do";
    private static final String CHUYEN_MON = "chuyen_mon";
    private static final String DAO_TAO = "dao_tao";
    private static final String LAM_VIEC = "lam_viec";
    private static final String STATUS = "status";


    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + DB_NAME + " (" +
                ID + " integer primary key AUTOINCREMENT, " +
                HO + " TEXT," +
                TEN + " TEXT," +
                NAM_SINH + " TEXT," +
                QUE_QUAN + " TEXT," +
                TRINH_DO + " TEXT," +
                CHUYEN_MON + " TEXT," +
                DAO_TAO + " TEXT," +
                LAM_VIEC + " TEXT," +
                STATUS + " TEXT"
                + " )";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public int addUser(User u) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(HO, u.getHo());
        cv.put(TEN, u.getTen());
        cv.put(NAM_SINH, u.getNam_sinh());
        cv.put(QUE_QUAN, u.getQue_quan());
        cv.put(TRINH_DO, u.getTrinh_do());
        cv.put(CHUYEN_MON, u.getChuyen_mon());
        cv.put(DAO_TAO, u.getDao_tao());
        cv.put(LAM_VIEC, u.getLam_viec());
        cv.put(STATUS, u.getStatus());
        long t = db.insert(DB_NAME, null, cv);
        return (int) t;
    }

    public int updateUser(User u) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(HO, u.getHo());
        cv.put(TEN, u.getTen());
        cv.put(NAM_SINH, u.getNam_sinh());
        cv.put(QUE_QUAN, u.getQue_quan());
        cv.put(TRINH_DO, u.getTrinh_do());
        cv.put(CHUYEN_MON, u.getChuyen_mon());
        cv.put(DAO_TAO, u.getDao_tao());
        cv.put(LAM_VIEC, u.getLam_viec());
        cv.put(STATUS, u.getStatus());
        long t = db.update(DB_NAME, cv, ID + "=?", new String[]{String.valueOf(u.getId())});
        return (int) t;
    }

    public User getById(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query(DB_NAME, new String[]{ID, HO, TEN, NAM_SINH, QUE_QUAN, TRINH_DO, CHUYEN_MON, DAO_TAO},
                ID + "=?", new String[]{id}, null, null, null, null);
        if (c.moveToFirst()) {
            User u = new User();
            u.setId(c.getInt(0));
            u.setHo(c.getString(1));
            u.setTen(c.getString(2));
            u.setNam_sinh(c.getString(3));
            u.setQue_quan(c.getString(4));
            u.setTrinh_do(c.getString(5));
            u.setChuyen_mon(c.getString(6));
            u.setDao_tao(c.getString(7));
            return u;
        }
        return null;
    }
}
