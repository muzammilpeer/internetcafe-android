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

/**
 * Created by MuzammilPeer on 1/11/2015.
 */
public class ReservationFragment extends BaseFragment {

    EditText etClientName,etClientAmount,etCheckIn,etCheckOut,etSecurityDeposit;
    Spinner spCheckOut,spSecurityDeposit;
    Button bUSB,bCamera,bCardReader,bCancel,bUpdate,bDelete;

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
        etClientName = (EditText) view.findViewById(R.id.etClientName);
        etClientAmount = (EditText) view.findViewById(R.id.etClientAmount);
        etCheckIn = (EditText) view.findViewById(R.id.etClientCheckIn);
        etCheckOut = (EditText) view.findViewById(R.id.etClientCheckOut);
        etSecurityDeposit = (EditText) view.findViewById(R.id.etClientSecurityDeposit);

        spCheckOut = (Spinner) view.findViewById(R.id.spClientCheckOut);
        spSecurityDeposit = (Spinner) view.findViewById(R.id.spClientSecurityDeposit);

        bCamera = (Button) view.findViewById(R.id.bCamera);
        bCancel = (Button) view.findViewById(R.id.bCancel);
        bCardReader = (Button) view.findViewById(R.id.bCardReader);
        bDelete = (Button) view.findViewById(R.id.bDelete);
        bUpdate = (Button) view.findViewById(R.id.bUpdate);
        bUSB = (Button) view.findViewById(R.id.bUSB);
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
