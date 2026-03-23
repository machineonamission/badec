package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.dd.ShadowLayout;

public final class HolderDeviceGermShieldStatusV2Binding implements ViewBinding {
    private final ShadowLayout rootView;
    public final ShadowLayout slContainer;
    public final AppCompatTextView tvStatus;
    public final TextView tvTitle;

    private HolderDeviceGermShieldStatusV2Binding(ShadowLayout shadowLayout, ShadowLayout shadowLayout2, AppCompatTextView appCompatTextView, TextView textView) {
        this.rootView = shadowLayout;
        this.slContainer = shadowLayout2;
        this.tvStatus = appCompatTextView;
        this.tvTitle = textView;
    }

    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceGermShieldStatusV2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceGermShieldStatusV2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_germ_shield_status_v2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceGermShieldStatusV2Binding bind(View view) {
        ShadowLayout shadowLayout = (ShadowLayout) view;
        int i = R.id.tv_status;
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
        if (appCompatTextView != null) {
            i = R.id.tv_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new HolderDeviceGermShieldStatusV2Binding(shadowLayout, shadowLayout, appCompatTextView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
