package com.example.allinonecse225.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.allinonecse225.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_Static extends Fragment {


    public Frag_Static() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag__static, container, false);
    }

}
