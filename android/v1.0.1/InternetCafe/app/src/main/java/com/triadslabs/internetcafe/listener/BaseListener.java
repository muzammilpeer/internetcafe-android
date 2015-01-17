package com.triadslabs.internetcafe.listener;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by MuzammilPeer on 1/17/2015.
 */
abstract public class BaseListener  implements IBaseListener {

//    public BaseFragment getActiveFragment(BaseActivity activity) {
//        return (BaseFragment)activity.getSupportFragmentManager().getFragments().get(0);
//    }



    private Fragment fragment;
    public Fragment getFragment() {
        return fragment;
    }

    private Activity activity;
    public Activity getActivity() {
        return activity;
    }



    protected BaseListener(Fragment currentFragment) {
        this.fragment = currentFragment;
    }

    protected BaseListener(Activity currentActivity) {
        this.activity = currentActivity;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    //Button click implementation
    @Override
    public void onClick(View v) {

    }

    //TabBar listener implementation

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    /**
     * Callback method to be invoked when an item in this AdapterView has
     * been clicked.
     * <p/>
     * Implementers can call getItemAtPosition(position) if they need
     * to access the data associated with the selected item.
     *
     * @param parent   The AdapterView where the click happened.
     * @param view     The view within the AdapterView that was clicked (this
     *                 will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id       The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
