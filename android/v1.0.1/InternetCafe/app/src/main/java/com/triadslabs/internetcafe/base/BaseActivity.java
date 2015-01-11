package com.triadslabs.internetcafe.base;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import com.triadslabs.internetcafe.R;

/**
 * Created by MuzammilPeer on 1/4/2015.
 */
abstract public class BaseActivity extends ActionBarActivity {

    public BaseActivity() {
        super();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        showHideActionBar(false,false);
        showHideTabs(false);
    }

    public void showHideActionBar(boolean isShow,boolean isCustom)
    {
        getSupportActionBar().setDisplayHomeAsUpEnabled(isCustom ? false : isShow);
        getSupportActionBar().setHomeButtonEnabled(isCustom ? false : isShow);
        getSupportActionBar().setDisplayShowTitleEnabled(isCustom ? false : isShow);
        getSupportActionBar().setDisplayShowCustomEnabled(isCustom);


        if (isShow)
            getSupportActionBar().show();
        else
            getSupportActionBar().hide();

    }

    public  void  lockUnlockDrawer(boolean isOpen,int resourceID,DrawerLayout drawerLayout)
    {
        drawerLayout.setDrawerLockMode(isOpen ? DrawerLayout.LOCK_MODE_UNLOCKED : DrawerLayout.LOCK_MODE_LOCKED_CLOSED , findViewById(resourceID));
    }

//    public  void  lockRightDrawer()
//    {
//        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, findViewById(R.id.right_drawer));
//    }

    public void replaceFragment(BaseFragment fragment)
    {
        android.support.v4.app.FragmentManager frgManager = this.getSupportFragmentManager();
        frgManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }

    public void showHideTabs(boolean isShow) {
        getSupportActionBar().setNavigationMode(isShow ? ActionBar.NAVIGATION_MODE_TABS : ActionBar.NAVIGATION_MODE_STANDARD);
    }
}
