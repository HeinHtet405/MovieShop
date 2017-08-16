package com.koekoetech.movieshop.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koekoetech.movieshop.R;
import com.koekoetech.movieshop.adapters.CategoryAdapter;
import com.koekoetech.movieshop.adapters.MovieAdapter;
import com.koekoetech.movieshop.model.Category;
import com.koekoetech.movieshop.model.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hein Htet on 8/15/2017.
 **/

public class FragmentMyanmarTitleMovie extends Fragment {

    private List<Category> categoryList = new ArrayList<>();
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView categoryRecyclerView,movieRecyclerView;
    private CategoryAdapter categoryAdapter;
    private MovieAdapter movieAdapter;

    public static FragmentMyanmarTitleMovie newInstance() {
        return new FragmentMyanmarTitleMovie();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_myanmar_title_movie, container, false);

        categoryRecyclerView = (RecyclerView) rootView.findViewById(R.id.categoryRecyclerView);
        movieRecyclerView = (RecyclerView) rootView.findViewById(R.id.newMoviesRecyclerView);

        categoryRecyclerView.setNestedScrollingEnabled(false);
        movieRecyclerView.setNestedScrollingEnabled(false);

        categoryAdapter = new CategoryAdapter(categoryList);
        movieAdapter = new MovieAdapter(getActivity(),movieList);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        movieRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryRecyclerView.setItemAnimator(new DefaultItemAnimator());
        categoryRecyclerView.setAdapter(categoryAdapter);
        movieRecyclerView.setAdapter(movieAdapter);

        prepareCategoryData();
        prepareMoviesData();
        return rootView;
    }

    private void prepareCategoryData() {

        Category one = new Category("Action");
        categoryList.add(one);

        Category two = new Category("Bollywood");
        categoryList.add(two);

        Category three = new Category("Comedy");
        categoryList.add(three);

        Category four = new Category("Asian");
        categoryList.add(four);

        Category five = new Category("007");
        categoryList.add(five);

        Category six = new Category("Cartoon");
        categoryList.add(six);

        Category seven = new Category("Series");
        categoryList.add(seven);

        categoryAdapter.notifyDataSetChanged();
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

        movieAdapter.notifyDataSetChanged();
    }
}
