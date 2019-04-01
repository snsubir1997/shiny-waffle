package com.example.contentprovider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button bsave, bload;
    ContentValues cv = new ContentValues();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.nameEditText);
        e2 = findViewById(R.id.mobileEditText);
        bsave = findViewById(R.id.saveButton);
        bload = findViewById(R.id.loadButton);

        bsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cv.put("name ",e1.getText().toString());
                cv.put("mobileNo ",Long.parseLong(e2.getText().toString()));
                Uri uri = getContentResolver().insert(MyContentProvider.content_uri,cv);
                Toast.makeText(MainActivity.this, uri.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        bload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cr = getContentResolver().query(MyContentProvider.content_uri,
                        null, null, null, "name");
                String s = "";
                while (cr.moveToNext()) {
                    String s1 = cr.getString(0);
                    int a = cr.getInt(1);
                    s = s + "Name is " + s1 + " Mobile no is " + a + "\n";
                }
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }


}
