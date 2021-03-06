package com.triadslabs.internetcafe.actionbar;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.triadslabs.internetcafe.MainActivity;
import com.triadslabs.internetcafe.R;
import com.triadslabs.internetcafe.base.BaseActionBarView;
import com.triadslabs.internetcafe.model.DrawerItem;

import butterknife.InjectView;

/**
 * Created by muzammilpeer on 1/5/15.
 */
public class DrawerActionBarView extends BaseActionBarView implements Toolbar.OnMenuItemClickListener,View.OnClickListener {

    @InjectView(R.id.tvActionbarTitle) TextView ItemName;
//    @InjectView(R.id.ivActionbarButton) ImageButton leftIcon;
//    @InjectView(R.id.ivActionbarSetting) ImageButton rightIcon;

    boolean isOpen;

    @Override
    public void updateCell(Object model) {
        if (model instanceof DrawerItem) {
            DrawerItem dItem = (DrawerItem) model;

            ItemName.setText(dItem.getItemName());

        }
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        Log.e("Some message on click","testing here");
        MainActivity activity = (MainActivity)v.getContext();

        if (v.getId() == R.id.ivActionbarButton) {
            isOpen = isOpen ? false : true ;
            activity.openCloseDrawer(isOpen,true);
        }else if (v.getId() == R.id.ivActionbarSetting) {
            isOpen = isOpen ? false : true ;
            activity.openCloseDrawer(isOpen,false);
        }
    }

    private void setListener()
    {
//        leftIcon.setOnClickListener(this);
//        rightIcon.setOnClickListener(this);
    }

    @Override
    public void initializeViews(View view) {
        super.initializeViews(view);
        setListener();

//        Toolbar toolbar = (Toolbar)view;
//        // Inflate a menu to be displayed in the toolbar
//        toolbar.inflateMenu(R.menu.your_toolbar_menu);
//        toolbar.setOnMenuItemClickListener(this);
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        return false;
    }



}
