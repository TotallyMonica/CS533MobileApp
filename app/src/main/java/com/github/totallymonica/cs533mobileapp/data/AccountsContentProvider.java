package com.github.totallymonica.cs533mobileapp.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import com.github.totallymonica.cs533mobileapp.R;
import com.github.totallymonica.cs533mobileapp.data.AccountsDatabaseDescription.UserAccount;

public class AccountsContentProvider extends ContentProvider {
    // Used to access the database
    private AccountsDatabaseHelper dbHelper;
    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    // constants used with UriMatcher to determine the operation to perform
    private static final int ONE_USER = 1;
    private static final int ALL_USERS = 2;

    static {
        uriMatcher.addURI(AccountsDatabaseDescription.AUTHORITY, UserAccount.TABLE_NAME + "/#", ONE_USER);
        uriMatcher.addURI(AccountsDatabaseDescription.AUTHORITY, UserAccount.TABLE_NAME + "/#", ALL_USERS);
    }

    @Override
    public boolean onCreate() {
        dbHelper = new AccountsDatabaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(UserAccount.TABLE_NAME);

        switch (uriMatcher.match(uri)) {
            case ONE_USER:
                queryBuilder.appendWhere(UserAccount._ID + "=" + uri.getLastPathSegment());
                break;
            case ALL_USERS:
                break;
            default:
                throw new UnsupportedOperationException(getContext().getString(R.string.invalid_query_uri) + uri);
        }

        // Execute query to one or more users
        Cursor cursor = queryBuilder.query(dbHelper.getReadableDatabase(), projection, selection, selectionArgs, null, null, sortOrder);

        // Check for content changes
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Uri newUserUri;

        switch (uriMatcher.match(uri)) {
            case ONE_USER:
                long rowId = dbHelper.getWritableDatabase().insert(UserAccount.TABLE_NAME, null, values);

                if (rowId > 0) { // SQLite IDs begin at 1, anything less than that is invalid
                    newUserUri = UserAccount.buildUserUri(rowId);
                    getContext().getContentResolver().notifyChange(uri, null);
                }
                else
                    throw new SQLException(getContext().getString(R.string.insert_failed) + uri);

                break;
            default:
                throw new UnsupportedOperationException(getContext().getString(R.string.invalid_insert_uri) + uri);
        }

        return newUserUri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int deletedRowsCount;

        switch (uriMatcher.match(uri)) {
            case ONE_USER:
                String id = uri.getLastPathSegment();

                deletedRowsCount = dbHelper.getWritableDatabase().delete(UserAccount.TABLE_NAME, UserAccount._ID + "=" + id, selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException(getContext().getString(R.string.invalid_delete_uri) + uri);
        }

        // Notify observers that data changed.
        if (deletedRowsCount != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }

        return deletedRowsCount;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int updatedRowsCount;

        switch (uriMatcher.match(uri)) {
            case ONE_USER:
                String id = uri.getLastPathSegment();

                updatedRowsCount = dbHelper.getWritableDatabase().update(UserAccount.TABLE_NAME, values, UserAccount._ID + "=" + id, selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException(getContext().getString(R.string.invalid_update_uri) + uri);
        }

        // Notify observers that data changed.
        if (updatedRowsCount != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }

        return updatedRowsCount;
    }
}
