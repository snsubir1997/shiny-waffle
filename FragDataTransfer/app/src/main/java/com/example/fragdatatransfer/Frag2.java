package com.example.fragdatatransfer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Frag2 extends Fragment {

    EditText et1,et2;
    Button b1;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_frag2, container, false);

        et1 = v.findViewById(R.id.et1);
        et2 = v.findViewById(R.id.et2);
        b1 = v.findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity m = (MainActivity) getActivity();
                m.recieve(et1.getText().toString(),et2.getText().toString());
            }
        });
        return v;
    }

}
