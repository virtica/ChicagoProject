package com.virtica.chicagoproject;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;

import com.actionbarsherlock.app.SherlockFragmentActivity;

/**
 * Created by Virtica on 7/13/13.
 */
public class CrimeTabFragment extends SherlockFragmentActivity {
    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.crime_main);
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.maintabcontent);
        mTabHost.addTab(mTabHost.newTabSpec("list").setIndicator("List"),
                CrimeActivity.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("map").setIndicator("Map"),
                MapActivity.class, null);
    }
}
