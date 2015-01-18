package com.triadslabs.internetcafe.listener;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;

import com.triadslabs.internetcafe.fragment.DashboardFragment;
import com.triadslabs.internetcafe.fragment.ReservationFragment;
import com.triadslabs.internetcafe.listener.base.ListViewOnItemClickListener;
import com.triadslabs.internetcafe.model.DashboardItem;

/**
 * Created by MuzammilPeer on 1/11/2015.
 */
public class DashboardItemClickListener extends ListViewOnItemClickListener {

    /**
     * @param currentFragment Copy constructor for keeping reference of current fragment
     */
    public DashboardItemClickListener(Fragment currentFragment) {
        super(currentFragment);
    }



//replaceFragment

    /**
     * @param parent
     * @param view
     * @param position
     * @param id
     * @required onItemClickAction is required method in child class
     */
    @Override
    protected void onItemClickAction(AdapterView<?> parent, View view, int position, long id) {
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
