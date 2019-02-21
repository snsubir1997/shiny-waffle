package com.subir.roshansirtestapp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.subir.roshansirtestapp1.Adapter.MyAdapter;
import com.subir.roshansirtestapp1.Model.ItemList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameText,regIdText;
    private MyAdapter myAdapter;
    private ArrayList<ItemList> itemListArrayList;
    private Toolbar toolbar;


    private String nameArr[] = {
            "Subir",
            "Karan",
            "Pratyaksh",
            "Ritu",
            "Ankur"
    };
    private String regIdArr[] = {
            "11613044",
            "11613045",
            "11613046",
            "11613047",
            "11613048"
    };
    private int imgArr[] = {
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("CodesFor Languages");

        nameText = findViewById(R.id.nameEditText);
        regIdText = findViewById(R.id.regNoEditText);

        Button saveBtn = findViewById(R.id.saveButton);
        Button clearBtn = findViewById(R.id.clearButton);
        final ListView listView = findViewById(R.id.nameList);

        saveBtn.setOnClickListener(this);
        clearBtn.setOnClickListener(this);

        itemListArrayList = new ArrayList<>();
        myAdapter = new MyAdapter(this, itemListArrayList);

        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ItemList item = (ItemList) parent.getItemAtPosition(position);
                String name = item.getName();

                Intent i = new Intent(MainActivity.this, NextActivity.class);
                i.putExtra("NAME_ID", name);
                startActivity(i);
            }
        });


        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);

        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
                mode.setTitle("" + listView.getCheckedItemCount() + " items selected");
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater menuInflater = mode.getMenuInflater();
                menuInflater.inflate(R.menu.context_action_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.menu_delete:

                        //action on clicking contextual action bar menu item

                        SparseBooleanArray checkedItems = listView.getCheckedItemPositions();
                        for (int i = 0; i < checkedItems.size(); i++) {

                            if (checkedItems.valueAt(i) == true) {
                                itemListArrayList.remove(i);
                            }
                        }
                        myAdapter.notifyDataSetChanged();

                        mode.finish();
                }
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.saveButton:
                addToList();
                break;
            case R.id.clearButton:
                nameText.setText("");
                regIdText.setText("");
                break;
        }
    }

    private void addToList() {
        String s1,s2;
        int imageResource;

        s1 = nameText.getText().toString();
        s2 = regIdText.getText().toString();

        int flag=0;
        for(int i=0;i<nameArr.length;i++)
        {
            if(nameArr[i].equals(s1) && regIdArr[i].equals(s2))
            {
                flag=1;
                imageResource = imgArr[i];
                ItemList itemList = new ItemList(s1,s2,imageResource);

                if(itemListArrayList.indexOf(itemList) > -1){
                    Toast.makeText(this,"Data Already Exists",Toast.LENGTH_SHORT).show();
                } else {
                    itemListArrayList.add(itemList);
                    myAdapter.notifyDataSetChanged();

                    break;
                }
            }
        }

        if(flag == 0)
        {
            Toast.makeText(this,"Data Invalid",Toast.LENGTH_SHORT).show();
        }
    }
}
