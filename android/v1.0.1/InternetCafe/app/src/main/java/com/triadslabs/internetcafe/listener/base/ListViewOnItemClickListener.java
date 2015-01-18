package com.triadslabs.internetcafe.listener.base;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;

import com.triadslabs.internetcafe.base.BaseListener;

/**
 * Created by MuzammilPeer on 1/18/2015.
 */
abstract public class ListViewOnItemClickListener extends BaseListener {

    /**
     * @param currentFragment Copy constructor for keeping reference of current fragment
     */
    protected ListViewOnItemClickListener(Fragment currentFragment) {
        super(currentFragment);
    }

    /**
     * @param currentActivity Copy constructor for keeping reference of current activity
     */
    protected ListViewOnItemClickListener(Activity currentActivity) {
        super(currentActivity);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    /**
     *       default implementation of listeners
     */
    ///////////////////////////////////////////////////////////////////////////////////////////

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
        super.onItemClick(parent, view, position, id);
        onItemClickAction(parent,view,position,id);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////
    /**
     *  Custom implementation of listeners
     */
    ///////////////////////////////////////////////////////////////////////////////////////////

    /**
     *  @required
     *  onItemClickAction is required method in child class
     */
    abstract protected void onItemClickAction(AdapterView<?> parent, View view, int position, long id);

}
