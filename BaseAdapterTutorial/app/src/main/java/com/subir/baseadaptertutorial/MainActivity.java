package com.subir.baseadaptertutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.subir.baseadaptertutorial.Modal.AdapterClass;
import com.subir.baseadaptertutorial.Modal.ItemList;
import com.subir.baseadaptertutorial.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView itemsListView  = findViewById(R.id.listView);

        //create adapter object
        AdapterClass adapter = new AdapterClass(this, generateItemsList());

        //set custom adapter as adapter to our list view
        itemsListView.setAdapter(adapter);
    }

    /**
     * Util function to generate list of items
     *
     * @return ArrayList
     */
    private ArrayList<ItemList> generateItemsList() {
        String itemName[] = getResources().getStringArray(R.array.names);
        String itemRoll[] = getResources().getStringArray(R.array.rollNos);
        String itemGpa[] = getResources().getStringArray(R.array.gpa);

        ArrayList<ItemList> list = new ArrayList<>();

        for (int i = 0; i < itemName.length; i++) {
            list.add(new ItemList(itemName[i], itemRoll[i], itemGpa[i]));
        }

        Log.d(TAG,"Entered generate Items List");
        return list;
    }

}



