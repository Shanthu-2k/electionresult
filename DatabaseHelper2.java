package com.example.agrishop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper2 extends SQLiteOpenHelper {
    public DatabaseHelper2(Context context) {
        super(context, Constants.DB_NAME, null , Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.CREATE_TABLE3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME3);
        onCreate(db);

    }
    public Boolean insertRegister(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.EMAIL1, email);
        values.put(Constants.PASSWORD1, password);
        long id = db.insert(Constants.TABLE_NAME3, null, values);
        if (id == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkUser(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Constants.TABLE_NAME3 + " WHERE " + Constants.EMAIL1 + " = ? ", new String[]{username});
        if (cursor.getCount() > 0) {
            return true;
        } else
            return false;
    }

    public Boolean checkLogin(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Constants.TABLE_NAME3 + " WHERE " + Constants.EMAIL1 + " = ? " + " and " + Constants.PASSWORD1 + " = ? ", new String[]{username, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
