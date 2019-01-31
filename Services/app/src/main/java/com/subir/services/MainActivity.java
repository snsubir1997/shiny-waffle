package com.subir.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button b1,b2;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.startServiceButton);
        b2 = findViewById(R.id.stopServiceButton);

        String action;
        i = new Intent(MainActivity.this,MyService.class);
    }

    public void checkService(View view)
    {
        switch(view.getId())
        {
            case R.id.startServiceButton:
                startService(i);
                break;
            case R.id.stopServiceButton:
                stopService(i);
                break;
        }
    }
}
