package com.triadslabs.internetcafe.listener;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;

import com.triadslabs.internetcafe.base.BaseListener;
import com.triadslabs.internetcafe.fragment.DashboardFragment;
import com.triadslabs.internetcafe.fragment.ReservationFragment;
import com.triadslabs.internetcafe.model.DashboardItem;

/**
 * Created by MuzammilPeer on 1/11/2015.
 */
public class DashboardItemClickListener extends BaseListener {

    public DashboardItemClickListener(Fragment currentFragment) {
        super(currentFragment);
    }
//replaceFragment

    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Object model = parent.getAdapter().getItem(position);
        if (model instanceof DashboardItem) {
            DashboardItem item = (DashboardItem) model;
            if (this.getFragment() instanceof DashboardFragment) {
                DashboardFragment dashboard = (DashboardFragment)this.getFragment();
                dashboard.replaceFragment(new ReservationFragment());
            }
        }
    }



}
