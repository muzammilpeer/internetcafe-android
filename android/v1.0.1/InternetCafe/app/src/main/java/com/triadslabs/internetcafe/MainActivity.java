package com.triadslabs.internetcafe;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.triadslabs.internetcafe.actionbar.DrawerActionBarView;
import com.triadslabs.internetcafe.adaptor.ExtendedGeneralArrayAdapter;
import com.triadslabs.internetcafe.adaptor.GeneralArrayAdapter;
import com.triadslabs.internetcafe.base.BaseActionBarActivity;
import com.triadslabs.internetcafe.base.BaseFragment;
import com.triadslabs.internetcafe.cell.DrawerCell;
import com.triadslabs.internetcafe.fragment.DashboardFragment;
import com.triadslabs.internetcafe.fragment.FragmentOne;
import com.triadslabs.internetcafe.fragment.FragmentThree;
import com.triadslabs.internetcafe.fragment.FragmentTwo;
import com.triadslabs.internetcafe.fragment.LoadMoreFragment;
import com.triadslabs.internetcafe.fragment.ScheduleFragment;
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


        rightadapter = new GeneralArrayAdapter(this, R.layout.item_view_children, rightDataList,DrawerCell.class);

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


    private DrawerItem getDrawerItem(Object item)
    {
        if (item instanceof DrawerItem)
        {
            return (DrawerItem)item;
        }else if (item instanceof ExtendedItem)
        {
            return (DrawerItem)((ExtendedItem) item).getItem();
        }

        return null;
    }
    //selection
    public void SelectItem(int position,Context mcontext,Object model,ListView drawerListView) {
            DrawerItem item = getDrawerItem(model);
            if (item instanceof DrawerItem) {

            BaseFragment fragment = null;
            Bundle args = new Bundle();
            switch (position) {
                case 0:
                    fragment =  new DashboardFragment();
                    args.putString(FragmentOne.ITEM_NAME, item
                            .getItemName());
                    args.putInt(FragmentOne.IMAGE_RESOURCE_ID, item
                            .getImgResID());
                    break;
                case 1:
                    fragment = new ScheduleFragment();
                    args.putString(FragmentTwo.ITEM_NAME, item
                            .getItemName());
                    args.putInt(FragmentTwo.IMAGE_RESOURCE_ID, item
                            .getImgResID());
                    break;
                case 2:
                    fragment = new LoadMoreFragment();
                    args.putString(FragmentThree.ITEM_NAME, item
                            .getItemName());
                    args.putInt(FragmentThree.IMAGE_RESOURCE_ID, item
                            .getImgResID());
                    break;
                default:
                    fragment = new FragmentThree();
                    args.putString(FragmentOne.ITEM_NAME, item
                            .getItemName());
                    args.putInt(FragmentThree.IMAGE_RESOURCE_ID, item
                            .getImgResID());
            }

            fragment.setArguments(args);

            replaceFragment(fragment);

            drawerListView.setItemChecked(position, true);

            super.setTitle(item.getItemName());

            super.SelectItem(position, mcontext, model, drawerListView);
        }
    }
}
