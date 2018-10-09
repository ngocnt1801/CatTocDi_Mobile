package com.salon.cattocdi.fragements;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;

import com.salon.cattocdi.R;
import com.salon.cattocdi.adapters.TestRecycleViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView rvNew, rvRating, rvSale;
    private EditText etSearch;


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

        //set layout
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvSale.setLayoutManager(mLayoutManager);

        rvRating.setLayoutManager(new GridLayoutManager(getActivity(),1));

        rvNew.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

//        testRecycleViewAdapter(rvBookmark);,
        testRecycleViewAdapter(rvRating, true);
        testRecycleViewAdapter(rvSale, false);
        testRecycleViewAdapter(rvNew, false);

        etSearch = view.findViewById(R.id.fg_home_search_et);
        etSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchFragment searchFragment = new SearchFragment();
                showFragment(searchFragment);
            }
        });
        return view;
    }

    private void testRecycleViewAdapter(RecyclerView rv, boolean isRating){
        //Show RECYCLEVIEW

        rv.setItemAnimator(new DefaultItemAnimator());
        TestRecycleViewAdapter adapter = new TestRecycleViewAdapter(isRating, getActivity());
        rv.setAdapter(adapter);
    }

    private void showFragment(Fragment fragment){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.activity_main_container_fl, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
