package com.example.sqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlite.DatabaseHelpers.MyDataBase;

public class MainActivity extends AppCompatActivity {
    
    private EditText e1,e2,e3,e4;
    private Button b1,b2,b3,b4;

    MyDataBase myDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDataBase = new MyDataBase(this);
        
        e1 = findViewById(R.id.nameEditText);
        e2 = findViewById(R.id.surnameEditText);
        e3 = findViewById(R.id.marksEditText);
        e4 = findViewById(R.id.rollNoEditText);

        b1 = findViewById(R.id.addButton);
        b2 = findViewById(R.id.viewAllButton);
        b3 = findViewById(R.id.deleteButton);
        b4 = findViewById(R.id.updateButton);
        
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
        
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewAllData();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItems();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateItems();
            }
        });
        
    }

    private void updateItems() {
        String s1,s2,s3,s4;
        s1 = e1.getText().toString();
        s2 = e2.getText().toString();
        s3 = e3.getText().toString();
        s4 = e4.getText().toString();
        boolean isUpdate = myDataBase.updateData(s1,s2,s3,s4);
        if(isUpdate == true)
            Toast.makeText(MainActivity.this,"Data Updated Successfully",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this,"Some Error",Toast.LENGTH_SHORT).show();
    }

    private void deleteItems() {
        String roll = e4.getText().toString();
        int deletedItems = myDataBase.deleteData(roll);
        if(deletedItems > 0)
            Toast.makeText(MainActivity.this,"Data Deleted Successfully",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this,"Some Error",Toast.LENGTH_SHORT).show();
    }

    private void viewAllData() {
        Cursor res = myDataBase.getAllData();

        if(res.getCount() == 0)
            Toast.makeText(MainActivity.this,"No Data",
                    Toast.LENGTH_SHORT)
                    .show();

        StringBuffer stringBuffer = new StringBuffer();
        while (res.moveToNext())
        {
            stringBuffer.append("Roll : "+res.getString(3));
            stringBuffer.append("Name : "+res.getString(0));
            stringBuffer.append("Surname : "+res.getString(1));
            stringBuffer.append("Marks : "+res.getString(2));
        }

        Toast.makeText(MainActivity.this,stringBuffer.toString(),
                Toast.LENGTH_LONG)
                .show();
    }

    private void insertData() {
        String s1,s2,s3,s4;
        s1 = e1.getText().toString();
        s2 = e2.getText().toString();
        s3 = e3.getText().toString();
        s4 = e4.getText().toString();
        boolean isInserted = myDataBase.insertData(s1,s2,s3,s4);
        if(isInserted)
            Toast.makeText(MainActivity.this,"Data Inserted",
                    Toast.LENGTH_SHORT)
                    .show();
        else
            Toast.makeText(MainActivity.this,"Some Error",
                    Toast.LENGTH_SHORT)
                    .show();
    }


}
