package com.triadslabs.internetcafe.base;

import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by MuzammilPeer on 1/4/2015.
 */
abstract public class BaseCell {
    //view shared
    protected View vBase;

    public void initializeViews(View view)
    {
        if (view != null) {
            //assign it to base cell view
            vBase = view;
            ButterKnife.inject(this, view);
        }
    }
    abstract public void updateCell(Object model);

//    abstract public BaseCell initialize();
}
