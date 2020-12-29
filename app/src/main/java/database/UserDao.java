package database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import database.User;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);

    @Query("DELETE FROM user_table")
    void delete();

    @Query("SELECT * FROM user_table WHERE :em == email AND :pass == password")
    User logIn(String em, String pass);
}
