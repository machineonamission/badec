package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SwitchCompat;

public abstract class HolderDeviceNSettingsModeBinding extends ViewDataBinding {
    public final TextView descText;
    public final Barrier descTopLine;
    public final View separator;
    public final SwitchCompat switchBtn;
    public final TextView title;

    protected HolderDeviceNSettingsModeBinding(Object obj, View view, int i, TextView textView, Barrier barrier, View view2, SwitchCompat switchCompat, TextView textView2) {
        super(obj, view, i);
        this.descText = textView;
        this.descTopLine = barrier;
        this.separator = view2;
        this.switchBtn = switchCompat;
        this.title = textView2;
    }

    public static HolderDeviceNSettingsModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNSettingsModeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HolderDeviceNSettingsModeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_n_settings_mode, viewGroup, z, obj);
    }

    public static HolderDeviceNSettingsModeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNSettingsModeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HolderDeviceNSettingsModeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_n_settings_mode, (ViewGroup) null, false, obj);
    }

    public static HolderDeviceNSettingsModeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNSettingsModeBinding bind(View view, Object obj) {
        return (HolderDeviceNSettingsModeBinding) bind(obj, view, R.layout.holder_device_n_settings_mode);
    }
}
