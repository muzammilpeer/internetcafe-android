package com.triadslabs.internetcafe.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;

import com.triadslabs.internetcafe.R;

import butterknife.ButterKnife;

/**
 * Created by MuzammilPeer on 1/4/2015.
 */
abstract public class BaseFragment extends Fragment {

    private BaseActivity baseActivity;
    private Context context;

//    public BaseFragment() {
//        this.baseActivity = (BaseActivity)this.getActivity();
//        this.context = this.baseActivity;
//    }

//    actionBar = getSherlockActivity().getSupportActionBar();
//    actionBar.removeAllTabs();
//    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

    public ActionBar getSupportActionBar()
    {
       return this.getBaseActivity().getSupportActionBar();
    }

    public BaseActivity getBaseActivity() {
        return (BaseActivity)this.getActivity();
    }

    public Context getContext() {
        return this.getBaseActivity();
    }

    public void showHideTabs(boolean isShow) {
        getSupportActionBar().setNavigationMode(isShow ? ActionBar.NAVIGATION_MODE_TABS : ActionBar.NAVIGATION_MODE_STANDARD);
    }

    public void replaceFragment(BaseFragment fragment)
    {
        FragmentManager frgManager = this.getBaseActivity().getSupportFragmentManager();
        frgManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
