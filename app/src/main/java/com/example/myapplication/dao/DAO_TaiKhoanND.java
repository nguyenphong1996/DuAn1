package com.example.myapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.myapplication.database.DbHelper;
import com.example.myapplication.model.TaiKhoanND;

import java.util.ArrayList;

public class DAO_TaiKhoanND {
    DbHelper helper;
    SQLiteDatabase db;

    public DAO_TaiKhoanND(Context context) {
        this.helper = new DbHelper(context);
    }

    // Lấy danh sách TaiKhoanND đang có
    public ArrayList<TaiKhoanND> getListTK() {
        db = helper.getReadableDatabase();
        ArrayList<TaiKhoanND> list = new ArrayList<TaiKhoanND>();
        Cursor cursor = db.rawQuery("select * from TaiKhoanND", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                list.add(new TaiKhoanND(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)
                ));
            } while (cursor.moveToNext());
        }
        return list;
    }

    public boolean insertTaiKhoan(TaiKhoanND taiKhoan) {
        db = helper.getWritableDatabase();
        db.beginTransaction();
        ContentValues values = new ContentValues();
        values.put("Email", taiKhoan.getEmail());
        values.put("MatKhau", taiKhoan.getMatKhau());
        values.put("TenDangNhap", taiKhoan.getTenDangNhap());

        long check = db.insert("TaiKhoanND", null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
        return check != -1;
    }

    public boolean updateMatKhauTK(TaiKhoanND taiKhoan) {
        Log.d("DAO_TaiKhoanND", "Updating TaiKhoanND with ID: " + taiKhoan.getId_TaiKhoan());
        db = helper.getWritableDatabase();
        db.beginTransaction();
        ContentValues values = new ContentValues();
        values.put("MatKhau", taiKhoan.getMatKhau());

        try {
            // Cập nhật dữ liệu của TaiKhoanNC trong cơ sở dữ liệu
            int check = db.update(
                    "TaiKhoanND", // Tên bảng
                    values, // Dữ liệu cần cập nhật
                    "Id_TaiKhoan = ?", // Điều kiện WHERE
                    new String[]{String.valueOf(taiKhoan.getId_TaiKhoan())} // Tham số cho điều kiện WHERE
            );
            db.setTransactionSuccessful();
            return check > 0;
        } catch (Exception e) {
            Log.e("DAO_TaiKhoanND", "Lỗi khi cố gắng thay đổi mật khẩu!", e);
            return false;
        } finally {
            if (db != null) {
                db.endTransaction();
                db.close();
            }
        }
    }

    public boolean updateTenDN(TaiKhoanND taiKhoan) {
        Log.d("DAO_TaiKhoanND", "Updating TaiKhoanND with ID: " + taiKhoan.getId_TaiKhoan());
        db = helper.getWritableDatabase();
        db.beginTransaction();
        ContentValues values = new ContentValues();
        values.put("TenDangNhap", taiKhoan.getTenDangNhap());

        try {
            // Cập nhật tên đăng nhập của TaiKhoanNC trong cơ sở dữ liệu
            int check = db.update(
                    "TaiKhoanND", // Tên bảng
                    values, // Dữ liệu cần cập nhật
                    "Id_TaiKhoan = ?", // Điều kiện WHERE
                    new String[]{String.valueOf(taiKhoan.getId_TaiKhoan())} // Tham số cho điều kiện WHERE
            );
            db.setTransactionSuccessful();
            return check > 0;
        } catch (Exception e) {
            Log.e("DAO_TaiKhoanND", "Lỗi khi cố gắng thay đổi tên đăng nhập!", e);
            return false;
        } finally {
            if (db != null) {
                db.endTransaction();
                db.close();
            }
        }
    }

//    public boolean deleteTaiKhoan(TaiKhoanND taiKhoan) {
//        Log.d("DAO_TaiKhoanND", "Deleting TaiKhoanND with ID: " + taiKhoan.getId_TaiKhoan());
//        db = helper.getWritableDatabase();
//        db.beginTransaction();
//        long result = db.delete(
//                "TaiKhoanND",
//                "Id_TaiKhoan = ?",
//                new String[]{String.valueOf(taiKhoan.getId_TaiKhoan())});
//        db.setTransactionSuccessful();
//        db.endTransaction();
//        return result > 0;
//    }
}
