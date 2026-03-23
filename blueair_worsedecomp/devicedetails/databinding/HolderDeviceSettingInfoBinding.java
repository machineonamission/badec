package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public abstract class HolderDeviceSettingInfoBinding extends ViewDataBinding {
    public final TextView infoTitle;
    public final TextView infoView;
    public final Guideline leftGuideline;
    public final Guideline rightGuideline;

    protected HolderDeviceSettingInfoBinding(Object obj, View view, int i, TextView textView, TextView textView2, Guideline guideline, Guideline guideline2) {
        super(obj, view, i);
        this.infoTitle = textView;
        this.infoView = textView2;
        this.leftGuideline = guideline;
        this.rightGuideline = guideline2;
    }

    public static HolderDeviceSettingInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceSettingInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HolderDeviceSettingInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_setting_info, viewGroup, z, obj);
    }

    public static HolderDeviceSettingInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceSettingInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HolderDeviceSettingInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_setting_info, (ViewGroup) null, false, obj);
    }

    public static HolderDeviceSettingInfoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceSettingInfoBinding bind(View view, Object obj) {
        return (HolderDeviceSettingInfoBinding) bind(obj, view, R.layout.holder_device_setting_info);
    }
}
