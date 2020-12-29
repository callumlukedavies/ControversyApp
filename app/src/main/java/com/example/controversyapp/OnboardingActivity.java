package com.example.controversyapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OnboardingActivity extends AppCompatActivity {

    ViewPager mViewPager;
    LinearLayout mConsLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;
    private Button mNextButton;
    private Button mPreviousButton;
    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        ActionBar bar = getSupportActionBar();
        bar.hide();

        mConsLayout = findViewById(R.id.dotLayout);
        mViewPager = findViewById(R.id.slideViewPager);
        mNextButton = findViewById(R.id.nextButton);
        mPreviousButton = findViewById(R.id.previousButton);

        sliderAdapter = new SliderAdapter(this);

        mViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mViewPager.addOnPageChangeListener(viewListener);

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPage == mDots.length-1){
                    Intent intent = new Intent(OnboardingActivity.this,
                            HomeActivity.class);
                    startActivity(intent);
                }else{
                    mViewPager.setCurrentItem(currentPage + 1);
                }
            }
        });

        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(currentPage - 1);
            }
        });
    }

    public void addDotsIndicator(int position){
        mDots = new TextView[sliderAdapter.getCount()];
        mConsLayout.removeAllViews();
        for(int i = 0; i < mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(50);
            mDots[i].setTextColor(Color.parseColor("#BBBBBB"));
            mConsLayout.addView(mDots[i]);
        }

        if (mDots.length > 0){
            mDots[position].setTextColor(Color.parseColor("#FFFFFF"));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset,
                                   int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);

            currentPage = position;
            if(currentPage == 0){
                mPreviousButton.setEnabled(false);
                mNextButton.setEnabled(true);
                mPreviousButton.setVisibility(View.INVISIBLE);
                mNextButton.setText("Next");
                mPreviousButton.setText("");
            } else if(currentPage == mDots.length - 1){
                mPreviousButton.setEnabled(true);
                mNextButton.setEnabled(true);
                mPreviousButton.setVisibility(View.VISIBLE);
                mNextButton.setText("Finish");
                mPreviousButton.setText("Back");
            }else{
                mPreviousButton.setEnabled(true);
                mNextButton.setEnabled(true);
                mPreviousButton.setVisibility(View.VISIBLE);
                mNextButton.setText("Next");
                mPreviousButton.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}