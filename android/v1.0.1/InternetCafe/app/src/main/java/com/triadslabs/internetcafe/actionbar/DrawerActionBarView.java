package com.triadslabs.internetcafe.actionbar;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.triadslabs.internetcafe.MainActivity;
import com.triadslabs.internetcafe.R;
import com.triadslabs.internetcafe.model.DrawerItem;
import android.os.Build;

/**
 * Created by muzammilpeer on 1/5/15.
 */
public class DrawerActionBarView extends BaseActionBarView {

    TextView ItemName;
    ImageButton leftIcon;
    ImageButton rightIcon;

    boolean isOpen;

    @Override
    public void setupChildren(View view) {
        if (view != null) {
            //assign it to base cell view
            vBase = view;

            //inflate your views
            ItemName = (TextView) vBase.findViewById(R.id.tvActionbarTitle);
            leftIcon = (ImageButton) vBase.findViewById(R.id.ivActionbarButton);
            rightIcon = (ImageButton) vBase.findViewById(R.id.ivActionbarSetting);

        }
    }

    @Override
    public void updateActionBar(Object model) {
        if (model instanceof DrawerItem) {
            DrawerItem dItem = (DrawerItem) model;

            ItemName.setText(dItem.getItemName());

            setListener();
        }
    }

    private View.OnClickListener cListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.e("Some message on click","testing here");
            MainActivity activity = (MainActivity)v.getContext();

            if (v.getId() == R.id.ivActionbarButton) {
                isOpen = isOpen ? false : true ;
                activity.openCloseDrawer(isOpen,true);
            }else if (v.getId() == R.id.ivActionbarSetting) {
                isOpen = isOpen ? false : true ;
                activity.openCloseDrawer(isOpen,false);
            }


        }
    };

    private void setListener()
    {
        leftIcon.setOnClickListener(cListener);
        rightIcon.setOnClickListener(cListener);
    }
}
