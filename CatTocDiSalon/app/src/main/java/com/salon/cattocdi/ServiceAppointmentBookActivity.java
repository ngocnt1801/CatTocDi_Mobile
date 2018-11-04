package com.salon.cattocdi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.salon.cattocdi.adapters.CategoryAdapter;
import com.salon.cattocdi.adapters.SuggestServiceCardAdapter;
import com.salon.cattocdi.models.Category;
import com.salon.cattocdi.models.Salon;
import com.salon.cattocdi.models.Service;
import com.salon.cattocdi.utils.MyContants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServiceAppointmentBookActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_show_service);

        List<Service> checkedList = (List<Service>) getIntent().getSerializableExtra("checked_list");
        final Salon salon = (Salon) getIntent().getSerializableExtra("salon");
        final RecyclerView rvService = findViewById(R.id.recyclerview);
        rvService.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        final CategoryAdapter adapter = new CategoryAdapter(this, MyContants.SERVICE_CHECKBOX, checkedList, salon.getCategories());
        rvService.setAdapter(adapter);
        TextView tvChoose = findViewById(R.id.btn_get_service);
        tvChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Service> checkedList = adapter.getCheckedList();

                Intent intent = new Intent(ServiceAppointmentBookActivity.this, SalonAppointmentActivity.class);
                intent.putExtra("checked_list", (Serializable) checkedList);
                intent.putExtra("salon", salon);
                startActivity(intent);
            }
        });
    }


}
