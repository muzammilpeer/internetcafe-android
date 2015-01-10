package com.triadslabs.internetcafe;

import android.os.Bundle;
import android.widget.ListView;

import com.triadslabs.internetcafe.actionbar.DrawerActionBarView;
import com.triadslabs.internetcafe.adaptor.ExtendedGeneralArrayAdapter;
import com.triadslabs.internetcafe.adaptor.GeneralArrayAdapter;
import com.triadslabs.internetcafe.base.BaseActionBarActivity;
import com.triadslabs.internetcafe.cell.DrawerCell;
import com.triadslabs.internetcafe.listener.DrawerItemClickListener;
import com.triadslabs.internetcafe.model.DrawerItem;
import com.triadslabs.internetcafe.model.ExtendedItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActionBarActivity {

    private ListView mLeftDrawerList;
    private ListView mRightDrawerList;

    ExtendedGeneralArrayAdapter fancyAdaptor;
    GeneralArrayAdapter leftAdapter;
    GeneralArrayAdapter rightadapter;

    List<ExtendedItem> leftDataList;
    List<DrawerItem> rightDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initializeCustomActionBar(R.layout.actionbar_header, DrawerActionBarView.class, new DrawerItem(getString(R.string.menu_item_search), R.drawable.ic_action_search));
        showHideActionBar(true, true);

//        generateLeftNavigationDrawerData();
        generateRightNavigationDrawerData();

        generateFancyList();

        //setup adaptor
//        leftAdapter = new GeneralArrayAdapter(this, R.layout.item_view_children, DrawerCell.class,
//                leftDataList);

        fancyAdaptor = new ExtendedGeneralArrayAdapter(this,leftDataList);


        rightadapter = new GeneralArrayAdapter(this, R.layout.item_view_children, DrawerCell.class,
                rightDataList);

        mLeftDrawerList = (ListView) findViewById(R.id.left_drawer);
        mRightDrawerList = (ListView) findViewById(R.id.right_drawer);

        //set adaptor for listview
//        mLeftDrawerList.setAdapter(leftAdapter);
        mLeftDrawerList.setAdapter(fancyAdaptor);

        mRightDrawerList.setAdapter(rightadapter);

        mLeftDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mRightDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        if (savedInstanceState == null) {
            SelectItem(0, this, leftDataList.get(0), mLeftDrawerList);
        }

    }

    public void openCloseDrawer(boolean isOpen,boolean isLeftDrawer)
    {
        if (isLeftDrawer)
        {
         openCloseDrawer(isOpen,mLeftDrawerList);
        }else {
            openCloseDrawer(isOpen,mRightDrawerList);
        }

    }


    private void generateLeftNavigationDrawerData()
    {
        leftDataList = new ArrayList();
        // Add Drawer Item to dataList
//        leftDataList.add(new DrawerItem(getString(R.string.menu_item_search), R.drawable.ic_action_search));
//        leftDataList.add(new DrawerItem(getString(R.string.menu_item_allocation), R.drawable.ic_action_email));
//
//        leftDataList.add(new DrawerItem(getString(R.string.menu_item_change_allocation), R.drawable.ic_action_email));
//        leftDataList.add(new DrawerItem(getString(R.string.menu_item_list_current_allocations), R.drawable.ic_action_email));
//        leftDataList.add(new DrawerItem(getString(R.string.menu_item_peon_charges_add), R.drawable.ic_action_email));
    }

    private void generateRightNavigationDrawerData()
    {
        rightDataList = new ArrayList();
        // Add Drawer Item to dataList
        rightDataList.add(new DrawerItem(getString(R.string.menu_item_import_export),
                R.drawable.ic_action_import_export));
        rightDataList.add(new DrawerItem(getString(R.string.menu_item_about), R.drawable.ic_action_about));
        rightDataList.add(new DrawerItem(getString(R.string.menu_item_settings), R.drawable.ic_action_settings));
        rightDataList.add(new DrawerItem(getString(R.string.menu_item_help), R.drawable.ic_action_help));
    }

    private void generateFancyList()
    {
        leftDataList = new ArrayList();
        // Add Drawer Item to dataList
        leftDataList.add(new ExtendedItem(R.layout.cell_drawer_left,DrawerCell.class, new DrawerItem(getString(R.string.menu_item_search), R.drawable.ic_action_search)));
        leftDataList.add(new ExtendedItem(R.layout.cell_drawer_right,DrawerCell.class,new DrawerItem(getString(R.string.menu_item_allocation), R.drawable.ic_action_email)));

        leftDataList.add(new ExtendedItem(R.layout.item_view_children,DrawerCell.class,new DrawerItem(getString(R.string.menu_item_change_allocation), R.drawable.ic_action_email)));
        leftDataList.add(new ExtendedItem(R.layout.cell_drawer_left,DrawerCell.class,new DrawerItem(getString(R.string.menu_item_list_current_allocations), R.drawable.ic_action_email)));
        leftDataList.add(new ExtendedItem(R.layout.cell_drawer_left,DrawerCell.class,new DrawerItem(getString(R.string.menu_item_peon_charges_add), R.drawable.ic_action_email)));
    }

    public ListView getmLeftDrawerList() {
        return mLeftDrawerList;
    }

    public ListView getmRightDrawerList() {
        return mRightDrawerList;
    }

}
