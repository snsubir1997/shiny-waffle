package com.subir.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.Date;

public class MyService2 extends Service {

    public MyService2()
    {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

   class MyBinder extends Binder
   {
       Service getService()
       {
           return MyService2.this;
       }
   }

   public String getTime()
   {
       Date date = new Date();
       return date.toString();
   }

    @Override
    public void onCreate() {
        Toast.makeText(getApplicationContext(),"OnCreate",Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(getApplicationContext(),"OnDesroy",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(getApplicationContext(),"OnUnbind",Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }
}
