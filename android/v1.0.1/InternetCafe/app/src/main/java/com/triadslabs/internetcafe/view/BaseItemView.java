package com.triadslabs.internetcafe.view;

import android.view.View;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.triadslabs.internetcafe.R;
import com.triadslabs.internetcafe.utils.ReflectionUtils;


/**
 * Created by MuzammilPeer on 1/4/2015.
 */
public class BaseItemView extends RelativeLayout {

    //It's your CellDesign Resource ID which you will pass on adaptor creation
    private static int layoutResID;

    //bCell is the reference of Your Cell object e.g (DrawerCell)
    private Object bCell;
    //classReference
    private static Class classReference;

    //View inflate class method
    public static BaseItemView inflate(ViewGroup parent,int layoutResourceID,Class cell) {
        BaseItemView.layoutResID = layoutResourceID;
        classReference = cell;
        BaseItemView itemView = (BaseItemView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);
        return itemView;
    }

    //Constructors
    public BaseItemView(Context c) {
        this(c, null);
    }

    public BaseItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    //Constructor which will create viewHolder for once using reflection
    public BaseItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        View baseView = LayoutInflater.from(context).inflate(BaseItemView.layoutResID , this, true);
        bCell = ReflectionUtils.instantiate(BaseItemView.classReference);
        ReflectionUtils.callMethod("setupChildren",View.class,baseView,BaseItemView.classReference,bCell);
    }

    //set item will call updatecell() method in your cell class using reflection
    public void setItem(Object item) {
        ReflectionUtils.callMethod("updateCell",Object.class,item,BaseItemView.classReference,bCell);
    }
}