package com.example.perside.login.vod;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.example.perside.login.LiveChanneltapsAdapter;
import com.example.perside.login.R;

/**
 * Created by perside on 11/16/17.
 */

public class FrenchMovies extends ActionBarActivity implements android.support.v7.app.ActionBar.TabListener {

    private ViewPager tabsviewPager;
    private ActionBar mActionBar;
    private FrenchMoviestabsAdapter mTabsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_french_movies);

        Intent intent = getIntent();
        String index = intent.getStringExtra("Listvod4");

        TextView textView = (TextView) findViewById(R.id.textView22);
        textView.setText(index);

        tabsviewPager = (ViewPager) findViewById(R.id.tabspager);

        //TODO change to new FrenchMoviestabsAdapter();
        mTabsAdapter = new FrenchMoviestabsAdapter(getSupportFragmentManager());

        tabsviewPager.setAdapter(mTabsAdapter);

        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab scienceFiction = getSupportActionBar().newTab().setText("Science Fiction").setTabListener(this);
        ActionBar.Tab comedie = getSupportActionBar().newTab().setText("Comedie").setTabListener(this);
        ActionBar.Tab horreur = getSupportActionBar().newTab().setText("Horreur").setTabListener(this);
        ActionBar.Tab drame = getSupportActionBar().newTab().setText("Drame").setTabListener(this);
        ActionBar.Tab artMartiaux = getSupportActionBar().newTab().setText("Arts Martiaux").setTabListener(this);
        ActionBar.Tab aventure = getSupportActionBar().newTab().setText("Aventure").setTabListener(this);
        ActionBar.Tab biotic = getSupportActionBar().newTab().setText("Biotic").setTabListener(this);
        ActionBar.Tab fantastique = getSupportActionBar().newTab().setText("Fantastique").setTabListener(this);
        ActionBar.Tab policier = getSupportActionBar().newTab().setText("Policier").setTabListener(this);
        ActionBar.Tab romance = getSupportActionBar().newTab().setText("Romance").setTabListener(this);
        ActionBar.Tab western = getSupportActionBar().newTab().setText("Western").setTabListener(this);

        getSupportActionBar().addTab(scienceFiction);
        getSupportActionBar().addTab(comedie);
        getSupportActionBar().addTab(horreur);
        getSupportActionBar().addTab(drame);
        getSupportActionBar().addTab(artMartiaux);
        getSupportActionBar().addTab(aventure);
        getSupportActionBar().addTab(biotic);
        getSupportActionBar().addTab(fantastique);
        getSupportActionBar().addTab(policier);
        getSupportActionBar().addTab(romance);
        getSupportActionBar().addTab(western);


        //This helps in providing swiping effect for v7 compat library
        tabsviewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                getSupportActionBar().setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });
    }
    @Override
    public void onTabReselected(ActionBar.Tab arg0, FragmentTransaction arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTabSelected(ActionBar.Tab selectedtab, FragmentTransaction arg1) {
        // TODO Auto-generated method stub
        tabsviewPager.setCurrentItem(selectedtab.getPosition()); //update tab position on tap
    }

    @Override
    public void onTabUnselected(ActionBar.Tab arg0, FragmentTransaction arg1) {
        // TODO Auto-generated method stub

    }
}

