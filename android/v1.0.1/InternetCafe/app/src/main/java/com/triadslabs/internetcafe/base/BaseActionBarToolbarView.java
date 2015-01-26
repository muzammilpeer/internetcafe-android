package com.triadslabs.internetcafe.base;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by MuzammilPeer on 1/24/2015.
 */
abstract public class BaseActionBarToolbarView extends Toolbar {

    //view shared
    protected View vBase;

    protected BaseActionBarToolbarView(Context context) {
        super(context);
    }

    protected BaseActionBarToolbarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected BaseActionBarToolbarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void initializeViews()
    {
        if (this != null) {
            //assign it to base cell view
            this.vBase = this;
            ButterKnife.inject(this, this);
        }
    }

    abstract public void updateCell(Object model);
}
