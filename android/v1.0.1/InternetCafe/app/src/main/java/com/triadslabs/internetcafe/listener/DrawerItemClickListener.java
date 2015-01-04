package com.triadslabs.internetcafe.listener;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.triadslabs.internetcafe.MainActivity;
import com.triadslabs.internetcafe.R;
import com.triadslabs.internetcafe.model.DrawerItem;

/**
 * Created by MuzammilPeer on 1/4/2015.
 */
public class DrawerItemClickListener implements
        ListView.OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Object model = parent.getAdapter().getItem(position);
        if (model instanceof DrawerItem) {
            DrawerItem item = (DrawerItem) model;
            if (view.getContext() instanceof MainActivity) {
                MainActivity activity = ((MainActivity) view.getContext());
                ListView selectedListView = activity.getmLeftDrawerList();
                if (parent.getId() == R.id.right_drawer) {
                    selectedListView = activity.getmRightDrawerList();
                }
                activity.SelectItem(position,view.getContext(),model,selectedListView);
            }
        }
    }
}