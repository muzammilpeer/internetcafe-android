package com.triadslabs.internetcafe.base;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.triadslabs.internetcafe.R;
import com.triadslabs.internetcafe.fragment.FragmentOne;
import com.triadslabs.internetcafe.fragment.FragmentThree;
import com.triadslabs.internetcafe.fragment.FragmentTwo;
import com.triadslabs.internetcafe.model.DrawerItem;


/**
 * Created by MuzammilPeer on 1/4/2015.
 */
abstract public class BaseActionBarActivity  extends ActionBarActivity
{

    private DrawerLayout mDrawerLayout;
    protected ActionBarDrawerToggle mDrawerToggle;
    protected CharSequence mTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mTitle = getTitle();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
                GravityCompat.START|GravityCompat.END);

        //Drawer Listner
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_drawer, R.string.drawer_open,
                R.string.drawer_close) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to
                // onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to
                // onPrepareOptionsMenu()
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    public void SelectItem(int position,Context mcontext,Object model,ListView drawerListView) {
        if (model instanceof DrawerItem) {
            DrawerItem item = (DrawerItem)model;

            Fragment fragment = null;
            Bundle args = new Bundle();
            switch (position) {
                case 0:
                    fragment = new FragmentOne();
                    args.putString(FragmentOne.ITEM_NAME, item
                            .getItemName());
                    args.putInt(FragmentOne.IMAGE_RESOURCE_ID, item
                            .getImgResID());
                    break;
                case 1:
                    fragment = new FragmentTwo();
                    args.putString(FragmentTwo.ITEM_NAME, item
                            .getItemName());
                    args.putInt(FragmentTwo.IMAGE_RESOURCE_ID, item
                            .getImgResID());
                    break;
                case 2:
                    fragment = new FragmentThree();
                    args.putString(FragmentThree.ITEM_NAME, item
                            .getItemName());
                    args.putInt(FragmentThree.IMAGE_RESOURCE_ID, item
                            .getImgResID());
                    break;
                default:
                    fragment = new FragmentThree();
                    args.putString(FragmentOne.ITEM_NAME, item
                            .getItemName());
                    args.putInt(FragmentThree.IMAGE_RESOURCE_ID, item
                            .getImgResID());
            }

            fragment.setArguments(args);
            FragmentManager frgManager = ((Activity)mcontext).getFragmentManager();
            frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                    .commit();

            drawerListView.setItemChecked(position, true);
            super.setTitle(item.getItemName());
            mDrawerLayout.closeDrawer(drawerListView);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
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
        // Pass any configuration change to the drawer toggles
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return false;
    }
}
