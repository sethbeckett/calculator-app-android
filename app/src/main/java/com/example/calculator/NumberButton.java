package com.example.calculator;

import android.content.Context;
import android.view.Gravity;
import android.widget.GridLayout;

import androidx.appcompat.widget.AppCompatButton;

public class NumberButton extends AppCompatButton {
    public NumberButton(Context context, ButtonData data, OnClickListener onClickListener) {
        super(context);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        //might need to add weight
        params.rowSpec = GridLayout.spec(data.row, 1, 1);
        params.columnSpec = GridLayout.spec(data.col, data.colSpan, 1);
        params.setMargins(2,2,2,2);
        setLayoutParams(params);
        setOnClickListener(onClickListener);
        setBackgroundColor(getResources().getColor(R.color.numButtonColor));
        setTextColor(getResources().getColor(R.color.buttonTextColor));
        setTextSize(24);
        setGravity(Gravity.CENTER);

    }
}
