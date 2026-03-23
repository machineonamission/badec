package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;

public final class NavHeaderMainBinding implements ViewBinding {
    public final ImageView imageView;
    private final LinearLayout rootView;
    public final TextView textViewUserName;

    private NavHeaderMainBinding(LinearLayout linearLayout, ImageView imageView2, TextView textView) {
        this.rootView = linearLayout;
        this.imageView = imageView2;
        this.textViewUserName = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NavHeaderMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static NavHeaderMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.nav_header_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static NavHeaderMainBinding bind(View view) {
        int i = R.id.imageView;
        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView2 != null) {
            i = R.id.textViewUserName;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new NavHeaderMainBinding((LinearLayout) view, imageView2, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
