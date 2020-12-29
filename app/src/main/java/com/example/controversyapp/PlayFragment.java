package com.example.controversyapp;

import android.content.Intent;
import android.drm.DrmStore;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

public class PlayFragment extends Fragment {
    public Button mPlayButton;
    public Button mOnboardButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_play, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPlayButton = view.findViewById(R.id.playButton);
        mOnboardButton = view.findViewById(R.id.onboardingButton);
        mPlayButton.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),
                        NameEntryActivity.class);
                startActivity(intent);
            }
        });

        mOnboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),
                        OnboardingActivity.class);
                startActivity(intent);
            }
        });


    }
}
