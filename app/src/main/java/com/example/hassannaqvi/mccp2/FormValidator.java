package com.example.hassannaqvi.mccp2;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.TextView;

/**
 * Created by hassan.naqvi on 4/21/2016.
 */
public class FormValidator extends TextValidator implements OnFocusChangeListener {


    public FormValidator(TextView textView) {
        super(textView);
    }

    @Override
    public void validate(TextView textView, String text) {

    }


    @Override
    public boolean validate(TextView textView) {
        if (TextUtils.isEmpty(textView.getText().toString())) {
            textView.setError(textView.getHint() + "is not given!");
            return false;
        } else {
            textView.setError(null);
            return true;
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus) {
            validate((TextView) v);
        }
    }

}


