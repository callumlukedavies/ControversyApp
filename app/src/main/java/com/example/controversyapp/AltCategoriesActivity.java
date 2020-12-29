package com.example.controversyapp;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AltCategoriesActivity extends AppCompatActivity {
    private CardView mHistoryButton;
    private CardView mScienceButton;
    private CardView mPoliticsButton;
    private CardView mReligionButton;
    private CardView mSocietyButton;
    private CardView mMiscButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.altcategories);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        mHistoryButton = findViewById(R.id.historyButton);
        mScienceButton = findViewById(R.id.scienceButton);
        mPoliticsButton = findViewById(R.id.politicsButton);
        mReligionButton = findViewById(R.id.religionButton);
        mSocietyButton = findViewById(R.id.societyButton);
        mMiscButton = findViewById(R.id.miscButton);
        mHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AltCategoriesActivity.this,
                        HistoryActivity.class);
                startActivity(intent);
            }
        });
        mScienceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AltCategoriesActivity.this,
                        ScienceActivity.class);
                startActivity(intent);
            }
        });
        mPoliticsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AltCategoriesActivity.this,
                        PoliticsActivity.class);
                startActivity(intent);
            }
        });
        mReligionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AltCategoriesActivity.this,
                        ReligionActivity.class);
                startActivity(intent);
            }
        });
        mSocietyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AltCategoriesActivity.this,
                        SocietyActivity.class);
                startActivity(intent);
            }
        });
        mMiscButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AltCategoriesActivity.this,
                        MiscActivity.class);
                startActivity(intent);
            }
        });
    }
}
