package com.triadslabs.internetcafe.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.triadslabs.internetcafe.R;
import com.triadslabs.internetcafe.adaptor.GeneralArrayAdapter;
import com.triadslabs.internetcafe.base.BaseFragment;
import com.triadslabs.internetcafe.cell.DashboardCell;
import com.triadslabs.internetcafe.listener.DashboardItemClickListener;
import com.triadslabs.internetcafe.model.DashboardItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by MuzammilPeer on 1/11/2015.
 */
public class DashboardFragment extends BaseFragment implements TabListener {

    @InjectView(R.id.lvDashboard) ListView lvDashboard;
//    private ListView lvDashboard;

    private GeneralArrayAdapter adDashboard;

    private List<DashboardItem> localDataSource;

    private List<DashboardItem> reserveDataSource;
    private List<DashboardItem> freeDataSource;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        initViews(rootView);
        initObjects(rootView);
        initListener();
        return rootView;
    }

    private void initViews(View view)
    {
        ButterKnife.inject(this, view);

//        lvDashboard = (ListView) view.findViewById(R.id.lvDashboard);

    }

    private void initObjects(View view)
    {
        setupActionBarTabs();
        generateDataSource();

        localDataSource = new ArrayList<DashboardItem>();
        localDataSource.addAll(this.reserveDataSource);

        adDashboard = new GeneralArrayAdapter(getContext(),R.layout.cell_dashboard,localDataSource, DashboardCell.class);
        lvDashboard.setAdapter(adDashboard);
    }

    private  void initListener()
    {
        lvDashboard.setOnItemClickListener(new DashboardItemClickListener());
    }

    private void generateDataSource()
    {
        ArrayList<DashboardItem> tempDataSource = new ArrayList<DashboardItem>();

        for (int i=0;i<20;i++) {
            tempDataSource.add(new DashboardItem("R#"+i,"Free Test Client","Camera","12:"+i+" AM","30","1:00 PM"));
        }

        freeDataSource = new ArrayList<DashboardItem>(tempDataSource);
        tempDataSource.clear();

        for (int i=0;i<50;i++) {
            tempDataSource.add(new DashboardItem("R#"+i,"Reserve Test Client","Camera","12:"+i+" AM","30","1:00 PM"));
        }
        reserveDataSource = new ArrayList<DashboardItem>(tempDataSource);

        tempDataSource.clear();
    }

    private void setupActionBarTabs() {
        ActionBar actionBar = getSupportActionBar();
        showHideTabs(true);
        actionBar.removeAllTabs();

        Tab tab1 = actionBar
                .newTab()
                .setText("Reserve")
                .setTabListener(this);

        actionBar.addTab(tab1);
        actionBar.selectTab(tab1);

        Tab tab2 = actionBar
                .newTab()
                .setText("Free")
                .setTabListener(this);
        actionBar.addTab(tab2);
    }


    //Tab Bar implementation
    @Override
    public void onTabSelected(Tab tab, FragmentTransaction fragmentTransaction) {

        if (this.localDataSource != null) {
            switch (tab.getPosition())
            {
                case 0 : {
                    this.localDataSource.clear();
                    this.localDataSource.addAll(reserveDataSource);
                }break;
                case 1 : {
                    this.localDataSource.clear();
                    this.localDataSource.addAll(freeDataSource);
                }break;
                default: {

                }break;
            }
            adDashboard.notifyDataSetChanged();

        }
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction fragmentTransaction) {

    }
}
