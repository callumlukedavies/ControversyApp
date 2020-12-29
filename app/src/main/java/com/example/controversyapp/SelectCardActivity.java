package com.example.controversyapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class SelectCardActivity extends AppCompatActivity {
    private TextView mcard1Title;
    private TextView mcard1Desc;
    private TextView mcard2Title;
    private TextView mcard2Desc;
    private TextView mcard3Title;
    private TextView mcard3Desc;
    private ScienceCard card1;
    private ScienceCard card2;
    private ScienceCard card3;
    private Random randomObj;
    private Button mSelectCardButton;
    private TextView mRoundTextView;
    private SharedPreferences sharedPreferences;
    private final String SHARED_PREFS = "sharedPrefs";
    public static final String ROUND = "round";
    private int round;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_card);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        randomObj = new Random();
        int rand1 = randomObj.nextInt(10);
        int rand2 = randomObj.nextInt(10);
        while(rand2 == rand1){
            rand2 = randomObj.nextInt(10);
        }
        int rand3 = randomObj.nextInt(10);
        while(rand3 == rand2 || rand3 == rand1){
            rand3 = randomObj.nextInt(10);
        }
        Log.d("LOG", "value - " + rand1);
        Log.d("LOG", "value2 - " + rand2);
        Log.d("LOG", "value3 - " + rand3);
        mcard1Desc = findViewById(R.id.card1Description);
        mcard1Title = findViewById(R.id.card1Title);
        mcard2Desc = findViewById(R.id.card2Description);
        mcard2Title = findViewById(R.id.card2Title);
        mcard3Desc = findViewById(R.id.card3Description);
        mcard3Title = findViewById(R.id.card3Title);
        mRoundTextView = findViewById(R.id.roundTextView);
        card1 = new ScienceCard(rand1);
        card2 = new ScienceCard(rand2);
        card3 = new ScienceCard(rand3);
        String title1 = card1.getTitle();
        String desc1 = card1.getDesc();
        String title2 = card2.getTitle();
        String desc2 = card2.getDesc();
        String title3 = card3.getTitle();
        String desc3 = card3.getDesc();
        mcard1Title.setText(title1);
        mcard1Desc.setText(desc1);
        mcard2Title.setText(title2);
        mcard2Desc.setText(desc2);
        mcard3Title.setText(title3);
        mcard3Desc.setText(desc3);
        round = sharedPreferences.getInt(ROUND, 0);
        mRoundTextView.setText("Round " + String.valueOf(round));



        mSelectCardButton = findViewById(R.id.selectCardButton);
        mSelectCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectCardActivity.this,
                        ArgumentActivity.class);
                startActivity(intent);
            }
        });
    }

}