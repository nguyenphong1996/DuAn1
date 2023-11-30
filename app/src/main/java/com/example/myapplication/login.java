package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.DAO.UserDAO;

public class login extends AppCompatActivity {
    EditText edt1, edt2;
    Button btn1;
    ImageButton img1, img2;
    TextView tv1;
    UserDAO dao;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        init();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edt1.getText().toString();
                String pass = edt2.getText().toString();

            if (isValidForm(email,pass)){

                if (dao.checkLogin(email, pass)) {
                    Toast.makeText(login.this, "ĐĂNG NHẬP THÀNH CÔNG", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login.this, main_giatui.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(login.this, "ĐĂNG NHẬP THẤT BẠI", Toast.LENGTH_SHORT).show();
                    ;
                }
            }
            }
        });
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, Register.class);
                myLauncher.launch(intent);
            }
        });
    }

    private void init() {
        edt1 = findViewById(R.id.edtUser);
        edt2 = findViewById(R.id.edtPassword);
        btn1 = findViewById(R.id.btnLogin);
        img1 = findViewById(R.id.imgBtnGoogle);
        img2 = findViewById(R.id.imgBtnFb);
        tv1 = findViewById(R.id.tvRegister);
    }

    private boolean isValidForm(String email, String pass) {
        if (email.trim().length() == 0) {
            Toast.makeText(login.this, "EMAIL KHÔNG ĐƯỢC ĐỂ TRỐNG", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (pass.trim().length() == 0) {
            Toast.makeText(login.this, "PASSWORD KHÔNG ĐƯỢC ĐỂ TRỐNG", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private ActivityResultLauncher<Intent> myLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode()==1){
                Intent intent = result.getData();
                String user = intent.getStringExtra("user");
                String pass = intent.getStringExtra("pass");
                Toast.makeText(login.this, "", Toast.LENGTH_SHORT).show();
            }
        }
    });
}
