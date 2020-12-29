package database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {

    public User(@NonNull String firstName, @NonNull String lastName,
                @NonNull String email, @NonNull String password){
        this.mFirstName = firstName;
        this.mLastName = lastName;
        this.mEmail = email;
        this.mPassword = password;
    }

    public void setMId(int mId) {
        this.mId = mId;
    }

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int mId;

    @NonNull
    public int getMId(){return mId;}

    @NonNull
    @ColumnInfo(name = "firstName")
    private String mFirstName;
    public String getFirstName(){return this.mFirstName;}

    @NonNull
    @ColumnInfo(name = "lastName")
    private String mLastName;
    public String getLastName(){return this.mLastName;}

    @NonNull
    @ColumnInfo(name = "email")
    private String mEmail;
    public String getEmail(){return this.mEmail;}

    @NonNull
    @ColumnInfo(name = "password")
    private String mPassword;
    public String getPassword(){return this.mPassword; }






}
