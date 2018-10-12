package com.salon.cattocdi.fragements;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.salon.cattocdi.R;
import com.salon.cattocdi.adapters.FragementAppointmentTestAdapter;
import com.salon.cattocdi.adapters.TestRecycleViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppointmentFragment extends Fragment {

    RecyclerView rvUpcomming;

    public AppointmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_appointment, container, false);
        rvUpcomming = view.findViewById(R.id.fg_appointment_rv_upcoming);
        testRecycleViewAdapter(rvUpcomming);


        return view;
    }

    private void testRecycleViewAdapter(RecyclerView rv){
        //Show RECYCLEVIEW
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        rv.setLayoutManager(mLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        FragementAppointmentTestAdapter adapter = new FragementAppointmentTestAdapter();
        rv.setAdapter(adapter);
    }

}
