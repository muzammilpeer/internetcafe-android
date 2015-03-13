package com.triadslabs.internetcafe.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.triadslabs.internetcafe.R;
import com.triadslabs.utils.reflection.ReflectionUtil;


/**
 * Created by MuzammilPeer on 1/4/2015.
 */
public class BaseItemView extends RelativeLayout {
    //bCell is the reference of Your Cell object e.g (DrawerCell)
    public BaseCell bCell;

    //View inflate class method
    public static BaseItemView inflate(ViewGroup parent,int layoutResourceID,Class cell) {
        //create class object and initiate baseview from xml
        BaseItemView itemView = (BaseItemView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);

        //Generate Childs views and attach them to parent view of cellview
        View baseView = LayoutInflater.from(parent.getContext()).inflate(layoutResourceID , itemView, true);
        //Cell Reference and cell views setup is called to fetch views from xml
        itemView.bCell = (BaseCell) ReflectionUtil.instantiate(cell);
        itemView.bCell.initializeViews(baseView);

        return itemView;
    }

    //Constructors
    public BaseItemView(Context c) {
        this(c, null);
    }

    public BaseItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    //Constructor called after inflating first
    public BaseItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    //set item will call updatecell()
    public void updateCell(Object item) {
        bCell.updateCell(item);
    }
}