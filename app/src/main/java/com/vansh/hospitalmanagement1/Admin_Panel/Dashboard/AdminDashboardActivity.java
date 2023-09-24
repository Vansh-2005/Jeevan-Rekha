package com.vansh.hospitalmanagement1.Admin_Panel.Dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.vansh.hospitalmanagement1.Admin_Panel.Authentication.AdminLoginActivity;
import com.vansh.hospitalmanagement1.Admin_Panel.Dashboard.Pending_Request.PendingRequestActivity;
import com.vansh.hospitalmanagement1.R;

public class AdminDashboardActivity extends AppCompatActivity {

    private CardView PendingRequest;
    private Button buttonLogout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        PendingRequest = findViewById(R.id.PendingRequest);

        buttonLogout = findViewById(R.id.buttonLogout);

        PendingRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminDashboardActivity.this, PendingRequestActivity.class);
                startActivity(i);
                finish();
            }
        });

        // Handle logout button click
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear the logged-in user data
                SharedPreferences preferences = getSharedPreferences("UserData", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.remove("LoggedInUser");
                editor.apply();

                // Navigate back to the login screen
                Intent intent = new Intent(AdminDashboardActivity.this, AdminLoginActivity.class);
                Toast.makeText(AdminDashboardActivity.this, "Logout Sucessfully", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish(); // Finish the admin dashboard activity
            }
        });
    }
}