package com.salon.cattocdi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.salon.cattocdi.utils.MyContants;

public class LoginActivity extends AppCompatActivity {



    private Button btnLogin, btnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.login_activity_login_btn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkLogin()){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    showDialogLoginFail();
                }
            }
        });

        btnSkip = findViewById(R.id.login_activity_skip_btn);
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean checkLogin(){
        boolean result = false;
        EditText etPhone = findViewById(R.id.login_activity_phone_et);
        EditText etPassword= findViewById(R.id.login_activity_password_et);
        if(etPhone.getText().toString().equals(MyContants.PHONE_TEST) && etPassword.getText().toString().equals(MyContants.PASSWORD_TEST) ){
            result = true;
        }
        return result;
    }

    private void showDialogLoginFail(){
        final AlertDialog dialog = new AlertDialog.Builder(LoginActivity.this).create();
        dialog.setTitle("Không chính xác");
        dialog.setMessage("Số điện thoại hoặc mật khẩu không chính xác");
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
