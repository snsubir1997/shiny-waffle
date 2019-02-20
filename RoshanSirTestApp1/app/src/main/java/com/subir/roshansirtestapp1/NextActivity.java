package com.subir.roshansirtestapp1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    private TextView e1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        e1 = findViewById(R.id.displayNameTextView);

        Bundle extras = getIntent().getExtras();
        String value;
        if (extras != null) {
            value = extras.getString("NAME_ID");
            e1.setText("Welcome "+value);
        }


    }
}
