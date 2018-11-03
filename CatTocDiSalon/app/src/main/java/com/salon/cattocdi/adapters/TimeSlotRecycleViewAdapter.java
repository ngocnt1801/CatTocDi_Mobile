package com.salon.cattocdi.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.salon.cattocdi.R;
import com.salon.cattocdi.ReviewAppointmentActivity;
import com.salon.cattocdi.models.Service;
import com.salon.cattocdi.models.DateSlot;

import java.sql.Timestamp;
import java.util.List;

public class TimeSlotRecycleViewAdapter extends RecyclerView.Adapter<TimeSlotRecycleViewAdapter.TimeSlotViewHolder>{

    private Context context;
    private int type;
    private Timestamp date;
    private List<Service> services;
    private List<DateSlot.Slot> dateSlots;

    public static final int MORNING = 1;
    public static final int AFTERNOON = 2;
    public static int EVENING = 3;


    public TimeSlotRecycleViewAdapter(Context context, int type, Timestamp date, List<Service> services, List<DateSlot.Slot> slots) {
        this.context = context;
        this.type = type;
        this.date = date;
        this.services = services;
        this.dateSlots = slots;
    }

    @NonNull
    @Override
    public TimeSlotViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view_item_time_slot, viewGroup, false);
        return new TimeSlotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TimeSlotViewHolder timeSlotViewHolder, int i) {

        timeSlotViewHolder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ReviewAppointmentActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dateSlots.size();
    }

    public class TimeSlotViewHolder extends RecyclerView.ViewHolder{

        private Button item;

        public TimeSlotViewHolder(@NonNull View itemView) {
            super(itemView);
            this.item = (Button) itemView;
        }
    }

    private void setTimeSlotButtonActive(Button btn){
        btn.setBackgroundResource(R.drawable.border_radius_edit_text_singup_button);
        btn.setTextColor(Color.parseColor("#ffffff"));
    }

    private void setTimeSlotButtonNormal(Button btn){
        btn.setBackgroundResource(R.drawable.border_radius_outline_btn);
        btn.setTextColor(Color.parseColor("#5f3f72"));
    }

}

