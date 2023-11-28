package com.example.myapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.myapplication.database.DbHelper;
import com.example.myapplication.model.DichVu;

import java.util.ArrayList;

public class DAO_DichVu {
    DbHelper helper;
    SQLiteDatabase db;

    public DAO_DichVu(Context context) {
        this.helper = new DbHelper(context);
    }

    // Lấy danh sách DichVu đang bán
    public ArrayList<DichVu> getDichVusOnSell() {
        db = helper.getReadableDatabase();
        ArrayList<DichVu> list = new ArrayList<DichVu>();
        Cursor cursor = db.rawQuery("select * from DichVu", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                list.add(new DichVu(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getFloat(2),
                        cursor.getString(3)
                ));
            } while (cursor.moveToNext());
        }
        return list;
    }

    // Lấy danh sách DichVu đang mua
    public ArrayList<DichVu> getDichVusOnBuy() {
        db = helper.getReadableDatabase();
        ArrayList<DichVu> list = new ArrayList<DichVu>();
        Cursor cursor = db.rawQuery("select * from DichVu where Is_buy = 1", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                list.add(new DichVu(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        true
                ));
            } while (cursor.moveToNext());
        }

        return list;
    }

    public boolean insertDichVu(DichVu DichVu, boolean isBuy) {
        db = helper.getWritableDatabase();
        db.beginTransaction();
        ContentValues values = new ContentValues();
        values.put("Name", DichVu.getName());
        values.put("Price", DichVu.getPrice());
        values.put("Quantity", DichVu.getQuantity());
        values.put("Is_buy", isBuy);

        long check = db.insert("DichVu", null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
        return check != -1;
    }

    public boolean updateDichVu(DichVu DichVu) {
        Log.d("DAO_DichVu", "Updating DichVu with ID: " + DichVu.getId());
        db = helper.getWritableDatabase();
        db.beginTransaction();
        ContentValues values = new ContentValues();
        values.put("Name", DichVu.getName());
        values.put("Price", DichVu.getPrice());
        values.put("Quantity", DichVu.getQuantity());
        values.put("Is_buy", DichVu.isBuy());

        // Cập nhật dữ liệu của DichVu trong cơ sở dữ liệu
        int check = db.update(
                "DichVu", // Tên bảng
                values, // Dữ liệu cần cập nhật
                "Id = ?", // Điều kiện WHERE
                new String[]{String.valueOf(DichVu.getId())} // Tham số cho điều kiện WHERE
        );
        db.setTransactionSuccessful();
        db.endTransaction();
        return check > 0;
    }

    public boolean deleteDichVu(DichVu DichVu) {
        Log.d("DAO_DichVu", "Deleting DichVu with ID: " + DichVu.getId());
        db = helper.getWritableDatabase();
        db.beginTransaction();
        long result = db.delete("DichVu", "Id = ?", new String[]{String.valueOf(DichVu.getId())});
        db.setTransactionSuccessful();
        db.endTransaction();
        return result > 0;
    }


}}
