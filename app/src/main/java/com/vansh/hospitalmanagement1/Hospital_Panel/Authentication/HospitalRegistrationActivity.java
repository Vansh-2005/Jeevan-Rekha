package com.vansh.hospitalmanagement1.Hospital_Panel.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.vansh.hospitalmanagement1.R;

public class HospitalRegistrationActivity extends AppCompatActivity {

    private EditText editTextHospitalName, editTextHospitalAddress, editTextHospitalEmail
            , editTextHospitalPassword, editTextHospitalPhoneNumber, editTextHospitalLicense;

    private DatabaseReference databaseReference;
    private int registrationCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_registration);

        // Initialize Firebase database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("hospitals");

        Button registerButton = findViewById(R.id.buttonHospitalRegister);

        editTextHospitalAddress = findViewById(R.id.editTextHospitalAddress);
        editTextHospitalName = findViewById(R.id.editTextHospitalName);
        editTextHospitalEmail = findViewById(R.id.editTextHospitalEmail);
        editTextHospitalPhoneNumber = findViewById(R.id.editTextHospitalPhoneNumber);
        editTextHospitalPassword = findViewById(R.id.editTextHospitalPassword);
        editTextHospitalLicense = findViewById(R.id.editTextHospitalLicense);

        // Retrieve the current registration count
        databaseReference.child("registrationCount").get().addOnSuccessListener(dataSnapshot -> {
            if (dataSnapshot.exists()) {
                registrationCount = dataSnapshot.getValue(Integer.class);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Gather data from form fields
                String hospitalName = editTextHospitalName.getText().toString();
                String hospitalAddress = editTextHospitalAddress.getText().toString();
                String hospitalEmail = editTextHospitalEmail.getText().toString();
                String hospitalPassword = editTextHospitalPassword.getText().toString();
                String hospitalPhone = editTextHospitalPhoneNumber.getText().toString();
                String hospitalLicense = editTextHospitalLicense.getText().toString();

                // Increment registration count and save it
                registrationCount++;
                databaseReference.child("registrationCount").setValue(registrationCount);

                // Generate the hospital key with the format "JR001," "JR002," etc.
                String hospitalKey = "JR" + String.format("%03d", registrationCount);

                // Create a Hospital object
                Hospital hospital = new Hospital(hospitalKey, hospitalName, hospitalAddress, hospitalEmail, hospitalPassword, hospitalPhone, hospitalLicense);

                // Store the hospital data in the database with the generated key
                databaseReference.child("hospitals").child(hospitalKey).setValue(hospital)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                // Data was successfully written
                                Toast.makeText(getApplicationContext(), "Registration successful", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Handle any errors that occurred
                                Toast.makeText(getApplicationContext(), "Registration failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
