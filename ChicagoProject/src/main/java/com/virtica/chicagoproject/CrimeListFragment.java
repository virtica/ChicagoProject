package com.virtica.chicagoproject;

import android.app.Activity;

import com.actionbarsherlock.app.SherlockListFragment;

/**
 * Created by Virtica on 7/13/13.
 */
public class CrimeListFragment extends SherlockListFragment {

    OnCrimeSelectedListener mCallback;

    public interface OnCrimeSelectedListener {
        public void onCrimeDetailSelected(int position);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnCrimeSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnCrimeSelectedListener");
        }
    }


}
