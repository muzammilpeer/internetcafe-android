package com.triadslabs.internetcafe.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.view.View;

import com.triadslabs.internetcafe.R;
import com.triadslabs.networklayer.enums.NetworkRequestEnum;
import com.triadslabs.networklayer.protocols.IResponseProtocol;
import com.triadslabs.utils.logger.Log4a;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by MuzammilPeer on 1/4/2015.
 */
abstract public class BaseFragment extends Fragment implements IResponseProtocol {

    private List localDataSource;
    public List getLocalDataSource() {
        return localDataSource;
    }
    public void setLocalDataSource(List localDataSource) {
        this.localDataSource = localDataSource;
    }

    protected void initViews(View view)
    {
        ButterKnife.inject(this, view);
    }

    protected void initObjects(View view)
    {
        localDataSource = new ArrayList();

    }

    protected  void initListener(View view)
    {
        //todo
    }

    public ActionBar getSupportActionBar()
    {
       return this.getBaseActivity().getSupportActionBar();
    }



    public void showHideTabs(boolean isShow) {
//        getSupportActionBar().setNavigationMode(isShow ? ActionBar.NAVIGATION_MODE_TABS : ActionBar.NAVIGATION_MODE_STANDARD);
    }




    public void replaceFragment(BaseFragment fragment)
    {
        FragmentManager frgManager = this.getBaseActivity().getSupportFragmentManager();
        frgManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }


    public BaseActivity getBaseActivity() {
        return (BaseActivity)this.getActivity();
    }

    public Context getContext() {
        return this.getBaseActivity();
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void responseWithError(Exception error, NetworkRequestEnum requestType) {
//        ca.hideProgress();
        Log4a.e("Webservice error", error == null || error.getMessage() == null ? "Exception" : error.getMessage() + "Data fetched for Request URL = " + requestType.getRelativeUrl());
    }

    @Override
    public void successWithData(Object data, NetworkRequestEnum requestType) {
//        ca.hideProgress();
        Log4a.e("Webservice success","Data fetched for Request URL = "+requestType.getRelativeUrl());
    }

}
