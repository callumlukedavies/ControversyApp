package com.example.controversyapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    public Button mPlayButton;
    public Button mOnboardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        mPlayButton = findViewById(R.id.playButton);
        mOnboardButton = findViewById(R.id.onboardingButton);
        mPlayButton.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,
                        NameEntryActivity.class);
                startActivity(intent);
            }
        });

        mOnboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,
                        OnboardingActivity.class);
                startActivity(intent);
            }
        });
    }
}