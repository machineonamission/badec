package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceModeButtonV2Binding implements ViewBinding {
    public final AppCompatImageView modeIcon;
    public final LinearLayout modeRoot;
    public final TextView modeText;
    private final FrameLayout rootView;

    private HolderDeviceModeButtonV2Binding(FrameLayout frameLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout, TextView textView) {
        this.rootView = frameLayout;
        this.modeIcon = appCompatImageView;
        this.modeRoot = linearLayout;
        this.modeText = textView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceModeButtonV2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceModeButtonV2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_mode_button_v2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceModeButtonV2Binding bind(View view) {
        int i = R.id.mode_icon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.mode_root;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.mode_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new HolderDeviceModeButtonV2Binding((FrameLayout) view, appCompatImageView, linearLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
