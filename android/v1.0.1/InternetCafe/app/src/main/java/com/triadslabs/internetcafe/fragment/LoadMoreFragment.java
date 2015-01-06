package com.triadslabs.internetcafe.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.triadslabs.internetcafe.R;
import com.triadslabs.internetcafe.adaptor.GeneralArrayAdapter;
import com.triadslabs.internetcafe.base.BaseFragment;
import com.triadslabs.internetcafe.cell.DrawerCell;
import com.triadslabs.internetcafe.model.DrawerItem;
import com.triadslabs.internetcafe.view.LoadMoreListView;
import com.triadslabs.internetcafe.view.LoadMoreListView.OnLoadMoreListener;

import java.util.ArrayList;

/**
 * Created by muzammilpeer on 1/6/15.
 */
public class LoadMoreFragment extends BaseFragment{

    //List View
    LoadMoreListView lmListView;
    GeneralArrayAdapter lmListAdaptor;

    Integer totalItems = 50;
    Integer pageSize = 10;
    Integer pageNumber = 0;
    ArrayList localDataSource;




    public LoadMoreFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_loadmore, container,
                false);

        initViews(view);
        initObjects();
        initListener();

        return view;
    }

    private void initViews(View view)
    {
        lmListView = (LoadMoreListView)view.findViewById(R.id.lmListView);
        lmListAdaptor = new GeneralArrayAdapter(view.getContext(), R.layout.item_view_children, DrawerCell.class,
                localDataSource);

    }

    private void  initObjects()
    {
        localDataSource = new ArrayList();
        generateRecordWithSize(pageSize);
        lmListAdaptor.notifyDataSetChanged();
    }

    private void initListener()
    {
        // set a listener to be invoked when the list reaches the end
        lmListView.setOnLoadMoreListener(new OnLoadMoreListener() {
            public void onLoadMore() {
                // Do the work to load more items at the end of list
                // here
                // new LoadDataTask().execute();
                callWebServicePaginated();
            }
        });


    }

    private void callWebServicePaginated() {
        int totalPageNumber = totalItems.intValue() / pageSize.intValue(); // Total

        if (pageNumber <= totalPageNumber) {
            pageNumber += 1; // pageNumber

            //add more record == pageSize
            generateRecordWithSize(pageSize);

        } else {
            lmListView.onLoadMoreComplete();
        }

        //update listview
        lmListAdaptor.notifyDataSetChanged();
    }

    private void generateRecordWithSize(int recordSize)
    {
        for (int i=0;i<recordSize;i++)
        {
            localDataSource.add(new DrawerItem("Test "+ i+pageNumber, R.drawable.ic_action_search));
        }
    }
}
