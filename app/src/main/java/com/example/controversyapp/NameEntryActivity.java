package com.example.controversyapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NameEntryActivity extends AppCompatActivity {
    private Button mNameEntryButton;
    private Button mSubmitNamesButton;
    private Button mShowNamesButton;
    private Button mReturnButton;
    private EditText mNameEntryEditText;
    private ConstraintLayout scrollLayout;
    private LinearLayout linLayout;
    private ArrayList<String> nameSet;
    private int round = 1;
    private int redPoints = 0;
    private int bluePoints = 0;
    private Set<String> redTeamNames;
    private Set<String> blueTeamNames;
    private Set<String> spectatorNames;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String RED_TEAM = "redTeamNames";
    public static final String BLUE_TEAM = "blueTeamNames";
    public static final String SPECTATORS = "spectatorNames";
    public static final String ROUND = "round";
    public static final String BLUE_POINTS = "bluePoints";
    public static final String RED_POINTS = "redPoints";
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_entry);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        nameSet = new ArrayList<>();
        mShowNamesButton = findViewById(R.id.showNamesButton);
        mNameEntryButton = findViewById(R.id.nameEntryButton);
        mReturnButton = findViewById(R.id.returnButton);
        scrollLayout = findViewById(R.id.scrollLayout);
        linLayout = findViewById(R.id.linLayout);
        scrollLayout.setZ((float) 2);
        mNameEntryEditText = findViewById(R.id.nameEntryEditText);
        mSubmitNamesButton = findViewById(R.id.submitNamesButton);
        setOnClickListeners();
    }

    public void saveData(){
        SharedPreferences sharedPreferences =
                getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet(RED_TEAM, redTeamNames);
        editor.putStringSet(BLUE_TEAM, blueTeamNames);
        editor.putStringSet(SPECTATORS, spectatorNames);
        editor.putInt(ROUND, round);
        editor.putInt(BLUE_POINTS, bluePoints);
        editor.putInt(RED_POINTS, redPoints);
        editor.apply();
    }

    public void setOnClickListeners(){
        mNameEntryEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == keyEvent.ACTION_DOWN) &&
                        (i == keyEvent.KEYCODE_ENTER)){
                    String name = mNameEntryEditText.getText().toString();
                    if(name.equals("")){
                        Toast.makeText(NameEntryActivity.this, "Please enter " +
                                        "a name",
                                Toast.LENGTH_SHORT).show();
                    }else if(name.length() > 20){
                        Toast.makeText(NameEntryActivity.this, "Names must be" +
                                        " under 20 characters",
                                Toast.LENGTH_LONG).show();
                    }else{
                        playSound();
                        nameSet.add(name);
                        addButtons(name);
                        if(nameSet.size() > 2){
                            mSubmitNamesButton.setBackgroundResource( R.drawable.rounded_button);
                            mSubmitNamesButton.setTextColor(Color.parseColor(
                                    "#ffffff"));
                        }
                    }
                    mNameEntryEditText.setText("");
                }
                return true;
            }
        });

        mNameEntryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mNameEntryEditText.getText().toString();
                if(name.equals("")){
                    Toast.makeText(NameEntryActivity.this, "Please enter " +
                                    "a name",
                            Toast.LENGTH_SHORT).show();
                }else if(name.length() > 20){
                    Toast.makeText(NameEntryActivity.this, "Names must be" +
                                    " under 20 characters",
                            Toast.LENGTH_LONG).show();
                }else{
                    nameSet.add(name);
                    addButtons(name);
                    playSound();
                    if(nameSet.size() > 2){
                        mSubmitNamesButton.setBackgroundResource( R.drawable.rounded_button);
                        mSubmitNamesButton.setTextColor(Color.parseColor(
                                "#ffffff"));
                    }
                }
                mNameEntryEditText.setText("");
            }
        });


        mSubmitNamesButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(nameSet.size() < 3){
                    Toast.makeText(NameEntryActivity.this, "Enter at least " +
                                    "three names",
                            Toast.LENGTH_SHORT).show();
                }else {
                    randomize(nameSet);
                    createTeams(nameSet);
                    saveData();
                    Intent intent = new Intent(NameEntryActivity.this,
                            DisplayTeamsActivity.class);
                    startActivity(intent);
                }
            }
        });

        mShowNamesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(NameEntryActivity.this);
                scrollLayout.setVisibility(View.VISIBLE);
                mNameEntryButton.setVisibility(View.GONE);
                mNameEntryEditText.setVisibility(View.GONE);
                mShowNamesButton.setVisibility(View.GONE);
                mSubmitNamesButton.setVisibility(View.GONE);
            }
        });

        mReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollLayout.setVisibility(View.GONE);
                mNameEntryButton.setVisibility(View.VISIBLE);
                mNameEntryEditText.setVisibility(View.VISIBLE);
                mShowNamesButton.setVisibility(View.VISIBLE);
                mSubmitNamesButton.setVisibility(View.VISIBLE);
            }
        });
    }

    public void createTeams(ArrayList<String> array){
        int size = array.size();
        int q1 = size/3;
        int q2 = q1*2;
        redTeamNames = new HashSet<>();
        blueTeamNames = new HashSet<>();
        spectatorNames = new HashSet<>();
        for(int i = 0; i < q1; i++){
            blueTeamNames.add(array.get(i));
        }

        for(int i = q1; i < q2; i++){
            redTeamNames.add(array.get(i));
        }
        for(int i = q2; i < size; i++){
            spectatorNames.add(array.get(i));
        }
    }

    public void randomize(ArrayList<String> array){
        Random rand = new Random();
        for(int i = 0; i < array.size(); i++){
             int randomIndexToSwap = rand.nextInt(array.size());
             String temp = array.get(randomIndexToSwap);
             array.set(randomIndexToSwap, array.get(i));
             array.set(i, temp);
        }
    }

    public void addButtons(String name){
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(10, 10, 10, 10);
        final Button button = new Button(this);
        button.setText(name);
        button.setBackgroundColor(Color.parseColor("#8C71C6"));
        button.setTextColor(Color.parseColor("#FFFFFF"));
        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        button.setAllCaps(false);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String var = String.valueOf(button.getText());
                nameSet.remove(var);
                if(nameSet.size() < 3){
                    mSubmitNamesButton.setBackgroundResource(R.drawable.rounded_button2);
                    mSubmitNamesButton.setTextColor(Color.parseColor(
                            "#66ffffff"));
                }
                ViewGroup group = (ViewGroup) view.getParent();
                group.removeView(view);
            }
        });
        linLayout.addView(button, params);
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void playSound(){
        if(player == null){
            player = MediaPlayer.create(this,
                    R.raw.zapsplat_multimedia_click2);
        }
        player.start();
    }
}