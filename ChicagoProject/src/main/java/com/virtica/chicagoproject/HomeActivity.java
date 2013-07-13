package com.virtica.chicagoproject;


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;


public class HomeActivity extends BaseActivity {

    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    ActionBarDrawerToggle mDrawerToggle;
    String[] mSectionTitles;
    CharSequence mTitle;
    CharSequence mDrawerTitle;

    LocationListener mlocListener;
    LocationManager mlocManager;
    TextView txtWardName;
    TextView txtDistrictName;
    String wardName;
    String districtName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getUserLocation();

        mTitle = mDrawerTitle = getTitle();
        mSectionTitles = getResources().getStringArray(R.array.sections_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mSectionTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        this.mlocManager = ((LocationManager)getSystemService("location"));
        this.mlocListener = new MyLocation();
        this.mlocManager.requestLocationUpdates("network", 0L, 0.0F, this.mlocListener);

        SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.drawable.ic_drawer,R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        return super.onPrepareOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
                mDrawerLayout.closeDrawer(mDrawerList);
            } else {
                mDrawerLayout.openDrawer(mDrawerList);
            }
        }

        return super.onOptionsItemSelected(item);
    }



    private void getUserLocation(){

    }


    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    public void selectItem(int position){
        switch(position) {
            case 1:
                Intent a = new Intent(HomeActivity.this, NeighborhoodActivity.class);
                startActivity(a);
                break;
            case 2:
                Intent b = new Intent(HomeActivity.this, EventsActivity.class);
                startActivity(b);
                break;
            case 3:
                Intent c = new Intent(HomeActivity.this, CommunityConcernActivity.class);
                startActivity(c);
                break;
            default:
        }
        mDrawerList.setItemChecked(position, true);

        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public void setTitle(CharSequence title){
        mTitle = title;
        getActionBar().setTitle(mTitle);

    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }



    public class MyLocation implements LocationListener{

        public  MyLocation(){

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {
            Toast.makeText(HomeActivity.this.getApplicationContext(), "GPS Enabled", 0).show();
        }

        @Override
        public void onProviderDisabled(String provider) {
            Toast.makeText(HomeActivity.this.getApplicationContext(), "GPS is disabled", 0).show();
        }

        public void onLocationChanged(Location location){

            if (location.hasAccuracy()){
                location.getLatitude();
                location.getLongitude();

            }
        }

    }
}
