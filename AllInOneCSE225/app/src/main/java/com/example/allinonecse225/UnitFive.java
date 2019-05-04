package com.example.allinonecse225;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class UnitFive extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3,b4,b5,b6;
    SharedPreferences shp;
    EditText et;
    Boolean flag = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit_five);

        checkStoragePermissions();

        shp = getSharedPreferences("mySharedPref", Context.MODE_PRIVATE);
        et = findViewById(R.id.someDatatosave);

        Button b1 = findViewById(R.id.savetosharedPref);
        Button b2 = findViewById(R.id.retrievefromsharedPref);
        Button b3 = findViewById(R.id.savetoInternal);
        Button b4 = findViewById(R.id.retrievefromInternal);
        Button b5 = findViewById(R.id.savetoExternal);
        Button b6 = findViewById(R.id.retrievefromExternal);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.savetosharedPref:
                savetoSharedPref();
                break;
            case R.id.retrievefromsharedPref:
                retrieveFromSharedPref();
                break;
            case R.id.savetoInternal:
                saveToInternal();
                break;
            case R.id.retrievefromInternal:
                retrieveFromInternal();
                break;
            case R.id.savetoExternal:
                saveToExternal();
                break;
            case R.id.retrievefromExternal:
                retrieveFromExternal();
                break;
        }
    }

    private void retrieveFromExternal() {

        File root = getExternalFilesDir(Environment.DIRECTORY_DCIM);
        FileInputStream fin = null;
        String data = "";
        if (root != null) {
            try {
                fin = new FileInputStream(root.getAbsolutePath() + "/myDir/my_file.txt");
                int c = fin.read();
                while (c != -1) {
                    data += (char) c;
                    c = fin.read();
                }
                fin.close();
                et.setText(data);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void saveToExternal() {

        if(flag)
        {
            String state = Environment.getExternalStorageState();
            if(state.equals(Environment.MEDIA_MOUNTED)) {
                Toast.makeText(UnitFive.this, "External Storage Available !", Toast.LENGTH_SHORT).show();
                File root = getExternalFilesDir(Environment.DIRECTORY_DCIM);

                //For creating the public files (retained after deletion of app)
                    //File root = Environment.getExternalStorageDirectory();
                    //File root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                //For creating the private files (not retained after deletion of app)
                    //File root = getExternalFilesDir(null);
                Toast.makeText(this, root.getAbsolutePath(), Toast.LENGTH_SHORT).show();
                File dir = new File(root.getAbsolutePath() + "/myDir");
                if (!dir.exists())
                    dir.mkdirs();

                File file = new File(dir, "my_file.txt");
                FileOutputStream fileOutputStream = null;
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    fileOutputStream.write(et.getText().toString().getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void retrieveFromInternal() {
        FileInputStream fileInputStream;
        String s = "";
        try {
            fileInputStream  = openFileInput("myFile.txt");
            int i;
            while(true) {
                try {
                    if ((i = fileInputStream.read()) != -1)
                        s= s + (char) i ;
                    else break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            et.setText(s);
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void saveToInternal() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(et.getText().toString());
        String str = stringBuffer.toString();

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput("myFile.txt",MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fileOutputStream.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void retrieveFromSharedPref() {
        String data = shp.getString("data",null);
        et.setText(data);
    }

    private void savetoSharedPref() {
        SharedPreferences.Editor edt = shp.edit();
        edt.putString("data",et.getText().toString());
        edt.apply();
    }

    public void checkStoragePermissions() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                flag = true;
                Toast.makeText(getApplicationContext(), "ALREADY HAVE THE PERMISSIONS !", Toast.LENGTH_SHORT).show();
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1 );
            }
        } else {
            Toast.makeText(getApplicationContext(), "RUNTIME PERMISSIONS NOT SUPPORTED !", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode==1 && grantResults[0]==PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(), "PERMISSIONS GRANTED !", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "PERMISSIONS DENIED !", Toast.LENGTH_SHORT).show();
        }
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
