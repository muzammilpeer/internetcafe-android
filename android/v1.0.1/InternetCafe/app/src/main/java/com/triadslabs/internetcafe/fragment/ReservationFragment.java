package com.triadslabs.internetcafe.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.triadslabs.internetcafe.R;
import com.triadslabs.internetcafe.base.BaseFragment;

/**
 * Created by MuzammilPeer on 1/11/2015.
 */
public class ReservationFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_reservation, container, false);

        initViews(rootView);
        initObjects(rootView);
        initListener();

        return rootView;
    }

    private void initViews(View view)
    {
//        lvDashboard = (ListView) view.findViewById(R.id.lvDashboard);

    }

    private void initObjects(View view)
    {
//        setupActionBarTabs();
//        generateDataSource();
//
//        adDashboard = new GeneralArrayAdapter(getContext(),R.layout.cell_dashboard,localDataSource, DashboardCell.class);
//        lvDashboard.setAdapter(adDashboard);
    }

    private  void initListener()
    {

    }
}
