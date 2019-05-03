package com.example.allinonecse225;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("All In One");

        Button b1 = findViewById(R.id.buttonUnitOne);
        Button b2 = findViewById(R.id.buttonUnitTwo);
        Button b3 = findViewById(R.id.buttonUnitThree);
        Button b4 = findViewById(R.id.buttonUnitFour);
        Button b5 = findViewById(R.id.buttonUnitFive);
        Button b6 = findViewById(R.id.buttonUnitSix);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonUnitOne:
                startActivity(new Intent(this,UnitOne.class));
                break;
            case R.id.buttonUnitTwo:
                startActivity(new Intent(this,UnitTwo.class));
                break;
            case R.id.buttonUnitThree:
                startActivity(new Intent(this,UnitThree.class));
                break;
            case R.id.buttonUnitFour:
                startActivity(new Intent(this,UnitFour.class));
                break;
            case R.id.buttonUnitFive:
                startActivity(new Intent(this,UnitFive.class));
                break;
            case R.id.buttonUnitSix:
                startActivity(new Intent(this,UnitSix.class));
                break;
        }
    }
}
