package com.example.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context, "FpolyLaundry", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Bảng người dùng
        db.execSQL("CREATE TABLE NguoiDung(" +
                "Email text primary key," +
                "Password text," +
                "FullName text)"
        );
        String data = "INSERT INTO User VALUES" +
                "('tientq@fpt.edu.vn', 'ps27928', 'Trịnh Quốc Tiến')," +
                "('quyls@fpt.edu.vn', 'ps27683', 'Lê Sỹ Quý')";
        db.execSQL(data);

        // Bảng sản phẩm
        db.execSQL("CREATE TABLE Item(" +
                "Id integer primary key autoincrement," +
                "Name text," +
                "Price integer," +
                "Quantity integer," +
                "Is_buy integer)"
        );
        data = "INSERT INTO Item VALUES" +
                "(null, 'Shedu Set', 70, 1, '1')," +
                "(null, 'Garuda Prime Set', 55, 1, '0')";
        db.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS User");
        db.execSQL("DROP TABLE IF EXISTS Item");
        onCreate(db);
    }
}
