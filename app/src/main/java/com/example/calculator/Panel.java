package com.example.calculator;

import android.content.Context;
import android.view.Gravity;
import android.widget.GridLayout;

import androidx.appcompat.widget.AppCompatTextView;

public class Panel extends AppCompatTextView {
    public Panel(Context context) {
        super(context);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.rowSpec = GridLayout.spec(0, 1, 1);
        params.columnSpec = GridLayout.spec(0, 3, 1);
        setLayoutParams(params);
        setTextColor(getResources().getColor(R.color.panelTextColor));
        setGravity(Gravity.CENTER);
        setTextSize(24);
        setText("");
    }
}
