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

import java.util.Random;

public class TimeSlotRecycleViewAdapter extends RecyclerView.Adapter<TimeSlotRecycleViewAdapter.TimeSlotViewHolder>{

    private Context context;
    private int count;
    private int type;
    private boolean isToday = false;

    public static final int MORNING = 1;
    public static final int AFTERNOON = 2;
    public static int EVENING = 3;

    public TimeSlotRecycleViewAdapter(Context context, int count, int type) {
        this.context = context;
        this.count = count;
        this.type = type;
    }

    public TimeSlotRecycleViewAdapter(Context context, int count, int type, boolean isToday) {
        this.context = context;
        this.count = count;
        this.type = type;
        this.isToday = isToday;
    }

    @NonNull
    @Override
    public TimeSlotViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view_item_time_slot, viewGroup, false);
        return new TimeSlotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TimeSlotViewHolder timeSlotViewHolder, int i) {

        if(type == MORNING){
            int hour = i + 8;
            String textMinute = i%2==0?"00" : "30";
            timeSlotViewHolder.item.setText(hour + ":" + textMinute);
        }else if (type == AFTERNOON){
            int hour = 16;
            if(isToday){
                hour = i + 16;
            }else{
                hour = i + 12;
            }
            int minute = 30 * (i%2);
            String textMinute = i%2==0?"00" : "30";
            timeSlotViewHolder.item.setText(hour + ":" + textMinute);
        }else if (type == EVENING){
            int hour = i + 18;
            int minute = 30 * (i%2);
            String textMinute = i%2==0?"00" : "30";
            timeSlotViewHolder.item.setText(hour + ":" + textMinute);
        }

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
        if (type == MORNING && isToday)  return 0;
        return count > 0 ? count : 1;
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

