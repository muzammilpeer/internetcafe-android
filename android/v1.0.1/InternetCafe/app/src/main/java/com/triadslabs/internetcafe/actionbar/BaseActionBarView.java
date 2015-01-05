package com.triadslabs.internetcafe.actionbar;

import android.view.View;

/**
 * Created by muzammilpeer on 1/5/15.
 */

abstract public class BaseActionBarView {
    //view shared
    protected View vBase;

    abstract public void setupChildren(View view);
    abstract public void updateActionBar(Object model);
}