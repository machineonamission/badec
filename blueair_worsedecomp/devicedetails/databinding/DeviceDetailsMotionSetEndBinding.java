package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class DeviceDetailsMotionSetEndBinding implements ViewBinding {
    public final View buttonMotionLayout;
    public final ImageView imageScrollArrow;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final ConstraintLayout sensorLayout;
    public final ConstraintLayout settingsLayout;

    private DeviceDetailsMotionSetEndBinding(ConstraintLayout constraintLayout, View view, ImageView imageView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4) {
        this.rootView = constraintLayout;
        this.buttonMotionLayout = view;
        this.imageScrollArrow = imageView;
        this.rootLayout = constraintLayout2;
        this.sensorLayout = constraintLayout3;
        this.settingsLayout = constraintLayout4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DeviceDetailsMotionSetEndBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DeviceDetailsMotionSetEndBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.device_details_motion_set_end, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DeviceDetailsMotionSetEndBinding bind(View view) {
        int i = R.id.buttonMotionLayout;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.imageScrollArrow;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.sensorLayout;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null) {
                    i = R.id.settingsLayout;
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout3 != null) {
                        return new DeviceDetailsMotionSetEndBinding(constraintLayout, findChildViewById, imageView, constraintLayout, constraintLayout2, constraintLayout3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
