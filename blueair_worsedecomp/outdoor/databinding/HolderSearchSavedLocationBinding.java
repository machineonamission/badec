package com.blueair.outdoor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.outdoor.R;

public final class HolderSearchSavedLocationBinding implements ViewBinding {
    public final TextView primaryText;
    private final LinearLayout rootView;

    private HolderSearchSavedLocationBinding(LinearLayout linearLayout, TextView textView) {
        this.rootView = linearLayout;
        this.primaryText = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HolderSearchSavedLocationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderSearchSavedLocationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_search_saved_location, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderSearchSavedLocationBinding bind(View view) {
        int i = R.id.primary_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            return new HolderSearchSavedLocationBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
