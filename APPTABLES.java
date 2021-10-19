package com.example.agrishop;

public class APPTABLES {
    public static final String DB_NAME="APPTABLE.DB";
    public static final int DB_VERSION = 5;

    public static final String TABLEC = "BUYER";
    public static final String EMAILC = " EMAILC";
    public static final String PASSWORDC = " PASSWORDC";
    public static final String CREATE_TABLEC = " create table " + TABLEC + " ( " + EMAILC + " TEXT PRIMARY KEY , " + PASSWORDC + " TEXT NOT NULL  ) ; ";
    public static final String TABLEF = "SELLER";
    public static final String EMAILF = " EMAILF";
    public static final String PASSWORDF = " PASSWORDF";
    public static final String CREATE_TABLEF = " create table " + TABLEF + " ( " + EMAILF + " TEXT PRIMARY KEY , " + PASSWORDF + " TEXT NOT NULL ) ; ";
    public static final String TABLE_NAMEP = "ADDP";
    public static final String PID = "PID";
    public static final String PNAME = "PNAME";
    public static final String PPRICE = "PPRICE";
    public static final String PQUANTITY = "PQUANTITY";
    public static final String PCATEGORY = "PCATEGORY";
    public static final String PCONTACT = "PCONTACT";
    public static final String PDESC = "PDESC";
    public static final String PIMAGE = "PIMAGE";
    public static final String CREATE_TABLEP = " CREATE TABLE " + TABLE_NAMEP + " ( " + PID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + PNAME + " TEXT NOT NULL , " + PPRICE + " TEXT NOT NULL , " + PQUANTITY + " TEXT NOT NULL , " + PCATEGORY + " TEXT NOT NULL , " + PCONTACT + " TEXT NOT NULL , " + PDESC + " TEXT NOT NULL , " + PIMAGE + " TEXT NOT NULL ) ; ";

}

