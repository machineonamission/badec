package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.AccessibleSeekBar;

public abstract class HolderDeviceHBrightnessBinding extends ViewDataBinding {
    public final ConstraintLayout contentContainer;
    public final ImageView endIcon;
    public final TextView progressText;
    public final AccessibleSeekBar seekbar;
    public final ImageView startIcon;
    public final TextView title;

    protected HolderDeviceHBrightnessBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, AccessibleSeekBar accessibleSeekBar, ImageView imageView2, TextView textView2) {
        super(obj, view, i);
        this.contentContainer = constraintLayout;
        this.endIcon = imageView;
        this.progressText = textView;
        this.seekbar = accessibleSeekBar;
        this.startIcon = imageView2;
        this.title = textView2;
    }

    public static HolderDeviceHBrightnessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceHBrightnessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HolderDeviceHBrightnessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_h_brightness, viewGroup, z, obj);
    }

    public static HolderDeviceHBrightnessBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceHBrightnessBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HolderDeviceHBrightnessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_h_brightness, (ViewGroup) null, false, obj);
    }

    public static HolderDeviceHBrightnessBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceHBrightnessBinding bind(View view, Object obj) {
        return (HolderDeviceHBrightnessBinding) bind(obj, view, R.layout.holder_device_h_brightness);
    }
}
