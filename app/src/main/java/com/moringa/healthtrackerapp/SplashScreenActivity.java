package com.moringa.healthtrackerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.moringa.healthtrackerapp.DonorActivity.DonorLoginActivity;
import com.moringa.healthtrackerapp.HospitalActivity.HospitalLoginActivity;

public class SplashScreenActivity extends AppCompatActivity implements View.OnClickListener{
    Button loginAsDonor;
    Button loginAsHospital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        loginAsDonor = findViewById(R.id.loginasdonor);
        loginAsHospital = findViewById(R.id.loginashospital);

        loginAsDonor.setOnClickListener(this);
        loginAsHospital.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == loginAsDonor){
            openDonorLogin();
        }
        if(v == loginAsHospital){
            openHospitalLogin();
        }
    }

    public void openDonorLogin(){
        Intent intent = new Intent(this, DonorLoginActivity.class);
        startActivity(intent);
    }

    public void openHospitalLogin(){
        Intent intent = new Intent(this, HospitalLoginActivity.class);
        startActivity(intent);
    }
}
