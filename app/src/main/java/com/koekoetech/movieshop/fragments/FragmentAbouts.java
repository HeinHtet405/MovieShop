package com.koekoetech.movieshop.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koekoetech.movieshop.R;

/**
 * Created by Hein Htet on 8/15/2017.
 **/

public class FragmentAbouts extends Fragment {

    public static FragmentAbouts newInstance() {
        return new FragmentAbouts();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_abouts, container, false);
    }
}
