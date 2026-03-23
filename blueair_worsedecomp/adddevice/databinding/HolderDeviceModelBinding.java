package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.dd.ShadowLayout;

public final class HolderDeviceModelBinding implements ViewBinding {
    public final LinearLayout layoutModel;
    public final AppCompatImageView modelImage;
    public final TextView modelName;
    private final ShadowLayout rootView;
    public final ShadowLayout slRoot;

    private HolderDeviceModelBinding(ShadowLayout shadowLayout, LinearLayout linearLayout, AppCompatImageView appCompatImageView, TextView textView, ShadowLayout shadowLayout2) {
        this.rootView = shadowLayout;
        this.layoutModel = linearLayout;
        this.modelImage = appCompatImageView;
        this.modelName = textView;
        this.slRoot = shadowLayout2;
    }

    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceModelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceModelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_model, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceModelBinding bind(View view) {
        int i = R.id.layout_model;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.model_image;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView != null) {
                i = R.id.model_name;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    ShadowLayout shadowLayout = (ShadowLayout) view;
                    return new HolderDeviceModelBinding(shadowLayout, linearLayout, appCompatImageView, textView, shadowLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
