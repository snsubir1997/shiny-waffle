package com.example.loaders;

import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @NonNull
    @Override
    public Loader onCreateLoader(int i, @Nullable Bundle bundle) {
        Uri uri = Uri.parse("content://com.example.contentprovider.myprovider/info_table");
        CursorLoader cursorLoader = new CursorLoader(this, uri, null, null, null, "name");
        Toast.makeText(this, "In onCreateLoader Method", Toast.LENGTH_SHORT).show();
        return cursorLoader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader loader, Object o) {
        Toast.makeText(this, "Inside the LoadFinished Method", Toast.LENGTH_SHORT).show();
        Cursor cursor = (Cursor) o;
        String s = "";
        while (cursor.moveToNext()) {
            String s1 = cursor.getString(0);
            int a = cursor.getInt(1);
            s = s + " Name is " + s1 + " Pass is " + a + "\n";
        }
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoaderReset(@NonNull Loader loader) {
    }

    public void doThis(View view){
        getSupportLoaderManager().initLoader(0, null, this);
    }
}
