package com.vansh.hospitalmanagement1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.vansh.hospitalmanagement1.Admin_Panel.Authentication.AdminLoginActivity;
import com.vansh.hospitalmanagement1.Hospital_Panel.Authentication.HospitalLoginActivity;
import com.vansh.hospitalmanagement1.User_pannel.Authentication.PatientLoginActivity;

public class MainActivity extends AppCompatActivity {


    private RadioGroup radioGroup;
    private Button buttonSelectRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        buttonSelectRole = findViewById(R.id.buttonSelectRole);


        // Set a click listener for the "Select" button
        buttonSelectRole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the selected radio button
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId != -1) { // At least one radio button is selected
                    // Determine the selected role
                    RadioButton radioButton = findViewById(selectedId);
                    String selectedRole = radioButton.getText().toString();

                    // Start the corresponding login activity based on the selected role
                    Intent intent;
                    switch (selectedRole) {
                        case "Admin":
                            intent = new Intent(MainActivity.this, AdminLoginActivity.class);
                            break;
                        case "Hospital":
                            intent = new Intent(MainActivity.this, HospitalLoginActivity.class);
                            break;
                        case "Patient":
                            intent = new Intent(MainActivity.this, PatientLoginActivity.class);
                            break;
                        default:
                            // Handle other cases or errors here
                            return;
                    }

                    // Start the login activity
                    startActivity(intent);
                }
            }
        });


    }
}