package com.example.perside.login.livechannel_tabsfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.perside.login.R;

/**
 * Created by perside on 11/20/17.
 */

public class LockChannelFragment extends android.support.v4.app.Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.lockchannels_view, container, false);

        return view;
    }
}
