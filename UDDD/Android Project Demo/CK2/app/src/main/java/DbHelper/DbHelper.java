package DbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import entity.User;

public class DbHelper extends SQLiteOpenHelper {
    Context context;
    private static final String DB_NAME = "user";
    private static final String ID = "id";
    private static final String HO_TEN = "hoTen";
    private static final String NAM_SINH = "namSinh";
    private static final String QUE_QUAN = "queQuan";
    private static final String HOC_VAN = "hocVan";
    private static final String CHUYEN_MON = "chuyenMon";
    private static final String DAO_TAO = "daoTao";
    private static final String LAM_VIEC = "lamViec";
    private static final String STATUS = "status";
    private static final String VAI_TRO = "vaiTro";

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table " + DB_NAME + " (" +
                ID + " integer primary key AUTOINCREMENT," +
                HO_TEN + " text," +
                NAM_SINH + " text," +
                QUE_QUAN + " text," +
                HOC_VAN + " text," +
                CHUYEN_MON + " text," +
                DAO_TAO + " text," +
                LAM_VIEC + " text," +
                STATUS + " text," +
                VAI_TRO + " text)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long addUser(User u) {
        u.setStatus("true");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(HO_TEN, u.getHoTen());
        cv.put(NAM_SINH, u.getNamSinh());
        cv.put(QUE_QUAN, u.getQueQuan());
        cv.put(HOC_VAN, u.getHocVan());
        cv.put(CHUYEN_MON, u.getChuyenMon());
        cv.put(DAO_TAO, u.getDaoTao());
        cv.put(LAM_VIEC, u.getLamViec());
        cv.put(STATUS, u.getStatus());
        cv.put(VAI_TRO, u.getVaiTro());
        return db.insert(DB_NAME, null, cv);
    }

    public long updateUser(User u) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(HO_TEN, u.getHoTen());
        cv.put(NAM_SINH, u.getNamSinh());
        cv.put(QUE_QUAN, u.getQueQuan());
        cv.put(HOC_VAN, u.getHocVan());
        cv.put(CHUYEN_MON, u.getChuyenMon());
        cv.put(DAO_TAO, u.getDaoTao());
        cv.put(LAM_VIEC, u.getLamViec());
        cv.put(STATUS, u.getStatus());
        cv.put(VAI_TRO, u.getVaiTro());
        return db.update(DB_NAME, cv, ID + "=?", new String[]{u.getId() + ""});
    }

    public long deleteUser(User u) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        u.setStatus("false");
        cv.put(HO_TEN, u.getHoTen());
        cv.put(NAM_SINH, u.getNamSinh());
        cv.put(QUE_QUAN, u.getQueQuan());
        cv.put(HOC_VAN, u.getHocVan());
        cv.put(CHUYEN_MON, u.getChuyenMon());
        cv.put(DAO_TAO, u.getDaoTao());
        cv.put(LAM_VIEC, u.getLamViec());
        cv.put(STATUS, u.getStatus());
        cv.put(VAI_TRO, u.getVaiTro());
        return db.update(DB_NAME, cv, ID + "=?", new String[]{u.getId() + ""});
    }

    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        Cursor c = this.getReadableDatabase().query(DB_NAME,
                new String[]{ID, HO_TEN, NAM_SINH, QUE_QUAN, HOC_VAN, CHUYEN_MON, DAO_TAO, LAM_VIEC, STATUS, VAI_TRO}, null, null, null, null, null);
        if (c.moveToFirst()) {
            while (c.moveToNext()) {
                User u = new User();
                u.setId(c.getInt(0));
                u.setHoTen(c.getString(1));
                u.setNamSinh(c.getString(2));
                u.setQueQuan(c.getString(3));
                u.setHocVan(c.getString(4));
                u.setChuyenMon(c.getString(5));
                u.setDaoTao(c.getString(6));
                u.setLamViec(c.getString(7));
                u.setStatus(c.getString(8));
                u.setVaiTro(c.getString(9));
                list.add(u);
            }
        }
        return list;
    }


    public List<String> getChuyenMon() {
//        HashMap<String, Integer> map = new HashMap<>();
//        Cursor c = this.getReadableDatabase().rawQuery("select namSinh, count(id) from user group by namSinh;", null);
//        if (c.moveToFirst()) {
//            while (c.moveToNext()) {
//                String namsinh = c.getString(0);
//                int soluong = c.getInt(1);
//                map.put(namsinh, soluong);
//            }
//        }
//        for (String i : map.keySet()) {
//            Log.v("ffasfasfasfasf", i + " XXXXXX " + map.get(i));
//        }
        Uri uri = Uri.parse("content://contacts/people");
        ArrayList<String> list = new ArrayList<>();
        Cursor c1 = context.getContentResolver().query(uri, null, null, null, null);
        if (c1.moveToFirst()) {
            do {
                String id = ContactsContract.Contacts._ID;
                String s = "";
                int idIndex = c1.getColumnIndex(id);
                s = c1.getString(idIndex) + "--";
                String nameCol = ContactsContract.Contacts.DISPLAY_NAME;
                int nameIndex = c1.getColumnIndex(nameCol);
                s += c1.getString(nameIndex);
                list.add(s);
            } while (c1.moveToNext());
            for (String i : list) {
                Log.v("asadsad", i);
            }
        }
        c1.close();
        return list;
//        return map;
    }
}
