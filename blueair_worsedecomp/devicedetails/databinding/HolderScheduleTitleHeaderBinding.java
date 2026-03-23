package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderScheduleTitleHeaderBinding implements ViewBinding {
    public final Guideline bottomGuideline;
    private final ConstraintLayout rootView;
    public final TextView title;
    public final Guideline topGuideline;

    private HolderScheduleTitleHeaderBinding(ConstraintLayout constraintLayout, Guideline guideline, TextView textView, Guideline guideline2) {
        this.rootView = constraintLayout;
        this.bottomGuideline = guideline;
        this.title = textView;
        this.topGuideline = guideline2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderScheduleTitleHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderScheduleTitleHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_schedule_title_header, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderScheduleTitleHeaderBinding bind(View view) {
        int i = R.id.bottom_guideline;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
        if (guideline != null) {
            i = R.id.title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.top_guideline;
                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                if (guideline2 != null) {
                    return new HolderScheduleTitleHeaderBinding((ConstraintLayout) view, guideline, textView, guideline2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
