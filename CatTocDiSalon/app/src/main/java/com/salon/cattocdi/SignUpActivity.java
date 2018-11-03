package com.salon.cattocdi;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.salon.cattocdi.models.ResponseMessage;
import com.salon.cattocdi.requests.AccountApi;
import com.salon.cattocdi.requests.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    private Button loginBtn, maleBtn, femaleBtn, signupBtn;
    private EditText etPhone, etPassword, etName;
    private boolean isMale = true;

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
        etPhone = findViewById(R.id.signup_activity_username_et);
        etName = findViewById(R.id.signup_activity_name_et);
        etPassword = findViewById(R.id.signup_activity_password_et);

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
                isMale = true;
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
                isMale = false;
                femaleBtn.setBackgroundResource(R.drawable.border_radius_btn_gender_right_fill);
                femaleBtn.setTextColor(Color.parseColor("#ffffff"));
                maleBtn.setBackgroundResource(R.drawable.border_radius_btn_gender_left);
                maleBtn.setTextColor(Color.parseColor("#000000"));
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean result = validRegister();
                if(result){
                    ApiClient.getInstance().create(AccountApi.class)
                            .register(etPhone.getText().toString(), etPassword.getText().toString(), isMale, etName.getText().toString(), etPhone.getText().toString() )
                            .enqueue(new Callback<ResponseMessage>() {
                                @Override
                                public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                                    if(response.body().isSuccess()){
                                        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                                        startActivity(intent);
                                    }else{
                                        showDialogLoginFail("Số điện thoại này đã được đăng ký");
                                    }
                                }

                                @Override
                                public void onFailure(Call<ResponseMessage> call, Throwable t) {
                                    showDialogLoginFail("Có lỗi xảy ra, vui lòng thử lại!");
                                }
                            });
                }

            }
        });

    }

    private boolean validRegister(){
        boolean result = true;
        if(etPhone.getText().toString().isEmpty()){
            etPhone.setError("Bạn phải nhập số điện thaoij");
            result = false;
        }
        if(etName.getText().toString().isEmpty()){
            etName.setError("Bạn phải nhập tên");
            result = false;

        }
        if(etPassword.getText().toString().isEmpty()){
            etPassword.setError("Bạn phải nhập mật khẩu");
            result = false;

        }

        return result;
    }

    private void showDialogLoginFail(String msg){
        final AlertDialog dialog = new AlertDialog.Builder(SignUpActivity.this).create();
        dialog.setTitle("Không thành công");
        dialog.setMessage(msg);
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
