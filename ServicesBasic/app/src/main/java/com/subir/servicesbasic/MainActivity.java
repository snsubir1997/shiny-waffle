package com.subir.servicesbasic;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5;
    Intent i,i2,i3;
    MyService2 ms2;
    boolean isbind=false;
    TextView t1;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);

        t1=findViewById(R.id.t1);

        Log.i(String.valueOf(R.string.tag), "inside main()" + Thread.currentThread().getId());

        i2=new Intent(this,MyService2.class);
        i = new Intent(this, MyService1.class);
        i3 = new Intent(this,MyIntentService.class);

        bindService(i2,sc, Context.BIND_AUTO_CREATE);
    }

    ServiceConnection sc=new ServiceConnection()
    {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder)
        {
            Toast.makeText(getApplicationContext(),"Service Connected",Toast.LENGTH_LONG).show();
            MyService2.MyBinder mb= (MyService2.MyBinder)iBinder;
            ms2=(MyService2) mb.getService();
            isbind=true;
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName)
        {
            Toast.makeText(getApplicationContext(),"Service DisConnected",Toast.LENGTH_LONG).show();
            isbind=false;
        }
    };

    public void mymethod(View view) {
        switch (view.getId()) {
            case R.id.b1:
                startService(i);
                break;
            case R.id.b2:
                stopService(i);
                break;
            case R.id.b3:
                t1.setText(ms2.getTime());
                break;
            case R.id.b4:
                onUnBind(sc);
                break;
            case R.id.b5:
                Bundle bundle = new Bundle();
                bundle.putInt("key",358);
                i3.putExtras(bundle);
                startService(i3);
                break;
        }
    }

    private void onUnBind(ServiceConnection sc)
    {
        ms2.onUnbind(i2);
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.drawable.ic_launcher_foreground);
        builder.setMessage("Do you want to exit?");
        builder.setCancelable(false);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }
}