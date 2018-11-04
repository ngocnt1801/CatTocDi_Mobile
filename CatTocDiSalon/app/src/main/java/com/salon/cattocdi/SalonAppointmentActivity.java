package com.salon.cattocdi;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.salon.cattocdi.adapters.AppointmentServiceRecycleViewAdapter;
import com.salon.cattocdi.adapters.TimeSlotRecycleViewAdapter;
import com.salon.cattocdi.models.DateSlot;
import com.salon.cattocdi.models.Salon;
import com.salon.cattocdi.models.Service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;


public class SalonAppointmentActivity extends AppCompatActivity {

    private RecyclerView rvMorning, rvAfternoon, rvNight, rvService;
    private Button btnAddService;
    private List<Service> checkedList;
    private Salon salon;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_salon_appointment);

        rvService = findViewById(R.id.activity_salon_appointment_service_rv);
        rvMorning = findViewById(R.id.activity_salon_appointment_morning_rv);
        rvAfternoon = findViewById(R.id.activity_salon_appointment_afternoon_rv);
        rvNight = findViewById(R.id.activity_salon_appointment_night_rv);

        ViewCompat.setNestedScrollingEnabled(rvService, false);
        ViewCompat.setNestedScrollingEnabled(rvMorning, false);
        ViewCompat.setNestedScrollingEnabled(rvAfternoon, false);
        ViewCompat.setNestedScrollingEnabled(rvNight, false);



        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.DATE, 0);

        // set Default Date Title
        TextView textTitleDate = findViewById(R.id.activity_appoinment_title_date);
        int month = startDate.get(Calendar.MONTH) + 1;
        String textMonth = Integer.toString(month);
        int dayOfMonth = startDate.get(Calendar.DAY_OF_MONTH);
        String textDayOfMonth = Integer.toString(dayOfMonth);
        textTitleDate.setText("Hôm nay" + ", " + textDayOfMonth + "/" + textMonth);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.DATE, 7);

        // Default Date set to Today.
        final Calendar defaultSelectedDate = Calendar.getInstance();

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.my_calendar_view)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .defaultSelectedDate(defaultSelectedDate)
                .build();
        Log.i("Default Date", DateFormat.format("EEE, MMM d, yyyy", defaultSelectedDate).toString());

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                String selectedDateStr = DateFormat.format("EEE, MMM d, yyyy", date).toString();
                TextView titleDate = findViewById(R.id.activity_appoinment_title_date);
                int day = date.get(Calendar.DAY_OF_WEEK);
                String textDay = "Chủ nhật";
                switch (day) {
                    case 2:
                        textDay = "Thứ 2";
                        break;
                    case 3:
                        textDay = "Thứ 3";
                        break;
                    case 4:
                        textDay = "Thứ 4";
                        break;
                    case 5:
                        textDay = "Thứ 5";
                        break;
                    case 6:
                        textDay = "Thứ 6";
                        break;
                    case 7:
                        textDay = "Thứ 7";
                        break;
                }
                int month = date.get(Calendar.MONTH) + 1;
                String textMonth = Integer.toString(month);
                int dayOfMonth = date.get(Calendar.DAY_OF_MONTH);
                String textDayOfMonth = Integer.toString(dayOfMonth);
                Calendar now = Calendar.getInstance();
                if (dayOfMonth == now.get(Calendar.DAY_OF_MONTH)) {
                    textDay = "Hôm nay";
                } else if (dayOfMonth == now.get(Calendar.DAY_OF_MONTH) + 1) {
                    textDay = "Ngày mai";
                } else if (dayOfMonth == now.get(Calendar.DAY_OF_MONTH) + 2) {
                    textDay = "Ngày mốt";
                }
                titleDate.setText(textDay + ", " + textDayOfMonth + "/" + textMonth);
                loadTimeSlotList(dayOfMonth == now.get(Calendar.DAY_OF_MONTH));
            }
        });

        loadTimeSlotList(true);

        checkedList = (List<Service>) getIntent().getSerializableExtra("checked_list");
        if(checkedList == null){
            checkedList = new ArrayList<>();
        }
        Service service = (Service)getIntent().getSerializableExtra("service_choosen");
        if(service != null){
            checkedList.add(service);
        }


        rvService.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvService.setAdapter(new AppointmentServiceRecycleViewAdapter(checkedList));

        salon = (Salon) getIntent().getSerializableExtra("salon");
        btnAddService = findViewById(R.id.btn_add_more_service_to_appointment);
        btnAddService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SalonAppointmentActivity.this, ServiceAppointmentBookActivity.class);
                if(checkedList != null){
                    intent.putExtra("checked_list", (Serializable) checkedList);
                }
                intent.putExtra("salon", (Serializable) salon);
                startActivity(intent);
            }
        });

    }

    private void loadTimeSlotList(boolean isToday){
        Random random = new Random();

        rvMorning.setLayoutManager(new GridLayoutManager(this, 4));
        rvMorning.setAdapter(new TimeSlotRecycleViewAdapter(this, TimeSlotRecycleViewAdapter.MORNING, new Timestamp(Calendar.getInstance().getTimeInMillis()), checkedList, new ArrayList<DateSlot.Slot>()));

        rvAfternoon.setLayoutManager(new GridLayoutManager(this, 4));
        rvMorning.setAdapter(new TimeSlotRecycleViewAdapter(this, TimeSlotRecycleViewAdapter.AFTERNOON, new Timestamp(Calendar.getInstance().getTimeInMillis()), checkedList, new ArrayList<DateSlot.Slot>()));

        rvNight.setLayoutManager(new GridLayoutManager(this, 4));
        rvMorning.setAdapter(new TimeSlotRecycleViewAdapter(this, TimeSlotRecycleViewAdapter.EVENING, new Timestamp(Calendar.getInstance().getTimeInMillis()), checkedList, new ArrayList<DateSlot.Slot>()));

    }
    @SuppressLint("ResourceType")
    private void showFragment(android.support.v4.app.Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.activity_salon_appointment, fragment);
        transaction.commit();
    }

}
