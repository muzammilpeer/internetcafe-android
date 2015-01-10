package com.triadslabs.internetcafe.cell;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.triadslabs.internetcafe.R;
import com.triadslabs.internetcafe.model.DrawerItem;

/**
 * Created by MuzammilPeer on 1/4/2015.
 */
public class DrawerCell extends BaseCell {

    TextView ItemName;

//    @Override
//    public BaseCell initialize() {
//
//        return new DrawerCell();
//    }

    ImageView icon;

    //public BaseCell initialize(Class clazzname);


    @Override
    public void setupChildren(View view) {
        if (view != null) {
            //assign it to base cell view
            vBase = view;

            //inflate your views
            ItemName = (TextView) vBase.findViewById(R.id.drawer_itemName);
            icon = (ImageView) vBase.findViewById(R.id.drawer_icon);
        }
    }

    @Override
    public void updateCell(Object model)
    {
        if (model instanceof DrawerItem) {
            DrawerItem dItem = (DrawerItem) model;
            icon.setImageDrawable(vBase.getResources().getDrawable(
                    dItem.getImgResID()));
            ItemName.setText(dItem.getItemName());
        }
    }

}
