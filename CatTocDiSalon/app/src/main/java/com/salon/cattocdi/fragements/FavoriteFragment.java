package com.salon.cattocdi.fragements;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salon.cattocdi.R;
import com.salon.cattocdi.adapters.TestRecycleViewAdapter;
import com.salon.cattocdi.utils.MyContants;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {

    private RecyclerView rv;

    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        rv = view.findViewById(R.id.fg_favorite_rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(new TestRecycleViewAdapter(true, MyContants.RV_ITEM_NORMAL, getActivity()));
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
