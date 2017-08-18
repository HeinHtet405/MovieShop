package com.koekoetech.movieshop.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koekoetech.movieshop.R;

/**
 * Created by Hein Htet on 8/15/2017.
 **/

public class FragmentAbouts extends Fragment {

    public static final String ARG_PARAM1 = "param1";

    public static FragmentAbouts newInstance(String param1) {
        FragmentAbouts fragmentAbouts = new FragmentAbouts();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragmentAbouts.setArguments(args);
        return fragmentAbouts;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String param1 = getArguments().getString(ARG_PARAM1);
            Log.i("Hein", "onCreate: "+ param1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_abouts, container, false);
    }
}
