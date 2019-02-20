package com.subir.servicesbasic;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Date;
public class MyService2 extends Service {
    public MyService2() {}
    IBinder ib= new MyBinder();
    @Override
    public IBinder onBind(Intent intent) {
        return ib;
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
            Date obj=new Date();
            return obj.toString();
        }
    @Override
    public void onCreate() {
        Toast.makeText(this,"On create",Toast.LENGTH_LONG).show();
        super.onCreate();
    }
    @Override
    public void onDestroy() {
        Toast.makeText(this,"Destroyed",Toast.LENGTH_LONG).show();
        super.onDestroy();
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this,"Unbinded",Toast.LENGTH_LONG).show();
        return super.onUnbind(intent);
    }
}
