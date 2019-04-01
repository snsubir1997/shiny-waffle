package com.example.testing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText e1,e2;
    private DatePicker dp1;
    private Button b1,b2;
    private EmailValidator mEmailValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.nameEditText);
        e2 = findViewById(R.id.emailEditText);
        dp1 = findViewById(R.id.dateOfBirthInput);
        b1 = findViewById(R.id.saveButton);
        b2 = findViewById(R.id.resetButton);

        mEmailValidator = new EmailValidator();
        e2.addTextChangedListener(mEmailValidator);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mEmailValidator.isValid()) {
                    e2.setError("Invalid email");
                    Log.w(TAG, "Not saving personal information: Invalid email");
                    return;
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Personal information reverted", Toast.LENGTH_LONG).show();
                Log.i(TAG, "Personal information reverted");
            }
        });

    }
}
