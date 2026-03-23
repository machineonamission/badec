package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public abstract class HolderDeviceNSettingsTriggerBinding extends ViewDataBinding {
    public final RadioButton radioButtonPm;
    public final RadioButton radioButtonPmTvoc;
    public final RadioGroup radioGroupTrigger;
    public final View separator;
    public final TextView title;

    protected HolderDeviceNSettingsTriggerBinding(Object obj, View view, int i, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, View view2, TextView textView) {
        super(obj, view, i);
        this.radioButtonPm = radioButton;
        this.radioButtonPmTvoc = radioButton2;
        this.radioGroupTrigger = radioGroup;
        this.separator = view2;
        this.title = textView;
    }

    public static HolderDeviceNSettingsTriggerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNSettingsTriggerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HolderDeviceNSettingsTriggerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_n_settings_trigger, viewGroup, z, obj);
    }

    public static HolderDeviceNSettingsTriggerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNSettingsTriggerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HolderDeviceNSettingsTriggerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_n_settings_trigger, (ViewGroup) null, false, obj);
    }

    public static HolderDeviceNSettingsTriggerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNSettingsTriggerBinding bind(View view, Object obj) {
        return (HolderDeviceNSettingsTriggerBinding) bind(obj, view, R.layout.holder_device_n_settings_trigger);
    }
}
