package com.vansh.hospitalmanagement1.Admin_Panel.Authentication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.vansh.hospitalmanagement1.Admin_Panel.Dashboard.AdminDashboardActivity;
import com.vansh.hospitalmanagement1.R;

public class AdminLoginActivity extends AppCompatActivity {

    private static final String ADMIN_USERNAME = "jeevanrekha@admin.com";
    private static final String ADMIN_PASSWORD = "admin@123";

    private Button buttonlogin;
    private EditText editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if the admin is already logged in
        SharedPreferences preferences = getSharedPreferences("UserData", MODE_PRIVATE);
        String loggedInUser = preferences.getString("LoggedInUser", "");

        if ("admin".equals(loggedInUser)) {
            // Admin is already logged in, navigate to the admin dashboard
            Intent intent = new Intent(AdminLoginActivity.this, AdminDashboardActivity.class);
            startActivity(intent);
            finish(); // Finish this login activity
        } else {
            // Admin is not logged in, show the login screen
            setContentView(R.layout.activity_admin_login);

            buttonlogin = findViewById(R.id.buttonLogin);
            editTextPassword = findViewById(R.id.editTextPassword);
            editTextEmail = findViewById(R.id.editTextEmail);

            buttonlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = editTextEmail.getText().toString();
                    String password = editTextPassword.getText().toString();

                    // Check if the entered credentials match the predefined admin credentials
                    if (email.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                        // Admin login successful

                        // Save the logged-in user as "admin" using SharedPreferences
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("LoggedInUser", "admin");
                        editor.apply();

                        // Navigate to the admin dashboard or other relevant screen
                        Intent intent = new Intent(AdminLoginActivity.this, AdminDashboardActivity.class);
                        Toast.makeText(AdminLoginActivity.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish(); // Finish this login activity
                    } else {
                        // Admin login failed
                        // Display an error message
                        Toast.makeText(AdminLoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
