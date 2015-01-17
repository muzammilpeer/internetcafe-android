package com.triadslabs.internetcafe.adaptor;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by MuzammilPeer on 1/17/2015.
 */
public class BaseArrayAdapter extends ArrayAdapter {

    /**
     * Constructor
     *
     * @param context  The current context.
     * @param resource The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     * @param objects  The objects to represent in the ListView.
     */
    public BaseArrayAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }


}
