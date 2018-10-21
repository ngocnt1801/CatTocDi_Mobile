package com.pro.salon.cattocdi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pro.salon.cattocdi.R;

public class ServiceRecycleViewAdapter extends RecyclerView.Adapter<ServiceRecycleViewAdapter.ServiceViewHolder>{
    private Context context;

    public ServiceRecycleViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_salon_detail_service_recycle_view, viewGroup, false);
        return new ServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewHolder serviceViewHolder, int i) {
        serviceViewHolder.btnAddService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder {
        public View item;
        public Button btnAddService;
        public ServiceViewHolder(@NonNull View itemView) {
            super(itemView);
            this.item = itemView;
            this.btnAddService = itemView.findViewById(R.id.btn_add_service_to_appointment);
        }
    }
}

