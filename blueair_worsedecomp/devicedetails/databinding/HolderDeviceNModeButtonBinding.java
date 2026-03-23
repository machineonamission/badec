package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public abstract class HolderDeviceNModeButtonBinding extends ViewDataBinding {
    public final AppCompatImageView infoView;
    public final AppCompatImageView modeIcon;
    public final LinearLayout modeRoot;
    public final TextView modeText;

    protected HolderDeviceNModeButtonBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.infoView = appCompatImageView;
        this.modeIcon = appCompatImageView2;
        this.modeRoot = linearLayout;
        this.modeText = textView;
    }

    public static HolderDeviceNModeButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNModeButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HolderDeviceNModeButtonBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_n_mode_button, viewGroup, z, obj);
    }

    public static HolderDeviceNModeButtonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNModeButtonBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HolderDeviceNModeButtonBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_n_mode_button, (ViewGroup) null, false, obj);
    }

    public static HolderDeviceNModeButtonBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNModeButtonBinding bind(View view, Object obj) {
        return (HolderDeviceNModeButtonBinding) bind(obj, view, R.layout.holder_device_n_mode_button);
    }
}
