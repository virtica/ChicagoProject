package com.virtica.chicagoproject;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;

/**
 * Created by Virtica on 7/13/13.
 */
public class EventsActivity extends SherlockActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }
}