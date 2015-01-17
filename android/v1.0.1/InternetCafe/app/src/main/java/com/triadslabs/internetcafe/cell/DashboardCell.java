package com.triadslabs.internetcafe.cell;

import android.widget.TextView;

import com.triadslabs.internetcafe.R;
import com.triadslabs.internetcafe.model.DashboardItem;

import butterknife.InjectView;

/**
 * Created by MuzammilPeer on 1/11/2015.
 */
public class DashboardCell extends BaseCell {

    @InjectView(R.id.tvRoomNumber) TextView tvRoomNumber;
    @InjectView(R.id.tvClientName) TextView tvClientName;
    @InjectView(R.id.tvAccessories) TextView tvAccessories;
    @InjectView(R.id.tvCheckIn) TextView tvCheckIn;
    @InjectView(R.id.tvAmount) TextView tvAmount;
    @InjectView(R.id.tvCheckOut) TextView tvCheckOut;

//    @Override
//    public void initializeViews(View view) {
//        if (view != null) {
//            //assign it to base cell view
//            vBase = view;
//            ButterKnife.inject(this, view);
//        }
//    }

    @Override
    public void updateCell(Object model) {
        if (model instanceof DashboardItem) {
            DashboardItem dItem = (DashboardItem) model;

            tvRoomNumber.setText(dItem.getRoomNo());
            tvClientName.setText(dItem.getClientName());
            tvAccessories.setText(dItem.getAccessories());
            tvCheckIn.setText(dItem.getCheckIn());
            tvAmount.setText(dItem.getAmount());
            tvCheckOut.setText(dItem.getCheckOut());

        }
    }
}
