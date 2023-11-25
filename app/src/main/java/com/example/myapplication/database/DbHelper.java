package com.example.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context, "APP GIẶT ỦI", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    String sql = "CREATE TABLE USER(tendanngnhap TEXT PRIMARY KEY,matkhau TEXT)";
    db.execSQL(sql);
        sql = "INSERT INTO USER VALUES('abc','123'),('abcd','1234')";
    db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if(i != i1){
            db.execSQL("DROP TABLE IF EXISTS NGUOIDUNG");
            onCreate(db);
        }
    }
}
