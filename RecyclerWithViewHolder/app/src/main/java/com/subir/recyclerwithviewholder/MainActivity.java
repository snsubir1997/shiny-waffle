package com.subir.recyclerwithviewholder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.subir.recyclerwithviewholder.Adapters.MyAdapter;
import com.subir.recyclerwithviewholder.Models.ItemList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ItemList> itemLists = new ArrayList<>();
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;

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
        String itemRoll[] = getResources().getStringArray(R.array.rollNos);
        String itemGpa[] = getResources().getStringArray(R.array.gpa);

        for (int i = 0; i < itemName.length; i++) {
            itemLists.add(new ItemList(itemName[i], itemRoll[i], itemGpa[i]));
        }

        mAdapter.notifyDataSetChanged();
    }
}
