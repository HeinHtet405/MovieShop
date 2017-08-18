package com.koekoetech.movieshop.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.koekoetech.movieshop.R;

/**
 * Created by Hein Htet on 8/16/2017.
 **/

public class FragmentMovieDetail extends Fragment {

    public static final String ARG_PARAM1 = "param1";
    private String param1;
    private ImageView posterView;

    public static FragmentMovieDetail newInstance(String param1) {
        FragmentMovieDetail fragmentMovieDetail = new FragmentMovieDetail();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragmentMovieDetail.setArguments(args);
        return fragmentMovieDetail;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            param1 = getArguments().getString(ARG_PARAM1);
            Log.i("Hein", "onCreate: "+ param1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        posterView = (ImageView)rootView.findViewById(R.id.moviePoster);
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

                    switch (param1) {
                        case "FragmentMyanmarTitle":
                            FragmentMyanmarTitleMovie fragment = FragmentMyanmarTitleMovie.newInstance("FragmentMovieDetail");
                            FragmentTransaction ft = getFragmentManager().beginTransaction();
                            ft.replace(R.id.fragment_frame, fragment);
                            ft.commit();
                            break;
                        case "FragmentEnglishTitle":
                            FragmentEnglishTitleMovie fragmentEnglishTitleMovie = FragmentEnglishTitleMovie.newInstance("FragmentMovieDetail");
                            FragmentTransaction transactionEng = getFragmentManager().beginTransaction();
                            transactionEng.replace(R.id.fragment_frame, fragmentEnglishTitleMovie);
                            transactionEng.commit();
                            break;
                        case "FragmentIMDBMovie":
                            FragmentIMDBMovie fragmentIMDBMovie = FragmentIMDBMovie.newInstance("FragmentMovieDetail");
                            FragmentTransaction transactionIMDB = getFragmentManager().beginTransaction();
                            transactionIMDB.replace(R.id.fragment_frame, fragmentIMDBMovie);
                            transactionIMDB.commit();
                            break;
                        case "FragmentMovieList":
                            FragmentMovieList fragmentMovieList = FragmentMovieList.newInstance("FragmentMovieDetail");
                            FragmentTransaction transaction = getFragmentManager().beginTransaction();
                            transaction.replace(R.id.fragment_frame, fragmentMovieList);
                            transaction.commit();
                            break;
                    }
                    return true;

                }

                return false;
            }
        });
    }
}
