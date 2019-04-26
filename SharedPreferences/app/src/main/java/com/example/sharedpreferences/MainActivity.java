package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2,e3,e4;
    Button b1,b2;
    SharedPreferences shp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shp = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE);

        e1 = findViewById(R.id.nameEditText);
        e2 = findViewById(R.id.emailEditText);
        e3 = findViewById(R.id.marksEditText);
        e4 = findViewById(R.id.rollNoEditText);

        b1 = findViewById(R.id.addButton);
        b2 = findViewById(R.id.viewButton);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = e1.getText().toString();
                String email = e2.getText().toString();
                String marks = e3.getText().toString();
                String roll = e4.getText().toString();

                SharedPreferences.Editor edt = shp.edit();
                edt.putString("UNAME", username);
                edt.putString("UEMAIL", email);
                edt.putString("UMARKS", marks);
                edt.putString("UROLL", roll);
                edt.apply();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String username= shp.getString("UNAME", null);
                    String email= shp.getString("UEMAIL", null);
                    String marks= shp.getString("UMARKS", null);
                    String roll= shp.getString("UROLL", null);

                    e1.setText(username);
                    e2.setText(email);
                    e3.setText(marks);
                    e4.setText(roll);

            }
        });
    }
}

/*
public void onCheckboxClicked(View view) {
    // Is the view now checked?
    boolean checked = ((CheckBox) view).isChecked();

    // Check which checkbox was clicked
    switch(view.getId()) {
        case R.id.checkbox_meat:
            if (checked)
                // Put some meat on the sandwich
            else
                // Remove the meat
            break;
        case R.id.checkbox_cheese:
            if (checked)
                // Cheese me
            else
                // I'm lactose intolerant
            break;
        // TODO: Veggie sandwich
    }
}
 */
