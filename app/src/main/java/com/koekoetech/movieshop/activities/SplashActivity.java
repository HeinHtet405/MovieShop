package com.koekoetech.movieshop.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.koekoetech.movieshop.R;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryText));
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryText));
        }
        setContentView(R.layout.activity_splash);
        int SPLASH_TIME_OUT = 1000;
        new Handler().postDelayed(new Runnable() {
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}