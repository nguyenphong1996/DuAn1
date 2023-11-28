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
        // Bảng tài khoản người dùng
        db.execSQL("CREATE TABLE TaiKhoanND(" +
                "Id_TaiKhoan integer PRIMARY KEY autoincrement," +
                "Email text ," +
                "MatKhau text," +
                "TenDangNhap text)"
        );
        String data = "INSERT INTO TaiKhoanND VALUES" +
                "(0, 'tientq@fpt.edu.vn', 'ps27928', 'Trịnh Quốc Tiến')," +
                "(1, 'quyls@fpt.edu.vn', 'ps27683', 'Lê Sỹ Quý')";
        db.execSQL(data);

        // Bảng thông tin người dùng
        db.execSQL("CREATE TABLE ThongTinND(" +
                "Id_NguoiDung INTEGER PRIMARY KEY AUTOINCREMENT," +
                "SDT text," +
                "Role_ND INTEGER," +
                "Id_TaiKhoan INTEGER," +
                "FOREIGN KEY(Id_TaiKhoan) REFERENCES TaiKhoanND(Id_TaiKhoan))"
        );
        data = "INSERT INTO ThongTinND VALUES" +
                "(0, 'tientq@fpt.edu.vn', 'ps27928', 'Trịnh Quốc Tiến')," +
                "(1, 'quyls@fpt.edu.vn', 'ps27683', 'Lê Sỹ Quý')";
        db.execSQL(data);

        // Bảng dịch vụ
        db.execSQL("CREATE TABLE DichVu(" +
                "Id_DV integer primary key autoincrement," +
                "Ten_DV text," +
                "GiaTien float," +
                "MoTa text)"
        );
        data = "INSERT INTO Item VALUES" +
                "(null, 'Giặt sấy đồ < 3kg', 45000, null)," +
                "(null, 'Giặt sấy đồ < 5kg', 75000, null)";
        db.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS User");
        db.execSQL("DROP TABLE IF EXISTS Item");
        onCreate(db);
    }
}
