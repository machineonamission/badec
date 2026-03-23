package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public abstract class HolderDeviceHSettingsDeleteBinding extends ViewDataBinding {
    public final MaterialButton deleteBtn;

    protected HolderDeviceHSettingsDeleteBinding(Object obj, View view, int i, MaterialButton materialButton) {
        super(obj, view, i);
        this.deleteBtn = materialButton;
    }

    public static HolderDeviceHSettingsDeleteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceHSettingsDeleteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HolderDeviceHSettingsDeleteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_h_settings_delete, viewGroup, z, obj);
    }

    public static HolderDeviceHSettingsDeleteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceHSettingsDeleteBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HolderDeviceHSettingsDeleteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_h_settings_delete, (ViewGroup) null, false, obj);
    }

    public static HolderDeviceHSettingsDeleteBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceHSettingsDeleteBinding bind(View view, Object obj) {
        return (HolderDeviceHSettingsDeleteBinding) bind(obj, view, R.layout.holder_device_h_settings_delete);
    }
}
