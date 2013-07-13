package com.virtica.chicagoproject;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Virtica on 7/13/13.
 */
public class MapActivity extends SherlockFragmentActivity {
        static final LatLng CHICAGO = new LatLng(41.8500, -87.6500);
        static final LatLng CICERO = new LatLng(41.50, 187.45);
        private GoogleMap map;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_map);



        // Do a null check to confirm that we have not already instantiated the map.
        if (map == null) {
            // Try to obtain the map from the SupportMapFragment.
            map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (map != null) {

                map.addMarker(new MarkerOptions().position(CHICAGO).title("Marker"));
            }
        }
        }
}