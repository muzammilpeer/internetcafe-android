package com.triadslabs.internetcafe.adaptor;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.triadslabs.internetcafe.view.BaseItemView;

import java.util.List;

public  class GeneralArrayAdapter extends ArrayAdapter {

    int layoutResID;
    Class classReference;

    public GeneralArrayAdapter(Context c, int layoutResourceID, Class clazzCell, List items) {
        super(c, layoutResourceID, items);
        this.layoutResID = layoutResourceID;
        this.classReference = clazzCell;
    }


    // Spinner/DropDown getDropDownView() support
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    // ListView and GridView  getView() support
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    //Inflate in both cases of getview,getdropdownview
    public View getCustomView(int position, View convertView, ViewGroup parent) {

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