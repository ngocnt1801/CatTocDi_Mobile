package com.salon.cattocdi.fragements;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.salon.cattocdi.R;
import com.salon.cattocdi.adapters.SalonDetailPromotionRecycleView;
import com.salon.cattocdi.adapters.ServiceRecycleViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SalonDetailServiceFragment extends Fragment {

    public SalonDetailServiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_salon_detail_service, container, false);
        // Inflate the layout for this fragment
        RecyclerView serviceRecycleView = view.findViewById(R.id.salon_service_recycle_view);
        serviceRecycleView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        serviceRecycleView.setAdapter(new ServiceRecycleViewAdapter());

        RecyclerView promotionRecycleView = view.findViewById(R.id.salon_promotion_recycle_view);
        promotionRecycleView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        promotionRecycleView.setAdapter(new SalonDetailPromotionRecycleView());

        return view;
    }

}
