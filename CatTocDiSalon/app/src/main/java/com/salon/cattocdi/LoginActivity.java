package com.salon.cattocdi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.salon.cattocdi.utils.MyContants;

public class LoginActivity extends AppCompatActivity {



    private Button btnLogin ;
    private TextView tvRegister,btnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
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

        tvRegister = findViewById(R.id.login_activity_register_tv);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
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

//    private void sendRequest(){
//        RequestQueue queue = Volley.newRequestQueue(this);
//        String url = "http://192.168.0.120/cattocdi.api/token";
//        StringRequest request = new StringRequest(Request.Method.POST, url,
//                new Response.Listener<String>() {
//                @Override
//                public void onResponse(String response) {
//                    Log.d("RESPONSE", response);
//                }
//        },
//                new Response.ErrorListener(){
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.d("RESPONSE", error.getMessage());
//                    }
//                }
//        ){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> param = new HashMap<>();
//                param.put("username","tiendat@gmail.com");
//                param.put("password","Test@123");
//                param.put("grant_type","password");
//                return param;
//            }
//        };
//        queue.add(request);
//    }
}
