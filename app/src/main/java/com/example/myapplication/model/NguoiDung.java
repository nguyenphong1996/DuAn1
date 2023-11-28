package com.example.myapplication.model;

public class NguoiDung {
    private int id_NguoiDung;
    private String sdt;
    private int role_ND;
    private int id_TaiKhoan;

    public NguoiDung() {
    }

    public NguoiDung(String sdt, int role_ND, int id_TaiKhoan) {
        this.sdt = sdt;
        this.role_ND = role_ND;
        this.id_TaiKhoan = id_TaiKhoan;
    }

    public int getId_NguoiDung() {
        return id_NguoiDung;
    }

    public void setId_NguoiDung(int id_NguoiDung) {
        this.id_NguoiDung = id_NguoiDung;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getRole_ND() {
        return role_ND;
    }

    public void setRole_ND(int role_ND) {
        this.role_ND = role_ND;
    }

    public int getId_TaiKhoan() {
        return id_TaiKhoan;
    }

    public void setId_TaiKhoan(int id_TaiKhoan) {
        this.id_TaiKhoan = id_TaiKhoan;
    }
}
