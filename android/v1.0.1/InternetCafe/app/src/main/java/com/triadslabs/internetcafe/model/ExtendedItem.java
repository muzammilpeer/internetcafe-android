package com.triadslabs.internetcafe.model;

import com.triadslabs.internetcafe.base.BaseItem;

/**
 * Created by MuzammilPeer on 1/10/2015.
 */
public class ExtendedItem  extends BaseItem {

    private int resourceID;
    private Class clazzName;
    private Object item;



    public ExtendedItem(int resourceID, Class clazzName, Object item) {
        this.resourceID = resourceID;
        this.clazzName = clazzName;
        this.item = item;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public Class getClazzName() {
        return clazzName;
    }

    public void setClazzName(Class clazzName) {
        this.clazzName = clazzName;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }
}
