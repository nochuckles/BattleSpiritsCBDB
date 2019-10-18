package com.example.battlespiritsdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;


public class MainActivity extends AppCompatActivity {

    private View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        decorView = getWindow().getDecorView();

    }

    public void onClick(View view) {
        Intent myIntent = null;

        switch (view.getId()) {
            case R.id.agumon:
                myIntent = new Intent(this, CardListActivity.class);
                break;
            case R.id.gabumon:
                myIntent = new Intent(this, StockActivity.class);
                break;
            case R.id.panchomon:
                myIntent = new Intent(this, CardFilter.class);
                break;
            case R.id.FedericoGarciaLorca:
                myIntent = new Intent(this, CardsLeftActivity.class);
                break;

        }

        if (myIntent != null) {
            startActivity(myIntent);
        }
    }

    /*@Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }*/

    public static int hideSystemBars() {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

    }
}
