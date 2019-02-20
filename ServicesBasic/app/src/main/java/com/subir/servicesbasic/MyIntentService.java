package com.subir.servicesbasic;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class MyIntentService extends IntentService {


    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            Log.i("My","Data is : "+bundle.getInt("key"));
            Log.i("My","Thread is : "+Thread.currentThread());
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"IntentServiceCreated",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        super.onStart(intent, startId);
        Toast.makeText(this,"IntentServiceStarted",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"IntentServiceDestroy",Toast.LENGTH_SHORT).show();
    }
}
