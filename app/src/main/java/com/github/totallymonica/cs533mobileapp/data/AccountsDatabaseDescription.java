package com.github.totallymonica.cs533mobileapp.data;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class AccountsDatabaseDescription {
    public static final String AUTHORITY = "com.github.totallymonica.cs533mobileapp.data";
    private static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    public static class User implements BaseColumns {
        // Table name
        public static final String TABLE_NAME = "Users";

        // URI for the users table
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();

        // Column names for the table
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_NAME_PASSWORD = "passwd";
        public static final String COLUMN_NAME_FIRST_NAME = "fname";
        public static final String COLUMN_NAME_LAST_NAME = "lname";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_PHONE = "phone";

        public static Uri buildUserUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}
