package com.subir.asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyThread myThread = new MyThread();
        myThread.start();

        Thread thread = new Thread(new AnotherThread());
        thread.start();

        for(int i = 0; i<10; i++)
        {
            Log.d(TAG,"MainActivity Thread "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class MyThread extends Thread {
        public void run() {
            for(int i = 0; i<10; i++)
            {
                Log.d(TAG,"In MyThread "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class AnotherThread implements Runnable {

        @Override
        public void run() {
            for(int i = 0; i<10; i++)
            {
                Log.d(TAG,"In AnotherThread "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
