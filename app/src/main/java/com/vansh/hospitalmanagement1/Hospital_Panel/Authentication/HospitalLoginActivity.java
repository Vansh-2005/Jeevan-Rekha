package com.vansh.hospitalmanagement1.Hospital_Panel.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.vansh.hospitalmanagement1.R;

public class HospitalLoginActivity extends AppCompatActivity {

    private Button buttonHospitalRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_login);

        buttonHospitalRegister = findViewById(R.id.buttonHospitalRegister);

        buttonHospitalRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HospitalLoginActivity.this,HospitalRegistrationActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}