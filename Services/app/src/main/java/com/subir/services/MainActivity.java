package com.subir.services;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button b1,b2;
    private Intent i;
    private TextView textView;
    private MyService2 myService2;
    private boolean isBind = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewForDate);

        String action;
        i = new Intent(MainActivity.this,MyService.class);
    }

    public void checkService(View view)
    {
        switch(view.getId())
        {
            case R.id.startServiceButton:
                startService(i);
                break;
            case R.id.stopServiceButton:
                stopService(i);
                break;
            case R.id.b3:
                textView.setText(myService2.getTime());
                break;
            case R.id.b4:
                onUnBind(serviceConnection);
                break;
        }

        Log.i("MainActivity ","In main activity "+ Thread.currentThread());
    }

    private void onUnBind(ServiceConnection sc)
    {
        myService2.onUnbind(i);
    }


    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Toast.makeText(getApplicationContext(),"ServiceConnected",Toast.LENGTH_SHORT).show();
            MyService2.MyBinder myBinder = (MyService2.MyBinder) service;
            myService2 = (MyService2)myBinder.getService();
            isBind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Toast.makeText(getApplicationContext(),"ServiceDisconnected",Toast.LENGTH_SHORT).show();
            isBind = false;
        }
    };


}
