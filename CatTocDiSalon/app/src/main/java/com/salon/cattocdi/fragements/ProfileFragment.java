package com.salon.cattocdi.fragements;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.salon.cattocdi.EditProfileActivity;
import com.salon.cattocdi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends android.app.Fragment {
    TextView editProfile, showLike, helpTv;
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
                /*Intent intent = new Intent(context, EditProfileActivity.class);
                startActivity(intent);*/
                ViewProifileFragment viewProifileFragment = new ViewProifileFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.fg_profile, viewProifileFragment, null).addToBackStack(null).commit();
            }


        });
        showLike = view.findViewById(R.id.show_top_tv);
        showLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowTopFragment showTopFragment = new ShowTopFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.fg_profile, showTopFragment, null).addToBackStack(null).commit();
               /*ShowTopFragment showTopFragment = new ShowTopFragment();
               showFragment(showTopFragment);*/
            }
        });

        helpTv = view.findViewById(R.id.help_tv);
        helpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HelpFragment helpFragment = new HelpFragment();
                getFragmentManager()
                        .beginTransaction().replace(R.id.fg_profile, helpFragment, null).addToBackStack(null).commit();
            }
        });
        return  view;
    }

    private void showFragment(android.app.Fragment fragment){
        android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.show_top_tv, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
