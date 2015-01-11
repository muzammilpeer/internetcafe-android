package com.triadslabs.internetcafe.listener;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.triadslabs.internetcafe.MainActivity;
import com.triadslabs.internetcafe.base.BaseActivity;
import com.triadslabs.internetcafe.base.BaseFragment;
import com.triadslabs.internetcafe.fragment.DashboardFragment;
import com.triadslabs.internetcafe.fragment.ReservationFragment;
import com.triadslabs.internetcafe.model.DashboardItem;

/**
 * Created by MuzammilPeer on 1/11/2015.
 */
public class DashboardItemClickListener implements
        ListView.OnItemClickListener {
    //replaceFragment

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Object model = parent.getAdapter().getItem(position);
        if (model instanceof DashboardItem) {
            DashboardItem item = (DashboardItem) model;
            if (view.getContext() instanceof MainActivity) {
                BaseActivity activity = ((BaseActivity) view.getContext());
                DashboardFragment dashboard = (DashboardFragment)getActiveFragment(activity) != null ? (DashboardFragment)getActiveFragment(activity) : new DashboardFragment() ;
                dashboard.replaceFragment(new ReservationFragment());
            }
        }
    }

    public BaseFragment getActiveFragment(BaseActivity activity) {
        return (BaseFragment)activity.getSupportFragmentManager().getFragments().get(0);
    }


//    public BaseFragment getActiveFragment(BaseActivity activity) {
//        if (activity.getSupportFragmentManager().getBackStackEntryCount() == 0) {
//            return null;
//        }
//        String tag = activity.getSupportFragmentManager().getBackStackEntryAt(activity.getSupportFragmentManager().getBackStackEntryCount() - 1).getName();
//        return (BaseFragment)activity.getSupportFragmentManager().findFragmentByTag(tag);
//    }

}
