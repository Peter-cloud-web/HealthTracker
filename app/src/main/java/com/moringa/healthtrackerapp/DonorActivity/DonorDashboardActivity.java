package com.moringa.healthtrackerapp.DonorActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.moringa.healthtrackerapp.MainActivity;
import com.moringa.healthtrackerapp.Maps.MapsActivity;
import com.moringa.healthtrackerapp.R;

public class DonorDashboardActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView donorProfile;
    ImageView donate;
    ImageView track;
    ImageView requests;
    ImageView notifications;
    ImageView donationHistory;
    ImageView settings;
    ImageView logout;
    Button maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_donor);

        donorProfile = findViewById(R.id.dashProfile);
        donate = findViewById(R.id.donate);
        track = findViewById(R.id.track);
        requests = findViewById(R.id.requests);
        notifications = findViewById(R.id.notification);
        donationHistory = findViewById(R.id.history);
        settings = findViewById(R.id.settings);
        logout = findViewById(R.id.logout);
        maps = findViewById(R.id.maps);

        maps.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
      if(v == maps){
          openMaps();
      }
    }
    public void openMaps(){
      Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
      startActivity(intent);
    }
}
