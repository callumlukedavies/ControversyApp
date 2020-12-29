package com.example.controversyapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class ChooseTopicActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private final String SHARED_PREFS = "sharedPrefs";
    public static final String BLUE_POINTS = "bluePoints";
    public static final String RED_POINTS = "redPoints";
    public static final String CHOOSING_TEAM = "choosingTeam";
    public static final String OPPOSING_TEAM = "opposingTeam";
    public static final String OPPOSING_TEAM_NAMES = "opposingTeamNames";
    public static final String CHOOSING_TEAM_NAMES = "choosingTeamNames";
    public static final String CHOOSING_PLAYER = "choosingPlayer";
    public static final String ROUND = "round";
    public static final String CATEGORY = "category";
    public static final String KEYNO = "keyNo";
    public static final String CARD1POSITION = "card1Position";
    public static final String CARD2POSITION = "card2Position";
    public static final String CARD3POSITION = "card3Position";
    public static final String CARD1TITLE = "card1Title";
    public static final String CARD2TITLE = "card2Title";
    public static final String CARD3TITLE = "card3Title";
    public static final String CARD1DESC = "card1Desc";
    public static final String CARD2DESC = "card2Desc";
    public static final String CARD3DESC = "card3Desc";
    private String category = "politics";
    private String choosingPlayer;
    private String choosingTeam;
    private String opposingTeam;
    private String opposingTeamText;
    private String opposingTeamNames;
    private String choosingTeamNames;
    String title1;
    String desc1;
    String title2;
    String desc2;
    String title3;
    String desc3;
    String position1Text;
    String position2Text;
    String position3Text;
    private int keyNo;
    private int redPoints;
    private int bluePoints;
    private int round;
    private int card1Position;
    private int card2Position;
    private int card3Position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_topic);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //set up views
        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        loadData();
        createPositionText(card1Position, card2Position, card3Position);
        CardView cardView1 = findViewById(R.id.card1);
        CardView cardView2 = findViewById(R.id.card2);
        CardView cardView3 = findViewById(R.id.card3);
        TextView mCard1Desc = findViewById(R.id.card1Description);
        TextView mCard1Title = findViewById(R.id.card1Title);
        TextView mCard2Desc = findViewById(R.id.card2Description);
        TextView mCard2Title = findViewById(R.id.card2Title);
        TextView mCard3Desc = findViewById(R.id.card3Description);
        TextView mCard3Title = findViewById(R.id.card3Title);
        TextView mRoundTextView = findViewById(R.id.roundTextView);
        TextView  mChooseTextView = findViewById(R.id.chooseTextView);
        TextView mCard1Position = findViewById(R.id.card1Position);
        TextView mCard2Position = findViewById(R.id.card2Position);
        TextView mCard3Position = findViewById(R.id.card3Position);
        Button mSelectCardButton = findViewById(R.id.selectCardButton);
        mCard1Title.setText(title1);
        mCard1Desc.setText(desc1);
        mCard2Title.setText(title2);
        mCard2Desc.setText(desc2);
        mCard3Title.setText(title3);
        mCard3Desc.setText(desc3);
        mCard1Position.setText(position1Text);
        mCard2Position.setText(position2Text);
        mCard3Position.setText(position3Text);
        buildTeamText();
        mRoundTextView.setText("Round " + String.valueOf(round));
        String chooseText = buildTeamText();
        mChooseTextView.setText(chooseText);
