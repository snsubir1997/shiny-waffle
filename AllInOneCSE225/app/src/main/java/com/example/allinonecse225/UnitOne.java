package com.example.allinonecse225;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class UnitOne extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit_one);

        b1 = findViewById(R.id.showAlertDialogBox);
        b2 = findViewById(R.id.showCustomDialogBox);
        b3 = findViewById(R.id.showProgressBar);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);

        progressBar = findViewById(R.id.pBar);
        progressBar.setProgress(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.showAlertDialogBox:
                showAlert();
                break;
            case R.id.showCustomDialogBox:
                showCustomDialog();
                break;
            case R.id.showProgressBar:
                showProgressBar();
                break;
        }
    }

    private void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1;i<=5;i++)
                {
                    progressBar.setProgress(i*20);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    private void showCustomDialog() {

        final Dialog dialog = new Dialog(this);

        View dialogView = getLayoutInflater().inflate(R.layout.custom_dialog,null);
        Button closeDialogButton = dialogView.findViewById(R.id.dialogCloseButton);

        dialog.setContentView(dialogView);
        closeDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_launcher_background);
        builder.setTitle("AlertBox");
        builder.setMessage("LoremIpsumDolemGamut");
        builder.setPositiveButton("ShowToast", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                View toastView = getLayoutInflater().inflate(R.layout.custom_toast,null);
                Toast toast = new Toast(getApplicationContext());
                toast.setView(toastView);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
