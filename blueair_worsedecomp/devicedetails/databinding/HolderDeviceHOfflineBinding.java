package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class HolderDeviceHOfflineBinding implements ViewBinding {
    public final Guideline bottomGuideline;
    public final Guideline endGuideline;
    public final AppCompatImageView offlineImageview;
    private final FrameLayout rootView;
    public final Guideline startGuideline;
    public final TextView subtitle;
    public final TextView title;
    public final MaterialButton troubleshootBtn;

    private HolderDeviceHOfflineBinding(FrameLayout frameLayout, Guideline guideline, Guideline guideline2, AppCompatImageView appCompatImageView, Guideline guideline3, TextView textView, TextView textView2, MaterialButton materialButton) {
        this.rootView = frameLayout;
        this.bottomGuideline = guideline;
        this.endGuideline = guideline2;
        this.offlineImageview = appCompatImageView;
        this.startGuideline = guideline3;
        this.subtitle = textView;
        this.title = textView2;
        this.troubleshootBtn = materialButton;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceHOfflineBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceHOfflineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_h_offline, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceHOfflineBinding bind(View view) {
        int i = R.id.bottom_guideline;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
        if (guideline != null) {
            i = R.id.end_guideline;
            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline2 != null) {
                i = R.id.offline_imageview;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView != null) {
                    i = R.id.start_guideline;
                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                    if (guideline3 != null) {
                        i = R.id.subtitle;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.troubleshoot_btn;
                                MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                if (materialButton != null) {
                                    return new HolderDeviceHOfflineBinding((FrameLayout) view, guideline, guideline2, appCompatImageView, guideline3, textView, textView2, materialButton);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
