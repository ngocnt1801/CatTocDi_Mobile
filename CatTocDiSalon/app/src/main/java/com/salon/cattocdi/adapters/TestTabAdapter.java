package com.salon.cattocdi.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.salon.cattocdi.fragements.ReviewsFragment;
import com.salon.cattocdi.fragements.SalonDetailContactFragment;
import com.salon.cattocdi.fragements.SalonDetailServiceFragment;
import com.salon.cattocdi.fragements.TestTabFragment;

public class TestTabAdapter extends FragmentPagerAdapter{
    private String title[] = {"DỊCH VỤ", "LIÊN HỆ", "ĐÁNH GIÁ"};
    private int salonId;

    public TestTabAdapter(FragmentManager fm, int salonId) {
        super(fm);
        this.salonId = salonId;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new SalonDetailServiceFragment(salonId);
            case 1:
                return new SalonDetailContactFragment(salonId);
            case 2:
                return new ReviewsFragment(salonId);
        }
        return null;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
