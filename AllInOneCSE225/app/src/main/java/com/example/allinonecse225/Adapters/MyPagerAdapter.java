package com.example.allinonecse225.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.allinonecse225.Fragments.FragOne;
import com.example.allinonecse225.Fragments.FragTwo;

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    int noOfTabs;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public MyPagerAdapter(FragmentManager fm,int noOfTabs) {
        super(fm);
        this.noOfTabs = noOfTabs;
    }


    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new FragOne();
            case 1:
                return new FragTwo();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
}
