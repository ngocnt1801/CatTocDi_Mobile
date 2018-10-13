package com.salon.cattocdi;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

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

public class SalonDetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_salon_detail);
        // SET UP TAB LAYOUT
        viewPager = (ViewPager) findViewById(R.id.detail_pager);
        TestTabAdapter adapter = new TestTabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.detail_tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        // END SET UP TAB LAYOUT

//        RecyclerView serviceRecycleView = findViewById(R.id.salon_service_recycle_view);
//        serviceRecycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        serviceRecycleView.setAdapter(new ServiceRecycleViewAdapter());
//
//        RecyclerView galleryRecycleView = findViewById(R.id.salon_image_recycle_view);
//        galleryRecycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        galleryRecycleView.setAdapter(new SalonProfileGalleryRecycleViewAdapter());
////        10.8459529,106.6322835
    }
}
