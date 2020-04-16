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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.moringa.healthtrackerapp.DonorActivity.DonorDashboardActivity;
import com.moringa.healthtrackerapp.DonorActivity.DonorLoginActivity;
import com.moringa.healthtrackerapp.DonorActivity.DonorRegisterActivity;
import com.moringa.healthtrackerapp.R;

public class HospitalRegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText signupEmail;
    EditText signupPassword;
    Button signupButton;
    TextView alreadyMember;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_hospital);

        signupEmail = findViewById(R.id.mailHospital);
        signupPassword = findViewById(R.id.passwordHospital);
        signupButton = findViewById(R.id.registerHospital);
        alreadyMember  = findViewById(R.id.AlreadyMember);

        auth=FirebaseAuth.getInstance();

        signupButton.setOnClickListener(this);
        alreadyMember.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == signupButton){
            saveInfo();
        }
        if(v == alreadyMember){
            openLogin();
        }
    }
    public void saveInfo(){
        String email = signupEmail.getText().toString();
        String pass =  signupPassword.getText().toString();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(),"Please enter your E-mail address",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(getApplicationContext(),"Please enter your Password",Toast.LENGTH_LONG).show();
        }
        if (pass.length() == 0){
            Toast.makeText(getApplicationContext(),"Please enter your Password",Toast.LENGTH_LONG).show();
        }
        if (pass.length()<8){
            Toast.makeText(getApplicationContext(),"Password must be more than 8 digit",Toast.LENGTH_LONG).show();
        }
        else{
            auth.createUserWithEmailAndPassword(email,pass)
                    .addOnCompleteListener(HospitalRegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(HospitalRegisterActivity.this,"Error,Check your network connection",Toast.LENGTH_LONG).show();
                            }
                            else{
                                startActivity(new Intent(HospitalRegisterActivity.this, HospitalDashboardActivity.class));
                                finish();
                            }
                        }
                    });
        }

    }
    public void openLogin(){
        startActivity(new Intent(HospitalRegisterActivity.this, HospitalLoginActivity.class));
    }
}


