package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "play_real.db";
    public static final String FIRST_OPEN = "TABLE_FIRST_OPEN";
    public static final String REFFER_ID = "TABLE_REFFER_ID";

    //public static int row=-5;



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+FIRST_OPEN+" (SN INTEGER PRIMARY KEY AUTOINCREMENT,STATUS TEXT)");

        db.execSQL("create table "+REFFER_ID+" (SN INTEGER PRIMARY KEY AUTOINCREMENT,REFFER_ID TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+FIRST_OPEN);
        db.execSQL("DROP TABLE IF EXISTS "+REFFER_ID);

        onCreate(db);
    }
    @Override
    public void onConfigure (SQLiteDatabase db){
        db.disableWriteAheadLogging();
    }


    //Insert

    public boolean insert_1st_open(String status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("STATUS",status);
        long result = db.insert(FIRST_OPEN,null ,contentValues);
        if(result < 0){
            //row=(int)result;
            return false;
        }

        else
        {
            //row=(int)result;
            return true;
        }

    }

    public boolean insert_reffer_id(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("REFFER_ID",id);
        long result = db.insert(REFFER_ID,null ,contentValues);
        if(result < 0){
            //row=(int)result;
            return false;
        }

        else
        {
            //row=(int)result;
            return true;
        }

    }




    public Cursor chk_open() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+FIRST_OPEN,null);
        res.moveToFirst();
        return res;
    }

    public Cursor get_reffer_id() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+REFFER_ID,null);
        res.moveToFirst();
        return res;
    }





    // Single Data

}
