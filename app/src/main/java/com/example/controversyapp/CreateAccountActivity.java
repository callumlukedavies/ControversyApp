package com.example.controversyapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import database.User;


public class CreateAccountActivity extends AppCompatActivity {
    private EditText mEditTextFirstName;
    private EditText mEditTextSecondName;
    private EditText mEditTextEmail;
    private EditText mEditTextPassword;
    private UserViewModel mUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        mEditTextFirstName = findViewById(R.id.editTextFirstName);
        mEditTextSecondName = findViewById(R.id.editTextSecondName);
        mEditTextEmail = findViewById(R.id.editTextEmail);
        mEditTextPassword = findViewById(R.id.editTextPassword);
        mUserViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        final Button button = findViewById(R.id.createAccountButton);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                boolean check = entryCheck();
                if(!check){
                    finish();
                }else{
                    String firstName = mEditTextFirstName.getText().toString();
                    String secondName = mEditTextSecondName.getText().toString();
                    String email = mEditTextEmail.getText().toString();
                    String password = mEditTextPassword.getText().toString();
                    User user = new User(firstName, secondName, email, password);
                    mUserViewModel.insert(user);
                    Intent intent = new Intent(CreateAccountActivity.this,
                            CreatePartyActivity.class);

                    startActivity(intent);

                }
            }
        });
    }

    public boolean entryCheck(){
        if(TextUtils.isEmpty(mEditTextFirstName.getText())){
            return false;
        }else if(TextUtils.isEmpty(mEditTextSecondName.getText())){
            return false;
        } else if(TextUtils.isEmpty(mEditTextEmail.getText())){
            return false;
        } else if(TextUtils.isEmpty(mEditTextPassword.getText())){
            return false;
        }else{
            return true;
        }
    }
}