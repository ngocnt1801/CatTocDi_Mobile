package com.salon.cattocdi.fragements;


import android.annotation.SuppressLint;
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

    private int salonId;

    public SalonDetailServiceFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public SalonDetailServiceFragment(int salonId) {
        this.salonId = salonId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_salon_detail_service, container, false);

        if(salonId >= 0){
            RecyclerView serviceRecycleView = view.findViewById(R.id.salon_service_recycle_view);
            serviceRecycleView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            serviceRecycleView.setAdapter(new ServiceRecycleViewAdapter(getActivity()));

            RecyclerView promotionRecycleView = view.findViewById(R.id.salon_promotion_recycle_view);
            promotionRecycleView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            promotionRecycleView.setAdapter(new SalonDetailPromotionRecycleView());
        }


        return view;
    }

}
