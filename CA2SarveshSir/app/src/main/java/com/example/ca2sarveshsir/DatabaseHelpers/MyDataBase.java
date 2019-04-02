package com.example.ca2sarveshsir.DatabaseHelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataBase extends SQLiteOpenHelper {

    public static final String dbName = "my.db";
    public static final int version = 1;
    public static final String tableName = "student_table";
    public static final String col_1 = "name";
    public static final String col_2 = "email";
    public static final String col_3 = "marks";
    public static final String col_4 = "rollNo";

    public MyDataBase(Context context) {
        super(context, dbName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+tableName+" (NAME TEXT, EMAIL TEXT, MARKS TEXT, ROLLNO INTEGER PRIMARY KEY)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+tableName);
        onCreate(db);
    }

    public boolean insertData(String name,String email,String marks,String rollNo)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,name);
        contentValues.put(col_2,email);
        contentValues.put(col_3,marks);
        contentValues.put(col_4,rollNo);

        long result = db.insert(tableName,null,contentValues);

        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+tableName,
                null);

        return cursor;
    }

    public boolean updateData(String name,String surname,String marks,String rollNo)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,name);
        contentValues.put(col_2,surname);
        contentValues.put(col_3,marks);
        contentValues.put(col_4,rollNo);
        db.update(tableName,contentValues," rollNo = ?",new String[] {rollNo});
        return true;
    }

    public int deleteData(String rollNo)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(tableName," rollNo = ?",new String[] {rollNo});
    }
}
