package com.salon.cattocdi;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.salon.cattocdi.adapters.SalonProfileGalleryRecycleViewAdapter;
import com.salon.cattocdi.adapters.ServiceRecycleViewAdapter;
import com.salon.cattocdi.adapters.TestTabAdapter;
import com.salon.cattocdi.utils.MyContants;

public class SalonDetailActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_salon_detail);

        Intent intent = getIntent();
        int salonId = intent.getIntExtra("salon_id", -1);
        if(salonId >= 0){
            //set name salon
            TextView tvName = findViewById(R.id.salon_detail_name);
            tvName.setText(MyContants.SALONS[salonId].getName());

            //setup view pager
            viewPager = findViewById(R.id.detail_pager);
            TestTabAdapter adapter = new TestTabAdapter(getSupportFragmentManager(), salonId);
            viewPager.setAdapter(adapter);
            TabLayout tabLayout = findViewById(R.id.detail_tab_layout);
            tabLayout.setupWithViewPager(viewPager);
        }
    }
}