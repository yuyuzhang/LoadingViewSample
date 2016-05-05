package com.example.yy.loadingviewsample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.loadingview.LoadingView;

public class MainActivity extends AppCompatActivity {
    LoadingView loadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState  ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadingView=(LoadingView)findViewById(R.id.loadingview);
    }
}
