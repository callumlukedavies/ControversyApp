package com.example.controversyapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ChooseCategoryActivity extends AppCompatActivity {
    private ImageButton mHistoryButton;
    private ImageButton mScienceButton;
    private ImageButton mPoliticsButton;
    private ImageButton mReligionButton;
    private ImageButton mSocietyButton;
    private ImageButton mMiscButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        mHistoryButton = (ImageButton) findViewById(R.id.historyButton);
        mScienceButton = (ImageButton) findViewById(R.id.scienceButton);
        mPoliticsButton = (ImageButton) findViewById(R.id.politicsButton);
        mReligionButton = (ImageButton) findViewById(R.id.religionButton);
        mSocietyButton = (ImageButton) findViewById(R.id.societyButton);
        mMiscButton = (ImageButton) findViewById(R.id.miscButton);
        mHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseCategoryActivity.this,
                        HistoryActivity.class);
                startActivity(intent);
            }
        });
        mScienceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseCategoryActivity.this,
                        ScienceActivity.class);
                startActivity(intent);
            }
        });
        mPoliticsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseCategoryActivity.this,
                        PoliticsActivity.class);
                startActivity(intent);
            }
        });
        mReligionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseCategoryActivity.this,
                        ReligionActivity.class);
                startActivity(intent);
            }
        });
        mSocietyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseCategoryActivity.this,
                        SocietyActivity.class);
                startActivity(intent);
            }
        });
        mMiscButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseCategoryActivity.this,
                        MiscActivity.class);
                startActivity(intent);
            }
        });
    }
}