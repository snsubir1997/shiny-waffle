package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    ProgressBar progressBar;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
        iv = findViewById(R.id.img);

    }

    public void showToastButtonClicked(View v){
        Toast.makeText(getApplicationContext(),"I am alive",Toast.LENGTH_SHORT).show();
    }

    public void loadImageButtonClicked(View v){
        new LoadIcon().execute(android.R.drawable.btn_star_big_on);
    }

    class LoadIcon extends AsyncTask<Integer,Integer, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tv.setText("Inside : Pre Execute");
            progressBar.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(Integer... integers) {

            tv.setText("Inside : doInbackground");

            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),android.R.drawable.star_big_on);

            for(int i=0;i<=10;i++){
                try {
                    Thread.sleep(1000);
                    publishProgress(i*10);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            return bitmap;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            tv.setText("Inside : onPost Execute");
            super.onPostExecute(bitmap);
            iv.setImageBitmap(bitmap);
        }
    }
}



