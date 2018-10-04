package com.salon.cattocdi.fragements;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.salon.cattocdi.EditProfileActivity;
import com.salon.cattocdi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends android.app.Fragment {
    TextView editProfile;
    //TextView logout;
    Context context;
    //private ProfileFragment profileFragment;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        context = view.getContext();
        editProfile = view.findViewById(R.id.edit_information_tv);
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //swapFragment();
                Intent intent = new Intent(context, EditProfileActivity.class);
                startActivity(intent);
            }


        });
        return  view;
    }

   /* private void swapFragment(){
        EditProfileFragment editProfileFragment = new EditProfileFragment();
        //ProfileFragment profileFragment = new ProfileFragment();
        android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
       *//* fragmentTransaction.add(R.id.activity_profile_2, editProfileFragment);
        fragmentTransaction.addToBackStack(null);*//*
       if (editProfileFragment.isAdded()){
           fragmentTransaction.show(editProfileFragment);
       }else {
           fragmentTransaction.add(R.id.activity_profile_2, editProfileFragment, "E");
       }
       if(editProfileFragment.isAdded()){
           fragmentTransaction.show(editProfileFragment);
           fragmentTransaction.hide(profileFragment);
       }
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }*/
    public void onClickLogout(View view) {
        //logout.setText("Log out");
    }

    public void onClickEditProfile(View view) {
       /* EditProfileFragment editProfileFragment = new EditProfileFragment();
        android.app.FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.activity_profile_2, editProfileFragment);
        fragmentTransaction.commit();*/
    }
}
