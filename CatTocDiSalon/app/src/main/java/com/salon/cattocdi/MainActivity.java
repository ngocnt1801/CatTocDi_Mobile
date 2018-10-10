package com.salon.cattocdi;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.WindowManager;

import com.salon.cattocdi.fragements.AppointmentFragment;
import com.salon.cattocdi.fragements.FavoriteFragment;
import com.salon.cattocdi.fragements.HomeFragment;
import com.salon.cattocdi.fragements.ProfileFragment;
import com.salon.cattocdi.fragements.SearchFragment;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;
    private RecyclerView rvListNearest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.bottom_nav_home_item:
                        HomeFragment homeFragment = new HomeFragment();
                        showFragment(homeFragment);
                        return true;
                    case R.id.bottom_nav_appointment_item:
                        AppointmentFragment appointmentFragment = new AppointmentFragment();
                        showFragment(appointmentFragment);
                        return true;
                    case R.id.bottom_nav_search_item:
                        SearchFragment searchFragment = new SearchFragment();
                        showFragment(searchFragment);
                        return true;
                    case R.id.bottom_nav_favorite_item:
                        FavoriteFragment favoriteFragment = new FavoriteFragment();
                        showFragment(favoriteFragment);
                        return true;
                    case R.id.bottom_nav_profile_item:
                        ProfileFragment profileFragment = new ProfileFragment();
                        showFragment(profileFragment);
                        return true;
                }

                return false;
            }
        });

        //HOME FRAGMENT will show first
        showFragment(new HomeFragment());


    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    private void showFragment(Fragment fragment){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.activity_main_container_fl, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
