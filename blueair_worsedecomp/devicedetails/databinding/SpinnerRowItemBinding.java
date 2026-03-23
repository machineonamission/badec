package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class SpinnerRowItemBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView row;
    public final LinearLayout spinnerLayout;

    private SpinnerRowItemBinding(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.row = textView;
        this.spinnerLayout = linearLayout2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SpinnerRowItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SpinnerRowItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.spinner_row_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SpinnerRowItemBinding bind(View view) {
        int i = R.id.row;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            return new SpinnerRowItemBinding(linearLayout, textView, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
