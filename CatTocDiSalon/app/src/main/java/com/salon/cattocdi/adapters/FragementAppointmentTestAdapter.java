package com.salon.cattocdi.adapters;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.salon.cattocdi.R;

import net.cachapa.expandablelayout.ExpandableLayout;

public class FragementAppointmentTestAdapter extends RecyclerView.Adapter<FragementAppointmentTestAdapter.AppointmentCardViewHolder> {

    @NonNull
    @Override
    public AppointmentCardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view_item_my_appointment, viewGroup, false);

        return new AppointmentCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AppointmentCardViewHolder viewHolder, int i) {
//        viewHolder.tvName.setText("Salon " + i);
//        viewHolder.tvAddress.setText("abc " + i + i + i);
//        viewHolder.tvServices.setText("Cắt, uống, nhuộm");
//        viewHolder.tvTime.setText("Thứ 2 1/10/2018, 3:00PM");
//        viewHolder.tvStylist.setText("Tran Van A");

//        viewHolder.btnCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//        viewHolder.img.setImageResource(MyContants.SALON_IMAGE_IDS[i]);

        if(i == 0){
            viewHolder.appointmentDetail.expand();
            activeAppointment(viewHolder);
        }

        viewHolder.appointmentRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewHolder.appointmentDetail.toggle();
                if(viewHolder.appointmentDetail.isExpanded()){
                    activeAppointment(viewHolder);
                }else{
                    inactiveAppointment(viewHolder);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class AppointmentCardViewHolder extends RecyclerView.ViewHolder{
        public TextView tvName, tvAddress, tvServices, tvStylist, tvTime;
        public ImageView img, icExpand;
        public Button btnCancel;
        public View item;
        public RelativeLayout appointmentRl;
        public ExpandableLayout appointmentDetail;

        public TextView tvAppoinmentType, tvDate, tvSalonName, tvStartTime, tvDot, tvEndTime;

        public AppointmentCardViewHolder(@NonNull View itemView) {
            super(itemView);
//            tvName = itemView.findViewById(R.id.fg_appointment_name_tv);
//            tvAddress = itemView.findViewById(R.id.fg_appointment_address_tv);
//            tvServices = itemView.findViewById(R.id.fg_appointment_services_tv);
//            tvStylist = itemView.findViewById(R.id.fg_appointment_stylist_tv);
//            tvTime = itemView.findViewById(R.id.fg_appointment_time_tv);
//            img = itemView.findViewById(R.id.appointment_item_excpand_image_cirle);
//            btnCancel = itemView.findViewById(R.id.fg_appointment_cancel_btn);
            appointmentRl = itemView.findViewById(R.id.fg_appointment_rv_item_rl);
            appointmentDetail = itemView.findViewById(R.id.expandable_layout);
            icExpand = itemView.findViewById(R.id.fg_appointment_expand_ic);

            tvAppoinmentType = itemView.findViewById(R.id.fg_appointment_upcomming_tv);
            tvDate = itemView.findViewById(R.id.fg_appointment_date_tv);
            tvSalonName = itemView.findViewById(R.id.fg_appointment_salon_name);
            tvStartTime = itemView.findViewById(R.id.fg_appointment_start_time);
            tvDot = itemView.findViewById(R.id.fg_appointment_dot_tv);
            tvEndTime = itemView.findViewById(R.id.fg_appointment_end_time);

            item = itemView;

        }

    }

    public void activeAppointment(AppointmentCardViewHolder itemView){
        itemView.appointmentRl.setBackgroundResource(R.color.icLogin);
        itemView.tvAppoinmentType.setTextColor(Color.parseColor("#ffffff"));
        itemView.tvAppoinmentType.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_calendar_white, 0,0,0);
        itemView.tvSalonName.setTextColor(Color.parseColor("#ffffff"));
        itemView.tvDate.setTextColor(Color.parseColor("#ffffff"));
        itemView.tvStartTime.setTextColor(Color.parseColor("#ffffff"));
        itemView.tvDot.setTextColor(Color.parseColor("#ffffff"));
        itemView.tvEndTime.setTextColor(Color.parseColor("#ffffff"));
        itemView.icExpand.setImageResource(R.drawable.ic_collapse);
    }

    public void inactiveAppointment(AppointmentCardViewHolder itemView){
        itemView.appointmentRl.setBackgroundResource(0);
        itemView.tvAppoinmentType.setTextColor(Color.parseColor("#6b5b95"));
        itemView.tvAppoinmentType.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_calendar_active, 0,0,0);
        itemView.tvSalonName.setTextColor(Color.parseColor("#000000"));
        itemView.tvDate.setTextColor(Color.parseColor("#000000"));
        itemView.tvStartTime.setTextColor(Color.parseColor("#000000"));
        itemView.tvDot.setTextColor(Color.parseColor("#000000"));
        itemView.tvEndTime.setTextColor(Color.parseColor("#000000"));
        itemView.icExpand.setImageResource(R.drawable.ic_expand);
    }

}
