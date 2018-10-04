package com.salon.cattocdi;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.WindowManager;

import com.salon.cattocdi.fragements.AppointmentFragment;
import com.salon.cattocdi.fragements.EditProfileFragment;
import com.salon.cattocdi.fragements.HomeFragment;
import com.salon.cattocdi.fragements.ProfileFragment;
import com.salon.cattocdi.fragements.SearchFragment;

public class EditProfileActivity extends Activity {
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_edit_profile);
        //EditProfileFragment editProfileFragment = new EditProfileFragment();
        //showFragment(editProfileFragment);

        //HOME FRAGMENT will show first
        //showFragment(new HomeFragment());



    }
    private void showFragment(Fragment fragment){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.activity_main_container_fl, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
