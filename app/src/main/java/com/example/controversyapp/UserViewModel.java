package com.example.controversyapp;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutionException;

import database.User;

public class UserViewModel extends AndroidViewModel {
    private UserRepository mRepository;
    private LiveData<List<User>> mAllUsers;
    public UserViewModel(Application application){
        super(application);
        mRepository = new UserRepository(application);
        mAllUsers = mRepository.getAllUsers();
    }

    LiveData<List<User>> getAllUsers(){return mAllUsers;}

    public void insert(User user){mRepository.insert(user);}

    public User logIn(String email, String password) throws ExecutionException, InterruptedException{
        User user = mRepository.logIn(email, password);
        return user;
    }
}
