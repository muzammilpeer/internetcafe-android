package com.triadslabs.internetcafe.fragment;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.triadslabs.internetcafe.R;
import com.triadslabs.internetcafe.adaptor.GeneralArrayAdapter;
import com.triadslabs.internetcafe.base.BaseFragment;
import com.triadslabs.internetcafe.cell.DashboardCell;
import com.triadslabs.internetcafe.listener.DashboardItemClickListener;
import com.triadslabs.internetcafe.listener.DashboardTabListener;
import com.triadslabs.internetcafe.model.DashboardItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * Created by MuzammilPeer on 1/11/2015.
 */
public class DashboardFragment extends BaseFragment {

    @InjectView(R.id.lvDashboard) ListView lvDashboard;

    private GeneralArrayAdapter adDashboard;
    public GeneralArrayAdapter getAdDashboard() {
        return adDashboard;
    }

    private List<DashboardItem> reserveDataSource;
    private List<DashboardItem> freeDataSource;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        initViews(rootView);
        initObjects(rootView);
        initListener(rootView);

        return rootView;
    }

    protected void initViews(View view)
    {
        super.initViews(view);
    }

    protected void initObjects(View view)
    {
        super.initObjects(view);

        generateDataSource();
        adDashboard = new GeneralArrayAdapter(getContext(),R.layout.cell_dashboard,this.getLocalDataSource(), DashboardCell.class);
        lvDashboard.setAdapter(adDashboard);

        //at the end setup actionbar to stop crashing null selection
       // setupActionBarTabs();
    }

    protected  void initListener(View view)
    {
        super.initListener(view);

        lvDashboard.setOnItemClickListener(new DashboardItemClickListener(this));
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
                .setTabListener(new DashboardTabListener(this));

        actionBar.addTab(tab1);
        actionBar.selectTab(tab1);

        Tab tab2 = actionBar
                .newTab()
                .setText("Free")
                .setTabListener(new DashboardTabListener(this));
        actionBar.addTab(tab2);
    }


    public List<DashboardItem> getReserveDataSource() {
        return reserveDataSource;
    }

    public List<DashboardItem> getFreeDataSource() {
        return freeDataSource;
    }



}
