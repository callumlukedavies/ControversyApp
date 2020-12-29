package com.example.controversyapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ScienceActivity extends AppCompatActivity {
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
    private String category = "science";
    private String choosingPlayer;
    private String choosingTeam;
    private String opposingTeam;
    private String opposingTeamText;
    private String opposingTeamNames;
    private String choosingTeamNames;
    private String title1;
    private String desc1;
    private String title2;
    private String desc2;
    private String title3;
    private String desc3;
    private int keyNo;
    private int redPoints;
    private int bluePoints;
    private int round;
    Button mContinueButton;
    Button mCard1AgreeButton;
    Button mCard1DisagreeButton;
    Button mCard2AgreeButton;
    Button mCard2DisagreeButton;
    Button mCard3AgreeButton;
    Button mCard3DisagreeButton;
    private int card1Position;
    private int card2Position;
    private int card3Position;
    private boolean card1Clicked;
    private boolean card2Clicked;
    private boolean card3Clicked;
    private boolean mContinueButtonNotClickable;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setCardsFalse();
        mContinueButtonNotClickable = true;

        //create three random numbers in the range 0-9
        Random randomObj = new Random();
        final int finalRand1 = randomObj.nextInt(18);
        int rand2 = randomObj.nextInt(18);
        while(rand2 == finalRand1){
            rand2 = randomObj.nextInt(18);
        }
        int rand3 = randomObj.nextInt(18);
        while(rand3 == rand2 || rand3 == finalRand1){
            rand3 = randomObj.nextInt(18);
        }
        final int finalRand2 = rand2;
        final int finalRand3 = rand3;

        //set up views
        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
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
        mContinueButton = findViewById(R.id.selectCardButton);
        mCard1AgreeButton = findViewById(R.id.card1AgreeButton);
        mCard1DisagreeButton = findViewById(R.id.card1DisagreeButton);
        mCard2AgreeButton = findViewById(R.id.card2AgreeButton);
        mCard2DisagreeButton = findViewById(R.id.card2DisagreeButton);
        mCard3AgreeButton = findViewById(R.id.card3AgreeButton);
        mCard3DisagreeButton = findViewById(R.id.card3DisagreeButton);
        ScienceCard card1 = new ScienceCard(finalRand1);
        ScienceCard card2 = new ScienceCard(finalRand2);
        ScienceCard card3 = new ScienceCard(finalRand3);
        title1 = card1.getTitle();
        desc1 = card1.getSupportString();
        title2 = card2.getTitle();
        desc2 = card2.getSupportString();
        title3 = card3.getTitle();
        desc3 = card3.getSupportString();
        mCard1Title.setText(title1);
        mCard1Desc.setText(desc1);
        mCard2Title.setText(title2);
        mCard2Desc.setText(desc2);
        mCard3Title.setText(title3);
        mCard3Desc.setText(desc3);
        loadData();
        buildTeamText();
        mRoundTextView.setText("Round " + String.valueOf(round));
        String chooseText = buildTeamText();
        mChooseTextView.setText(chooseText);
        setOnClickListeners();

        //set on key listeners

        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mContinueButtonNotClickable){
                    Toast.makeText(ScienceActivity.this, "Please choose a " +
                                    "position on each topic",
                            Toast.LENGTH_SHORT).show();
                }else{
                    saveData();
                    Intent intent = new Intent(ScienceActivity.this,
                            ChooseTopicActivity.class);
                    startActivity(intent);
                }
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
        editor.putString(CARD1TITLE, title1);
        editor.putString(CARD2TITLE, title2);
        editor.putString(CARD3TITLE, title3);
        editor.putString(CARD1DESC, desc1);
        editor.putString(CARD2DESC, desc2);
        editor.putString(CARD3DESC, desc3);
        editor.apply();
    }

    public void loadData() {
        choosingTeam = sharedPreferences.getString(CHOOSING_TEAM, "");
        opposingTeam = sharedPreferences.getString(OPPOSING_TEAM, "");
        round = sharedPreferences.getInt(ROUND, 0);
        bluePoints = sharedPreferences.getInt(BLUE_POINTS, 0);
        redPoints = sharedPreferences.getInt(RED_POINTS, 0);
        choosingPlayer = sharedPreferences.getString(CHOOSING_PLAYER, "");
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
        builder.append(choosingPlayer);
        builder.append(getString(R.string.chooseTopicText1));
//        builder.append(opposingTeamText);
//        builder.append(getString(R.string.chooseTopicText2));
        String text = builder.toString();
        return text;
    }

    public void setCardsFalse(){
        card1Clicked = false;
        card2Clicked = false;
        card3Clicked = false;
    }

    public void setmContinueButton(){
        mContinueButton.setBackgroundResource(R.drawable.rounded_button);
        mContinueButton.setTextColor(Color.parseColor("#ffffff"));
        mContinueButtonNotClickable = false;

    }


    public void setOnClickListeners(){
        mCard1AgreeButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 mCard1AgreeButton.setBackgroundResource(R.drawable.button_clicked_science);
                 mCard1DisagreeButton.setBackgroundResource(R.drawable.button_unclicked_science);
                 card1Position = 1;
                 card1Clicked = true;
                 if(card2Clicked && card3Clicked){
                     setmContinueButton();
                 }
             }
         });

        mCard1DisagreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCard1AgreeButton.setBackgroundResource(R.drawable.button_unclicked_science);
                mCard1DisagreeButton.setBackgroundResource(R.drawable.button_clicked_science);
                card1Position = 0;
                card1Clicked = true;
                if(card2Clicked && card3Clicked){
                    setmContinueButton();
                }
            }
        });

        mCard2AgreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCard2AgreeButton.setBackgroundResource(R.drawable.button_clicked_science);
                mCard2DisagreeButton.setBackgroundResource(R.drawable.button_unclicked_science);
                card2Position = 1;
                card2Clicked = true;
                if(card1Clicked && card3Clicked){
                    setmContinueButton();
                }

            }
        });

        mCard2DisagreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCard2AgreeButton.setBackgroundResource(R.drawable.button_unclicked_science);
                mCard2DisagreeButton.setBackgroundResource(R.drawable.button_clicked_science);
                card2Position = 0;
                card2Clicked = true;
                if(card1Clicked && card3Clicked){
                    setmContinueButton();
                }
            }
        });

        mCard3AgreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCard3AgreeButton.setBackgroundResource(R.drawable.button_clicked_science);
                mCard3DisagreeButton.setBackgroundResource(R.drawable.button_unclicked_science);
                card3Position = 1;
                card3Clicked = true;
                if(card1Clicked && card2Clicked){
                    setmContinueButton();
                }
            }
        });

        mCard3DisagreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCard3AgreeButton.setBackgroundResource(R.drawable.button_unclicked_science);
                mCard3DisagreeButton.setBackgroundResource(R.drawable.button_clicked_science);
                card3Position = 0;
                card3Clicked = true;
                if(card1Clicked && card2Clicked){
                    setmContinueButton();
                }

            }
        });
    }
}