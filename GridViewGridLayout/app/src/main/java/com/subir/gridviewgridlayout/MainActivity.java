package com.subir.gridviewgridlayout;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        String [] arr = {"First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arr);
        gridView.setAdapter(arrayAdapter);

        gridView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        view.setBackgroundColor(Color.BLUE);
        parent.setBackgroundColor(Color.GRAY);
        Toast.makeText(this," "+position+" ",Toast.LENGTH_SHORT).show();
    }
}
