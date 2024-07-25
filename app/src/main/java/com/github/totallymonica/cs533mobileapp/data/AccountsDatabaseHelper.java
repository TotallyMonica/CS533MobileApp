package com.github.totallymonica.cs533mobileapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.github.totallymonica.cs533mobileapp.data.AccountsDatabaseDescription.UserAccount;
import com.github.totallymonica.cs533mobileapp.model.User;
import com.google.gson.Gson;

public class AccountsDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "users.db";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + UserAccount.TABLE_NAME +
                    " (" + UserAccount._ID + " INTEGER PRIMARY KEY," +
                    UserAccount.COLUMN_NAME_PASSWORD + " TEXT," +
                    UserAccount.COLUMN_NAME_NAME + " TEXT," +
                    UserAccount.COLUMN_NAME_EMAIL + " TEXT," +
                    UserAccount.COLUMN_NAME_PHONE + " TEXT," +
                    UserAccount.COLUMN_NAME_ADDRESS + " TEXT," +
                    UserAccount.COLUMN_NAME_JSON + " TEXT)";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + UserAccount.TABLE_NAME;

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    public AccountsDatabaseHelper(Context context) {
        super(context, UserAccount.TABLE_NAME, null, DATABASE_VERSION);
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences("Preferences", 0);
        }
    }

    public int getId(User user) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(UserAccount.COLUMN_NAME_EMAIL, user.getEmail());
        cv.put(UserAccount.COLUMN_NAME_PASSWORD, user.getPassword());

        Cursor cursor = db.rawQuery("SELECT " + UserAccount._ID + " FROM " + UserAccount.TABLE_NAME +
                            " WHERE " + UserAccount.COLUMN_NAME_EMAIL + " = '" + user.getEmail() +
                            "' AND " + UserAccount.COLUMN_NAME_PASSWORD + " = '" + user.getPassword() + "';",
                null);

        if (cursor.moveToFirst()) {
            return cursor.getInt(0);
        } else {
            return -1;
        }
    }

    public boolean addOne(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        Gson gson = new Gson();
        String json = gson.toJson(cv);

        cv.put(UserAccount.COLUMN_NAME_EMAIL, user.getEmail());
        cv.put(UserAccount.COLUMN_NAME_NAME, user.getName());
        cv.put(UserAccount.COLUMN_NAME_PHONE, user.getMobile());
        cv.put(UserAccount.COLUMN_NAME_PASSWORD, user.getPassword());
        cv.put(UserAccount.COLUMN_NAME_ADDRESS, user.getEmail());
//        cv.put(UserAccount.COLUMN_NAME_JSON, json);

        System.out.println(json);

        long insert = db.insert(UserAccount.TABLE_NAME, null, cv);
        db.close();

        // Account was created successfully, save it so that we can log in with it
        if (insert != -1) {
            int userId = getId(user);
            editor = sharedPreferences.edit();
            editor.putBoolean("LoggedIn", true);
            editor.putInt(UserAccount._ID, userId);
            editor.putString(UserAccount.COLUMN_NAME_EMAIL, user.getEmail());
            editor.commit();
        }
        return (insert != -1);
    }

    public static void logout() {
        editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    public static String getUser() {
        String username = sharedPreferences.getString(UserAccount.COLUMN_NAME_EMAIL, "");
        return username;
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
