package com.triadslabs.internetcafe.adaptor;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.triadslabs.internetcafe.model.DrawerItem;
import com.triadslabs.internetcafe.view.BaseItemView;

public  class GeneralArrayAdapter extends ArrayAdapter {

    int layoutResID;
    Class classReference;

    public GeneralArrayAdapter(Context c, int layoutResourceID, Class clazzCell, List<DrawerItem> items) {
        super(c, layoutResourceID, items);
        this.layoutResID = layoutResourceID;
        this.classReference = clazzCell;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseItemView itemView = (BaseItemView)convertView;
        if (null == itemView) {
            //setupchilderns
            itemView = BaseItemView.inflate(parent, this.layoutResID, this.classReference);
        }

        if (itemView != null) {
            //updateCell
            itemView.setItem(getItem(position));
        }
        return itemView;
    }
}