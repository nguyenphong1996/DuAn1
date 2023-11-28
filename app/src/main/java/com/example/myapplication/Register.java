package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    EditText edt1,edt2,edt3,edt4;
    Button btn1,btn2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        init();
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private void init(){
        edt1=findViewById(R.id.edtRegisterUser);
        edt2=findViewById(R.id.edtRegisterPass);
        edt3=findViewById(R.id.edtRePass);
        edt4=findViewById(R.id.edtRegisterEmail);
        btn1=findViewById(R.id.btn_back);
        btn2=findViewById(R.id.btn_register);
    }
}
