package com.example.agrishop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHelper1 extends SQLiteOpenHelper {

    public DatabaseHelper1(Context context1) {
        super(context1, Constants.DB_NAME, null, Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Constants.CREATE_TABLE1);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME1);
        onCreate(db);

    }

    public Boolean insertRegister(String EMAIL, String PASSWORD) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.EMAIL, EMAIL);
        values.put(Constants.PASSWORD, PASSWORD);
        long id = db.insert(Constants.TABLE_NAME1, null, values);
        if (id == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkUser(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Constants.TABLE_NAME1 + " WHERE " + Constants.EMAIL + " = ? ", new String[]{username});
        if (cursor.getCount() > 0) {
            return true;
        } else
            return false;
    }

    public Boolean checkLogin(String username, String PASSWORD) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Constants.TABLE_NAME1 + " WHERE " + Constants.EMAIL + " = ? " + " and " + Constants.PASSWORD + " = ? ", new String[]{username, PASSWORD});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
