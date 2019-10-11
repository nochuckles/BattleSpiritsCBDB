package com.example.battlespiritsdb;

import android.net.Uri;
import android.os.Bundle;

import com.example.battlespiritsdb.Fragments.NameFragment;
import com.example.battlespiritsdb.Fragments.RarityFragment;
import com.example.battlespiritsdb.Fragments.SetFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.battlespiritsdb.ui.main.SectionsPagerAdapter;

public class CardFilter extends AppCompatActivity implements NameFragment.OnFragmentInteractionListener,
        SetFragment.OnFragmentInteractionListener,
        RarityFragment.OnFragmentInteractionListener {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_filter);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);



    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}