package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    EditText edt1,edt2;
    Button btn1;
    ImageButton img1,img2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        edt1 = findViewById(R.id.edtUser);
        edt2 = findViewById(R.id.edtPassword);
        btn1 = findViewById(R.id.btnLogin);
        img1 = findViewById(R.id.imgBtnGoogle);
        img2 = findViewById(R.id.imgBtnFb);
    }
    private void init(){

    }
}
