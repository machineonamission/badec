package com.blueair.graph.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.graph.R;

public final class MarkerviewDotOutdoorBinding implements ViewBinding {
    public final View dashedLine;
    public final ImageView img;
    private final FrameLayout rootView;

    private MarkerviewDotOutdoorBinding(FrameLayout frameLayout, View view, ImageView imageView) {
        this.rootView = frameLayout;
        this.dashedLine = view;
        this.img = imageView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MarkerviewDotOutdoorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static MarkerviewDotOutdoorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.markerview_dot_outdoor, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MarkerviewDotOutdoorBinding bind(View view) {
        int i = R.id.dashed_line;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.img;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                return new MarkerviewDotOutdoorBinding((FrameLayout) view, findChildViewById, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
