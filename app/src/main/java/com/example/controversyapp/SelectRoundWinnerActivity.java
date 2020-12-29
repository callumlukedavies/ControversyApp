package com.example.controversyapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.HashSet;

public class SelectRoundWinnerActivity extends AppCompatActivity {
    private ImageButton mVoteRedButton;
    private ImageButton mVoteBlueButton;
    private int round = 1;
    private int redPoints;
    private int bluePoints;
    private String choosingTeam;
    private String opposingTeam;
    private String opposingTeamNames;
    private String choosingTeamNames;
    private SharedPreferences sharedPreferences;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String ROUND = "round";
    public static final String BLUE_POINTS = "bluePoints";
    public static final String RED_POINTS = "redPoints";
    public static final String CHOOSING_TEAM = "choosingTeam";
    public static final String OPPOSING_TEAM = "opposingTeam";
    public static final String OPPOSING_TEAM_NAMES = "opposingTeamNames";
    public static final String CHOOSING_TEAM_NAMES = "choosingTeamNames";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_round_winner);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        sharedPreferences =
                getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        mVoteBlueButton = findViewById(R.id.voteBlueButton);
        mVoteRedButton = findViewById(R.id.voteRedButton);
        loadData();
        setOnClickListeners();
    }

    public void loadData(){
        choosingTeam = sharedPreferences.getString(CHOOSING_TEAM, "");
        round = sharedPreferences.getInt(ROUND, 0);
        bluePoints = sharedPreferences.getInt(BLUE_POINTS, 0);
        redPoints = sharedPreferences.getInt(RED_POINTS, 0);
    }

    public void saveData(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(choosingTeam.equals("redTeam")){
            choosingTeam = "blueTeam";
            opposingTeam = "redTeam";
            choosingTeamNames = "blueTeamNames";
            opposingTeamNames = "redTeamNames";

        }else if(choosingTeam.equals("blueTeam")){
            choosingTeam = "redTeam";
            opposingTeam = "blueTeam";
            choosingTeamNames = "redTeamNames";
            opposingTeamNames = "blueTeamNames";
        }else{
            Log.d("SAVINGERROR", "There was an error saving round winner data" +
                    ".");
        }
        editor.putString(CHOOSING_TEAM, choosingTeam);
        editor.putString(OPPOSING_TEAM, opposingTeam);
        editor.putString(CHOOSING_TEAM_NAMES, choosingTeamNames);
        editor.putString(OPPOSING_TEAM_NAMES, opposingTeamNames);
        editor.putInt(ROUND, round);
        editor.putInt(BLUE_POINTS, bluePoints);
        editor.putInt(RED_POINTS, redPoints);
        editor.apply();

    }

    public void setOnClickListeners(){
        mVoteRedButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                redPoints++;
                if(round > 2){
                    saveData();
                    Intent intent = new Intent(SelectRoundWinnerActivity.this
                            , AnnounceWinnersActivity.class);
                    startActivity(intent);
                }else {
                    round++;
                    saveData();
                    Intent intent = new Intent(SelectRoundWinnerActivity.this,
                            BeginRoundActivity.class);
                    startActivity(intent);
                }

            }
        });

        mVoteBlueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                bluePoints++;
                if(round > 2){
                    saveData();
                    Log.d("Message", "round = " + round);
                    Intent intent = new Intent(SelectRoundWinnerActivity.this
                            , AnnounceWinnersActivity.class);
                    startActivity(intent);
                }else {
                    Log.d("Message", "round = " + round);
                    round++;
                    saveData();
                    Intent intent = new Intent(SelectRoundWinnerActivity.this,
                            BeginRoundActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}