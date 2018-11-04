package com.salon.cattocdi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import android.widget.TextView;

import com.salon.cattocdi.adapters.SalonAdapter;
import com.salon.cattocdi.models.Salon;
import com.salon.cattocdi.utils.MyContants;

import java.util.List;

public class ListSalonActivity extends AppCompatActivity {

    private TextView titleTv;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_list_salon);

        titleTv = findViewById(R.id.activity_list_salon_title_tv);
        rv = findViewById(R.id.activity_list_rv);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        String title = (String) bundle.get("title");
        List<Salon> salonList = (List<Salon>) bundle.getSerializable("salon");
        titleTv.setText(title);

        int type = bundle.getInt("type");
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        switch (type){
            case MyContants.RV_ITEM_VOUCHER:
                rv.setAdapter(new SalonAdapter(MyContants.RV_ITEM_VOUCHER, this, salonList));
                break;
            case MyContants.RV_ITEM_NORMAL:
                rv.setAdapter(new SalonAdapter(MyContants.RV_ITEM_NORMAL, this, salonList));
                break;
        }


    }
}
