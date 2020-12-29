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
import android.widget.Toast;

public class ViewChosenCardActivity extends AppCompatActivity {
//    objective: get string data that was chosen from previous page
    // can do this by sending intent extra as a the key for a category object

    private TextView mChosenCardTitle;
    private TextView mChosenCardDescBody;
    private TextView mChosenCardForBody;
    private TextView mChosenCardAgainstBody;
    private Button mContinueButton;
    private String category;
    private int keyNo;
    private String SHARED_PREFS = "sharedPrefs";
    public static final String CATEGORY = "category";
    public static final String KEYNO = "keyNo";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_chosen_card);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        mContinueButton = findViewById(R.id.continueButton);
        mChosenCardTitle = findViewById(R.id.chosenCardTitle);
        mChosenCardDescBody = findViewById(R.id.chosenCardDescBody);
        mChosenCardForBody = findViewById(R.id.chosenCardForBody);
        mChosenCardAgainstBody = findViewById(R.id.chosenCardAgainstBody);
        loadData();

        if(category.equals("science")){
            ScienceCard card = new ScienceCard(keyNo);
            mChosenCardDescBody.setText(card.getDesc());
            mChosenCardTitle.setText(card.getTitle());
            mChosenCardForBody.setText(card.getSupportString());
            mChosenCardAgainstBody.setText(card.getOppositionString());
        }else if(category.equals("politics")){
            PoliticsCard card = new PoliticsCard(keyNo);
            mChosenCardDescBody.setText(card.getDesc());
            mChosenCardTitle.setText(card.getTitle());
            mChosenCardForBody.setText(card.getSupportString());
            mChosenCardAgainstBody.setText(card.getOppositionString());
        }else if(category.equals("society")){
            SocietyCard card = new SocietyCard(keyNo);
            mChosenCardDescBody.setText(card.getDesc());
            mChosenCardTitle.setText(card.getTitle());
            mChosenCardForBody.setText(card.getSupportString());
            mChosenCardAgainstBody.setText(card.getOppositionString());
        }else if(category.equals("misc")){
            MiscCard card = new MiscCard(keyNo);
            mChosenCardDescBody.setText(card.getDesc());
            mChosenCardTitle.setText(card.getTitle());
        }else if(category.equals("history")){
            HistoryCard card = new HistoryCard(keyNo);
            mChosenCardDescBody.setText(card.getDesc());
            mChosenCardTitle.setText(card.getTitle());
        }else if(category.equals("religion")){
            ReligionCard card = new ReligionCard(keyNo);
            mChosenCardDescBody.setText(card.getDesc());
            mChosenCardTitle.setText(card.getTitle());
            mChosenCardForBody.setText(card.getSupportString());
            mChosenCardAgainstBody.setText(card.getOppositionString());
        }else{
            Log.d("DEBUG", "Error...");
        }

        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewChosenCardActivity.this,
                        DeclareOppositionPlayerActivity.class);
                startActivity(intent);
            }
        });


    }

    public void loadData(){
        SharedPreferences sharedPreferences =
                getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        category = sharedPreferences.getString(CATEGORY, "");
        keyNo = sharedPreferences.getInt(KEYNO, 0);
    }
}