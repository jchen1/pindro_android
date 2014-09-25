package pindro.pindro.helpers;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;

import java.lang.reflect.Method;

import pindro.pindro.R;

/**
 * Created by jeff on 9/25/14.
 */
public class ActionBarUtils {

    public static void setSearchStyle(Context context, SearchView searchView) {
        int queryTextViewId = context.getResources().getIdentifier("android:id/search_src_text", null, null);
        View autoComplete = searchView.findViewById(queryTextViewId);
        try {
            Class<?> clazz = Class.forName("android.widget.SearchView$SearchAutoComplete");

            SpannableStringBuilder stopHint = new SpannableStringBuilder("   ");
            stopHint.append(context.getString(R.string.search));

            // Add the icon as an spannable
            Drawable searchIcon = context.getResources().getDrawable(R.drawable.search);
            Method textSizeMethod = clazz.getMethod("getTextSize");
            Float rawTextSize = (Float) textSizeMethod.invoke(autoComplete);
            int textSize = (int) (rawTextSize * 1.25);
            searchIcon.setBounds(0, 0, textSize, textSize);
            stopHint.setSpan(new ImageSpan(searchIcon), 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            // Set the new hint text
            Method setHintMethod = clazz.getMethod("setHint", CharSequence.class);
            setHintMethod.invoke(autoComplete, stopHint);

            // Set hint text color
            ((EditText)autoComplete).setHintTextColor(Color.WHITE);
        }
        catch (Exception e) {}

        // Set close button
        int closeButtonId = context.getResources().getIdentifier("android:id/search_close_btn", null, null);
        ImageView closeButtonImage = (ImageView) searchView.findViewById(closeButtonId);
        closeButtonImage.setImageResource(R.drawable.close);

    }
}
