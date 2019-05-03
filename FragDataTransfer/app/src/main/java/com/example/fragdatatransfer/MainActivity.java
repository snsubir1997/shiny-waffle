package com.example.fragdatatransfer;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction t = manager.beginTransaction();
        Frag1 f1 = new Frag1();
        Frag2 f2= new Frag2();
        t.add(R.id.frame1,f1);
        t.add(R.id.frame2,f2);
        t.commit();
    }

    public void recieve(String s1,String s2)
    {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction t = manager.beginTransaction();
        Frag1 f1= new Frag1();
        Bundle b1 = new Bundle();
        b1.putString("name",s1);
        b1.putString("regno",s2);
        f1.setArguments(b1);
        t.add(R.id.frame1,f1);
        t.commit();
    }
}