//        setOnClickListeners();

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
                Log.d("DEBUG", String.valueOf(keyNo));
                Log.d("DEBUG", category);
                Intent intent = new Intent(ChooseTopicActivity.this,
                        DeclareOppositionPlayerActivity.class);
                startActivity(intent);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
                Log.d("DEBUG", String.valueOf(keyNo));
                Log.d("DEBUG", category);
                Intent intent = new Intent(ChooseTopicActivity.this,
                        DeclareOppositionPlayerActivity.class);
                startActivity(intent);
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
                Log.d("DEBUG", String.valueOf(keyNo));
                Log.d("DEBUG", category);
                Intent intent = new Intent(ChooseTopicActivity.this,
                        DeclareOppositionPlayerActivity.class);
                startActivity(intent);
            }
        });

        mSelectCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = createAlertDialog();
                alertDialog.show();
            }
        });
    }

    public void saveData(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(CATEGORY, category);
        editor.putInt(KEYNO, keyNo);
        editor.putInt(CARD1POSITION, card1Position);
        editor.putInt(CARD2POSITION, card2Position);
        editor.putInt(CARD3POSITION, card3Position);
        editor.apply();
    }

    public void loadData() {
        choosingTeam = sharedPreferences.getString(CHOOSING_TEAM, "");
        opposingTeam = sharedPreferences.getString(OPPOSING_TEAM, "");
        round = sharedPreferences.getInt(ROUND, 0);
        bluePoints = sharedPreferences.getInt(BLUE_POINTS, 0);
        redPoints = sharedPreferences.getInt(RED_POINTS, 0);
        choosingPlayer = sharedPreferences.getString(CHOOSING_PLAYER, "");
        title1 =sharedPreferences.getString(CARD1TITLE, "");
        desc1 = sharedPreferences.getString(CARD1DESC, "");
        title2 =sharedPreferences.getString(CARD2TITLE, "");
        desc2 =sharedPreferences.getString(CARD2DESC, "");
        title3 =sharedPreferences.getString(CARD3TITLE, "");
        desc3 =sharedPreferences.getString(CARD3DESC, "");
        card1Position = sharedPreferences.getInt(CARD1POSITION, 0);
        card2Position = sharedPreferences.getInt(CARD2POSITION, 0);
        card3Position = sharedPreferences.getInt(CARD3POSITION, 0);

    }

    public void saveForfeitRoundData(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        round++;
        if(choosingTeam.equals("redTeam")){
            redPoints++;
            choosingTeam = "blueTeam";
            opposingTeam = "redTeam";
            choosingTeamNames = "blueTeamNames";
            opposingTeamNames = "redTeamNames";

        }else if(choosingTeam.equals("blueTeam")){
            bluePoints++;
            choosingTeam = "redTeam";
            opposingTeam = "blueTeam";
            choosingTeamNames = "redTeamNames";
            opposingTeamNames = "blueTeamNames";
        }else{
            Log.d("SAVINGERROR", "There was an error saving forfeit data.");
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

    public String buildTeamText(){
        if(opposingTeam.equals("blueTeam")){
            opposingTeamText = " Blue Team";
        }else if (opposingTeam.equals("redTeam")){
            opposingTeamText = " Red Team";
        }else{
            opposingTeamText = "Team name not found";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(opposingTeamText);
        builder.append(getString(R.string.chooseTopicText2));
        String text = builder.toString();
        return text;
    }

    public AlertDialog createAlertDialog (){
        AlertDialog.Builder builder=
                new AlertDialog.Builder(ChooseTopicActivity.this);
        builder.setTitle("Forfeit");
        builder.setMessage("Click yes to forfeit the round.");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface,
                                int i) {

                if(round > 2){
                    saveForfeitRoundData();
                    Intent intent = new Intent(ChooseTopicActivity.this
                            , AnnounceWinnersActivity.class);
                    startActivity(intent);
                }else {
                    saveForfeitRoundData();
                    Intent intent = new Intent(ChooseTopicActivity.this,
                            BeginRoundActivity.class);
                    startActivity(intent);
                }
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface,
                                int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        return alertDialog;
    }

    public void createPositionText(int pos1, int pos2, int pos3){
        if(pos1 == 1){
            position1Text = "Your Position: Disagree";
        }else{
            position1Text = "Your Position: Agree";
        }

        if(pos2 == 1){
            position2Text = "Your Position: Disagree";
        }else{
            position2Text = "Your Position: Agree";
        }

        if(pos3 == 1){
            position3Text = "Your Position: Disagree";
        }else{
            position3Text = "Your Position: Agree";
        }
    }


}