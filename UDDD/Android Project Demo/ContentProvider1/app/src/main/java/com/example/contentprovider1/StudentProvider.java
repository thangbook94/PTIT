package com.example.contentprovider1;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.util.HashMap;

public class StudentProvider extends ContentProvider {

    static final String PROVIDER_NAME = "com.example.provider.College";
    static final String URI = "content://" + PROVIDER_NAME + "/students";
    static final Uri CONTENT_URI = Uri.parse(URI);

    static final String _ID = "_id";
    static final String NAME = "name";
    static final String GRADE = "grade";

    private static HashMap<String, String> STUDENTS_PROJECTION_MAP;

    static final int STUDENTS = 1;
    static final int STUDENTS_ID = 2;

    static final UriMatcher uriMatcher;
    static{
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "students", STUDENTS);
        uriMatcher.addURI(PROVIDER_NAME, "students/#", STUDENTS_ID);
    }

    private SQLiteDatabase db;
    static final String DATABASE_NAME = "college";
    static final String STUDENTS_TABLE_NAME = "students";
    static final int DATABASE_VERSION = 1;
    static final String CREATE_DB_TABLE =
            "CREATE TABLE " + STUDENTS_TABLE_NAME +
                    " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT NOT NULL, " +
                    "grade TEXT NOT NULL);";



    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_DB_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + STUDENTS_TABLE_NAME );
            onCreate(db);
        }

    }



    @Override
    public boolean onCreate() {
        Context context = getContext();
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
        return (db == null) ? false:true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(STUDENTS_TABLE_NAME);

        switch (uriMatcher.match(uri)) {
            case STUDENTS:
                qb.setProjectionMap(STUDENTS_PROJECTION_MAP);
                break;
            case STUDENTS_ID:
                qb.appendWhere(_ID + "=" + uri.getPathSegments().get(1) );
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        if(sortOrder == null || sortOrder == ""){
            sortOrder = NAME;
        }

        Cursor c = qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (uriMatcher.match(uri)) {
            case STUDENTS:
                return "vnd.android.cursor.dir/vnd.students";
            case STUDENTS_ID:
                return "vnd.android.cusor.item/vnd.students";
            default:
                throw new IllegalArgumentException("Unsupport URIL " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        long rowID = db.insert(STUDENTS_TABLE_NAME, "", values);
        if(rowID > 0){
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }
        throw new SQLException("Failed to add a record into " + uri);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int count = 0;

        switch (uriMatcher.match(uri)){
            case STUDENTS:
                count = db.delete(STUDENTS_TABLE_NAME, selection, selectionArgs);
                break;
            case STUDENTS_ID:
                count = db.delete(STUDENTS_TABLE_NAME, _ID + "=" + uri.getPathSegments().get(1) +
                        (!TextUtils.isEmpty(selection) ? " AND (" +
                                selection + ')': ""), selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int count = 0;

        switch (uriMatcher.match(uri)){
            case STUDENTS:
                count = db.update(STUDENTS_TABLE_NAME, values, selection, selectionArgs);
                break;
            case STUDENTS_ID:
                count = db.update(STUDENTS_TABLE_NAME, values, _ID + "=" + uri.getPathSegments().get(1) +
                        (!TextUtils.isEmpty(selection) ? " AND (" +
                                selection + ')': ""), selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}
