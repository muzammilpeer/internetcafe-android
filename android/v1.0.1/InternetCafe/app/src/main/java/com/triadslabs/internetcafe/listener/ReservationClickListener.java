package com.triadslabs.internetcafe.listener;

import android.view.View;

import com.triadslabs.internetcafe.R;
import com.triadslabs.internetcafe.base.BaseActivity;
import com.triadslabs.internetcafe.base.BaseFragment;
import com.triadslabs.internetcafe.fragment.DashboardFragment;
import com.triadslabs.internetcafe.fragment.ReservationFragment;

/**
 * Created by MuzammilPeer on 1/11/2015.
 */
public class ReservationClickListener implements View.OnClickListener {
    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v)
    {
        if (v.getContext() instanceof BaseActivity) {
            BaseActivity activity = ((BaseActivity) v.getContext());
            ReservationFragment fragment = (ReservationFragment)getActiveFragment(activity) != null ? (ReservationFragment)getActiveFragment(activity) : new ReservationFragment() ;

            if (v.getId() == R.id.bCancel) {
                fragment.replaceFragment(new DashboardFragment());
            } else if (v.getId() == R.id.bUpdate) {
                fragment.replaceFragment(new DashboardFragment());
            } else if (v.getId() == R.id.bDelete) {
                fragment.replaceFragment(new DashboardFragment());
            }
        }
    }

    public BaseFragment getActiveFragment(BaseActivity activity) {
        return (BaseFragment)activity.getSupportFragmentManager().getFragments().get(0);
    }
}
