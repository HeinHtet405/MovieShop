package com.koekoetech.movieshop;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Hein Htet on 8/15/2017.
 **/

public class FragmentIMDBMovie extends Fragment {

    public static FragmentIMDBMovie newInstance() {
        return new FragmentIMDBMovie();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_imdb_movie, container, false);
    }
}
