package com.moringa.healthtrackerapp.DonorActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.moringa.healthtrackerapp.Models.Register;
import com.moringa.healthtrackerapp.Network.APIService;
import com.moringa.healthtrackerapp.Network.APIUtils;
import com.moringa.healthtrackerapp.Network.RetrofitClient;
import com.moringa.healthtrackerapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DonorRegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = DonorRegisterActivity.class.getSimpleName();

    EditText fName;
    EditText lName;
    EditText userName;
    EditText email;
    EditText password;
    EditText confirmPassword;
    EditText contact;
    EditText address;
    EditText role;
    Button  signupButton;
    TextView alreadyMember;
    TextView mResponse;

    private APIService mAPIService;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_donor);


        signupButton = findViewById(R.id.registerUser);
        alreadyMember  = findViewById(R.id.AlreadyMember);

        fName = findViewById(R.id.fName);
        lName = findViewById(R.id.lName);
        userName = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        contact = findViewById(R.id.contact);
        address = findViewById(R.id.address);
        role = findViewById(R.id.role);
        mResponse = findViewById(R.id.response);


        alreadyMember.setOnClickListener(this);


        mAPIService = APIUtils.getAPIService();

        signupButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                    String firstName = fName.getText().toString().trim();
                    String lastName =  lName.getText().toString().trim();
                    String username = userName.getText().toString().trim();
                    String mAddress = address.getText().toString().trim();
                    String mEmail = email.getText().toString().trim();
                    String mPassword =  password.getText().toString().trim();
                    String mConfirmPassword = confirmPassword.getText().toString().trim();
                    String mContact =  contact.getText().toString().trim();
                    String mRole =  role.getText().toString().trim();



                    if(TextUtils.isEmpty(firstName)){
                        Toast.makeText(getApplicationContext(),"Please enter your first name",Toast.LENGTH_LONG).show();

                    }
                    if(TextUtils.isEmpty(lastName)){
                        Toast.makeText(getApplicationContext(),"Please enter your last Name",Toast.LENGTH_LONG).show();

                    }
                    if(TextUtils.isEmpty(mAddress)){
                        Toast.makeText(getApplicationContext(),"Please enter your Address",Toast.LENGTH_LONG).show();

                    }
                    if(TextUtils.isEmpty(username)){
                        Toast.makeText(getApplicationContext(),"Please enter your userName",Toast.LENGTH_LONG).show();

                    }
                    if(TextUtils.isEmpty(mEmail)){
                        Toast.makeText(getApplicationContext(),"Please enter your Email",Toast.LENGTH_LONG).show();

                    }
                    if(TextUtils.isEmpty(mContact)){
                        Toast.makeText(getApplicationContext(),"Please enter your Contact",Toast.LENGTH_LONG).show();
                        return;
                    }
                    if (mPassword.length() == 0){
                        Toast.makeText(getApplicationContext(),"Please enter your Password",Toast.LENGTH_LONG).show();

                    }
                    if (mConfirmPassword.length()<8){
                        Toast.makeText(getApplicationContext(),"Password confirm your password",Toast.LENGTH_LONG).show();

                    }else{
                        SignIn(firstName,lastName, mAddress, username,mEmail,mContact,mRole,mPassword,mConfirmPassword);

                    }
                }
        });
    }
    public void SignIn(String firstName,String lastName,String mAddress,String username,String mEmail,String mContact,String mRole,String mPassword,String mConfirmPassword){


        mAPIService.save(firstName,lastName, mAddress, username,mEmail,mContact,mRole,mPassword,mConfirmPassword).enqueue(new Callback<Register>() {


            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {


                if(response.isSuccessful()){

                    Toast.makeText(DonorRegisterActivity.this,"registered",Toast.LENGTH_LONG).show();

                    showResponse(response.body().toString());

                    Log.i(TAG, "Your information has been submitted to API." + response.body().toString());

                    startActivity(new Intent(DonorRegisterActivity.this,DonorDashboardActivity.class));;
                }
            }
            @Override
            public void onFailure(Call<Register> call, Throwable t) {
                Toast.makeText(DonorRegisterActivity.this,"error",Toast.LENGTH_LONG).show();

                Log.e(TAG, "Unable to submit post to API.");
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v == alreadyMember){
            openLogin();
        }
    }


    public void openLogin(){
        startActivity(new Intent(DonorRegisterActivity.this,DonorLoginActivity.class));
    }

    public void showResponse(String response) {
        if(mResponse.getVisibility() == View.GONE) {
            mResponse.setVisibility(View.VISIBLE);error fixi
        }
        mResponse.setText(response);
  }
}
