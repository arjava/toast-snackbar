package com.arjava.diftoastsnackbar;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

public class DUtils {

    public static void inform(Activity view, String string, int text_color) {
        Snackbar snack = Snackbar.make(view.findViewById(android.R.id.content), string, Snackbar.LENGTH_LONG);
        View views = snack.getView();
        TextView tv = views.findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextColor(view.getResources().getColor(text_color));
        //change background color too ?
        views.setBackgroundColor(views.getResources().getColor(R.color.colorPrimaryDark));
        snack.show();
    }

}
