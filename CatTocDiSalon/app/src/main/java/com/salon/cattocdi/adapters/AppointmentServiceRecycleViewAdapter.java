package com.salon.cattocdi.adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.salon.cattocdi.LoginActivity;
import com.salon.cattocdi.R;

public class AppointmentServiceRecycleViewAdapter extends RecyclerView.Adapter<AppointmentServiceRecycleViewAdapter.AppointmentSeriveViewHolder>{

    private int count = 4;

    @NonNull
    @Override
    public AppointmentSeriveViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view_service_add_item, viewGroup, false);
        return new AppointmentSeriveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AppointmentSeriveViewHolder viewHolder, final int i) {
        viewHolder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count--;
                notifyItemRemoved(i);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return count;
    }

    public class AppointmentSeriveViewHolder extends RecyclerView.ViewHolder{

        private View item;
        private TextView tvService;
        private ImageView ivDelete;

        public AppointmentSeriveViewHolder(@NonNull View itemView) {
            super(itemView);
            tvService = itemView.findViewById(R.id.activity_salon_appointmet_service_tv);
            this.item = itemView;
            this.ivDelete = itemView.findViewById(R.id.activity_salon_appointmet_delete_iv);
        }
    }

}
