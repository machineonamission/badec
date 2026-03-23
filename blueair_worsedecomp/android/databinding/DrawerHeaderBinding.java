package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;

public final class DrawerHeaderBinding implements ViewBinding {
    public final AppCompatImageView blueairIcon;
    public final AppCompatImageView blueairIconDot;
    public final AppCompatImageView drawerCloseView;
    public final Guideline leftGuideline;
    public final Guideline middleGuideline;
    private final ConstraintLayout rootView;

    private DrawerHeaderBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, Guideline guideline, Guideline guideline2) {
        this.rootView = constraintLayout;
        this.blueairIcon = appCompatImageView;
        this.blueairIconDot = appCompatImageView2;
        this.drawerCloseView = appCompatImageView3;
        this.leftGuideline = guideline;
        this.middleGuideline = guideline2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DrawerHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DrawerHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.drawer_header, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DrawerHeaderBinding bind(View view) {
        int i = R.id.blueair_icon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.blueair_icon_dot;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView2 != null) {
                i = R.id.drawer_close_view;
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView3 != null) {
                    i = R.id.left_guideline;
                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                    if (guideline != null) {
                        i = R.id.middle_guideline;
                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline2 != null) {
                            return new DrawerHeaderBinding((ConstraintLayout) view, appCompatImageView, appCompatImageView2, appCompatImageView3, guideline, guideline2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
