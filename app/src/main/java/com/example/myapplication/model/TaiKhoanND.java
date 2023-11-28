package com.example.myapplication.model;

public class TaiKhoanND {
    private String email, matKhau, tenDangNhap;

    public TaiKhoanND() {
    }

    public TaiKhoanND(String email, String matKhau, String fullName) {
        this.email = email;
        this.matKhau = matKhau;
        this.tenDangNhap = fullName;
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