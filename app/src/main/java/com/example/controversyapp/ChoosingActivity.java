package com.example.controversyapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ChoosingActivity extends AppCompatActivity {
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String CHOOSING_TEAM = "choosingTeam";
    public static final String OPPOSING_TEAM = "opposingTeam";
    public static final String OPPOSING_TEAM_NAMES = "opposingTeamNames";
    public static final String CHOOSING_TEAM_NAMES = "choosingTeamNames";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        Button mChooseRedButton = findViewById(R.id.chooseRedButton);
        Button mChooseBlueButton = findViewById(R.id.chooseBlueButton);

        mChooseRedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseRedTeam("redTeamNames", "blueTeamNames");
                Intent intent = new Intent(ChoosingActivity.this,
                        BeginRoundActivity.class);
                startActivity(intent);
            }
        });

        mChooseBlueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseBlueTeam("blueTeamNames", "redTeamNames");
                Intent intent = new Intent(ChoosingActivity.this,
                        BeginRoundActivity.class);
                startActivity(intent);
            }
        });
    }

    public void chooseBlueTeam(String choosingTeamNames,
                             String opposingTeamNames){
        SharedPreferences sharedPreferences =
                getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(CHOOSING_TEAM, "blueTeam");
        editor.putString(OPPOSING_TEAM, "redTeam");
        editor.putString(CHOOSING_TEAM_NAMES, choosingTeamNames);
        editor.putString(OPPOSING_TEAM_NAMES, opposingTeamNames);
        editor.apply();
    }

    public void chooseRedTeam(String choosingTeamNames, String opposingTeamNames){
        SharedPreferences sharedPreferences =
                getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(CHOOSING_TEAM, "redTeam");
        editor.putString(OPPOSING_TEAM, "blueTeam");
        editor.putString(CHOOSING_TEAM_NAMES, choosingTeamNames);
        editor.putString(OPPOSING_TEAM_NAMES, opposingTeamNames);
        editor.apply();
    }

}