package com.salon.cattocdi.fragements;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.salon.cattocdi.R;
import com.salon.cattocdi.SearchResultActivity;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    private EditText etDate, etService;
    private Button btSearch;
    RelativeLayout serviceLayout;
   // ExpandableListView listService;
    RecyclerView recyclerView;


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         View view = inflater.inflate(R.layout.fragment_search, container, false);
        etDate = view.findViewById(R.id.fg_search_date_et);

        // Get Current Date
        final Calendar c = Calendar.getInstance();
        final int mYear = c.get(Calendar.YEAR);
        final int mMonth = c.get(Calendar.MONTH);
        final int mDay = c.get(Calendar.DAY_OF_MONTH);


        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        etDate.setText(day + "/"+month +"/"+year);
                    }
                }, mYear, mMonth, mDay);
                dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                dialog.show();
            }
        });




        etService = view.findViewById(R.id.fg_search_service_et);
        etService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowServiceFragment showServiceFragment = new ShowServiceFragment();
                getFragmentManager().beginTransaction().replace(R.id.activity_main_container_fl, showServiceFragment, null)
                        .addToBackStack(null).commit();

            }
        });
        Bundle bundle = this.getArguments();
        if(bundle != null){
            etService.setText(getArguments().getString("name"));
        }

        /*etService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            ShowServiceFragment showServiceFragment = new ShowServiceFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.fg_search, showServiceFragment, null).addToBackStack(null).commit();
               *//* Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.fragemnt_search_service_expend);

                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.MATCH_PARENT;
                dialog.setTitle("Dịch vụ");
                listService = dialog.findViewById(R.id.fg_search_elv);
                listService.setAdapter(new ExpandableListViewAdapter(getActivity()));
                dialog.show();
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.white);
                dialog.getWindow().setAttributes(lp);*//*
            }
        });*/

        btSearch = view.findViewById(R.id.fg_search_search_btn);
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchResultActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }



}
