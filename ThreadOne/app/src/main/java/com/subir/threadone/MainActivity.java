package com.subir.threadone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tv1, tv2;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.oddTextView);
        tv2 = findViewById(R.id.evenTextView);

        b1 = findViewById(R.id.fillButton);
        b2 = findViewById(R.id.clearButton);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread1 = new Thread(new OddThread());
                thread1.start();
                Thread thread2 = new Thread(new EvenThread());
                thread2.start();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv1.setText("");
                tv2.setText("");

            }
        });
    }

    class OddThread implements Runnable {

        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 1; i<99; i += 2)
                        try {
                            tv1.setText(tv1.getText().toString() + i + ", ");
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            });
        }
    }

    class EvenThread implements Runnable {

        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i<99; i += 2)
                        try {
                            tv2.setText(tv2.getText().toString() + i + ", ");
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            });
        }
    }
}
