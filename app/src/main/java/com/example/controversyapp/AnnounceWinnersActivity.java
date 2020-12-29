package com.example.controversyapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AnnounceWinnersActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String ROUND = "round";
    public static final String BLUE_POINTS = "bluePoints";
    public static final String RED_POINTS = "redPoints";
    private int redPoints;
    private int bluePoints;
    private TextView mBluePointsTextView;
    private TextView mRedPointsTextView;
    private TextView mWinnersTextView;
    private ImageView mWinnersImageView;
    private Button mEndButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announce_winners);
        ActionBar bar = getSupportActionBar();
        mBluePointsTextView = findViewById(R.id.bluePointsTextView);
        mRedPointsTextView = findViewById(R.id.redPointsTextView);
        mEndButton = findViewById(R.id.endButton);
        mWinnersImageView = findViewById(R.id.winnersImageView);
        mWinnersTextView = findViewById(R.id.winnersTextView);

        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        bar.hide();
        loadData();

        if(bluePoints > redPoints){
            mWinnersImageView.setImageResource(R.drawable.ic_game_winners_blue);
            mWinnersTextView.setText("Blue Team Wins!");
        }else{
            mWinnersImageView.setImageResource(R.drawable.ic_game_winners_red);
            mWinnersTextView.setText("Red Team Wins!");

        }


        mBluePointsTextView.setText(String.valueOf(bluePoints));
        mRedPointsTextView.setText(String.valueOf(redPoints));

        mEndButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnnounceWinnersActivity.this,
                        HomeActivity.class);
                startActivity(intent);
            }
        });

    }

    public void loadData(){
        bluePoints = sharedPreferences.getInt(BLUE_POINTS, 0);
        redPoints = sharedPreferences.getInt(RED_POINTS, 0);
    }
}