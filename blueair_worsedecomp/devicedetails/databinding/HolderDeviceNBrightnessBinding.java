package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.AccessibleSeekBar;

public abstract class HolderDeviceNBrightnessBinding extends ViewDataBinding {
    public final ConstraintLayout contentContainer;
    public final TextView progressText;
    public final AccessibleSeekBar seekbar;
    public final TextView title;

    protected HolderDeviceNBrightnessBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, AccessibleSeekBar accessibleSeekBar, TextView textView2) {
        super(obj, view, i);
        this.contentContainer = constraintLayout;
        this.progressText = textView;
        this.seekbar = accessibleSeekBar;
        this.title = textView2;
    }

    public static HolderDeviceNBrightnessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNBrightnessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HolderDeviceNBrightnessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_n_brightness, viewGroup, z, obj);
    }

    public static HolderDeviceNBrightnessBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNBrightnessBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HolderDeviceNBrightnessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_n_brightness, (ViewGroup) null, false, obj);
    }

    public static HolderDeviceNBrightnessBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNBrightnessBinding bind(View view, Object obj) {
        return (HolderDeviceNBrightnessBinding) bind(obj, view, R.layout.holder_device_n_brightness);
    }
}
