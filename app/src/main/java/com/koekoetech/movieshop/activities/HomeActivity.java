package com.koekoetech.movieshop.activities;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.koekoetech.movieshop.R;
import com.koekoetech.movieshop.adapters.CartItemAdapter;
import com.koekoetech.movieshop.fragments.FragmentAbouts;
import com.koekoetech.movieshop.fragments.FragmentEnglishTitleMovie;
import com.koekoetech.movieshop.fragments.FragmentIMDBMovie;
import com.koekoetech.movieshop.fragments.FragmentMyanmarTitleMovie;
import com.koekoetech.movieshop.model.CartItem;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private BottomNavigationView mBottomNavigationView;
    private ImageView movieCart;
    private List<CartItem> cartItemList = new ArrayList<>();
    private RecyclerView cartRecyclerView;
    private CartItemAdapter cartItemAdapter;
    private RelativeLayout mainTotalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        movieCart = (ImageView) findViewById(R.id.movieCart);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mainTotalAmount = (RelativeLayout) findViewById(R.id.mainTotalAmount);
        //toolbar
        setSupportActionBar(toolbar);

        setupBottomNavigation();

        if (savedInstanceState == null) {

            loadMyanmarTitleMovieFragment();
        }

        onClickCartMovie();

        cartRecyclerView = (RecyclerView) findViewById(R.id.cartRecyclerView);
        cartItemAdapter = new CartItemAdapter(getApplicationContext(), cartItemList);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        cartRecyclerView.setItemAnimator(new DefaultItemAnimator());
        cartRecyclerView.setAdapter(cartItemAdapter);

        cartRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    mainTotalAmount.setVisibility(View.GONE);
                } else {
                    mainTotalAmount.setVisibility(View.VISIBLE);
                }
            }
        });

        prepareCartData();
    }

    private void prepareCartData() {
        CartItem one = new CartItem("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg", "The Shawshank Redemption", "(English)", "100Ks");
        cartItemList.add(one);

        CartItem two = new CartItem("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg", "God Father (1 to 3)", "(မြန်မာစာတန်းထိုး)", "100Ks");
        cartItemList.add(two);

        CartItem three = new CartItem("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg", "God Father (1 to 3)", "(မြန်မာစာတန်းထိုး)", "100Ks");
        cartItemList.add(three);

        CartItem four = new CartItem("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg", "God Father (1 to 3)", "(မြန်မာစာတန်းထိုး)", "100Ks");
        cartItemList.add(four);

        CartItem five = new CartItem("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg", "God Father (1 to 3)", "(မြန်မာစာတန်းထိုး)", "100Ks");
        cartItemList.add(five);

        CartItem six = new CartItem("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg", "God Father (1 to 3)", "(မြန်မာစာတန်းထိုး)", "100Ks");
        cartItemList.add(six);

        CartItem seven = new CartItem("https://i.pinimg.com/originals/28/89/9e/28899ebf1d1d899f78aaa656894d9781.jpg", "God Father", "(မြန်မာစာတန်းထိုး)", "100Ks");
        cartItemList.add(seven);

        cartItemAdapter.notifyDataSetChanged();
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

        FragmentMyanmarTitleMovie fragment = FragmentMyanmarTitleMovie.newInstance("HomeActivity");
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame, fragment);
        ft.commit();
    }

    private void loadIMDBMovieFragment() {

        FragmentIMDBMovie fragment = FragmentIMDBMovie.newInstance("HomeActivity");
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame, fragment);
        ft.commit();
    }

    private void loadEnglishTitleMovieFragment() {

        FragmentEnglishTitleMovie fragment = FragmentEnglishTitleMovie.newInstance("HomeActivity");
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame, fragment);
        ft.commit();
    }

    private void loadAboutsFragment() {
        FragmentAbouts fragment = FragmentAbouts.newInstance("HomeActivity");
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
