package com.example.agrishop;

public class Constants {
    public static final String DB_NAME="SHANTHIMA.DB";
    public static final int DB_VERSION=6;
    public static final String TABLE_NAME1="CUSTOMER";
    public static final String EMAIL="EMAIL" ;
    public static final String PASSWORD="PASSWORD";
    public static final String TABLE_NAME3="FARMER";
    public static final String EMAIL1="EMAIL1" ;
    public static final String PASSWORD1="PASSWORD1";
    public static final String TABLE_NAMEP="ADDP";
    public static final String ID="ID";
    public static final String NAME="NAME" ;
    public static final String PRICE="PRICE";
    public static final String QUANTITY="QUANTITY";
    public static final String CATEGORY="CATEGORY";
    public static final String CONTACT = "CONTACT";
    public static final String DESC="DESC";
    public static final String IMAGE="IMAGE";
    public static final String TABLE_NAME2="BOOKING";
    public static final String ID1="ID1";
    public static final String NAME1="NAME1";
    public static final String PRICE1="PRICE1";
    public static final String QUANTITY1="QUANTITY1";
    public static final String CONTACT1="CONTACT1";
    public static final String DESC1="DESC1";
    public static final String  PHONE="PHONE";
    public static final String ADDRESS="ADDRESS";
    public static final String UNITS="UNITS";
    public static final String AMOUNT="AMOUNT";
    public static final String ORDERID="ORDERID";
    public static final String CREATE_TABLE2=" create table " + TABLE_NAME2 + " ( " + ORDERID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + ID1 + " TEXT NOT NULL , " + NAME1 + " TEXT NOT NULL , " + PRICE1 + " TEXT NOT NULL , " + QUANTITY1 + " TEXT NOT NULL , " + CONTACT1 + " TEXT NOT NULL , " + DESC1 + " TEXT NOT NULL , " + PHONE + " TEXT NOT NULL , " + ADDRESS + " TEXT NOT NULL , " + UNITS + " TEXT NOT NULL , " + AMOUNT + " TEXT NOT NULL ) ; " ;

    public static final String CREATE_TABLE1=" create table "+ TABLE_NAME1 + " ( " + EMAIL+ " TEXT PRIMARY KEY , " +  PASSWORD + " TEXT NOT NULL ) ; ";
    public static final String CREATE_TABLE3=" create table "+ TABLE_NAME3 + " ( " + EMAIL1 + " TEXT PRIMARY KEY , " + PASSWORD1 + " TEXT NOT NULL ) ; ";
    public static final String CREATE_TABLEP=" create table "+ TABLE_NAMEP + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + NAME + " TEXT NOT NULL , " + PRICE + " TEXT NOT NULL , " + QUANTITY + " TEXT NOT NULL , " + CATEGORY + " TEXT NOT NULL , " + CONTACT + " TEXT NOT NULL , " + DESC + " TEXT NOT NULL , " + IMAGE + " TEXT NOT NULL ) ; " ;

}
