package com.virtica.chicagoproject;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;

/**
 * Created by Virtica on 7/13/13.
 */
public class CrimeActivity extends SherlockFragmentActivity {

    @Override
    public  void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crime_entries);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.crimefragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create an instance of ExampleFragment
            CrimeListFragment firstFragment = new CrimeListFragment();

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.crimefragment_container, firstFragment).commit();
        }


    }

}
