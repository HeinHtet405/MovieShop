package com.koekoetech.movieshop;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private BottomNavigationView mBottomNavigationView;
    private ImageView movieCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        movieCart = (ImageView) findViewById(R.id.movieCart);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        //toolbar
        setSupportActionBar(toolbar);

        setupBottomNavigation();

        if (savedInstanceState == null) {

            loadMyanmarTitleMovieFragment();
        }

        onClickCartMovie();

    }

    private void onClickCartMovie() {
        movieCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.END);
            }
        });
    }

    private void setupBottomNavigation() {

        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.action_myanmar_title:
                        loadMyanmarTitleMovieFragment();
                        return true;
                    case R.id.action_imdb:
                        loadIMDBMovieFragment();
                        return true;
                    case R.id.action_english_title:
                        loadEnglishTitleMovieFragment();
                        return true;
                    case R.id.action_abouts:
                        loadAboutsFragment();
                        return true;
                }
                return false;
            }
        });
    }

    private void loadMyanmarTitleMovieFragment() {

        FragmentMyanmarTitleMovie fragment = FragmentMyanmarTitleMovie.newInstance();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame, fragment);
        ft.commit();
    }

    private void loadIMDBMovieFragment() {

        FragmentIMDBMovie fragment = FragmentIMDBMovie.newInstance();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame, fragment);
        ft.commit();
    }

    private void loadEnglishTitleMovieFragment() {

        FragmentEnglishTitleMovie fragment = FragmentEnglishTitleMovie.newInstance();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame, fragment);
        ft.commit();
    }

    private void loadAboutsFragment() {
        FragmentAbouts fragment = FragmentAbouts.newInstance();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame, fragment);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
            drawerLayout.closeDrawer(GravityCompat.END);
        } else {
            finish();
        }
    }

}
