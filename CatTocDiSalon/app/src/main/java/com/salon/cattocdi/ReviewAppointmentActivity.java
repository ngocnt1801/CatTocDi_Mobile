package com.salon.cattocdi;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.salon.cattocdi.fragements.AppointmentFragment;

public class ReviewAppointmentActivity extends AppCompatActivity {
    private Button btnBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_appointment);
        btnBook = findViewById(R.id.review_appointment_activity);
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewAppointmentActivity.this, MainActivity.class);
                intent.putExtra("done", "done");
                Toast.makeText(ReviewAppointmentActivity.this,"Bạn đã đặt lịch thành công",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}
