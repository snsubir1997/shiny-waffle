package com.example.allinonecse225;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.allinonecse225.Fragments.FragOne;
import com.example.allinonecse225.Fragments.FragThree;
import com.example.allinonecse225.Fragments.FragTwo;

public class UnitThree extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3,b4,b5;
    FragmentManager fm;
    FragmentTransaction ft;
    Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit_three);

        b1 = findViewById(R.id.frag_one);
        b2 = findViewById(R.id.frag_two);
        b3 = findViewById(R.id.frag_three);
        b4 = findViewById(R.id.frag_replace);
        b5 = findViewById(R.id.frag_remove);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (v.getId()) {
            case R.id.frag_one:
                ft.add(R.id.fragFrame,new FragOne(),"One");
                break;
            case R.id.frag_two:
                ft.add(R.id.fragFrame,new FragTwo(),"Two");
                break;
            case R.id.frag_three:
                ft.add(R.id.fragFrame,new FragThree(),"Three");
                break;
            case R.id.frag_replace:
                fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentFragment);
                if(fragment!=null)
                    ft.replace(R.id.fragmentFragment,new FragTwo());
                break;
            case R.id.frag_remove:
                fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentFragment);
                if(fragment!=null)
                    ft.remove(fragment);
                break;
        }
        ft.addToBackStack(null);
        ft.commit();
    }
}
