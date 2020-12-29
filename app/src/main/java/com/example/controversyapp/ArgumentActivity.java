package com.example.controversyapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ArgumentActivity extends AppCompatActivity {
    public static final String CHOOSING_PLAYER = "choosingPlayer";
    public static final String OPPOSING_PLAYER = "opposingPlayer";
    public static final String SHARED_PREFS = "sharedPrefs";
    private CountDownTimer timer;
    private MediaPlayer player;
    private TextView mTimerTextView;
    private TextView mInstructionsTextView;
    private Button mContinueButton;
    private long timeLeftInMilliseconds = 0;
    private boolean roundFinished = false;
    private String choosingPlayer;
    private String opposingPlayer;
    private boolean preventBackButton = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_argument);
        ActionBar bar = getSupportActionBar();
        bar.hide();
        loadData();
        setViews();
        setOnClickListeners();
    }

    public void loadData(){
        //LOAD TEAM DATA FROM SHAREDPREFS
        SharedPreferences sharedPreferences =
                getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        choosingPlayer = sharedPreferences.getString(CHOOSING_PLAYER, "");
        opposingPlayer = sharedPreferences.getString(OPPOSING_PLAYER, "");
    }

    public void setViews(){
        mTimerTextView = findViewById(R.id.timerTextView);
        mInstructionsTextView = findViewById(R.id.instructionsText);
        mContinueButton = findViewById(R.id.continueButton);
    }

    public void setOnClickListeners(){
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(roundFinished) continueToNextActivity();
                else setUp();
            }
        });
    }

    public void continueToNextActivity(){
        Intent intent = new Intent(ArgumentActivity.this,
                SelectRoundWinnerActivity.class);
        startActivity(intent);
    }

    public void setUp(){
        preventBackButton = true;
        mContinueButton.setVisibility(View.GONE);
        mTimerTextView.setText("");
        mTimerTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 200);
        mInstructionsTextView.setVisibility(View.VISIBLE);
        startFirstInterval();
    }

    public void startFirstInterval(){
        mInstructionsTextView.setText(R.string.intervalOne);
        timeLeftInMilliseconds = 6000;
        timer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateIntervalTimer();
            }

            @Override
            public void onFinish() {
                startFirstTimer();
            }
        }.start();
    }

    public void startFirstTimer(){
        mTimerTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 100);
        mInstructionsTextView.setText(R.string.instructionOne);
//        timeLeftInMilliseconds = 120000;
        timeLeftInMilliseconds = 15000;
        timer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                playSound(R.raw.zapsplat_long_beep);
                startSecondInterval();
            }
        }.start();
    }

    public void startSecondInterval(){
        String intervalTwoText =
                choosingPlayer + getString(R.string.intervalTwo);
        mTimerTextView.setTextColor(Color.parseColor("#ffffff"));
        mInstructionsTextView.setText(intervalTwoText);
        timeLeftInMilliseconds = 6000;
        timer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateIntervalTimer();
            }

            @Override
            public void onFinish() {
                startSecondTimer();
            }
        }.start();
    }

    public void startSecondTimer(){
//        timeLeftInMilliseconds = 120000;
        timeLeftInMilliseconds = 15000;

        String instructionTwoText =
                choosingPlayer + getString(R.string.instructionTwo);
        mInstructionsTextView.setText(instructionTwoText);
        mTimerTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 100);
        timer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                playSound(R.raw.zapsplat_long_beep);
                startThirdInterval();
            }
        }.start();

    }

    public void startThirdInterval(){
        String intervalThreeText =
                opposingPlayer + getString(R.string.intervalThree);
        mInstructionsTextView.setText(intervalThreeText);
        mTimerTextView.setTextColor(Color.parseColor("#ffffff"));
        timeLeftInMilliseconds = 6000;
        timer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateIntervalTimer();
            }

            @Override
            public void onFinish() {
                startThirdTimer();
            }
        }.start();
    }

    public void startThirdTimer(){
        timeLeftInMilliseconds = 120000;
//        timeLeftInMilliseconds = 10000;
        String instructionThreeText =
                opposingPlayer + getString(R.string.instructionThree);
        mInstructionsTextView.setText(instructionThreeText);
        mTimerTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 100);
        timer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                playSound(R.raw.zapsplat_long_beep);
                startFourthInterval();
            }
        }.start();
    }

    public void startFourthInterval(){
        String intervalFourText =
                choosingPlayer + " and " + opposingPlayer + getString(R.string.intervalFour);
        mInstructionsTextView.setText(intervalFourText);
        mTimerTextView.setTextColor(Color.parseColor("#ffffff"));
        timeLeftInMilliseconds = 6000;
        timer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateIntervalTimer();
            }

            @Override
            public void onFinish() {
                startFourthTimer();
                playSound(R.raw.zapsplat_boxing);
            }
        }.start();
    }

    public void startFourthTimer(){
        timeLeftInMilliseconds = 300000;
//        timeLeftInMilliseconds = 10000;
        String instructionFourText =
                choosingPlayer + " and " + opposingPlayer + getString(R.string.instructionFour);
        mInstructionsTextView.setText(instructionFourText);
        mTimerTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 100);
        timer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                mContinueButton.setVisibility(View.VISIBLE);
                mTimerTextView.setText("");
                mTimerTextView.setTextColor(Color.parseColor("#ffffff"));
                mInstructionsTextView.setVisibility(View.GONE);
                mTimerTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 27);
                mTimerTextView.setText(R.string.instructionFive);
                roundFinished = true;
            }
        }.start();
    }

    public void updateTimer(){
        // Prints the time left in minutes and seconds onto the screen.
        int minutes = (int) (timeLeftInMilliseconds/60000);
        int seconds = (int) (timeLeftInMilliseconds % 60000/1000);
        String timeLeft;
        timeLeft = "0" + minutes;
        timeLeft += ":";
        if(seconds < 10) timeLeft += "0";
        timeLeft+=seconds;

        if(minutes < 1 && seconds < 11){
            mTimerTextView.setTextColor(Color.parseColor("#DF2935"));
            playSound(R.raw.zapsplat_multimedia_click2);
        }
        mTimerTextView.setText(timeLeft);
    }

    public void updateIntervalTimer(){
//        Gives the user a 5 second window
        int seconds = (int) (timeLeftInMilliseconds % 60000/1000);
        String sec = "" + seconds;
        if(seconds == 0) mTimerTextView.setText(R.string.go);
        else mTimerTextView.setText(sec);
    }

    public void playSound(int sound){
        //Plays a sound given as an argument.
        if(player == null) createMediaPlayer(sound);
        player.start();
    }

    public void stopPlayer(){
        //Releases the media player.
        if(player != null) releaseMediaPlayer();
    }

    public void createMediaPlayer(int sound){
        player = MediaPlayer.create(this,
                sound);
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                stopPlayer();
            }
        });
    }

    public void releaseMediaPlayer(){
        player.release();
        player = null;
    }

    @Override
    public void onBackPressed() {
        if(preventBackButton){
            Toast.makeText(ArgumentActivity.this, "Cannot return",
                    Toast.LENGTH_SHORT).show();
        }else{
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopPlayer();
        timer.cancel();
    }
}