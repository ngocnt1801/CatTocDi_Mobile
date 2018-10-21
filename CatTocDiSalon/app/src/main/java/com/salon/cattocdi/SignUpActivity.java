package com.salon.cattocdi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class SignUpActivity extends AppCompatActivity {

    private Button loginBtn, maleBtn, femaleBtn, signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        loginBtn = findViewById(R.id.signup_activity_login_btn);
        maleBtn = findViewById(R.id.signup_activity_male_btn);
        femaleBtn = findViewById(R.id.signup_activity_female_btn);
        signupBtn = findViewById(R.id.signup_activity_signup_btn);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        maleBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                maleBtn.setBackgroundResource(R.drawable.border_radius_btn_gender_left_fill);
                maleBtn.setTextColor(Color.parseColor("#ffffff"));
                femaleBtn.setBackgroundResource(R.drawable.border_radius_btn_gender_right);
                femaleBtn.setTextColor(Color.parseColor("#000000"));
            }
        });

        femaleBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                femaleBtn.setBackgroundResource(R.drawable.border_radius_btn_gender_right_fill);
                femaleBtn.setTextColor(Color.parseColor("#ffffff"));
                maleBtn.setBackgroundResource(R.drawable.border_radius_btn_gender_left);
                maleBtn.setTextColor(Color.parseColor("#000000"));
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
