package com.salon.cattocdi;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback{
    GoogleMap mMap;
    SupportMapFragment mapFragment;
    LocationRequest mLocationRequest;
    Location mLastLocation;
    Marker mCurrLocationmMarker;
    FusedLocationProviderClient mFusuedLocationClient;
    Geocoder geocoder;
    List<LatLng> addressList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mFusuedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.salons_map);
        mapFragment.getMapAsync(this);
        geocoder = new Geocoder(this, Locale.getDefault());
        addressList = new ArrayList<>();

        initData();
    }

    private void initData() {
        Double[] lattitude = {10.858228, 10.855226, 10.850321, 10.851248, 10.850826};
        Double[] longtitude = {106.629373, 106.624505, 106.623503, 106.628643, 106.631089};
        for (int i =0; i < lattitude.length; i++) {
            addressList.add(new LatLng(lattitude[i], longtitude[i]));
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1200);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                mFusuedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallBack, Looper.myLooper());
                mMap.setMyLocationEnabled(true);

            } else {
                checkLocationPermission();
            }
        }

    }

    private void makeMarker() {
        for (int i = 0; i < addressList.size(); i++) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(addressList.get(i));
            markerOptions.title("Beauty Salon");
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
            mCurrLocationmMarker = mMap.addMarker(markerOptions);
        }

        CameraUpdate cu = CameraUpdateFactory.newLatLngZoom(new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude()), 15);
        mMap.animateCamera(cu);
    }

    LocationCallback mLocationCallBack = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {



                Location location = locationResult.getLastLocation();
                if(location != null){
                    mLastLocation = location;
                    if (mCurrLocationmMarker != null) {
                        mCurrLocationmMarker.remove();
                    }
                    makeMarker();
                }




        }
    };

    private void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                new AlertDialog.Builder(this)
                        .setTitle("Location Permission Nedded")
                        .setMessage("This app needs the Location permissio, Please accept")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions(MapsActivity.this,
                                        new String[]{
                                                Manifest.permission.ACCESS_FINE_LOCATION
                                        }, 88);
                            }
                        }).create().show();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION
                }, 88);
            }
        }
    }

}
