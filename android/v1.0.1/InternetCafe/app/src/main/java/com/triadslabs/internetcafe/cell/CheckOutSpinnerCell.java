package com.triadslabs.internetcafe.cell;

import android.widget.TextView;

import com.triadslabs.internetcafe.R;

import butterknife.InjectView;

/**
 * Created by MuzammilPeer on 1/11/2015.
 */
public class CheckOutSpinnerCell extends BaseCell
{

    @InjectView(R.id.tvTitle) TextView tvTitle;

//    @Override
//    public void setupChildren(View view) {
//        if (view != null) {
//            //assign it to base cell view
//            vBase = view;
//            ButterKnife.inject(this, view);
//        }
//
//    }

    @Override
    public void updateCell(Object model) {
        if (model instanceof String)
        {
            tvTitle.setText((String)model);
        }
    }
}
