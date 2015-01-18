package com.triadslabs.internetcafe.listener;

import android.support.v4.app.Fragment;
import android.view.View;

import com.triadslabs.internetcafe.R;
import com.triadslabs.internetcafe.fragment.DashboardFragment;
import com.triadslabs.internetcafe.fragment.ReservationFragment;
import com.triadslabs.internetcafe.listener.base.ViewClickListener;

/**
 * Created by MuzammilPeer on 1/11/2015.
 */
public class ReservationClickListener extends ViewClickListener {
    /**
     * @param currentFragment Copy constructor for keeping reference of current fragment , make your child class constructor to public modifier
     */
    public ReservationClickListener(Fragment currentFragment) {
        super(currentFragment);
    }


    /**
     * @param v
     * @required onClickAction is required method in child class
     */
    @Override
    protected void onClickAction(View v) {
        if (this.getFragment() instanceof ReservationFragment) {
            ReservationFragment fragment = (ReservationFragment)this.getFragment();

            if (v.getId() == R.id.bCancel) {
                fragment.replaceFragment(new DashboardFragment());
            } else if (v.getId() == R.id.bUpdate) {
                fragment.replaceFragment(new DashboardFragment());
            } else if (v.getId() == R.id.bDelete) {
                fragment.replaceFragment(new DashboardFragment());
            }
        }
    }
}
