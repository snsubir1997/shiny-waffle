package com.example.allinonecse225;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.allinonecse225.Adapters.MyPagerAdapter;
import com.example.allinonecse225.Fragments.FragOne;
import com.example.allinonecse225.Fragments.FragTwo;

public class UnitSix extends AppCompatActivity {

    DrawerLayout dl;
    NavigationView nv;
    FragmentManager fm;
    FragmentTransaction ft;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit_six);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dl=findViewById(R.id.dl);
        nv=findViewById(R.id.nv);

        TabLayout tl = findViewById(R.id.tbLayout);
        tl.addTab(tl.newTab().setText("X"));
        tl.addTab(tl.newTab().setText("Y"));

        tl.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager vp = findViewById(R.id.vpgr);

        tl.setupWithViewPager(vp);

        final ActionBar ab=getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        final PagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(),tl.getTabCount());
        vp.setAdapter(adapter);
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tl));
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(UnitSix.this,""+item.getTitle(),Toast.LENGTH_SHORT).show();
                item.setCheckable(false);
                dl.closeDrawers();

                switch (item.getItemId()){
                    case R.id.homeid:
                        fm=getSupportFragmentManager();
                        ft=fm.beginTransaction();
                        ft.add(R.id.fragFrame,new FragOne());
                        //toolbar.setTitle("Home");
                        ft.commit();
                        break;
                    case R.id.mobileid:
                        fm=getSupportFragmentManager();
                        ft=fm.beginTransaction();
                        ft.add(R.id.fragFrame,new FragTwo());
                        //toolbar.setTitle("Mobile");
                        ft.commit();
                        break;
                    case R.id.shopid:
                        break;
                    case R.id.orderid:
                        break;
                    case R.id.userid:
                        break;

                }


                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                dl.openDrawer(GravityCompat.START);
                break;
        }

        return true;
    }
}
