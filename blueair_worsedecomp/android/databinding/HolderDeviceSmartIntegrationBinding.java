package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;

public final class HolderDeviceSmartIntegrationBinding implements ViewBinding {
    public final ConstraintLayout clickview;
    public final AppCompatImageView deviceImageView;
    public final TextView deviceName;
    private final ConstraintLayout rootView;

    private HolderDeviceSmartIntegrationBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, TextView textView) {
        this.rootView = constraintLayout;
        this.clickview = constraintLayout2;
        this.deviceImageView = appCompatImageView;
        this.deviceName = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceSmartIntegrationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceSmartIntegrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_smart_integration, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceSmartIntegrationBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.device_image_view;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.device_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new HolderDeviceSmartIntegrationBinding(constraintLayout, constraintLayout, appCompatImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
