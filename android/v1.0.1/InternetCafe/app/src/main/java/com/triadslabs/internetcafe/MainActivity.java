package com.triadslabs.internetcafe;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.ListView;

import com.triadslabs.internetcafe.adaptor.GeneralArrayAdapter;
import com.triadslabs.internetcafe.base.BaseActionBarActivity;
import com.triadslabs.internetcafe.cell.DrawerCell;
import com.triadslabs.internetcafe.model.DrawerItem;
import com.triadslabs.internetcafe.listener.DrawerItemClickListener;

public class MainActivity extends BaseActionBarActivity {

    private ListView mLeftDrawerList;
    private ListView mRightDrawerList;

    GeneralArrayAdapter leftAdapter;
    GeneralArrayAdapter rightadapter;

    List<DrawerItem> leftDataList;
    List<DrawerItem> rightDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        generateLeftNavigationDrawerData();
        generateRigtNavigationDrawerData();
        //setup adaptor
        leftAdapter = new GeneralArrayAdapter(this, R.layout.item_view_children, DrawerCell.class,
                leftDataList);
        rightadapter = new GeneralArrayAdapter(this, R.layout.item_view_children, DrawerCell.class,
                rightDataList);

        mLeftDrawerList = (ListView) findViewById(R.id.left_drawer);
        mRightDrawerList = (ListView) findViewById(R.id.right_drawer);

        //set adaptor for listview
        mLeftDrawerList.setAdapter(leftAdapter);

        mRightDrawerList.setAdapter(rightadapter);

        mLeftDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mRightDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        if (savedInstanceState == null) {
            SelectItem(0,this,leftDataList.get(0),mLeftDrawerList);
        }

    }

    private void generateLeftNavigationDrawerData()
    {
        leftDataList = new ArrayList();
        // Add Drawer Item to dataList
        leftDataList.add(new DrawerItem(getString(R.string.menu_item_search), R.drawable.ic_action_search));
        leftDataList.add(new DrawerItem(getString(R.string.menu_item_allocation), R.drawable.ic_action_email));

        leftDataList.add(new DrawerItem(getString(R.string.menu_item_change_allocation), R.drawable.ic_action_email));
        leftDataList.add(new DrawerItem(getString(R.string.menu_item_list_current_allocations), R.drawable.ic_action_email));
        leftDataList.add(new DrawerItem(getString(R.string.menu_item_peon_charges_add), R.drawable.ic_action_email));
    }

    private void generateRigtNavigationDrawerData()
    {
        rightDataList = new ArrayList();
        // Add Drawer Item to dataList
        rightDataList.add(new DrawerItem(getString(R.string.menu_item_import_export),
                R.drawable.ic_action_import_export));
        rightDataList.add(new DrawerItem(getString(R.string.menu_item_about), R.drawable.ic_action_about));
        rightDataList.add(new DrawerItem(getString(R.string.menu_item_settings), R.drawable.ic_action_settings));
        rightDataList.add(new DrawerItem(getString(R.string.menu_item_help), R.drawable.ic_action_help));
    }

    public ListView getmLeftDrawerList() {
        return mLeftDrawerList;
    }

    public ListView getmRightDrawerList() {
        return mRightDrawerList;
    }

}
