package com.blueair.graph.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.graph.R;

public final class MarkerviewLabelBinding implements ViewBinding {
    public final View dashedLine;
    public final TextView markerText;
    private final FrameLayout rootView;

    private MarkerviewLabelBinding(FrameLayout frameLayout, View view, TextView textView) {
        this.rootView = frameLayout;
        this.dashedLine = view;
        this.markerText = textView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MarkerviewLabelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static MarkerviewLabelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.markerview_label, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MarkerviewLabelBinding bind(View view) {
        int i = R.id.dashed_line;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.marker_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new MarkerviewLabelBinding((FrameLayout) view, findChildViewById, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
