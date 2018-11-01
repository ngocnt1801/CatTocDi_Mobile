package com.salon.cattocdi.fragements;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salon.cattocdi.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

//    private RecyclerView rvNew, rvRating, rvSale;
//    private EditText etSearch;
//    private TextView voucherSeeAllTv, newSeeAllTv;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
//        rvNew = view.findViewById(R.id.fg_home_rv_new);
//        rvRating = view.findViewById(R.id.fg_home_rv_rating);
//        rvSale = view.findViewById(R.id.fg_home_rv_sale);
//
//        etSearch = view.findViewById(R.id.fg_home_search_et);
//
//        voucherSeeAllTv = view.findViewById(R.id.fg_home_voucher_see_all_tv);
//        newSeeAllTv = view.findViewById(R.id.fg_home_new_see_all_tv);
//
//        //set layout
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
//        rvSale.setLayoutManager(mLayoutManager);
//
//        rvRating.setLayoutManager(new GridLayoutManager(getActivity(),1));
//
//        rvNew.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
//
////        testRecycleViewAdapter(rvBookmark);,
//        testRecycleViewAdapter(rvRating, MyContants.RV_ITEM_NORMAL);
//        testRecycleViewAdapter(rvSale, MyContants.RV_ITEM_VOUCHER);
//        testRecycleViewAdapter(rvNew, MyContants.RV_ITEM_NEW);
//
//        ViewCompat.setNestedScrollingEnabled(rvRating, false);
//
//
//        etSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SearchFragment searchFragment = new SearchFragment();
//                showFragment(searchFragment);
//                BottomNavigationView navigationView = (BottomNavigationView) getActivity().findViewById(R.id.bottom_nav);
//                navigationView.getMenu().getItem(2).setChecked(true);
//            }
//        });
//
//
//        voucherSeeAllTv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), ListSalonActivity.class);
//                Bundle option = ActivityOptionsCompat.makeScaleUpAnimation(voucherSeeAllTv,0,0,voucherSeeAllTv.getWidth(), voucherSeeAllTv.getLineHeight()).toBundle();
//                Bundle bundle = new Bundle();
//                bundle.putString("title","Khuyến mãi");
//                bundle.putInt("type", MyContants.RV_ITEM_VOUCHER);
//                intent.putExtra("activity_content", bundle);
//                ActivityCompat.startActivity(getActivity(), intent, option);
//
//            }
//        });
//
//        newSeeAllTv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), ListSalonActivity.class);
//                Bundle option = ActivityOptionsCompat.makeScaleUpAnimation(voucherSeeAllTv,0,0,voucherSeeAllTv.getWidth(), voucherSeeAllTv.getLineHeight()).toBundle();
//                Bundle bundle = new Bundle();
//                bundle.putString("title","Cửa hàng mới");
//                bundle.putInt("type", MyContants.RV_ITEM_NORMAL);
//                intent.putExtra("activity_content", bundle);
//                ActivityCompat.startActivity(getActivity(), intent, option);
//            }
//        });
        ViewPager viewPager = view.findViewById(R.id.detail_pager);
        setupViewPager(viewPager);
        // Set Tabs inside Toolbar
        TabLayout tabs = view.findViewById(R.id.detail_tab_layout);
        tabs.setupWithViewPager(viewPager);
        return view;
    }

    //    private void testRecycleViewAdapter(RecyclerView rv, int type){
//        //Show RECYCLEVIEW
//
//        rv.setItemAnimator(new DefaultItemAnimator());
//        SalonAdapter adapter = new SalonAdapter(type, getActivity());
//        rv.setAdapter(adapter);
//    }
//
//    private void showFragment(Fragment fragment){
//        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.activity_main_container_fl, fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }
// Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {


        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new HomeMapFragment(), "Bản đồ");
        adapter.addFragment(new HomeListFragment(), "Danh sách");
        viewPager.setAdapter(adapter);


    }

    static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
