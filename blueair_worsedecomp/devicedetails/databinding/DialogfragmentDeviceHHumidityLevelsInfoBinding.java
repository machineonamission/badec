package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public abstract class DialogfragmentDeviceHHumidityLevelsInfoBinding extends ViewDataBinding {
    public final ConstraintLayout contentContainer;
    public final Button doneBtn;
    public final TextView levelRangesText;
    public final TextView levelsText;
    public final TextView optimalHumiditySettings;
    public final View separator;
    public final TextView title;

    protected DialogfragmentDeviceHHumidityLevelsInfoBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, Button button, TextView textView, TextView textView2, TextView textView3, View view2, TextView textView4) {
        super(obj, view, i);
        this.contentContainer = constraintLayout;
        this.doneBtn = button;
        this.levelRangesText = textView;
        this.levelsText = textView2;
        this.optimalHumiditySettings = textView3;
        this.separator = view2;
        this.title = textView4;
    }

    public static DialogfragmentDeviceHHumidityLevelsInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceHHumidityLevelsInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogfragmentDeviceHHumidityLevelsInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_h_humidity_levels_info, viewGroup, z, obj);
    }

    public static DialogfragmentDeviceHHumidityLevelsInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceHHumidityLevelsInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogfragmentDeviceHHumidityLevelsInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_h_humidity_levels_info, (ViewGroup) null, false, obj);
    }

    public static DialogfragmentDeviceHHumidityLevelsInfoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceHHumidityLevelsInfoBinding bind(View view, Object obj) {
        return (DialogfragmentDeviceHHumidityLevelsInfoBinding) bind(obj, view, R.layout.dialogfragment_device_h_humidity_levels_info);
    }
}
