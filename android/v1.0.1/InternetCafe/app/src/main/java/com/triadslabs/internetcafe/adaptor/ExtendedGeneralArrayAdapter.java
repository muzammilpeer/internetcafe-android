package com.triadslabs.internetcafe.adaptor;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.triadslabs.internetcafe.R;
import com.triadslabs.internetcafe.model.ExtendedItem;
import com.triadslabs.internetcafe.view.BaseItemView;

import java.util.List;

/**
 * Created by MuzammilPeer on 1/10/2015.
 */
public class ExtendedGeneralArrayAdapter extends BaseArrayAdapter {
    //this class is for equivalence to xlform project in ios
    //Reference  https://github.com/xmartlabs/XLForm
    // Requirement
    // Customize each Cell with it's own data
    //e.g
    // localDataSource[0] == [DrawerItemModel() == DrawerItemCell() + ResourceIDofLayoutCell(int)]
    // localDataSource[1] == [CycleItemModel() == CycleItemCell() + ResourceIDofLayoutCell(int)]
    // localDataSource[.] == [.. == ..]
    // localDataSource[n] == [AnyItemModel() == AnyItemCell() + ResourceIDofLayoutCell(int)]

    //localDataSource.add(new ExtendedItem(R.layout.some_cell,DrawerItemCell.class,model);

    public ExtendedGeneralArrayAdapter(Context c, List items) {
        super(c, R.layout.item_view, items);
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
            //fetch model first for decision making
//            ExtendedItem model = getItem(position) instanceof ExtendedItem ? (ExtendedItem)getItem(position) : new ExtendedItem(R.layout.item_view_children, Object.class,new Object());
            ExtendedItem model = (ExtendedItem)getItem(position);
            //setupchilderns
            itemView = BaseItemView.inflate(parent, model.getResourceID(), model.getClazzName());
        }

        if (itemView != null) {
            //updateCell
            itemView.updateCell(((ExtendedItem) getItem(position)).getItem());
        }
        return itemView;
    }
}