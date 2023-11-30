package com.example.myapplication.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.database.DbHelper;
import com.example.myapplication.model.TaiKhoanND;

public class UserDAO {
    DbHelper helper;
    SQLiteDatabase db;
    public UserDAO(Context context){
        helper = new DbHelper(context);
    }
    public boolean checkLogin(String username,String password){
        db = helper.getReadableDatabase();
        String sql = "SELECT * FROM  TaiKhoanND WHERE Email=? AND Matkhau=?";
        Cursor cs = db.rawQuery(sql,new String[]{username,password});
        int count = cs.getCount();
        db.close();
        return (count>0);
    }
    public boolean isDuplicateAcc(String username){
        db = helper.getReadableDatabase();
        String sql ="SELECT * FROM TaiKhoanND WHERE Email=?";
        Cursor cs = db.rawQuery(sql,new String[]{username});
        int count = cs.getCount();
        db.close();
        return (count>0);
    }
    public  boolean register(TaiKhoanND item){
        db = helper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("Email",item.getEmail());
        values.put("Matkhau",item.getMatKhau());
        long rowId = db.insert("USER",null,values);
        return (rowId != -1);
    }
}
