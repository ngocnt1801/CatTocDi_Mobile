package com.salon.cattocdi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import com.salon.cattocdi.adapters.SalonProfileGalleryRecycleViewAdapter;
import com.salon.cattocdi.adapters.ServiceRecycleViewAdapter;

public class SalonDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_salon_detail);
        RecyclerView serviceRecycleView = findViewById(R.id.salon_service_recycle_view);
        serviceRecycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        serviceRecycleView.setAdapter(new ServiceRecycleViewAdapter());

        RecyclerView galleryRecycleView = findViewById(R.id.salon_image_recycle_view);
        galleryRecycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        galleryRecycleView.setAdapter(new SalonProfileGalleryRecycleViewAdapter());
    }
}
