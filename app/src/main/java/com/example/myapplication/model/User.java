package com.example.myapplication.model;

public class User {
      private   String tendangnhap,natkhau;

    public User(String tendangnhap, String natkhau) {
        this.tendangnhap = tendangnhap;
        this.natkhau = natkhau;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getNatkhau() {
        return natkhau;
    }

    public void setNatkhau(String natkhau) {
        this.natkhau = natkhau;
    }
}
