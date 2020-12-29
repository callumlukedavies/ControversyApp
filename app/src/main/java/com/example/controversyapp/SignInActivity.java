package com.example.controversyapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import database.User;

public class SignInActivity extends AppCompatActivity {

    private Button mSigninButton;
    private UserViewModel mUserViewModel;
    private EditText editTextPassword;
    private EditText editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        mSigninButton = (Button) findViewById(R.id.log_in_button);
        mUserViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        mSigninButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                Log.d("SignInActivity", "email is : " + email);
                Log.d("SignInActivity", "password is : " + password);
                boolean val = validate(email);
                if(val) {
                    try {
                        User user = mUserViewModel.logIn(email, password);
                        if (user != null) {
                            Intent intent = new Intent(SignInActivity.this,
                                    CreatePartyActivity.class);

                            startActivity(intent);
                        } else {
                            Toast.makeText(SignInActivity.this, "unknown email or password", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(SignInActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(SignInActivity.this, "Invalid Email Address", Toast.LENGTH_LONG).show();
                }
            }

        });
    }

    public boolean validate(String email){

        if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return true;
        }else{
            return false;
        }
    }
}