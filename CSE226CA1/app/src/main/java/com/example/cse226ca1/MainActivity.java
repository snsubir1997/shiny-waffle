package com.example.cse226ca1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cse226ca1.Adapter.MyAdapter;
import com.example.cse226ca1.Model.ItemList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ItemList> itemLists = new ArrayList<>();
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;

    int itemImage[] = {
            R.drawable.ic_android_black_24dp,
            R.drawable.ic_android_black_24dp,
            R.drawable.ic_android_black_24dp,
            R.drawable.ic_android_black_24dp,
            R.drawable.ic_android_black_24dp,
            R.drawable.ic_android_black_24dp};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        mAdapter = new MyAdapter(itemLists);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareData();
    }

    public void prepareData()
    {
        String itemName[] = getResources().getStringArray(R.array.names);

        for (int i = 0; i < itemName.length; i++) {
            itemLists.add(new ItemList(itemName[i], itemImage[i]));
        }

        mAdapter.notifyDataSetChanged();
    }
}
