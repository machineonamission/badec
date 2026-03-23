package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SwitchCompat;

public abstract class HolderDeviceNSettingsHinsBinding extends ViewDataBinding {
    public final SwitchCompat daySwitchBtn;
    public final TextView descText;
    public final SwitchCompat nightSwitchBtn;
    public final View separator;
    public final TextView title;

    protected HolderDeviceNSettingsHinsBinding(Object obj, View view, int i, SwitchCompat switchCompat, TextView textView, SwitchCompat switchCompat2, View view2, TextView textView2) {
        super(obj, view, i);
        this.daySwitchBtn = switchCompat;
        this.descText = textView;
        this.nightSwitchBtn = switchCompat2;
        this.separator = view2;
        this.title = textView2;
    }

    public static HolderDeviceNSettingsHinsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNSettingsHinsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HolderDeviceNSettingsHinsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_n_settings_hins, viewGroup, z, obj);
    }

    public static HolderDeviceNSettingsHinsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNSettingsHinsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HolderDeviceNSettingsHinsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_n_settings_hins, (ViewGroup) null, false, obj);
    }

    public static HolderDeviceNSettingsHinsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNSettingsHinsBinding bind(View view, Object obj) {
        return (HolderDeviceNSettingsHinsBinding) bind(obj, view, R.layout.holder_device_n_settings_hins);
    }
}
