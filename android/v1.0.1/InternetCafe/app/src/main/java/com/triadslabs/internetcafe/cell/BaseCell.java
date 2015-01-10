package com.triadslabs.internetcafe.cell;

import android.view.View;

/**
 * Created by MuzammilPeer on 1/4/2015.
 */
abstract public class BaseCell {
    //view shared
    protected View vBase;

    abstract public void setupChildren(View view);
    abstract public void updateCell(Object model);

//    abstract public BaseCell initialize();
}
