package com.moringa.healthtrackerapp.HospitalActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.moringa.healthtrackerapp.DonorActivity.DonorRegisterActivity;
import com.moringa.healthtrackerapp.DonorActivity.DonorResetPassword;
import com.moringa.healthtrackerapp.R;

public class HospitalResetActivity extends AppCompatActivity implements View.OnClickListener {

    EditText inputEmail;
    Button btnReset;
    TextView signUp;

    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword_donor);
        inputEmail = findViewById(R.id.resethospitalemail);
        btnReset =  findViewById(R.id.hospitalreset);
        signUp = findViewById(R.id.hospitalsignup);

        auth = FirebaseAuth.getInstance();

        btnReset.setOnClickListener(this);
        signUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnReset){
            resetPassword();
        }
        if(v == signUp){
            openRegister();

        }
    }
    public void resetPassword(){
        String email = inputEmail.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(getApplication(),"Enter your email address",Toast.LENGTH_LONG).show();
            return;
        }
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(HospitalResetActivity.this,"We sent you an email we the password",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(HospitalResetActivity.this,"Error, Can't reset password.Try again later",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    public void openRegister(){
        Intent intent = new Intent(this, HospitalRegisterActivity.class);
        startActivity(intent);
    }
}

