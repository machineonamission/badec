package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public abstract class HolderDeviceSettingInfoErrorReportBinding extends ViewDataBinding {
    public final TextView infoTitle;
    public final TextView infoView;

    protected HolderDeviceSettingInfoErrorReportBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.infoTitle = textView;
        this.infoView = textView2;
    }

    public static HolderDeviceSettingInfoErrorReportBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceSettingInfoErrorReportBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HolderDeviceSettingInfoErrorReportBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_setting_info_error_report, viewGroup, z, obj);
    }

    public static HolderDeviceSettingInfoErrorReportBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceSettingInfoErrorReportBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HolderDeviceSettingInfoErrorReportBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_setting_info_error_report, (ViewGroup) null, false, obj);
    }

    public static HolderDeviceSettingInfoErrorReportBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceSettingInfoErrorReportBinding bind(View view, Object obj) {
        return (HolderDeviceSettingInfoErrorReportBinding) bind(obj, view, R.layout.holder_device_setting_info_error_report);
    }
}
