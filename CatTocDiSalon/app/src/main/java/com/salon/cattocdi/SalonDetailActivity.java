package com.salon.cattocdi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

public class SalonDetailActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMapOptions options = new GoogleMapOptions().liteMode(true);
    private GoogleMap map;
    private LatLng latLng;
    private SupportMapFragment supportMapFragment;

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
//        10.8459529,106.6322835
        latLng = new LatLng(10.8466881,106.6329596);
        supportMapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.salon_detail_map);
        supportMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.map = googleMap;
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13));
        map.addMarker(markerOptions);
    }
}
