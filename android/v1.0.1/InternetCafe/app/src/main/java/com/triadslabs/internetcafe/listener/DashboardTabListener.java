package com.triadslabs.internetcafe.listener;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;

import com.triadslabs.internetcafe.base.BaseListener;
import com.triadslabs.internetcafe.fragment.DashboardFragment;

/**
 * Created by MuzammilPeer on 1/17/2015.
 */
public class DashboardTabListener extends BaseListener
{
    public DashboardTabListener(Fragment currentFragment) {
        super(currentFragment);
    }


    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        DashboardFragment dashboardFragment = (DashboardFragment)this.getFragment();
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
