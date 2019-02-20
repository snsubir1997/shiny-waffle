package com.subir.customdialogbox;

import android.app.Dialog;
import android.os.VibrationEffect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);

        progressBar.setProgress(0);

        showProgress();
    }

    @Override
    public void onBackPressed() {
        showDialog();
    }

    public void showDialog()
    {
        final Dialog dialog = new Dialog(this);
        View v = getLayoutInflater().inflate(R.layout.dialog_layout,null);

        Button b1 = v.findViewById(R.id.cancelBtn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.setContentView(v);
        dialog.show();
    }

    public void showProgress(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 5; i++)
                    {
                        progressBar.setProgress(i*20);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }
}
