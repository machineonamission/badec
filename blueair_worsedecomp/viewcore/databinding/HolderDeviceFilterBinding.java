package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;

public abstract class HolderDeviceFilterBinding extends ViewDataBinding {
    public final MaterialButton btnSelect;
    public final AppCompatImageView icon;
    public final TextView name;

    protected HolderDeviceFilterBinding(Object obj, View view, int i, MaterialButton materialButton, AppCompatImageView appCompatImageView, TextView textView) {
        super(obj, view, i);
        this.btnSelect = materialButton;
        this.icon = appCompatImageView;
        this.name = textView;
    }

    public static HolderDeviceFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HolderDeviceFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_filter, viewGroup, z, obj);
    }

    public static HolderDeviceFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceFilterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HolderDeviceFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_filter, (ViewGroup) null, false, obj);
    }

    public static HolderDeviceFilterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceFilterBinding bind(View view, Object obj) {
        return (HolderDeviceFilterBinding) bind(obj, view, R.layout.holder_device_filter);
    }
}
