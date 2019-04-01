package com.example.contentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MyContentProvider extends ContentProvider {

    SQLiteDatabase myDatabase;
    public static final String dbName = "myDb";
    public static final int dbv = 1;
    public static final String authority = "com.example.contentprovider.myprovider";
    public static final Uri content_uri = Uri.parse("content://" + authority + "/info_table");


    @Override
    public boolean onCreate() {
        MyDatabaseClass myDatabaseClass = new MyDatabaseClass(getContext());
        myDatabase = myDatabaseClass.getWritableDatabase();
        if (myDatabase != null)
            return true;
        else
            return false;
    }


    @Override
    public Cursor query(@Nullable Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteQueryBuilder myQuery = new SQLiteQueryBuilder();
        myQuery.setTables("info_table");

        Cursor cr = myQuery.query(myDatabase, null, null, null, null, null, sortOrder);
        cr.setNotificationUri(getContext().getContentResolver(), uri);
        return cr;
    }

    @Override
    public String getType(@Nullable Uri uri) {
        return null;
    }

    @Override
    public Uri insert(@Nullable Uri uri, @Nullable ContentValues values) {
        long row = myDatabase.insert("info_table", null, values);
        uri= ContentUris.withAppendedId(content_uri,row);
        getContext().getContentResolver().notifyChange(uri, null);
        return uri;
    }

    @Override
    public int delete(@Nullable Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@Nullable Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {

        throw new UnsupportedOperationException("not yet implemented");
    }

    //inner class: since it can access the private data of the outer class
    //also the inner class is perfectly encapsulated, and data leak
    class MyDatabaseClass extends SQLiteOpenHelper {

        Context context;
        final static String databaseName = "database1.db";

        MyDatabaseClass(Context context) {
            super(context, databaseName, null, 1);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String s = "create table info_table (name text, mobileNo  integer)";
            db.execSQL(s);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
