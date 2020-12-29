package com.example.controversyapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

public class DisplayTeamsActivity extends AppCompatActivity {
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String  RED_TEAM = "redTeamNames";
    public static final String  BLUE_TEAM = "blueTeamNames";
    public static final String  SPECTATORS = "spectatorNames";
    private Set<String> redTeamNames;
    private Set<String> blueTeamNames;
    private Set<String> spectatorNames;
    private TextView mRedNamesTextView;
    private TextView mBlueNamesTextView;
    private TextView mSpecNamesTextView;
    private Button mContinueButton;
    private String redTeamNamesText;
    private String blueTeamNamesText;
    private String spectatorNamesText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_teams);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        mRedNamesTextView = findViewById(R.id.redNamesTextView);
        mBlueNamesTextView = findViewById(R.id.blueNamesTextView);
        mSpecNamesTextView = findViewById(R.id.specNamesTextView);
        mContinueButton = findViewById(R.id.continueButton);
        loadData();
        redTeamNamesText = buildString(redTeamNames);
        mRedNamesTextView.setText(redTeamNamesText);
        blueTeamNamesText = buildString(blueTeamNames);
        mBlueNamesTextView.setText(blueTeamNamesText);
        spectatorNamesText = buildString(spectatorNames);
        mSpecNamesTextView.setText(spectatorNamesText);

        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DisplayTeamsActivity.this,
                        ChoosingActivity.class);
                startActivity(intent);
            }
        });
    }

    public void loadData(){
        //LOAD TEAM DATA FROM SHAREDPREFS
        SharedPreferences sharedPreferences =
                getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        redTeamNames = sharedPreferences.getStringSet(RED_TEAM,
                new HashSet<String>());
        blueTeamNames = sharedPreferences.getStringSet(BLUE_TEAM,
                new HashSet<String>());
        spectatorNames = sharedPreferences.getStringSet(SPECTATORS,
                new HashSet<String>());
    }

    public String buildString(Set set){
        //TAKE A SET AND TURN IT INTO A STRING
        StringBuilder builder = new StringBuilder();
        String[] names = new String[set.size()];
        String temp;
        set.toArray(names);
        for(int i = 0; i < names.length; i++){
            builder.append(names[i] + "\n");
        }
        temp = builder.toString();
        return temp;
    }
}