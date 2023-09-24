package com.vansh.hospitalmanagement1.User_pannel.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.vansh.hospitalmanagement1.R;

public class PatientLoginActivity extends AppCompatActivity {
    private TextView textViewPatientRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);

        textViewPatientRegister = findViewById(R.id.textViewPatientRegister);


        textViewPatientRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PatientLoginActivity.this,PatientRegistrationActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}