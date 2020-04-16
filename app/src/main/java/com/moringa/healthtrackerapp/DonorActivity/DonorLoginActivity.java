package com.moringa.healthtrackerapp.DonorActivity;

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
import com.google.firebase.database.FirebaseDatabase;
import com.moringa.healthtrackerapp.R;

public class DonorLoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText email;
    EditText password;
    TextView forgotPassword;
    Button login;
    Button register;

    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_donor);

        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        email = findViewById(R.id.emails);
        password = findViewById(R.id.passwords);
        forgotPassword = findViewById(R.id.forgotpassword);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

        login.setOnClickListener(this);
        register.setOnClickListener(this);
        forgotPassword.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if(v==login){
            openDashboard();
        }
        if(v==register){
            openRegister();
        }
        if(v==register){
            openForgotPassword();
        }

    }

    public void openDashboard(){
        String mail = email.getText().toString();
        final String passcode = password.getText().toString();

        if(TextUtils.isEmpty(mail)){
            Toast.makeText(getApplicationContext(),"Please enter your email address",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(passcode)){
            Toast.makeText(getApplicationContext(),"Enter your password",Toast.LENGTH_SHORT).show();
            return;
        }
        auth.signInWithEmailAndPassword(mail,passcode)
                .addOnCompleteListener(DonorLoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Error, Wrong email or password", Toast.LENGTH_SHORT).show();
                        if (password.length() < 8) {
                            Toast.makeText(getApplicationContext(), "Password must be more than 8 didgit", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                        }
                        }else {
                            Intent intent = new Intent(DonorLoginActivity.this, DonorDashboardActivity.class);
                            startActivity(intent);
                            finish();

                        }

                    }
                });

    }
    private void openRegister() {
        Intent intent = new Intent(DonorLoginActivity.this, DonorRegisterActivity.class);
        Toast.makeText(DonorLoginActivity.this,"Welcome to the registry panel " ,Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
    private void openForgotPassword() {
        Intent intent = new Intent(DonorLoginActivity.this, DonorRegisterActivity.class);
        Toast.makeText(DonorLoginActivity.this,"Welcome to the registry panel " ,Toast.LENGTH_LONG).show();
        startActivity(intent);
    }



}

