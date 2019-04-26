package com.example.ca3roshansir;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ca3roshansir.R;

public class MainActivity extends AppCompatActivity {
    DrawerLayout dl;
    NavigationView nv;
    Toolbar tb;
    FragmentManager fm;
    FragmentTransaction ft;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dl = findViewById(R.id.drawerLayout);
        nv = findViewById(R.id.navigationView);
        tb = findViewById(R.id.toolbar);

        viewPager = findViewById(R.id.viewPager);

        FrameLayout frameLayout  = findViewById(R.id.frameLayout);
        View v = frameLayout.getChildAt(frameLayout.getId());
        imageView = frameLayout.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.ic_menu_black_24dp);

        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new HomeFragment(),"HomeFragment");
        viewPager.setAdapter(viewPagerAdapter);


        setSupportActionBar(tb);
        final ActionBar ab=getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(MainActivity.this,""+item.getTitle(),Toast.LENGTH_SHORT).show();
                dl.closeDrawers();

                switch (item.getItemId()){
                    case R.id.imageOne:
                        fm=getSupportFragmentManager();
                        ft=fm.beginTransaction();
                        ft.add(R.id.frameLayout,new HomeFragment());
                        ab.setTitle(item.getTitle());
                        ft.commit();
                        break;
                    case R.id.imageTwo:
                        fm=getSupportFragmentManager();
                        ft=fm.beginTransaction();
                        ft.add(R.id.frameLayout,new HomeFragment());
                        ab.setTitle(item.getTitle());
                        ft.commit();
                        break;
                    case R.id.imageThree:
                        fm=getSupportFragmentManager();
                        ft=fm.beginTransaction();
                        ft.add(R.id.frameLayout,new HomeFragment());
                        ab.setTitle(item.getTitle());
                        ft.commit();
                        break;
                    case R.id.imageFour:
                        fm=getSupportFragmentManager();
                        ft=fm.beginTransaction();
                        ft.add(R.id.frameLayout,new HomeFragment());
                        ab.setTitle(item.getTitle());
                        ft.commit();
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
