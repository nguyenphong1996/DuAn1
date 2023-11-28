package com.example.myapplication.model;

public class TaiKhoanND {
    private int id_TaiKhoan;
    private String email, matKhau, tenDangNhap;

    public TaiKhoanND() {
    }

    public TaiKhoanND(String email, String matKhau, String fullName) {
        this.email = email;
        this.matKhau = matKhau;
        this.tenDangNhap = fullName;
    }

    public int getId_TaiKhoan() {
        return id_TaiKhoan;
    }

    public void setId_TaiKhoan(int id_TaiKhoan) {
        this.id_TaiKhoan = id_TaiKhoan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }
}