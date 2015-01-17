package com.triadslabs.internetcafe.base;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.triadslabs.internetcafe.R;
import com.triadslabs.internetcafe.actionbar.BaseActionBarView;
import com.triadslabs.internetcafe.utils.ReflectionUtils;


/**
 * Created by MuzammilPeer on 1/4/2015.
 */
abstract public class BaseActionBarActivity  extends BaseActivity
{

    private DrawerLayout mDrawerLayout;
    protected ActionBarDrawerToggle mDrawerToggle;
    protected CharSequence mTitle;

    //private View actionbarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (findViewById(android.R.id.home) != null) {
            findViewById(android.R.id.home).setVisibility(View.GONE);
        }

        mTitle = getTitle();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
                GravityCompat.START | GravityCompat.END);

        lockLeftDrawer();
        lockRightDrawer();
//        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, findViewById(R.id.right_drawer));
//        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, findViewById(R.id.left_drawer));

        //Drawer Listener
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

    public  void  lockLeftDrawer()
    {
        lockUnlockDrawer(false,R.id.left_drawer,mDrawerLayout);
    }

    public  void  lockRightDrawer()
    {
        lockUnlockDrawer(false,R.id.right_drawer,mDrawerLayout);
    }


    //override it's implementation in child class for listview reference
    protected void openCloseDrawer(boolean isOpen,View listView)
    {
        if (isOpen)
        {
            mDrawerLayout.openDrawer(listView);
        }else {
            mDrawerLayout.closeDrawer(listView);
        }
    }

    //actionbar customization
//    private BaseActionBarView setupCustomActionBar(int resourceID,Class customBarClass)
//    {
//        BaseActionBarView customBar = (BaseActionBarView)ReflectionUtils.instantiate(customBarClass);
//        View actionbarView = getLayoutInflater().inflate(resourceID,
//                null);
//        getSupportActionBar().setCustomView(null);
//        getSupportActionBar().setCustomView(actionbarView);
//        customBar.initializeViews(actionbarView);
////        ReflectionUtils.callMethod("initializeViews",View.class,actionbarView,customBar.getClass(),customBar);
//        return customBar;
//    }
//
//    private void updateCustomActionBar(Object model,Object customBar)
//    {
//        ReflectionUtils.callMethod("updateCell",Object.class,model,customBar.getClass(),customBar);
//    }
//
    public void initializeCustomActionBar(int rID,Class barClass,Object model)
    {
        BaseActionBarView customBar = (BaseActionBarView)ReflectionUtils.instantiate(barClass);
        View actionbarView = getLayoutInflater().inflate(rID,
                null);
        getSupportActionBar().setCustomView(null);
        getSupportActionBar().setCustomView(actionbarView);

        //setup childerens views
        customBar.initializeViews(actionbarView);
        //update with model
        customBar.updateCell(model);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        initializeCustomActionBar(R.layout.actionbar_header,DrawerActionBarView.class,new DrawerItem(getString(R.string.menu_item_search), R.drawable.ic_action_search) );

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
        //setContentView(R.layout.myLayout);
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

    protected void SelectItem(int position,Context mcontext,Object model,ListView drawerListView)
    {
        mDrawerLayout.closeDrawer(drawerListView);
    }
//    public DrawerLayout getmDrawerLayout() {
//        return mDrawerLayout;
//    }
//
//    public void setmDrawerLayout(DrawerLayout mDrawerLayout) {
//        this.mDrawerLayout = mDrawerLayout;
//    }
//
//    public ActionBarDrawerToggle getmDrawerToggle() {
//        return mDrawerToggle;
//    }
//
//    public void setmDrawerToggle(ActionBarDrawerToggle mDrawerToggle) {
//        this.mDrawerToggle = mDrawerToggle;
//    }
//
//    public CharSequence getmTitle() {
//        return mTitle;
//    }
//
//    public void setmTitle(CharSequence mTitle) {
//        this.mTitle = mTitle;
//    }
}
