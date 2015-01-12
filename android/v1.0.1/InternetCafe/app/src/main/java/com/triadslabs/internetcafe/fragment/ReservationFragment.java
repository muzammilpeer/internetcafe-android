package com.triadslabs.internetcafe.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.triadslabs.internetcafe.R;
import com.triadslabs.internetcafe.adaptor.GeneralArrayAdapter;
import com.triadslabs.internetcafe.base.BaseFragment;
import com.triadslabs.internetcafe.cell.CheckOutSpinnerCell;
import com.triadslabs.internetcafe.listener.ReservationClickListener;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by MuzammilPeer on 1/11/2015.
 */
public class ReservationFragment extends BaseFragment {

    @InjectView(R.id.etClientName) EditText etClientName;
    @InjectView(R.id.etClientAmount) EditText etClientAmount;
    @InjectView(R.id.etClientCheckIn) EditText etCheckIn;
    @InjectView(R.id.etClientCheckOut) EditText etCheckOut;
    @InjectView(R.id.etClientSecurityDeposit) EditText etSecurityDeposit;

    @InjectView(R.id.spClientCheckOut) Spinner spCheckOut;
    @InjectView(R.id.spClientSecurityDeposit) Spinner spSecurityDeposit;

    @InjectView(R.id.bUSB) Button bUSB;
    @InjectView(R.id.bCamera) Button bCamera;
    @InjectView(R.id.bCardReader) Button bCardReader;
    @InjectView(R.id.bCancel) Button bCancel;
    @InjectView(R.id.bUpdate) Button bUpdate;
    @InjectView(R.id.bDelete) Button bDelete;


    GeneralArrayAdapter adCheckOut,adSecurityDeposit;
    ArrayList checkOutDataSource,securityDataSource;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_reservation, container, false);

        showHideTabs(false);

        initViews(rootView);
        initObjects(rootView);
        initListener();

        return rootView;
    }

    private void initViews(View view)
    {
        ButterKnife.inject(this, view);
    }

    private void initObjects(View view)
    {
        generateCheckOutData();
        generateSecurityDeposit();

        adCheckOut = new GeneralArrayAdapter(getContext(),R.layout.cell_spinner_security,checkOutDataSource,CheckOutSpinnerCell.class);
        adSecurityDeposit = new GeneralArrayAdapter(getContext(),R.layout.cell_spinner_security,securityDataSource,CheckOutSpinnerCell.class);

        spSecurityDeposit.setAdapter(adSecurityDeposit);
        spCheckOut.setAdapter(adCheckOut);

    }

    private void generateCheckOutData()
    {
        checkOutDataSource = new ArrayList();
        checkOutDataSource.add("00:00 AM");
        checkOutDataSource.add("01:00 AM");
        checkOutDataSource.add("02:00 AM");
        checkOutDataSource.add("03:00 AM");
    }

    private void generateSecurityDeposit()
    {
        securityDataSource = new ArrayList();
        securityDataSource.add("CNIC");
        securityDataSource.add("Amount");
        securityDataSource.add("Reference");
    }
    private  void initListener()
    {
        bUpdate.setOnClickListener(new ReservationClickListener());
        bCancel.setOnClickListener(new ReservationClickListener());
        bDelete.setOnClickListener(new ReservationClickListener());
    }


}
