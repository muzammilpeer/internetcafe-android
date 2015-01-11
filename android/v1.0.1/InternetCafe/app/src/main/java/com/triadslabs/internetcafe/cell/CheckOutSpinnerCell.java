package com.triadslabs.internetcafe.cell;

import android.view.View;
import android.widget.TextView;

import com.triadslabs.internetcafe.R;

/**
 * Created by MuzammilPeer on 1/11/2015.
 */
public class CheckOutSpinnerCell extends BaseCell
{
    TextView tvTitle;

    @Override
    public void setupChildren(View view) {
        if (view != null) {
            //assign it to base cell view
            vBase = view;

            //inflate your views
            tvTitle = (TextView) vBase.findViewById(R.id.tvTitle);
        }

    }

    @Override
    public void updateCell(Object model) {
        if (model instanceof String)
        {
            tvTitle.setText((String)model);
        }
    }
}
