package com.example.myapplication.model;

public class DichVu {
    private int id_DV;
    private String ten_DV;
    private float giaTien;
    private String mota;

    public DichVu() {
    }

    public DichVu(int id_DV, String ten_DV, float giaTien, String mota) {
        this.id_DV = id_DV;
        this.ten_DV = ten_DV;
        this.giaTien = giaTien;
        this.mota = mota;
    }

    public DichVu(String ten_DV, float giaTien, String mota) {
        this.ten_DV = ten_DV;
        this.giaTien = giaTien;
        this.mota = mota;
    }

    public int getId_DV() {
        return id_DV;
    }

    public void setId_DV(int id_DV) {
        this.id_DV = id_DV;
    }

    public String getTen_DV() {
        return ten_DV;
    }

    public void setTen_DV(String ten_DV) {
        this.ten_DV = ten_DV;
    }

    public float getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
