package com.example.storage;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private EditText name, email, pass;
    private Button b1,b2,b3,b4,b5;
    private TextView displayData;
    private Boolean flag = false;

    final String fileName = "myFile.txt";
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkStoragePermissions();

        name = findViewById(R.id.nameEditText);
        email = findViewById(R.id.emailEditText);
        pass = findViewById(R.id.passwordEditText);

        b1 = findViewById(R.id.writeToInternal);
        b2 = findViewById(R.id.resetButton);
        b3 = findViewById(R.id.readInternal);
        b4 = findViewById(R.id.writeToExternal);
        b5 = findViewById(R.id.readExternal);

        displayData = findViewById(R.id.dataTextView);

        //write to internal
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(name.getText().toString() + ", ");
                stringBuffer.append(email.getText().toString() + ", ");
                stringBuffer.append(pass.getText().toString() + "\n");

                String string = stringBuffer.toString();

                try {
                    FileOutputStream fileOutputStream = openFileOutput(fileName,MODE_APPEND);
                    fileOutputStream.write(string.getBytes());

                    final AlertDialog builder = new AlertDialog.Builder(MainActivity.this).create();
                    builder.setTitle("File Status");
                    builder.setMessage("Successfully Saved");
                    builder.setCancelable(false);
                    builder.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent goToLoginPage = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(goToLoginPage);
                            builder.dismiss();
                        }
                    });

                    builder.show();
                    fileOutputStream.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //resetData
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                email.setText("");
                pass.setText("");
            }
        });

        //readInternal
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fileInputStream = openFileInput(fileName);
                    int i;
                    String s = "";
                    while ((i = fileInputStream.read()) != -1) {
                        s = s + (char) i;
                    }
                    displayData.setText(s);
                    fileInputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //write to external
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    String state = Environment.getExternalStorageState();
                    if (state.equals(Environment.MEDIA_MOUNTED)) {
                        Toast.makeText(MainActivity.this, "External Storage Available !", Toast.LENGTH_SHORT).show();

                        //For creating the public files (retained after deletion of app)
                        //File root = Environment.getExternalStorageDirectory();
                        //File root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);

                        //For creating the private files (not retained after deletion of app)
                        //File root = getExternalFilesDir(null);

                        File root = getExternalFilesDir(Environment.DIRECTORY_DCIM);

                        Toast.makeText(MainActivity.this, root.getAbsolutePath(), Toast.LENGTH_SHORT).show();

                        File dir = new File(root.getAbsolutePath() + "/myDir");

                           if (!dir.exists())
                            dir.mkdirs();

                        file = new File(dir, "my_file.txt");
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file);

                            StringBuffer sb = new StringBuffer();
                            sb.append(name.getText().toString());
                            sb.append(", " + email.getText().toString());
                            sb.append(", " + pass.getText().toString() + "\n");
                            String string = sb.toString();
                            fileOutputStream.write(string.getBytes());

                            Toast.makeText(MainActivity.this, "Write Process Successful", Toast.LENGTH_SHORT).show();

                            fileOutputStream.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else {
                        Toast.makeText(MainActivity.this, "External Storage Not Available !", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //readExternal
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    File root = getExternalFilesDir(Environment.DIRECTORY_DCIM);
                    FileInputStream fin = null;
                    if (root != null) {
                        fin = new FileInputStream(root.getAbsolutePath()+"/myDir/my_file.txt");
                    }
                    String data = "";
                    int c = fin.read();
                    while(c!=-1) {
                        data += (char) c;
                        c = fin.read();
                    }
                    fin.close();
                    Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT).show();
                    displayData.setText(data);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }


    public void checkStoragePermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                flag = true;    //
                Toast.makeText(getApplicationContext(), "ALREADY HAVE THE PERMISSIONS !", Toast.LENGTH_SHORT).show();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        } else
            Toast.makeText(getApplicationContext(), "RUNTIME PERMISSION NOT SUPPORTED !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getApplicationContext(), "PERMISSION GRANTED THANK YOU!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "PERMISSION DENIED !", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
