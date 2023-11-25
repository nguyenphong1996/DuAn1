package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class GiaoHang extends AppCompatActivity {
    TabLayout tabL;
    ViewPager2 viewP;
    MyViewPagerAdapter viewPagerAdap ter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giao_hang);
        tabL = findViewById(R.id.tabLa);
        viewP = findViewById(R.id.viewPa);

        viewPagerAdapter = new MyViewPagerAdapter(this);
        viewP.setAdapter(viewPagerAdapter);
        new TabLayoutMediator(tabL, viewP, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Chờ xác nhận");
                    break;
                    case 1:
                        tab.setText("Chờ lấy hàng");
                        break;
                    case 2:
                        tab.setText("Chờ giao hàng");
                        break;
                }
            }
        });
    }
}