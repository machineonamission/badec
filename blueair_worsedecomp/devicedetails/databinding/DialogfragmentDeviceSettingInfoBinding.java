package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;

public abstract class DialogfragmentDeviceSettingInfoBinding extends ViewDataBinding {
    public final RecyclerView recyclerViewDeviceInfo;
    public final LinearLayout rootLayout;
    public final TextView screenTitle;
    public final Toolbar toolbar;

    protected DialogfragmentDeviceSettingInfoBinding(Object obj, View view, int i, RecyclerView recyclerView, LinearLayout linearLayout, TextView textView, Toolbar toolbar2) {
        super(obj, view, i);
        this.recyclerViewDeviceInfo = recyclerView;
        this.rootLayout = linearLayout;
        this.screenTitle = textView;
        this.toolbar = toolbar2;
    }

    public static DialogfragmentDeviceSettingInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceSettingInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogfragmentDeviceSettingInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_setting_info, viewGroup, z, obj);
    }

    public static DialogfragmentDeviceSettingInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceSettingInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogfragmentDeviceSettingInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_setting_info, (ViewGroup) null, false, obj);
    }

    public static DialogfragmentDeviceSettingInfoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceSettingInfoBinding bind(View view, Object obj) {
        return (DialogfragmentDeviceSettingInfoBinding) bind(obj, view, R.layout.dialogfragment_device_setting_info);
    }
}
