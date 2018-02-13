package com.example.perside.login.vod.vod_tabsAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.perside.login.vod.VodFrenchMovies_tabFragment.ArtsMartiauxFragment;
import com.example.perside.login.vod.VodFrenchMovies_tabFragment.BiopicFragment;
import com.example.perside.login.vod.VodFrenchMovies_tabFragment.FantastiqueFragment;
import com.example.perside.login.vod.VodFrenchMovies_tabFragment.HorreurFragment;
import com.example.perside.login.vod.VodFrenchMovies_tabFragment.PolicierFragment;
import com.example.perside.login.vod.VodFrenchMovies_tabFragment.RomanceFragment;
import com.example.perside.login.vod.VodFrenchMovies_tabFragment.ScienceFictionFragment;
import com.example.perside.login.vod.VodFrenchMovies_tabFragment.DrameFragment;
import com.example.perside.login.vod.VodFrenchMovies_tabFragment.ComedieFragment;
import com.example.perside.login.vod.VodFrenchMovies_tabFragment.AventureFragment;
import com.example.perside.login.vod.VodFrenchMovies_tabFragment.WesternFragment;

/**
 * Created by perside on 1/25/18.
 */

public class FrenchMoviestabsAdapter extends FragmentStatePagerAdapter {
    private int TOTAL_TABS = 11;

    public FrenchMoviestabsAdapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Fragment getItem(int index) {
        // TODO Auto-generated method stub
        switch (index) {
            case 0:
                return new ScienceFictionFragment();

            case 1:
                return new ComedieFragment();

            case 2:
                return new HorreurFragment();

            case 3:
                return new DrameFragment();

            case 4:
                return new AventureFragment();

            case 5:
                return new RomanceFragment();

            case 6:
                return new PolicierFragment();

            case 7:
                return new BiopicFragment();

            case 8:
                return new WesternFragment();

            case 9:
                return new FantastiqueFragment();

            case 10:
                return new ArtsMartiauxFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return TOTAL_TABS;
    }
}
