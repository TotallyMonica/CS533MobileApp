package com.github.totallymonica.cs533mobileapp.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import com.github.totallymonica.cs533mobileapp.R;
import com.github.totallymonica.cs533mobileapp.data.AccountsDatabaseDescription.User;

public class AccountsContentProvider extends ContentProvider {
    // Used to access the database
    private AccountsDatabaseHelper dbHelper;
    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    // constants used with UriMatcher to determine the operation to perform
    private static final int ONE_USER = 1;
    private static final int ALL_USERS = 2;

    static {
        uriMatcher.addURI(AccountsDatabaseDescription.AUTHORITY, User.TABLE_NAME + "/#", ONE_USER);
        uriMatcher.addURI(AccountsDatabaseDescription.AUTHORITY, User.TABLE_NAME + "/#", ALL_USERS);
    }

    @Override
    public boolean onCreate() {
        dbHelper = new AccountsDatabaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(User.TABLE_NAME);

        switch (uriMatcher.match(uri)) {
            case ONE_USER:
                queryBuilder.appendWhere(User._ID + "=" + uri.getLastPathSegment());
                break;
            case ALL_USERS:
                break;
            default:
                throw new UnsupportedOperationException(getContext().getString(R.string.invalid_query_uri) + uri);
        }

        Cursor cursor = queryBuilder.query(dbHelper.getReadableDatabase(), projection, selection, selectionArgs, null, null, sortOrder);

        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Uri newUserUri = null;

        switch (uriMatcher.match(uri)) {
            case ONE_USER:
                long rowId = dbHelper.getWritableDatabase().insert(
                        User.TABLE_NAME, null, values);

                if (rowId > 0) {
                    newUserUri = User.buildUserUri(rowId);
                }
        }

        return newUserUri;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
