package com.triadslabs.internetcafe.listener.base;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;

import com.triadslabs.internetcafe.base.BaseListener;

/**
 * Created by MuzammilPeer on 1/18/2015.
 */
abstract public class ViewClickListener extends BaseListener {

    /**
     * @param currentFragment Copy constructor for keeping reference of current fragment , make your child class constructor to public modifier
     */
    public ViewClickListener(Fragment currentFragment) {
        super(currentFragment);
    }

    /**
     * @param currentActivity Copy constructor for keeping reference of current activity , make your child class constructor to public modifier
     */
    public ViewClickListener(Activity currentActivity) {
        super(currentActivity);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    /**
     *       default implementation of listeners
     */
    ///////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        super.onClick(v);
        onClickAction(v);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    /**
     *  Custom implementation of listeners
     */
    ///////////////////////////////////////////////////////////////////////////////////////////

    /**
     *  @required
     *  onClickAction is required method in child class
     */
    abstract protected void onClickAction(View v);
}
