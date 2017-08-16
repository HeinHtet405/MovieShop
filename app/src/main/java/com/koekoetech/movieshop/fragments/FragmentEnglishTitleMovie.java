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

public class FragmentEnglishTitleMovie extends Fragment {

    private List<Category> categoryList = new ArrayList<>();
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView alphabetRecyclerView,englishMovieRecyclerView;
    private CategoryAdapter categoryAdapter;
    private MovieAdapter movieAdapter;

    public static FragmentEnglishTitleMovie newInstance() {
        return new FragmentEnglishTitleMovie();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_english_title_movie, container, false);

        alphabetRecyclerView = (RecyclerView) rootView.findViewById(R.id.alphabetRecyclerView);
        englishMovieRecyclerView = (RecyclerView) rootView.findViewById(R.id.englishMovieRecyclerView);

        alphabetRecyclerView.setNestedScrollingEnabled(false);
        englishMovieRecyclerView.setNestedScrollingEnabled(false);

        categoryAdapter = new CategoryAdapter(categoryList);
        movieAdapter = new MovieAdapter(getActivity(),movieList);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        englishMovieRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        alphabetRecyclerView.setLayoutManager(layoutManager);
        alphabetRecyclerView.setItemAnimator(new DefaultItemAnimator());
        alphabetRecyclerView.setAdapter(categoryAdapter);
        englishMovieRecyclerView.setAdapter(movieAdapter);

        prepareAlphabetData();
        prepareEnglishMoviesData();
        return rootView;
    }

    private void prepareAlphabetData() {

        Category one = new Category("A");
        categoryList.add(one);

        Category two = new Category("B");
        categoryList.add(two);

        Category three = new Category("C");
        categoryList.add(three);

        Category four = new Category("D");
        categoryList.add(four);

        Category five = new Category("E");
        categoryList.add(five);

        Category six = new Category("F");
        categoryList.add(six);

        Category seven = new Category("G");
        categoryList.add(seven);

        categoryAdapter.notifyDataSetChanged();
    }

    private void prepareEnglishMoviesData() {

        Movie one = new Movie("http://www.hollywoodreporter.com/sites/default/files/custom/Blog_Images/avengers-movie-poster-1.jpg");
        movieList.add(one);

        Movie two = new Movie("http://www.hollywoodreporter.com/sites/default/files/custom/Blog_Images/avengers-movie-poster-1.jpg");
        movieList.add(two);

        Movie three = new Movie("http://www.hollywoodreporter.com/sites/default/files/custom/Blog_Images/avengers-movie-poster-1.jpg");
        movieList.add(three);

        Movie four = new Movie("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        movieList.add(four);

        Movie five = new Movie("http://www.hollywoodreporter.com/sites/default/files/custom/Blog_Images/avengers-movie-poster-1.jpg");
        movieList.add(five);

        Movie six = new Movie("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        movieList.add(six);

        Movie seven = new Movie("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg");
        movieList.add(seven);

        Movie eight = new Movie("http://www.hollywoodreporter.com/sites/default/files/custom/Blog_Images/avengers-movie-poster-1.jpg");
        movieList.add(eight);

        Movie nine = new Movie("http://www.hollywoodreporter.com/sites/default/files/custom/Blog_Images/avengers-movie-poster-1.jpg");
        movieList.add(nine);

        Movie ten = new Movie("http://www.hollywoodreporter.com/sites/default/files/custom/Blog_Images/avengers-movie-poster-1.jpg");
        movieList.add(ten);

        Movie eleven = new Movie("http://www.hollywoodreporter.com/sites/default/files/custom/Blog_Images/avengers-movie-poster-1.jpg");
        movieList.add(eleven);

        Movie twelve = new Movie("http://www.hollywoodreporter.com/sites/default/files/custom/Blog_Images/avengers-movie-poster-1.jpg");
        movieList.add(twelve);

        Movie thirteen = new Movie("http://www.hollywoodreporter.com/sites/default/files/custom/Blog_Images/avengers-movie-poster-1.jpg");
        movieList.add(thirteen);

        movieAdapter.notifyDataSetChanged();
    }
}
