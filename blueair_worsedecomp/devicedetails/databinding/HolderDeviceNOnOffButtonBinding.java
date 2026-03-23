package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public abstract class HolderDeviceNOnOffButtonBinding extends ViewDataBinding {
    public final HolderDeviceNModeButtonBinding modeRoot;
    public final TextView offHint;

    protected HolderDeviceNOnOffButtonBinding(Object obj, View view, int i, HolderDeviceNModeButtonBinding holderDeviceNModeButtonBinding, TextView textView) {
        super(obj, view, i);
        this.modeRoot = holderDeviceNModeButtonBinding;
        this.offHint = textView;
    }

    public static HolderDeviceNOnOffButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNOnOffButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HolderDeviceNOnOffButtonBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_n_on_off_button, viewGroup, z, obj);
    }

    public static HolderDeviceNOnOffButtonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNOnOffButtonBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HolderDeviceNOnOffButtonBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_n_on_off_button, (ViewGroup) null, false, obj);
    }

    public static HolderDeviceNOnOffButtonBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNOnOffButtonBinding bind(View view, Object obj) {
        return (HolderDeviceNOnOffButtonBinding) bind(obj, view, R.layout.holder_device_n_on_off_button);
    }
}
