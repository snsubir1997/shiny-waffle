package com.subir.asyncone;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    TextView t1,t2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.timeEditText);
        t1 = findViewById(R.id.timeToSleepTextView);
        t1 = findViewById(R.id.resultTextView);
        b1 = findViewById(R.id.startButton);
    }

    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        private String resp;
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog  = ProgressDialog.show(MainActivity.this,
                    "ProgressDialog",
                    "Wait for time "+ e1.getText().toString()+" seconds" );
        }

        @Override
        protected String doInBackground(String... strings) {

            publishProgress("Sleeping");//calls on Progress Update()

            try {
                int time = Integer.parseInt(strings[0])*1000;
                Thread.sleep(time);
                resp = "Slept for "+strings[0]+" seconds";
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
