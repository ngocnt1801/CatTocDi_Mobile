package com.salon.cattocdi;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.salon.cattocdi.adapters.SalonDetailViewPagerAdapter;
import com.salon.cattocdi.models.Salon;

public class SalonDetailActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_salon_detail);

        Intent intent = getIntent();
        Salon salon = (Salon) intent.getSerializableExtra("salon");
        if(salon != null){
            //set name salon
            TextView tvName = findViewById(R.id.salon_detail_name);
            tvName.setText(salon.getName());

            //setup view pager
            viewPager = findViewById(R.id.detail_pager);
            SalonDetailViewPagerAdapter adapter = new SalonDetailViewPagerAdapter(getSupportFragmentManager(), salon);
            viewPager.setAdapter(adapter);
            TabLayout tabLayout = findViewById(R.id.detail_tab_layout);
            tabLayout.setupWithViewPager(viewPager);
        }
    }
}