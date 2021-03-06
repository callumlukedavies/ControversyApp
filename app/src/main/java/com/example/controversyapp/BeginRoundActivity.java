package com.example.controversyapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BeginRoundActivity extends AppCompatActivity {
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String CHOOSING_TEAM_NAMES = "choosingTeamNames";
    public static final String OPPOSING_TEAM_NAMES = "opposingTeamNames";
    public static final String CHOOSING_PLAYER = "choosingPlayer";
    public static final String CHOOSING_TEAM = "choosingTeam";
    public static final String ROUND = "round";
    private boolean buttonClicked = false;
    private Set<String> opposingTeamNames;
    private Set<String> choosingTeamNames;
    private String choosingPlayer;
    private String choosingTeam;
    private String choosingTeamKey;
    private String opposingTeamKey;
    private ArrayList<String> teamNames;
    private int round;
    private LinearLayout linLayout;
    private TextView titleTextView;
    private TextView scrollTitle;
    private TextView mDescTextView;
    private String teamColor;
    private String teamText;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_round);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        loadData();
        linLayout = findViewById(R.id.linLayout);
        setToArrayList(choosingTeamNames);
        createButtons(teamNames);
        buildTeamAttributes();
        Button confirmButton = findViewById(R.id.confirmButton);
        mDescTextView = findViewById(R.id.descTextView);
        String text =
                teamText + " " + getString(R.string.beginRoundActivityDesc);
        mDescTextView.setText(text);
        titleTextView = findViewById(R.id.titleTextView);
        titleTextView.setText("Round " + round);
        scrollTitle = findViewById(R.id.scrollTitle);
        scrollTitle.setText(teamText);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttonClicked){
                    saveData();
                    Intent intent = new Intent(BeginRoundActivity.this,
                            AltCategoriesActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(BeginRoundActivity.this, "Select a player " +
                                    "to continue",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public void loadData(){
        //LOAD TEAM DATA FROM SHAREDPREFS
        SharedPreferences sharedPreferences =
                getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        round = sharedPreferences.getInt(ROUND, 1);
        choosingTeam = sharedPreferences.getString(CHOOSING_TEAM, "");
        choosingTeamKey = sharedPreferences.getString(CHOOSING_TEAM_NAMES, "");
        opposingTeamKey = sharedPreferences.getString(OPPOSING_TEAM_NAMES, "");
        opposingTeamNames = sharedPreferences.getStringSet(opposingTeamKey,
                    new HashSet<String>());
        choosingTeamNames = sharedPreferences.getStringSet(choosingTeamKey,
                    new HashSet<String>());
    }

    public void saveData(){
        SharedPreferences sharedPreferences =
                getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(CHOOSING_PLAYER, choosingPlayer);
        editor.apply();
    }

    public void setToArrayList(Set set){
        teamNames = new ArrayList<>(set);
    }

    public void createButtons(ArrayList list){
        final int listLength = list.size();
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(10, 10, 10, 10);
        for(int i = 0; i < listLength; i++){
            String name = String.valueOf(list.get(i));
            final Button button = new Button(this);
            button.setText(name);
            button.setId(i);
            button.setBackgroundColor(Color.parseColor("#8C71C6"));
            button.setTextColor(Color.parseColor("#FFFFFF"));
            button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
            button.setAllCaps(false);


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    buttonClicked = true;
                    choosingPlayer = String.valueOf(button.getText());
                    for(int i = 0; i < listLength; i++){
                        Button but = findViewById(i);
                        but.setBackgroundColor(Color.parseColor("#8C71C6"));
                    }
                    button.setBackgroundColor(Color.parseColor(teamColor));
                }
            });

            linLayout.addView(button, params);
        }
    }

    public void buildTeamAttributes(){
        if(choosingTeam.equals("blueTeam")){
            teamText = "Blue Team";
            teamColor = "#7692FF";
        }else if (choosingTeam.equals("redTeam")){
            teamText = "Red Team";
            teamColor = "#EE6352";
        }else{
            Log.d("ERROR", "buildTeamAttributes(): There was an error");
        }
    }






}