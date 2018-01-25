package com.example.perside.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by perside on 11/6/17.
 */

public class LiveChannel extends ActionBarActivity implements android.support.v7.app.ActionBar.TabListener {

    private ViewPager tabsviewPager;
    private ActionBar mActionBar;
    private LiveChanneltapsAdapter mTabsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_channel);

        Intent intent = getIntent();
        String index = intent.getStringExtra("ListIndex1");

        TextView textView = (TextView) findViewById(R.id.textView22);
        textView.setText(index);

            tabsviewPager = (ViewPager) findViewById(R.id.tabspager);

            mTabsAdapter = new LiveChanneltapsAdapter(getSupportFragmentManager());

            tabsviewPager.setAdapter(mTabsAdapter);

            getSupportActionBar().setHomeButtonEnabled(false);
            getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

            ActionBar.Tab friendstab = getSupportActionBar().newTab().setText("All").setTabListener(this);
            ActionBar.Tab publicprofiletab = getSupportActionBar().newTab().setText("Lock channels").setTabListener(this);
            ActionBar.Tab communitytab = getSupportActionBar().newTab().setText("French").setTabListener(this);
            ActionBar.Tab testtab = getSupportActionBar().newTab().setText("English").setTabListener(this);

            getSupportActionBar().addTab(friendstab);
            getSupportActionBar().addTab(publicprofiletab);
            getSupportActionBar().addTab(communitytab);
            getSupportActionBar().addTab(testtab);


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
