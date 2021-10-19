package com.example.agrishop;

public class NewTables {
    public static final String DB_NAME="KALA.DB";
    public static final int DB_VERSION=3;
    public static final String TABLE_NAMEP = "ADDP";
    public static final String PID = "PID";
    public static final String PNAME = "PNAME";
    public static final String PPRICE = "PPRICE";
    public static final String PQUANTITY = "PQUANTITY";
    public static final String PCATEGORY = "PCATEGORY";
    public static final String PCONTACT = "PCONTACT";
    public static final String PDESC = "PDESC";
    public static final String PIMAGE = "PIMAGE";
    public static final String TABLEORDER="OTABLE";
    public static final String ORDERID1= "ORDERID";
    public static final String PRODUCTID="PRODUCTID";
    public static final String PRODUCTNAME="PRODUCTNAME";
    public static final String PRODUCTPRICE="PRODUCTPRICE";
    public static final String PRODUCTQUANTITY="PRODUCTQUANTITY";
    public static final String PRODUCTCONTACT="PRODUCTCONTACT";
    public static final String PRODUCTDESC="PRODUCTDESC";
    public static final String CUSTOMERADDRESS="CUSTOMERADDRESS";
    public static final String CUSTOMERCONTACT="CUSTOMERCONTACT";
    public static final String TOTALUNITS="UNITS";
    public static final String TOTALAMOUNT="TOTALAMOUNT";
    public static final String CREATE_TABLEP = " CREATE TABLE " + TABLE_NAMEP + " ( " + PID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + PNAME + " TEXT NOT NULL , " + PPRICE + " TEXT NOT NULL , " + PQUANTITY + " TEXT NOT NULL , " + PCATEGORY + " TEXT NOT NULL , " + PCONTACT + " TEXT NOT NULL , " + PDESC + " TEXT NOT NULL , " + PIMAGE + " TEXT NOT NULL ) ; ";
    public static final String CREATE_TABLE_ORDER = " CREATE TABLE " + TABLEORDER + " ( " + ORDERID1 + " INTEGER PRIMARY KEY AUTOINCREMENT , " + PRODUCTID + " TEXT NOT NULL , " + PRODUCTNAME + " TEXT NOT NULL , " + PRODUCTPRICE + " TEXT NOT NULL , " + PRODUCTQUANTITY + " TEXT NOT NULL , " + PRODUCTCONTACT + "TEXT NOT NULL , " + PRODUCTDESC + " TEXT NOT NULL , " + CUSTOMERCONTACT + " TEXT NOT NULL , " + CUSTOMERADDRESS + " TEXT NOT NULL , " + TOTALUNITS + " TEXT NOT NULL , " + TOTALAMOUNT + " TEXT NOT NULL ) ; " ;

}
