package com.koekoetech.movieshop.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koekoetech.movieshop.R;
import com.koekoetech.movieshop.adapters.MovieListAdapter;
import com.koekoetech.movieshop.model.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hein Htet on 8/16/2017.
 **/

public class FragmentMovieList extends Fragment implements MovieListAdapter.MovieListItemClickable {

    public static final String ARG_PARAM1 = "param1";
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView movieListRecyclerView;
    private MovieListAdapter movieListAdapter;

    public static FragmentMovieList newInstance(String param1) {
        FragmentMovieList fragmentMovieList = new FragmentMovieList();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragmentMovieList.setArguments(args);
        return fragmentMovieList;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String param1 = getArguments().getString(ARG_PARAM1);
            Log.i("Hein", "onCreate: " + param1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movie_list, container, false);

        movieListRecyclerView = (RecyclerView) rootView.findViewById(R.id.movieListRecyclerView);
        movieListAdapter = new MovieListAdapter(getActivity(), movieList);
        movieListRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        movieListRecyclerView.setAdapter(movieListAdapter);
        movieListAdapter.setListener(this);

        prepareMoviesData();

        return rootView;
    }

    private void prepareMoviesData() {

        Movie one = new Movie("http://gdj.graphicdesignjunction.com/wp-content/uploads/2011/12/grey-movie-poster.jpg");
        movieList.add(one);

        Movie two = new Movie("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        movieList.add(two);

        Movie three = new Movie("https://s-media-cache-ak0.pinimg.com/originals/6c/35/67/6c35676d384779f3499f06aa3061af35.jpg");
        movieList.add(three);

        Movie four = new Movie("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        movieList.add(four);

        Movie five = new Movie("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        movieList.add(five);

        Movie six = new Movie("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        movieList.add(six);

        Movie seven = new Movie("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        movieList.add(seven);

        Movie eight = new Movie("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        movieList.add(eight);

        Movie nine = new Movie("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        movieList.add(nine);

        Movie ten = new Movie("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        movieList.add(ten);

        Movie eleven = new Movie("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        movieList.add(eleven);

        Movie twelve = new Movie("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        movieList.add(twelve);

        Movie thirteen = new Movie("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        movieList.add(thirteen);

        Movie fourteen = new Movie("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        movieList.add(fourteen);

        Movie fifteen = new Movie("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        movieList.add(fifteen);

        Movie sixteen = new Movie("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        movieList.add(sixteen);

        Movie seventy = new Movie("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        movieList.add(seventy);

        Movie eighteen = new Movie("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        movieList.add(eighteen);

        movieListAdapter.notifyDataSetChanged();
    }


    @Override
    public void onResume() {

        super.onResume();

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {

                    FragmentMyanmarTitleMovie fragment = FragmentMyanmarTitleMovie.newInstance("");
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment_frame, fragment);
                    ft.commit();

                    return true;

                }

                return false;
            }
        });
    }

    @Override
    public void movieListItemClickListener() {
        FragmentMovieDetail fragment = FragmentMovieDetail.newInstance("FragmentMovieList");
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame, fragment);
        ft.commit();
    }
}
