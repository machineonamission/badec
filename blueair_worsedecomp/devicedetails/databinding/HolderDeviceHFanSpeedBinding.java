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

public abstract class HolderDeviceHFanSpeedBinding extends ViewDataBinding {
    public final RadioGroup radioGroup;
    public final RadioButton speed0;
    public final RadioButton speed1;
    public final RadioButton speed2;
    public final RadioButton speed3;
    public final RadioButton speed4;
    public final TextView title;

    protected HolderDeviceHFanSpeedBinding(Object obj, View view, int i, RadioGroup radioGroup2, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, TextView textView) {
        super(obj, view, i);
        this.radioGroup = radioGroup2;
        this.speed0 = radioButton;
        this.speed1 = radioButton2;
        this.speed2 = radioButton3;
        this.speed3 = radioButton4;
        this.speed4 = radioButton5;
        this.title = textView;
    }

    public static HolderDeviceHFanSpeedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceHFanSpeedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HolderDeviceHFanSpeedBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_h_fan_speed, viewGroup, z, obj);
    }

    public static HolderDeviceHFanSpeedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceHFanSpeedBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HolderDeviceHFanSpeedBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_h_fan_speed, (ViewGroup) null, false, obj);
    }

    public static HolderDeviceHFanSpeedBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceHFanSpeedBinding bind(View view, Object obj) {
        return (HolderDeviceHFanSpeedBinding) bind(obj, view, R.layout.holder_device_h_fan_speed);
    }
}
