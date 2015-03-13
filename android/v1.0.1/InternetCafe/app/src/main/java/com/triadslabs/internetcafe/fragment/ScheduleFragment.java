package com.triadslabs.internetcafe.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.triadslabs.internetcafe.R;
import com.triadslabs.internetcafe.base.BaseFragment;
import com.triadslabs.utils.gesture.GestureUtil;

/**
 * Created by muzammilpeer on 1/9/15.
 */
public class ScheduleFragment extends BaseFragment {

    Button b1, b2, b3, b4;

    int b1x1, b1x2, b1y1, b1y2;

    private TextView xcordview;
    private TextView ycordview;
    private TextView buttonIndicator;
    private LinearLayout touchview;
    private static int defaultStates[];
    private Button mLastButton;
    private final static int[] STATE_PRESSED = {
            android.R.attr.state_pressed,
            android.R.attr.state_focused
                    | android.R.attr.state_enabled };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_schedule, container, false);

        initViews(rootView);
        initListener();

        showHideTabs(false);
        return rootView;
    }

    public  void initViews(View view)
    {
        xcordview = (TextView) view.findViewById(R.id.textView4);
        ycordview = (TextView) view.findViewById(R.id.textView3);
        buttonIndicator = (TextView) view.findViewById(R.id.button_indicator);
        touchview = (LinearLayout) view.findViewById(R.id.llScheduleView);

        b1 = (Button) view.findViewById(R.id.button1);
        b2 = (Button) view.findViewById(R.id.button2);
        b3 = (Button) view.findViewById(R.id.button3);
        b4 = (Button) view.findViewById(R.id.button4);
        defaultStates = b1.getBackground().getState();
    }
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.isSelected())
            {
                v.setBackgroundColor(getResources().getColor(R.color.green));
                v.setSelected(false);
            }else {
                v.setBackgroundColor(getResources().getColor(R.color.red));
                v.setSelected(true);
            }
        }
    };

    public void initListener()
    {
        b1.setOnClickListener(clickListener);
        b2.setOnClickListener(clickListener);
        b3.setOnClickListener(clickListener);
        b4.setOnClickListener(clickListener);

        touchview.setOnTouchListener(new View.OnTouchListener() {

            private boolean isInside = false;

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int x = (int) event.getX();
                int y = (int) event.getY();

                xcordview.setText(String.valueOf(x));
                ycordview.setText(String.valueOf(y));

                for (int i = 0; i < touchview.getChildCount(); i++) {
                    View current = touchview.getChildAt(i);
                    if (current instanceof Button) {
                        Button b = (Button) current;

                        if (!GestureUtil.isPointWithin(x, y, b.getLeft(), b.getRight(), b.getTop(),
                                b.getBottom())) {
                            b.getBackground().setState(defaultStates);
                        }

                        if (GestureUtil.isPointWithin(x, y, b.getLeft(), b.getRight(), b.getTop(),
                                b.getBottom())) {
                            b.getBackground().setState(STATE_PRESSED);
                            if (b != mLastButton) {
                                mLastButton = b;
                                buttonIndicator.setText(mLastButton.getText());
                                if (mLastButton.isSelected())
                                {
                                    mLastButton.setBackgroundColor(getResources().getColor(R.color.green));
                                    mLastButton.setSelected(false);
                                }else {
                                    mLastButton.setBackgroundColor(getResources().getColor(R.color.red));
                                    mLastButton.setSelected(true);
                                }
                            }
                        }

                    }
                }
                return true;
            }

        });



    }
}
