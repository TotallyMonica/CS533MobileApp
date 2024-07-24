package com.github.totallymonica.cs533mobileapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.github.totallymonica.cs533mobileapp.data.AccountsDatabaseDescription.User;

public class AccountsDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "users.db";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + User.TABLE_NAME +
                    " (" + User._ID + " INTEGER PRIMARY KEY," +
                    User.COLUMN_NAME_USERNAME + " TEXT," +
                    User.COLUMN_NAME_PASSWORD + " TEXT," +
                    User.COLUMN_NAME_NAME + " TEXT," +
                    User.COLUMN_NAME_EMAIL + " TEXT," +
                    User.COLUMN_NAME_PHONE + " TEXT," +
                    User.COLUMN_NAME_ADDRESS + " TEXT)";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + User.TABLE_NAME;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public AccountsDatabaseHelper(Context context) {
        super(context, User.TABLE_NAME, null, DATABASE_VERSION);
    }

    public int getId(UserInfo user) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(User.COLUMN_NAME_USERNAME, user.username);
        cv.put(User.COLUMN_NAME_PASSWORD, user.password);

        Cursor cursor = db.rawQuery("SELECT " + User._ID + " FROM " + User.TABLE_NAME +
                            " WHERE " + User.COLUMN_NAME_USERNAME + " = '" + user.username +
                            "' AND " + User.COLUMN_NAME_PASSWORD + " = '" + user.password + "';",
                null);

        if (cursor.moveToFirst()) {
            return cursor.getInt(0);
        } else {
            return -1;
        }
    }

    public boolean addOne(UserInfo user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(User.COLUMN_NAME_EMAIL, user.emailAddress);
        cv.put(User.COLUMN_NAME_NAME, user.name);
        cv.put(User.COLUMN_NAME_PHONE, user.phoneNumber);
        cv.put(User.COLUMN_NAME_USERNAME, user.username);
        cv.put(User.COLUMN_NAME_PASSWORD, user.password);
        cv.put(User.COLUMN_NAME_ADDRESS, user.emailAddress);

        long insert = db.insert(User.TABLE_NAME, null, cv);
        db.close();

        // Account was created successfully, save it so that we can log in with it
        if (insert != -1) {
            int userId = getId(user);
            editor = sharedPreferences.edit();
            editor.putBoolean("LoggedIn", true);
            editor.putInt(User._ID, userId);
            editor.putString(User.COLUMN_NAME_USERNAME, user.username);
            editor.commit();
        }
        return (insert != -1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
