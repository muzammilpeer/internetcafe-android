package com.triadslabs.internetcafe.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.view.View;

import com.triadslabs.internetcafe.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by MuzammilPeer on 1/4/2015.
 */
abstract public class BaseFragment extends Fragment {

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
        getSupportActionBar().setNavigationMode(isShow ? ActionBar.NAVIGATION_MODE_TABS : ActionBar.NAVIGATION_MODE_STANDARD);
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
}
