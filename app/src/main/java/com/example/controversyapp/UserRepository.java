package com.example.controversyapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutionException;

import database.User;
import database.UserDao;
import database.UserRoomDatabase;

public class UserRepository {
    private UserDao mUserDao;
    private LiveData<List<User>> mAllUsers;

    UserRepository(Application application){
        UserRoomDatabase db = UserRoomDatabase.getDatabase(application);
        mUserDao = db.UserDao();
    }

    LiveData <List<User>> getAllUsers(){return mAllUsers;}
    public void insert(User user){new insertAsyncTask(mUserDao).execute(user);}
    public User logIn(String email, String password) throws ExecutionException, InterruptedException {
        getAsyncTask task = new getAsyncTask(mUserDao);
        task.execute(email, password);
        User user = task.get();
        return user;

    }


    private static class insertAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDao mAsyncTaskDao;

        insertAsyncTask(UserDao dao){mAsyncTaskDao = dao;}
        
        @Override
        protected Void doInBackground(final User... params){
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class getAsyncTask extends AsyncTask<String, Void, User>{
        private UserDao mAsyncTaskDao;

        getAsyncTask(UserDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected User doInBackground(String... strings) {
            User user = mAsyncTaskDao.logIn(strings[0], strings[1]);
            return user;
        }
    }
}
