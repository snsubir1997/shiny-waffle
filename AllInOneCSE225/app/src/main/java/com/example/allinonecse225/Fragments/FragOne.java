package com.example.allinonecse225.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.allinonecse225.MainActivity;
import com.example.allinonecse225.R;
import com.example.allinonecse225.UnitThree;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragOne extends Fragment {

    EditText et;

    public FragOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_frag_one, container, false);

        
        return inflater.inflate(R.layout.fragment_frag_one, container, false);
    }

}
