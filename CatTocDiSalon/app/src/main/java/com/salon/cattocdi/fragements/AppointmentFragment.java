package com.salon.cattocdi.fragements;


import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.salon.cattocdi.R;
import com.salon.cattocdi.adapters.FragementAppointmentTestAdapter;
import com.salon.cattocdi.adapters.TestRecycleViewAdapter;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppointmentFragment extends Fragment {

    RecyclerView rvUpcomming;
    FusedLocationProviderClient mFusedLocationClient;
    Location mCurrentLocation;
    LocationCallback mlocationCallback;
    LocationRequest mLocationRequest;


    public AppointmentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_appointment, container, false);
        rvUpcomming = view.findViewById(R.id.fg_appointment_rv_upcoming);
        getLocation();
        testRecycleViewAdapter();



        return view;
    }

    private void testRecycleViewAdapter(){
        //Show RECYCLEVIEW

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        FragementAppointmentTestAdapter adapter = new FragementAppointmentTestAdapter(getActivity(), mCurrentLocation);
        rvUpcomming.setAdapter(adapter);
        rvUpcomming.setLayoutManager(mLayoutManager);
        rvUpcomming.setItemAnimator(new DefaultItemAnimator());
    }

    public void getLocation() {

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(getActivity());

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1200);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        mlocationCallback = new LocationCallback(){
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if(mCurrentLocation != null || mCurrentLocation == locationResult.getLastLocation()){
                    return;
                }
                mCurrentLocation = locationResult.getLastLocation();
                FragementAppointmentTestAdapter adapter = new FragementAppointmentTestAdapter(getActivity(), mCurrentLocation);
                rvUpcomming.setAdapter(adapter);
            }
        };

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                mFusedLocationClient.requestLocationUpdates(mLocationRequest, mlocationCallback, Looper.myLooper());
            } else {
                checkLocationPermission();
            }
        }

    }

    private void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Location Permission Nedded")
                        .setMessage("This app needs the Location permissio, Please accept")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions(getActivity(),
                                        new String[]{
                                                Manifest.permission.ACCESS_FINE_LOCATION
                                        }, 99);
                            }
                        }).create().show();
            } else {
                ActivityCompat.requestPermissions(getActivity(), new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION
                }, 99);
            }
        }
    }
}
