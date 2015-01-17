package com.triadslabs.internetcafe.cell;

import android.widget.ImageView;
import android.widget.TextView;

import com.triadslabs.internetcafe.R;
import com.triadslabs.internetcafe.model.DrawerItem;

import butterknife.InjectView;

/**
 * Created by MuzammilPeer on 1/4/2015.
 */
public class DrawerCell extends BaseCell {

    @InjectView(R.id.drawer_itemName) TextView itemName;
    @InjectView(R.id.drawer_icon) ImageView itemIcon;

//    @Override
//    public void initializeViews(View view) {
//        if (view != null) {
//            //assign it to base cell view
//            vBase = view;
//            ButterKnife.inject(this, view);
//        }
//    }

    @Override
    public void updateCell(Object model)
    {
        if (model instanceof DrawerItem) {
            DrawerItem dItem = (DrawerItem) model;
            itemIcon.setImageDrawable(vBase.getResources().getDrawable(
                    dItem.getImgResID()));
            itemName.setText(dItem.getItemName());
        }
    }

}
