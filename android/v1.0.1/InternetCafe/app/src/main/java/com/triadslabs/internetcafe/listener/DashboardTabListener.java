package com.triadslabs.internetcafe.listener;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;

import com.triadslabs.internetcafe.fragment.DashboardFragment;
import com.triadslabs.internetcafe.listener.base.ActionBarTabListener;

/**
 * Created by MuzammilPeer on 1/17/2015.
 */
public class DashboardTabListener extends ActionBarTabListener
{
    /**
     * @param currentFragment Copy constructor for keeping reference of current fragment
     */
    public DashboardTabListener(Fragment currentFragment) {
        super(currentFragment);
    }

    /**
     * @param tab
     * @param fragmentTransaction
     * @required onTabSelection is required method in child class
     */
    @Override
    protected void onTabSelection(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        DashboardFragment dashboardFragment = (DashboardFragment)getFragment();
        if (dashboardFragment.getLocalDataSource() != null) {
            switch (tab.getPosition())
            {
                case 0 : {
                    dashboardFragment.getLocalDataSource().clear();
                    dashboardFragment.getLocalDataSource().addAll(dashboardFragment.getReserveDataSource());
                }break;
                case 1 : {
                    dashboardFragment.getLocalDataSource().clear();
                    dashboardFragment.getLocalDataSource().addAll(dashboardFragment.getFreeDataSource());
                }break;
                default: {

                }break;
            }
            dashboardFragment.getAdDashboard().notifyDataSetChanged();

        }
    }


}
