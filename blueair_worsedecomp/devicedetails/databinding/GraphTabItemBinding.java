package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class GraphTabItemBinding implements ViewBinding {
    public final ImageButton infoIcon;
    private final LinearLayout rootView;
    public final TextView text;

    private GraphTabItemBinding(LinearLayout linearLayout, ImageButton imageButton, TextView textView) {
        this.rootView = linearLayout;
        this.infoIcon = imageButton;
        this.text = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static GraphTabItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static GraphTabItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.graph_tab_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static GraphTabItemBinding bind(View view) {
        int i = R.id.info_icon;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = R.id.text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new GraphTabItemBinding((LinearLayout) view, imageButton, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
