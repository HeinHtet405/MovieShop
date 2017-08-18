package com.koekoetech.movieshop.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koekoetech.movieshop.R;
import com.koekoetech.movieshop.adapters.IMDBMovieAdapter;
import com.koekoetech.movieshop.model.IMDBMovie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hein Htet on 8/15/2017.
 **/

public class FragmentIMDBMovie extends Fragment implements IMDBMovieAdapter.IMDBMovieListItemClickable {

    private List<IMDBMovie> imdbMovieList = new ArrayList<>();
    private RecyclerView imdbRecyclerView;
    private IMDBMovieAdapter imdbMovieAdapter;

    public static final String ARG_PARAM1 = "param1";

    public static FragmentIMDBMovie newInstance(String param1) {
        FragmentIMDBMovie fragmentIMDBMovie = new FragmentIMDBMovie();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragmentIMDBMovie.setArguments(args);
        return fragmentIMDBMovie;
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
        View rootView = inflater.inflate(R.layout.fragment_imdb_movie, container, false);

        imdbRecyclerView = (RecyclerView) rootView.findViewById(R.id.imdbRecyclerView);

        imdbMovieAdapter = new IMDBMovieAdapter(getActivity(),imdbMovieList);
        imdbRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        imdbRecyclerView.setItemAnimator(new DefaultItemAnimator());
        imdbRecyclerView.setAdapter(imdbMovieAdapter);
        imdbMovieAdapter.setListener(this);

        prepareIMDBData();

        return rootView;
    }

    private void prepareIMDBData() {
        IMDBMovie one = new IMDBMovie(1,"The Shawshank Redemption (1994)","(မြန်မာစာတန်းထိုး)","9.3","https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        imdbMovieList.add(one);

        IMDBMovie two = new IMDBMovie(2,"God Father (1 to 3)","(မြန်မာစာတန်းထိုး)","9.2","https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        imdbMovieList.add(two);

        IMDBMovie three = new IMDBMovie(3,"Dangal (2016)","(မြန်မာစာတန်းထိုး)","9.1","https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        imdbMovieList.add(three);

        IMDBMovie four = new IMDBMovie(4,"Boyka: Undisputed (2017)","(မြန်မာစာတန်းထိုး)","9.0","https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        imdbMovieList.add(four);

        IMDBMovie five = new IMDBMovie(5,"The Dark Knight (2008)","(မြန်မာစာတန်းထိုး)","8.9","https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        imdbMovieList.add(five);

        IMDBMovie six = new IMDBMovie(6,"Imaginary Cat (2015) Complete","(မြန်မာစာတန်းထိုး)","8.8","https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        imdbMovieList.add(six);

        IMDBMovie seven = new IMDBMovie(7,"Schindler’s List (1993)","(မြန်မာစာတန်းထိုး)","8.8","https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        imdbMovieList.add(seven);

        imdbMovieAdapter.notifyDataSetChanged();
    }

    @Override
    public void imdbMovieistItemClickListener() {
        FragmentMovieDetail fragment = FragmentMovieDetail.newInstance("FragmentIMDBMovie");
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame, fragment);
        ft.commit();
    }
}
