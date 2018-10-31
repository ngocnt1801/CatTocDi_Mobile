package com.salon.cattocdi.fragements;


import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
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
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.salon.cattocdi.MapsActivity;
import com.salon.cattocdi.R;
import com.salon.cattocdi.SalonDetailActivity;
import com.salon.cattocdi.models.Salon;
import com.salon.cattocdi.utils.MyContants;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.content.Context.LOCATION_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeMapFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    GoogleMap mMap;
    SupportMapFragment mapFragment;
    LocationRequest mLocationRequest;
    Location mLastLocation;
    Marker mCurrLocationmMarker;
    FusedLocationProviderClient mFusuedLocationClient;
    Geocoder geocoder;
    List<LatLng> addressList;
    LayoutInflater mInflater;
    public HomeMapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_map, container, false);

        mFusuedLocationClient = LocationServices.getFusedLocationProviderClient(getActivity());
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.salons_map);
        mapFragment.getMapAsync(this);
        geocoder = new Geocoder(getActivity(), Locale.getDefault());
        addressList = new ArrayList<>();
        initData();
        return view;
    }

    private void initData() {
        Double[] lattitude = {10.858228, 10.855226, 10.850321, 10.849307, 10.850826, 10.855239, 10.851772};
        Double[] longtitude = {106.629373, 106.624505, 106.623503, 106.626485, 106.631089, 106.633389, 106.634312};
        for (int i = 0; i < lattitude.length; i++) {
            addressList.add(new LatLng(lattitude[i], longtitude[i]));
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMarkerClickListener(this);
//        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(getActivity(), R.raw.map_styled));
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1200);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                mFusuedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallBack, Looper.myLooper());
                mMap.setMyLocationEnabled(false);
                LocationManager mLocationManager = (LocationManager)getActivity().getSystemService(LOCATION_SERVICE);
                List<String> providers = mLocationManager.getProviders(true);
                Location currentLocation = null;
                for (String provider : providers) {
                    Location l = mLocationManager.getLastKnownLocation(provider);
                    if (l == null) {
                        continue;
                    }
                    if (currentLocation == null || l.getAccuracy() < currentLocation.getAccuracy()) {
                        // Found best last known location: %s", l);
                        currentLocation = l;
                    }
                }

                LatLng currentPosition = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(currentPosition)
                        .zoom(17f)
                        .build();
                CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
                mMap.animateCamera(cameraUpdate);
                Marker myLocationMarker = createMarker(currentPosition);
                makeMarker();

            } else {
                checkLocationPermission();
            }
        }
    }

    private Marker createMarker(LatLng location){
        Drawable drawable = getResources().getDrawable(R.drawable.ic_my_location_arrow);
        Canvas canvas = new Canvas();
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);

        MarkerOptions markerOptions = new MarkerOptions().position(location)
                .icon(BitmapDescriptorFactory.fromBitmap(bitmap));
        return mMap.addMarker(markerOptions);
    }

    LocationCallback mLocationCallBack = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {

            Location location = locationResult.getLastLocation();
            if (location != null) {
                mLastLocation = location;
                if (mCurrLocationmMarker != null) {
                    mCurrLocationmMarker.remove();
                }
            }

        }
    };

    private void makeMarker() {
        Bitmap bm;
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (int i = 0; i < addressList.size(); i++) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(addressList.get(i));
            builder.include(addressList.get(i));
            bm = createBitmapFromLayoutWithText(MyContants.SALONS[i]);
//            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(bm));
            mCurrLocationmMarker = mMap.addMarker(markerOptions);

        }
    }

    public Bitmap createBitmapFromLayoutWithText(Salon salon) {
        LayoutInflater mInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        LinearLayout view = new LinearLayout(getActivity());
        View layout = mInflater.inflate(R.layout.info_window_marker, view, true);
//        TextView tv = (TextView) findViewById(R.id.my_text);
//        tv.setText("Beat It!!");

        TextView tvDiscount = layout.findViewById(R.id.salon_image);
        tvDiscount.setText(salon.getDiscount() + "%");

        TextView tvName = layout.findViewById(R.id.salon_name_map);
        tvName.setText(salon.getName());

        RatingBar rb = layout.findViewById(R.id.salon_rating_map);
        rb.setRating(salon.getRatingNumber());

        if (salon.isFull()) {
            tvDiscount.setBackgroundResource(R.drawable.ic_discount_map_disable);

            RelativeLayout rl = layout.findViewById(R.id.marker_info_window);
            rl.setBackgroundResource(R.drawable.ic_marker_background_disable);

            ImageView iv = layout.findViewById(R.id.marker_icon);
            iv.setImageResource(R.drawable.ic_marker_disable);

            TextView tv = layout.findViewById(R.id.info_window_status);
            tv.setText("Hết chỗ");
            tv.setTextColor(Color.parseColor("#616161"));
        }

        //Provide it with a layout params. It should necessarily be wrapping the
        //content as we not really going to have a parent for it.
        view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        //Pre-measure the view so that height and width don't remain null.
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

        //Assign a size and position to the view and all of its descendants
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());

        //Create the bitmap
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(),
                view.getMeasuredHeight(),
                Bitmap.Config.ARGB_8888);
        //Create a canvas with the specified bitmap to draw into
        Canvas c = new Canvas(bitmap);

        //Render this view (and all of its children) to the given Canvas
        view.draw(c);
        return bitmap;
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
                                        }, 88);
                            }
                        }).create().show();
            } else {
                ActivityCompat.requestPermissions(getActivity(), new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION
                }, 88);
            }
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        mMap.animateCamera(CameraUpdateFactory.newLatLng(marker.getPosition()));
        Intent intent = new Intent(getActivity(), SalonDetailActivity.class);
        startActivity(intent);
        return true;
    }
}
