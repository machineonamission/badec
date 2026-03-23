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

public abstract class HolderDeviceHAttributeFanSpeedBinding extends ViewDataBinding {
    public final TextView cleanAirEta;
    public final RadioGroup radioGroup;
    public final RadioButton speed0;
    public final RadioButton speed1;
    public final RadioButton speed2;
    public final RadioButton speed3;
    public final RadioButton speed4;
    public final TextView title;

    protected HolderDeviceHAttributeFanSpeedBinding(Object obj, View view, int i, TextView textView, RadioGroup radioGroup2, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, TextView textView2) {
        super(obj, view, i);
        this.cleanAirEta = textView;
        this.radioGroup = radioGroup2;
        this.speed0 = radioButton;
        this.speed1 = radioButton2;
        this.speed2 = radioButton3;
        this.speed3 = radioButton4;
        this.speed4 = radioButton5;
        this.title = textView2;
    }

    public static HolderDeviceHAttributeFanSpeedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceHAttributeFanSpeedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HolderDeviceHAttributeFanSpeedBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_h_attribute_fan_speed, viewGroup, z, obj);
    }

    public static HolderDeviceHAttributeFanSpeedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceHAttributeFanSpeedBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HolderDeviceHAttributeFanSpeedBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_h_attribute_fan_speed, (ViewGroup) null, false, obj);
    }

    public static HolderDeviceHAttributeFanSpeedBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceHAttributeFanSpeedBinding bind(View view, Object obj) {
        return (HolderDeviceHAttributeFanSpeedBinding) bind(obj, view, R.layout.holder_device_h_attribute_fan_speed);
    }
}
