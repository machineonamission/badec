package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;

public final class SwipeRightLayoutBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final AppCompatImageView standbyImageview;
    public final LinearLayout standbyModeRoot;
    public final TextView standbyTitleview;

    private SwipeRightLayoutBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout, TextView textView) {
        this.rootView = constraintLayout;
        this.standbyImageview = appCompatImageView;
        this.standbyModeRoot = linearLayout;
        this.standbyTitleview = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SwipeRightLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SwipeRightLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.swipe_right_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SwipeRightLayoutBinding bind(View view) {
        int i = R.id.standby_imageview;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.standby_mode_root;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.standby_titleview;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new SwipeRightLayoutBinding((ConstraintLayout) view, appCompatImageView, linearLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
