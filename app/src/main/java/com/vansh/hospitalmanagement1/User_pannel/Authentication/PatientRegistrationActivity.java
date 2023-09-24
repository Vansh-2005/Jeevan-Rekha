package com.vansh.hospitalmanagement1.User_pannel.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.vansh.hospitalmanagement1.R;

import java.util.Calendar;

public class PatientRegistrationActivity extends AppCompatActivity {  private EditText editTextPatientFullName;
    private EditText editTextPatientDOB;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private RadioGroup radioGroupGender;
    private EditText editTextPatientEmail;
    private EditText editTextPatientPassword;
    private EditText editTextPatientPhoneNumber;
    private Spinner spinnerHospitalName;
    private ImageView imageViewProfilePhoto;
    private Button buttonChoosePhoto;
    private Button buttonRegister;
    private Calendar calendar;
    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_registration);


        editTextPatientDOB = findViewById(R.id.editTextPatientDOB);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        editTextPatientEmail = findViewById(R.id.editTextPatientEmail);
        editTextPatientPassword = findViewById(R.id.editTextPatientPassword);
        editTextPatientPhoneNumber = findViewById(R.id.editTextPatientPhoneNumber);
        spinnerHospitalName = findViewById(R.id.spinnerHospitalName);
        imageViewProfilePhoto = findViewById(R.id.imageViewProfilePhoto);
        buttonChoosePhoto = findViewById(R.id.buttonChoosePhoto);
        buttonRegister = findViewById(R.id.buttonRegister);

//        For Opening Calender

        editTextPatientDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a DatePickerDialog to allow the user to select a date
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        PatientRegistrationActivity.this,
                        dateSetListener,
                        year,
                        month,
                        day
                );
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis()); // Optional: Set a max date
                datePickerDialog.show();
            }
        });
        // Initialize the DatePickerDialog.OnDateSetListener
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Handle the selected date (e.g., set it in the EditText)
                String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                editTextPatientDOB.setText(selectedDate); // Set the selected date in the EditText
            }
        };


        // Set up the Spinner for hospital name selection (you will need to populate it with hospital names)

        // Handle choosing a profile photo (you will need to implement this)

        // Handle registration button click
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement patient registration logic
            }
        });
    }
}