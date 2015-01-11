package com.triadslabs.internetcafe.cell;

import android.view.View;
import android.widget.TextView;

import com.triadslabs.internetcafe.R;
import com.triadslabs.internetcafe.model.DashboardItem;

/**
 * Created by MuzammilPeer on 1/11/2015.
 */
public class DashboardCell extends BaseCell {

    TextView tvRoomNumber,tvClientName,tvAccessories,tvCheckIn,tvAmount,tvCheckOut;

    @Override
    public void setupChildren(View view) {
        if (view != null) {
            //assign it to base cell view
            vBase = view;

            //inflate your views
            tvRoomNumber = (TextView) vBase.findViewById(R.id.tvRoomNumber);
            tvClientName = (TextView) vBase.findViewById(R.id.tvClientName);
            tvAccessories = (TextView) vBase.findViewById(R.id.tvAccessories);
            tvCheckIn = (TextView) vBase.findViewById(R.id.tvCheckIn);
            tvAmount = (TextView) vBase.findViewById(R.id.tvAmount);
            tvCheckOut = (TextView) vBase.findViewById(R.id.tvCheckOut);

        }
    }

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
