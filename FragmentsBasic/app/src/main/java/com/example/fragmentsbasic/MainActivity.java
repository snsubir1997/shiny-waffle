package com.example.fragmentsbasic;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button b1,b2,b3,b4,b5;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.fragOneButton);
        b2 = findViewById(R.id.fragTwoButton);
        b3 = findViewById(R.id.fragThreeButton);

        b4 = findViewById(R.id.replaceButton);
        b5 = findViewById(R.id.removeButton);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (v.getId())
        {
            case R.id.fragOneButton:
                fragmentTransaction.add(R.id.fragmentFrame,new BlankFragment(),"One");
                break;
            case R.id.fragTwoButton:
                fragmentTransaction.add(R.id.fragmentFrame,new BlankFragment2(),"Two");
                break;
            case R.id.fragThreeButton:
                fragmentTransaction.add(R.id.fragmentFrame,new BlankFragment3(),"Three");
                break;
            case R.id.replaceButton:
                fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentFragment);
                if(fragment!=null)
                fragmentTransaction.replace(R.id.fragmentFragment,new BlankFragment2());
                break;
            case R.id.removeButton:
                fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentFragment);
                if(fragment!=null)
                fragmentTransaction.remove(fragment);
                break;
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
