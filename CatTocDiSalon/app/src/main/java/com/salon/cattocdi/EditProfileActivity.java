package com.salon.cattocdi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.salon.cattocdi.fragements.ProfileFragment;

public class EditProfileActivity extends Activity {
    private BottomNavigationView bottomNav;
    private Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_edit_profile);
        btnUpdate = findViewById(R.id.btn_update_profile);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfileActivity.this, MainActivity.class);
                intent.putExtra("update", "update");
                Toast.makeText(EditProfileActivity.this,"Bạn đã thay đổi thông tin cá nhân thành công",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }


}
