package dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import entity.Phong;

public class DbHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DB_PHONG = "PHONG";
    private static final String PHONG_ID = "ID";
    private static final String PHONG_SO = "SO";
    private static final String PHONG_TANG = "TANG";
    private static final String PHONG_LOAI = "LOAI";
    private static final String PHONG_GIA = "GIA";
    private static final String PHONG_STATUS = "STATUS";

    private static final String DB_THUE = "THUE";
    private static final String THUE_ID = "ID";
    private static final String THUE_IN = "PIN";
    private static final String THUE_OUT = "POUT";
    private static final String THUE_ID_PHONG = "ID_PHONG";


    public DbHelper(@Nullable Context context) {
        super(context, DB_PHONG, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table " + DB_PHONG + " (" +
                PHONG_ID + " integer primary key autoincrement," +
                PHONG_SO + " text, " +
                PHONG_TANG + " text, " +
                PHONG_LOAI + " text, " +
                PHONG_GIA + " text, " +
                PHONG_STATUS + " text) ";
        sqLiteDatabase.execSQL(sql);
        sql = "create table " + DB_THUE + " (" +
                THUE_ID + " integer primary key autoincrement, " +
                THUE_IN + " text, " +
                THUE_ID_PHONG + " text, " +
                THUE_OUT + " text) ";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public int addPhong(Phong p) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(PHONG_TANG, p.getTang());
        cv.put(PHONG_GIA, p.getGia());
        cv.put(PHONG_LOAI, p.getLoai());
        cv.put(PHONG_SO, p.getSo());
        cv.put(PHONG_STATUS, p.getStatus());
        return (int) db.insert(DB_PHONG, null, cv);
    }

    public List<Phong> getPhong() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query(DB_PHONG, new String[]{
                PHONG_ID, PHONG_GIA, PHONG_SO, PHONG_TANG, PHONG_LOAI, PHONG_STATUS
        }, null, null, null, null, null);
        List<Phong> re = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                Phong p = new Phong();
                p.setId(c.getInt(0));
                p.setGia(c.getString(1));
                p.setSo(c.getString(2));
                p.setTang(c.getString(3));
                p.setLoai(c.getString(4));
                p.setStatus(c.getString(5));
                re.add(p);
            } while (c.moveToNext());
        }
        return re;
    }

}
