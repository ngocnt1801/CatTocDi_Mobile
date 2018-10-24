package com.salon.cattocdi.adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.salon.cattocdi.R;
import com.salon.cattocdi.SalonAppointmentActivity;

import org.w3c.dom.Text;

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

        switch (i){
            case 0:
                serviceViewHolder.tvServiceTitle.setText("Cắt tóc");
                serviceViewHolder.tvPriceTime.setText("30,000 vnd trong 15 phút");
                break;
            case 1:
                serviceViewHolder.tvServiceTitle.setText("Uốn tóc");
                serviceViewHolder.tvPriceTime.setText("200,000 vnd trong 2 tiếng");
                break;
            case 2:
                serviceViewHolder.tvServiceTitle.setText("Duỗi tóc");
                serviceViewHolder.tvPriceTime.setText("200,000 vnd trong 1 tiếng 30 phút");
                break;
            case 3:
                serviceViewHolder.tvServiceTitle.setText("Nhuộm tóc");
                serviceViewHolder.tvPriceTime.setText("450,000 vnd trong 3 tiếng");
                break;
            case 4:
                serviceViewHolder.tvServiceTitle.setText("Highlight");
                serviceViewHolder.tvPriceTime.setText("400,000 vnd trong 2 tiếng");
                break;
        }

        serviceViewHolder.btnAddService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SalonAppointmentActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder {
        public View item;
        public Button btnAddService;
        public TextView tvServiceTitle, tvPriceTime;
        public ServiceViewHolder(@NonNull View itemView) {
            super(itemView);
            this.item = itemView;
            this.btnAddService = itemView.findViewById(R.id.btn_add_service_to_appointment);
            this.tvPriceTime = itemView.findViewById(R.id.service_price_time);
            this.tvServiceTitle = itemView.findViewById(R.id.service_title);
        }
    }
}

