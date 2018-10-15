package com.salon.cattocdi.fragements;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import com.salon.cattocdi.ListSalonActivity;
import com.salon.cattocdi.R;
import com.salon.cattocdi.adapters.TestRecycleViewAdapter;
import com.salon.cattocdi.utils.MyContants;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView rvNew, rvRating, rvSale;
    private EditText etSearch;
    private TextView voucherSeeAllTv, newSeeAllTv;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        rvNew = view.findViewById(R.id.fg_home_rv_new);
        rvRating = view.findViewById(R.id.fg_home_rv_rating);
        rvSale = view.findViewById(R.id.fg_home_rv_sale);

        etSearch = view.findViewById(R.id.fg_home_search_et);

        voucherSeeAllTv = view.findViewById(R.id.fg_home_voucher_see_all_tv);
        newSeeAllTv = view.findViewById(R.id.fg_home_new_see_all_tv);

        //set layout
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvSale.setLayoutManager(mLayoutManager);

        rvRating.setLayoutManager(new GridLayoutManager(getActivity(),1));

        rvNew.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

//        testRecycleViewAdapter(rvBookmark);,
        testRecycleViewAdapter(rvRating, MyContants.RV_ITEM_NORMAL);
        testRecycleViewAdapter(rvSale, MyContants.RV_ITEM_VOUCHER);
        testRecycleViewAdapter(rvNew, MyContants.RV_ITEM_NEW);

        ViewCompat.setNestedScrollingEnabled(rvRating, false);


        etSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchFragment searchFragment = new SearchFragment();
                showFragment(searchFragment);
            }
        });


        voucherSeeAllTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ListSalonActivity.class);
                Bundle option = ActivityOptionsCompat.makeScaleUpAnimation(voucherSeeAllTv,0,0,voucherSeeAllTv.getWidth(), voucherSeeAllTv.getLineHeight()).toBundle();
                Bundle bundle = new Bundle();
                bundle.putString("title","Khuyến mãi");
                bundle.putInt("type", MyContants.RV_ITEM_VOUCHER);
                intent.putExtra("activity_content", bundle);
                ActivityCompat.startActivity(getActivity(), intent, option);

            }
        });

        newSeeAllTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ListSalonActivity.class);
                Bundle option = ActivityOptionsCompat.makeScaleUpAnimation(voucherSeeAllTv,0,0,voucherSeeAllTv.getWidth(), voucherSeeAllTv.getLineHeight()).toBundle();
                Bundle bundle = new Bundle();
                bundle.putString("title","Cửa hàng mới");
                bundle.putInt("type", MyContants.RV_ITEM_NORMAL);
                intent.putExtra("activity_content", bundle);
                ActivityCompat.startActivity(getActivity(), intent, option);
            }
        });



        return view;
    }

    private void testRecycleViewAdapter(RecyclerView rv, int type){
        //Show RECYCLEVIEW

        rv.setItemAnimator(new DefaultItemAnimator());
        TestRecycleViewAdapter adapter = new TestRecycleViewAdapter(type, getActivity());
        rv.setAdapter(adapter);
    }

    private void showFragment(Fragment fragment){
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.activity_main_container_fl, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
