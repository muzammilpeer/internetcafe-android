package com.triadslabs.internetcafe.base;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import com.triadslabs.internetcafe.R;
import com.triadslabs.internetcafe.utils.ReflectionUtils;

/**
 * Created by MuzammilPeer on 1/4/2015.
 */
abstract public class BaseActivity extends ActionBarActivity {

    protected BaseActionBarToolbarView currentToolBar;

    public BaseActivity() {
        super();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void initializeCustomToolbar(int rID,Class barClass,Object model)
    {
        BaseActionBarView customBar = (BaseActionBarView) ReflectionUtils.instantiate(barClass);
        currentToolBar = (BaseActionBarToolbarView)this.findViewById(rID);
        if (currentToolBar != null && customBar != null) {
            customBar.initializeViews(currentToolBar);
            customBar.updateCell(model);
            setSupportActionBar(currentToolBar);
//            currentToolBar.addView(actionbarView);
//            //setup childrens views
//            customBar.initializeViews(actionbarView);
//            //update with model
//            customBar.updateCell(model);
//            setSupportActionBar(currentToolBar);

        }
    }

//    public void initializeCustomToolbar(View view,int rID,Class barClass,Object model)
//    {
//        BaseActionBarView customBar = (BaseActionBarView) ReflectionUtils.instantiate(barClass);
//        View actionbarView = getLayoutInflater().inflate(rID,
//                null);
//        currentToolBar = (BaseActionBarToolbarView)view.findViewById(R.id.myToolbar);
//        if (currentToolBar != null) {
//            currentToolBar.updateCell(model);
////            currentToolBar.addView(actionbarView);
////            //setup childrens views
////            customBar.initializeViews(actionbarView);
////            //update with model
////            customBar.updateCell(model);
////            setSupportActionBar(currentToolBar);
//
//        }
//    }
//    public void showHideActionBar(boolean isShow,boolean isCustom)
//    {
//        getSupportActionBar().setDisplayHomeAsUpEnabled(isCustom ? false : isShow);
//        getSupportActionBar().setHomeButtonEnabled(isCustom ? false : isShow);
//        getSupportActionBar().setDisplayShowTitleEnabled(isCustom ? false : isShow);
//        getSupportActionBar().setDisplayShowCustomEnabled(isCustom);
//
//
//        if (isShow)
//            getSupportActionBar().show();
//        else
//            getSupportActionBar().hide();
//
//    }



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
