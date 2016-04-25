package com.example.hassannaqvi.mccp2;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hassan.naqvi on 4/21/2016.
 */
public class FormValidationFactory<T extends Activity> {

    private static List<View> possibleTextViews = new ArrayList<View>();
    private ViewGroup viewGroup;
    private View view;

    public static boolean validate() {

        for (View possibleTextView : possibleTextViews) {
            if (possibleTextView instanceof EditText) {
                String error = ((EditText) possibleTextView).getError() == null ? null : ((EditText) possibleTextView).getError().toString();
                boolean validated = TextUtils.isEmpty(error);
                if (!validated) return false;
            }
        }
        return true;
    }

    public void setUpValidators(T t) {

        viewGroup = ((ViewGroup) t.findViewById(android.R.id.content));
        view = viewGroup.getChildAt(0);
        possibleTextViews = view.getFocusables(0);

        for (View possibleTextView : possibleTextViews) {

            if (possibleTextView instanceof EditText) {
                ((EditText) possibleTextView).addTextChangedListener(new FormValidator((EditText) possibleTextView));
                possibleTextView.setOnFocusChangeListener(new FormValidator((EditText) possibleTextView));
            }
        }

    }


}
