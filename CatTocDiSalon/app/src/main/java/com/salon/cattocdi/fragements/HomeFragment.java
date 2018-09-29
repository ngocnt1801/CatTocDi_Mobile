package com.salon.cattocdi.fragements;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salon.cattocdi.R;
import com.salon.cattocdi.adapters.TestRecycleViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView rvBookmark, rvRating, rvSale;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        rvBookmark = view.findViewById(R.id.fg_home_rv_bookmark);
        rvRating = view.findViewById(R.id.fg_home_rv_rating);
        rvSale = view.findViewById(R.id.fg_home_rv_sale);
        testRecycleViewAdapter(rvBookmark);
        testRecycleViewAdapter(rvRating);
        testRecycleViewAdapter(rvSale);
        return view;
    }

    private void testRecycleViewAdapter(RecyclerView rv){
        //Show RECYCLEVIEW
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        rv.setLayoutManager(mLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        TestRecycleViewAdapter adapter = new TestRecycleViewAdapter();
        rv.setAdapter(adapter);
    }

}
