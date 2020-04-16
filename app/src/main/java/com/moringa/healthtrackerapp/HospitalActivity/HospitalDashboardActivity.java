package com.moringa.healthtrackerapp.HospitalActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.moringa.healthtrackerapp.R;

public class HospitalDashboardActivity extends AppCompatActivity {

    ImageView hospitalProfile;
    ImageView donationHistory;
    ImageView requestDonation;
    ImageView newDonation;
    ImageView notifications;
    ImageView help;
    ImageView settings;
    ImageView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_hospital);

        hospitalProfile = findViewById(R.id.dashHospitalProfile);
        donationHistory = findViewById(R.id.donationhistory);
        requestDonation = findViewById(R.id.requestDonation);
        newDonation = findViewById(R.id.newdonation);
        notifications = findViewById(R.id.notifications);
        help = findViewById(R.id.help);
        settings = findViewById(R.id.settings);
        logout = findViewById(R.id.logout);
    }
}
