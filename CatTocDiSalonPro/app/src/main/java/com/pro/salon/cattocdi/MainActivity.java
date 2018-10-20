package com.pro.salon.cattocdi;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.github.eunsiljo.timetablelib.data.TimeData;
import com.github.eunsiljo.timetablelib.data.TimeGridData;
import com.github.eunsiljo.timetablelib.data.TimeTableData;
import com.github.eunsiljo.timetablelib.view.TimeTableView;
import com.github.eunsiljo.timetablelib.viewholder.TimeTableItemViewHolder;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TimeTableView scheduleTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        scheduleTable = findViewById(R.id.salon_schedule);
//
//        scheduleTable.setOnTimeItemClickListener(new TimeTableItemViewHolder.OnTimeItemClickListener() {
//            @Override
//            public void onTimeItemClick(View view, int i, TimeGridData timeGridData) {
//                Log.d("CLICK NE", "" + timeGridData.getTime().getTitle());
//            }
//        });
//
//        scheduleTable.setStartHour(7);
//        scheduleTable.setTableMode(TimeTableView.TableMode.SHORT);
//
//        //assign data test
//        ArrayList<TimeTableData> table = null;
//        table = getSamples(DateTime.now().withTimeAtStartOfDay().getMillis());
//        scheduleTable.setTimeTable(DateTime.now().withTimeAtStartOfDay().getMillis(), table);

    }

    private ArrayList<TimeTableData> getSamples(long date){

        ArrayList<TimeTableData> tables = new ArrayList<>();
        for(int i=0; i< 7; i++){
            ArrayList<TimeData> values = new ArrayList<>();
            DateTime start = new DateTime(date);
            DateTime end = start.plusMinutes((int)((Math.random() * 10) + 1) * 30);
            for(int j=0; j< 7; j++){
                int textColor = R.color.black;


                TimeData timeData = new TimeData(j, "", R.color.light, textColor, start.getMillis(), end.getMillis());

                values.add(timeData);

                start = end.plusMinutes((int)((Math.random() * 10) + 1) * 10);
                end = start.plusMinutes((int)((Math.random() * 10) + 1) * 30);
            }

            tables.add(new TimeTableData("", values));
        }
        return tables;
    }

//    private ArrayList<TimeTableData> getData(){
//
//        Random random = new Random();
//        ArrayList<TimeTableData> table = new ArrayList<>();
//
//        for(int i = 0; i < 7; i++){
//            ArrayList<TimeData> col = new ArrayList<>();
//
//
//            TimeData t = new TimeData(0, "",
//                        R.color.color_table_1,
//                        R.color.lightTextColor,
//                        getMillis("2018-10-19 7:00:00"), getMillis("2018-10-19 8:30:00")) ;
//
//            TimeData t1 = new TimeData(1, "",
//                    R.color.color_table_2,
//                    R.color.lightTextColor,
//                    getMillis("2018-10-19 9:00:00"), getMillis("2018-10-19 10:00:00")) ;
//            TimeData t2 = new TimeData(1, "",
//                    R.color.color_table_3,
//                    R.color.lightTextColor,
//                    getMillis("2018-10-19 11:00:00"), getMillis("2018-10-19 11:45:00")) ;
//            TimeData t3 = new TimeData(1, "",
//                    R.color.color_table_4,
//                    R.color.lightTextColor,
//                    getMillis("2018-10-19 12:00:00"), getMillis("2018-10-19 13:20:00")) ;
//            TimeData t4 = new TimeData(1, "",
//                    R.color.color_table_5,
//                    R.color.lightTextColor,
//                    getMillis("2018-10-19 13:30:00"), getMillis("2018-10-19 14:15:00")) ;
//            TimeData t5 = new TimeData(1, "",
//                    R.color.color_table_6,
//                    R.color.lightTextColor,
//                    getMillis("2018-10-19 15:00:00"), getMillis("2018-10-19 16:30:00")) ;
//            TimeData t6 = new TimeData(1, "",
//                    R.color.color_table_7,
//                    R.color.lightTextColor,
//                    getMillis("2018-10-19 17:00:00"), getMillis("2018-10-19 19:00:00")) ;
//
//                col.add(t);
//                col.add(t1);
//                col.add(t2);
//                col.add(t3);
//                col.add(t4);
//                col.add(t5);
//                col.add(t6);
//
//            table.add(new TimeTableData("", col));
//        }
//
//        return table;
//    }
    private long getMillis(String day){
        DateTime date = getDateTimePattern().parseDateTime(day);
        return date.getMillis();
    }
    private DateTimeFormatter getDateTimePattern(){
        return DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    }
}
