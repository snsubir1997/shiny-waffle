package com.example.ca1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ca1.Adapter.MyAdapter;
import com.example.ca1.Model.ItemList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText e1,e2;
    private Button b;
    private ListView lv;
    private MyAdapter mAdapter;
    private ArrayList<ItemList> itemListArrayList;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.nameEditText);
        e2 = findViewById(R.id.regIdEditText);
        lv = findViewById(R.id.listview);

        Button b = findViewById(R.id.saveButton);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, regId;
                name = e1.getText().toString();
                regId = e2.getText().toString();
                if(check(name, regId))
                {
                    addToList(name, regId);
                }
            }
        });

        itemListArrayList = new ArrayList<>();
        mAdapter = new MyAdapter(this, itemListArrayList);

        lv.setAdapter(mAdapter);

    }

    private boolean check(String name, String regId) {

        ItemList it = new ItemList(name,regId);

        if(name!="" && regId!="")
        {

            if(itemListArrayList.contains(it))
            {
                Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
                Log.d("MainActivity", String.valueOf(itemListArrayList.indexOf(it)));
                Toast.makeText(this,"Data Already Exists",Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        else
            return false;


        return true;
    }

    private void addToList(String s1, String s2) {

        int flag=0;
        for(int i=0;i<nameArr.length;i++)
        {
            if(nameArr[i].equals(s1) && regIdArr[i].equals(s2))
            {
                flag=1;

                ItemList itemList = new ItemList(s1,s2);

                itemListArrayList.add(itemList);
                mAdapter.notifyDataSetChanged();

                break;
            }
        }

        if(flag == 0)
        {
            Toast.makeText(this,"Data Invalid",Toast.LENGTH_SHORT).show();
        }
    }
}
