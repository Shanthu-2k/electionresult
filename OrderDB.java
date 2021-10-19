package com.example.agrishop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class OrderDB extends SQLiteOpenHelper {
    public OrderDB(@Nullable Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.CREATE_TABLE2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME2);
       onCreate(db);


    }
    public Boolean insertOrder(String id, String name, String price, String quantity, String contact, String desc, String phone, String address,String units,String amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.ID1,id);
        values.put(Constants.NAME1, name);
        values.put(Constants.PRICE1, price);
        values.put(Constants.QUANTITY1,quantity);
        values.put(Constants.CONTACT1, contact);
        values.put(Constants.DESC1, desc);
        values.put(Constants.PHONE,phone);
        values.put(Constants.ADDRESS,address);
        values.put(Constants.UNITS,units);
        values.put(Constants.AMOUNT,amount);
        long id1 = db.insert(Constants.TABLE_NAME2, null, values);
        if (id1 == -1) {
            return false;
        } else {
            return true;
        }
    }
    public ArrayList<Model1> getOrder(String orderBy) {
        ArrayList<Model1> arrayList = new ArrayList<>();

        String selectionQuery= " SELECT * FROM " + Constants.TABLE_NAME2 + " ORDER BY " + orderBy;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectionQuery,null);
        if (cursor.moveToNext()) {
            do {
                Model1 model = new Model1(
                        ""+cursor.getInt(cursor.getColumnIndex(Constants.ORDERID)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.ID1)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.NAME1)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.PRICE1)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.QUANTITY1)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.CONTACT1)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.DESC1)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.PHONE)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.ADDRESS)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.UNITS)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.AMOUNT))

                );
                arrayList.add(model);
            } while (cursor.moveToNext());
        }
        db.close();
        return arrayList;
    }
}
