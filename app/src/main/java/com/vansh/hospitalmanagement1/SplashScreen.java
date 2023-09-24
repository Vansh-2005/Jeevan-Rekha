package com.vansh.hospitalmanagement1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vansh.hospitalmanagement1.Admin_Panel.Dashboard.AdminDashboardActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Load the animation
        Animation splashAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_animation);

        // Apply the animation to the logo and app name
        ImageView imageViewLogo = findViewById(R.id.imageViewLogo);
        TextView textViewAppName = findViewById(R.id.textViewAppName);

        imageViewLogo.startAnimation(splashAnimation);
        textViewAppName.startAnimation(splashAnimation);

        // Set a delay and then determine the destination activity based on the user's role
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Check the user's role from SharedPreferences
                SharedPreferences preferences = getSharedPreferences("UserData", MODE_PRIVATE);
                String loggedInUser = preferences.getString("LoggedInUser", "");

                Intent intent = null;
                if (loggedInUser.equals("admin")) {
                    // User is logged in as admin, direct to AdminDashboardActivity
                    intent = new Intent(SplashScreen.this, AdminDashboardActivity.class);
                } else if (loggedInUser.equals("hospital")) {
                    // User is logged in as hospital, direct to HospitalDashboardActivity
//                    intent = new Intent(SplashScreen.this, HospitalDashboardActivity.class);
                    Toast.makeText(SplashScreen.this, "coming soon", Toast.LENGTH_SHORT).show();
                } else if (loggedInUser.equals("patient")) {
                    // User is logged in as patient, direct to PatientDashboardActivity
//                    intent = new Intent(SplashScreen.this, PatientDashboardActivity.class);
                    Toast.makeText(SplashScreen.this, "coming soon", Toast.LENGTH_SHORT).show();
                } else {
                    // User is new, direct to MainActivity
                    intent = new Intent(SplashScreen.this, MainActivity.class);
                }

                startActivity(intent);
                finish();
            }
        }, 2000); // Delay for 2 seconds

    }
}