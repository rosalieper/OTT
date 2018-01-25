package com.example.perside.login;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.perside.login.livechannel_tabsfragment.AllChannelFragment;
import com.example.perside.login.livechannel_tabsfragment.EnglishChannelFragment;
import com.example.perside.login.livechannel_tabsfragment.FrenchChannelFragmnet;
import com.example.perside.login.livechannel_tabsfragment.LockChannelFragment;

/**
 * Created by perside on 11/20/17.
 */

public class LiveChanneltapsAdapter extends FragmentStatePagerAdapter {
    private int TOTAL_TABS = 4;

    public LiveChanneltapsAdapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Fragment getItem(int index) {
        // TODO Auto-generated method stub
        switch (index) {
            case 0:
                return new AllChannelFragment();

            case 1:
                return new LockChannelFragment();

            case 2:
                return new EnglishChannelFragment();

            case 3:
                return new FrenchChannelFragmnet();
        }

        return null;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return TOTAL_TABS;
    }
}
