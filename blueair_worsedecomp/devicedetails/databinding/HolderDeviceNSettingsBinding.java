package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public abstract class HolderDeviceNSettingsBinding extends ViewDataBinding {
    public final View arrow;
    public final View separator;
    public final TextView title;
    public final TextView value;

    protected HolderDeviceNSettingsBinding(Object obj, View view, int i, View view2, View view3, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.arrow = view2;
        this.separator = view3;
        this.title = textView;
        this.value = textView2;
    }

    public static HolderDeviceNSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HolderDeviceNSettingsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_n_settings, viewGroup, z, obj);
    }

    public static HolderDeviceNSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNSettingsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HolderDeviceNSettingsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_n_settings, (ViewGroup) null, false, obj);
    }

    public static HolderDeviceNSettingsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNSettingsBinding bind(View view, Object obj) {
        return (HolderDeviceNSettingsBinding) bind(obj, view, R.layout.holder_device_n_settings);
    }
}
