package com.triadslabs.internetcafe.actionbar;

import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by muzammilpeer on 1/5/15.
 */

abstract public class BaseActionBarView {
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
}