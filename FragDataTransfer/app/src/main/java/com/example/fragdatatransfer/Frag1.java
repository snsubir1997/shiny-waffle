package com.example.fragdatatransfer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Frag1 extends Fragment {
    TextView t1,t2;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v;
        v= inflater.inflate(R.layout.fragment_frag1, container, false);

        t1 = v.findViewById(R.id.t1);
        t2 = v.findViewById(R.id.t2);
        Bundle b1 = getArguments();
        if(b1!=null)
        {
            t1.setText(b1.getString("name"));
            t2.setText(b1.getString("regno"));
        }

        return v;
    }

}
