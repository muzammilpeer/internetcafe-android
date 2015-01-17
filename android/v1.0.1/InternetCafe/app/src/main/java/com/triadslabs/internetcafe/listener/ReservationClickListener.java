package com.triadslabs.internetcafe.listener;

import android.support.v4.app.Fragment;
import android.view.View;

import com.triadslabs.internetcafe.R;
import com.triadslabs.internetcafe.base.BaseListener;
import com.triadslabs.internetcafe.fragment.DashboardFragment;
import com.triadslabs.internetcafe.fragment.ReservationFragment;

/**
 * Created by MuzammilPeer on 1/11/2015.
 */
public class ReservationClickListener extends BaseListener {

    public ReservationClickListener(Fragment currentFragment) {
        super(currentFragment);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v)
    {
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
