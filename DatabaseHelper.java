package com.example.agrishop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private String id, name, price, category, contact, desc;
    long ins;

    public DatabaseHelper(Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.CREATE_TABLEP);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      //  db.execSQL(" DROP TABLE IF EXISTS " + DB.TABLE_NAMEP);
     //   onCreate(db);

    }

   public Boolean insertInfo(String name,String price,String quantity,String category,String contact,String desc,String image)
   {
       SQLiteDatabase db=this.getWritableDatabase();
       ContentValues values=new ContentValues();
       values.put(Constants.NAME,name);
       values.put(Constants.PRICE,price);
       values.put(Constants.QUANTITY,quantity);
       values.put(Constants.CATEGORY,category);
       values.put(Constants.CONTACT,contact);
       values.put(Constants.DESC,desc);
       values.put(Constants.IMAGE,image);
       long id =db.insert(Constants.TABLE_NAMEP,null,values);
       if (id == -1) {
           return false;
       } else {
           return true;
       }

   }



    public ArrayList<Model> getAllData(String orderBy) {
        ArrayList<Model> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(true,Constants.TABLE_NAMEP, new String[]{Constants.ID, Constants.NAME, Constants.PRICE, Constants.QUANTITY, Constants.CONTACT , Constants.DESC, Constants.IMAGE,}, Constants.CATEGORY + "=?", new String[]{"Fruits"}, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Model model = new Model();
                model.setId(cursor.getString(cursor.getColumnIndexOrThrow(Constants.ID)));
                model.setName(cursor.getString(cursor.getColumnIndexOrThrow(Constants.NAME)));
                model.setPrice(cursor.getString(cursor.getColumnIndexOrThrow(Constants.PRICE)));
                model.setQuantity(cursor.getString(cursor.getColumnIndexOrThrow(Constants.QUANTITY)));
                model.setContact(cursor.getString(cursor.getColumnIndexOrThrow(Constants.CONTACT)));
                model.setDesc(cursor.getString(cursor.getColumnIndexOrThrow(Constants.DESC)));
                model.setImage(cursor.getString(cursor.getColumnIndexOrThrow(Constants.IMAGE)));
                arrayList.add(model);
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        db.close();
        return arrayList;
    }
    public ArrayList<Model> getVeg(String orderBy) {
        ArrayList<Model> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(true,Constants.TABLE_NAMEP, new String[]{Constants.ID, Constants.NAME, Constants.PRICE, Constants.QUANTITY, Constants.CONTACT , Constants.DESC, Constants.IMAGE,}, Constants.CATEGORY + "=?", new String[]{"Vegetables"}, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Model model = new Model();
                model.setId(cursor.getString(cursor.getColumnIndexOrThrow(Constants.ID)));
                model.setName(cursor.getString(cursor.getColumnIndexOrThrow(Constants.NAME)));
                model.setPrice(cursor.getString(cursor.getColumnIndexOrThrow(Constants.PRICE)));
                model.setQuantity(cursor.getString(cursor.getColumnIndexOrThrow(Constants.QUANTITY)));
                model.setContact(cursor.getString(cursor.getColumnIndexOrThrow(Constants.CONTACT)));
                model.setDesc(cursor.getString(cursor.getColumnIndexOrThrow(Constants.DESC)));
                model.setImage(cursor.getString(cursor.getColumnIndexOrThrow(Constants.IMAGE)));
                arrayList.add(model);
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        db.close();
        return arrayList;
    }
    public ArrayList<Model> getOils(String orderBy) {
        ArrayList<Model> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(true,Constants.TABLE_NAMEP, new String[]{Constants.ID, Constants.NAME, Constants.PRICE, Constants.QUANTITY, Constants.CONTACT , Constants.DESC, Constants.IMAGE,}, Constants.CATEGORY + "=?", new String[]{"Oils"}, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Model model = new Model();
                model.setId(cursor.getString(cursor.getColumnIndexOrThrow(Constants.ID)));
                model.setName(cursor.getString(cursor.getColumnIndexOrThrow(Constants.NAME)));
                model.setPrice(cursor.getString(cursor.getColumnIndexOrThrow(Constants.PRICE)));
                model.setQuantity(cursor.getString(cursor.getColumnIndexOrThrow(Constants.QUANTITY)));
                model.setContact(cursor.getString(cursor.getColumnIndexOrThrow(Constants.CONTACT)));
                model.setDesc(cursor.getString(cursor.getColumnIndexOrThrow(Constants.DESC)));
                model.setImage(cursor.getString(cursor.getColumnIndexOrThrow(Constants.IMAGE)));
                arrayList.add(model);
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        db.close();
        return arrayList;
    }
    public ArrayList<Model> getFlowers(String orderBy) {
        ArrayList<Model> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(true,Constants.TABLE_NAMEP, new String[]{Constants.ID, Constants.NAME, Constants.PRICE, Constants.QUANTITY, Constants.CONTACT , Constants.DESC, Constants.IMAGE,}, Constants.CATEGORY + "=?", new String[]{"Flowers"}, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Model model = new Model();
                model.setId(cursor.getString(cursor.getColumnIndexOrThrow(Constants.ID)));
                model.setName(cursor.getString(cursor.getColumnIndexOrThrow(Constants.NAME)));
                model.setPrice(cursor.getString(cursor.getColumnIndexOrThrow(Constants.PRICE)));
                model.setQuantity(cursor.getString(cursor.getColumnIndexOrThrow(Constants.QUANTITY)));
                model.setContact(cursor.getString(cursor.getColumnIndexOrThrow(Constants.CONTACT)));
                model.setDesc(cursor.getString(cursor.getColumnIndexOrThrow(Constants.DESC)));
                model.setImage(cursor.getString(cursor.getColumnIndexOrThrow(Constants.IMAGE)));
                arrayList.add(model);
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        db.close();
        return arrayList;
    }
    public ArrayList<Model> getCP(String orderBy) {
        ArrayList<Model> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(true,Constants.TABLE_NAMEP, new String[]{Constants.ID, Constants.NAME, Constants.PRICE, Constants.QUANTITY, Constants.CONTACT , Constants.DESC, Constants.IMAGE,}, Constants.CATEGORY + "=?", new String[]{"Cereals and Pulses"}, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Model model = new Model();
                model.setId(cursor.getString(cursor.getColumnIndexOrThrow(Constants.ID)));
                model.setName(cursor.getString(cursor.getColumnIndexOrThrow(Constants.NAME)));
                model.setPrice(cursor.getString(cursor.getColumnIndexOrThrow(Constants.PRICE)));
                model.setQuantity(cursor.getString(cursor.getColumnIndexOrThrow(Constants.QUANTITY)));
                model.setContact(cursor.getString(cursor.getColumnIndexOrThrow(Constants.CONTACT)));
                model.setDesc(cursor.getString(cursor.getColumnIndexOrThrow(Constants.DESC)));
                model.setImage(cursor.getString(cursor.getColumnIndexOrThrow(Constants.IMAGE)));
                arrayList.add(model);
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        db.close();
        return arrayList;
    }
    public ArrayList<Model> getMilk(String orderBy) {
        ArrayList<Model> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(true,Constants.TABLE_NAMEP, new String[]{Constants.ID, Constants.NAME, Constants.PRICE, Constants.QUANTITY, Constants.CONTACT , Constants.DESC, Constants.IMAGE,}, Constants.CATEGORY + "=?", new String[]{"Milk Products"}, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Model model = new Model();
                model.setId(cursor.getString(cursor.getColumnIndexOrThrow(Constants.ID)));
                model.setName(cursor.getString(cursor.getColumnIndexOrThrow(Constants.NAME)));
                model.setPrice(cursor.getString(cursor.getColumnIndexOrThrow(Constants.PRICE)));
                model.setQuantity(cursor.getString(cursor.getColumnIndexOrThrow(Constants.QUANTITY)));
                model.setContact(cursor.getString(cursor.getColumnIndexOrThrow(Constants.CONTACT)));
                model.setDesc(cursor.getString(cursor.getColumnIndexOrThrow(Constants.DESC)));
                model.setImage(cursor.getString(cursor.getColumnIndexOrThrow(Constants.IMAGE)));
                arrayList.add(model);
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        db.close();
        return arrayList;
    }

}