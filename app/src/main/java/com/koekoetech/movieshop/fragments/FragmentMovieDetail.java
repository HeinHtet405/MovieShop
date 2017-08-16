package com.koekoetech.movieshop.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koekoetech.movieshop.R;

/**
 * Created by Hein Htet on 8/16/2017.
 **/

public class FragmentMovieDetail extends Fragment {

    public static FragmentMovieDetail newInstance() {
        return new FragmentMovieDetail();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        return rootView;
    }

    @Override
    public void onResume() {

        super.onResume();

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){

                    FragmentMyanmarTitleMovie fragment = FragmentMyanmarTitleMovie.newInstance();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment_frame, fragment);
                    ft.commit();

                    return true;

                }

                return false;
            }
        });
    }
}
