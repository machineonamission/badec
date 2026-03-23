package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderLinkDeviceBinding implements ViewBinding {
    public final Guideline bottomGuideline;
    public final TextView deviceName;
    public final AppCompatImageView deviceTick;
    public final Guideline endGuideline;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final Guideline startGuideline;
    public final Guideline topGuideline;

    private HolderLinkDeviceBinding(ConstraintLayout constraintLayout, Guideline guideline, TextView textView, AppCompatImageView appCompatImageView, Guideline guideline2, ConstraintLayout constraintLayout2, Guideline guideline3, Guideline guideline4) {
        this.rootView = constraintLayout;
        this.bottomGuideline = guideline;
        this.deviceName = textView;
        this.deviceTick = appCompatImageView;
        this.endGuideline = guideline2;
        this.rootLayout = constraintLayout2;
        this.startGuideline = guideline3;
        this.topGuideline = guideline4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderLinkDeviceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderLinkDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_link_device, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderLinkDeviceBinding bind(View view) {
        int i = R.id.bottom_guideline;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
        if (guideline != null) {
            i = R.id.device_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.device_tick;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView != null) {
                    i = R.id.end_guideline;
                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                    if (guideline2 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i = R.id.start_guideline;
                        Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline3 != null) {
                            i = R.id.top_guideline;
                            Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                            if (guideline4 != null) {
                                return new HolderLinkDeviceBinding(constraintLayout, guideline, textView, appCompatImageView, guideline2, constraintLayout, guideline3, guideline4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
