package com.triadslabs.internetcafe.actionbar;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.triadslabs.internetcafe.MainActivity;
import com.triadslabs.internetcafe.R;
import com.triadslabs.internetcafe.base.BaseActionBarView;
import com.triadslabs.internetcafe.model.DrawerItem;

import butterknife.InjectView;

/**
 * Created by muzammilpeer on 1/5/15.
 */
public class DrawerActionBarView extends BaseActionBarView {

    @InjectView(R.id.tvActionbarTitle) TextView ItemName;
    @InjectView(R.id.ivActionbarButton) ImageButton leftIcon;
    @InjectView(R.id.ivActionbarSetting) ImageButton rightIcon;

    boolean isOpen;

    @Override
    public void updateCell(Object model) {
        if (model instanceof DrawerItem) {
            DrawerItem dItem = (DrawerItem) model;

            ItemName.setText(dItem.getItemName());

            setListener();
        }
    }

    private View.OnClickListener cListener = new View.OnClickListener() {
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
    };

    private void setListener()
    {
        leftIcon.setOnClickListener(cListener);
        rightIcon.setOnClickListener(cListener);
    }
}
