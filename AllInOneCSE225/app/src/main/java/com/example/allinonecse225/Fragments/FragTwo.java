package com.example.allinonecse225.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.allinonecse225.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragTwo extends Fragment {

    TextView t1;

    public FragTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v;
        v= inflater.inflate(R.layout.fragment_frag_two, container, false);

        t1 = v.findViewById(R.id.showfragonedata);
        Bundle b1 = getArguments();
        if(b1!=null)
        {
            t1.setText(b1.getString("text"));
        }
        return inflater.inflate(R.layout.fragment_frag_two, container, false);
    }

}
