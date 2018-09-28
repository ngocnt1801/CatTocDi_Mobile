package com.salon.cattocdi;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.salon.cattocdi.fragements.AppointmentFragment;
import com.salon.cattocdi.fragements.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                        return true;
                    case R.id.bottom_nav_profile_item:
                        return true;
                }

                return false;
            }
        });

        //HOME FRAGMENT will show first
        showFragment(new HomeFragment());
    }

    private void showFragment(Fragment fragment){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.activity_main_container_fl, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
