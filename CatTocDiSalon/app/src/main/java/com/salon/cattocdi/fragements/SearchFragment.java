package com.salon.cattocdi.fragements;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ExpandableListView;

import com.salon.cattocdi.ListSalonActivity;
import com.salon.cattocdi.R;
import com.salon.cattocdi.SearchResultActivity;
import com.salon.cattocdi.adapters.ExpandableListViewAdapter;
import com.salon.cattocdi.utils.MyContants;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    private EditText etDate, etService;
    private Button btSearch;
    ExpandableListView listService;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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
            public void onClick(View view) {
                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.fragment_search_service_dialog);
                dialog.setTitle("Services");
                listService = dialog.findViewById(R.id.fg_search_elv);
                listService.setAdapter(new ExpandableListViewAdapter(getActivity()));
                dialog.show();
            }
        });

        btSearch = view.findViewById(R.id.fg_search_search_btn);
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ListSalonActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title", "Kết quả tìm kiếm");
                bundle.putInt("type", MyContants.RV_ITEM_NORMAL);
                intent.putExtra("activity_content",bundle);
                startActivity(intent);
            }
        });


        return view;
    }

}
