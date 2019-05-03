package com.example.allinonecse225;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.allinonecse225.Adapters.ListAdapter;
import com.example.allinonecse225.Modals.ItemList;
import com.example.allinonecse225.Recievers.PendingIntentBroadcastReciever;

import java.util.ArrayList;

public class UnitTwo extends AppCompatActivity {

    ListView listView;
    GridView gridView;
    ArrayList<ItemList> itemList = new ArrayList<>();
    Button b1,b2;
    private final int REQ_CODE = 2142341;

    String[] name = {"Xavier", "Panther", "Tony", "Natasha", "Steve", "Stan", "Joe", "Antony"};
    String[] rollNo = {"1121", "1122", "1123", "1124", "1125", "1126", "1127", "1128"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit_two);

        b1 = findViewById(R.id.startAlert);
        b2 = findViewById(R.id.stopAlert);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAlert();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listView = findViewById(R.id.listView);
        gridView = findViewById(R.id.gridView);

        for(int i = 0;i<name.length;i++)
        {
            ItemList itr = new ItemList(name[i],rollNo[i]);
            itemList.add(itr);
        }

        ListAdapter adapter = new ListAdapter(this,itemList);
        listView.setAdapter(adapter);
        gridView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {

                TextView tv = v.findViewById(R.id.nameTextView);
                String name = tv.getText().toString();

                Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {

                TextView tv = v.findViewById(R.id.nameTextView);
                String name = tv.getText().toString();

                Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void startAlert() {

        Intent intent = new Intent(this, PendingIntentBroadcastReciever.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),
                REQ_CODE,intent,0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis() + (5000), pendingIntent);
        Toast.makeText(getApplicationContext(),"Alarm After " + "5" + " seconds",
                Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        Process.killProcess(Process.myPid());
        super.onDestroy();
    }
}
