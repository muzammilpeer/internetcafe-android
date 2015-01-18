package com.triadslabs.internetcafe.listener.base;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;

import com.triadslabs.internetcafe.base.BaseListener;

/**
 * Created by MuzammilPeer on 1/18/2015.
 */
abstract  public class ActionBarTabListener extends BaseListener {

    /**
     * @param currentFragment Copy constructor for keeping reference of current fragment , make your child class constructor to public modifier
     */
    protected ActionBarTabListener(Fragment currentFragment) {
        super(currentFragment);
    }

    /**
     * @param currentActivity Copy constructor for keeping reference of current activity , make your child class constructor to public modifier
     */
    protected ActionBarTabListener(Activity currentActivity) {
        super(currentActivity);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////
    /**
     *       default implementation of listeners
     */
    ///////////////////////////////////////////////////////////////////////////////////////////

    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        onTabSelection(tab, fragmentTransaction);
    }

    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        onTabUnselection(tab,fragmentTransaction);
    }

    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        onTabReselection(tab,fragmentTransaction);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    /**
     *  Custom implementation of listeners
     */
    ///////////////////////////////////////////////////////////////////////////////////////////

    /**
      *  @required
      *  onTabSelection is required method in child class
    */
    abstract protected void onTabSelection(ActionBar.Tab tab, FragmentTransaction fragmentTransaction);


    /**
      *  @optional
      * onTabUnselection is optional method in child class , override this method in child class to make changes
    */
    protected  void onTabUnselection(ActionBar.Tab tab, FragmentTransaction fragmentTransaction)
    {
        //optional methods
    }

    /**
      *  @optional
      * onTabReselection is optional method in child class , override this method in child class to make changes
    */
    protected void onTabReselection(ActionBar.Tab tab, FragmentTransaction fragmentTransaction)
    {
        //optional methods
    }
}
