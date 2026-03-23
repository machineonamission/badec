package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.dd.ShadowLayout;

public final class HolderDeviceAlarmsBinding implements ViewBinding {
    public final ConstraintLayout contentContainer;
    public final ImageView ivAlarm;
    private final ShadowLayout rootView;
    public final ShadowLayout slContainer;
    public final TextView tvAlarmLabel;
    public final TextView tvAlarmValue;

    private HolderDeviceAlarmsBinding(ShadowLayout shadowLayout, ConstraintLayout constraintLayout, ImageView imageView, ShadowLayout shadowLayout2, TextView textView, TextView textView2) {
        this.rootView = shadowLayout;
        this.contentContainer = constraintLayout;
        this.ivAlarm = imageView;
        this.slContainer = shadowLayout2;
        this.tvAlarmLabel = textView;
        this.tvAlarmValue = textView2;
    }

    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static HolderDeviceAlarmsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HolderDeviceAlarmsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.holder_device_alarms, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static HolderDeviceAlarmsBinding bind(View view) {
        int i = R.id.content_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.iv_alarm;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                ShadowLayout shadowLayout = (ShadowLayout) view;
                i = R.id.tv_alarmLabel;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tv_alarmValue;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new HolderDeviceAlarmsBinding(shadowLayout, constraintLayout, imageView, shadowLayout, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
