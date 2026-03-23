package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public abstract class HolderDeviceNFilterStatusBinding extends ViewDataBinding {
    public final MaterialButton buyNew;
    public final Barrier descTextBarrier;
    public final TextView expiredText;
    public final TextView hintText;
    public final FrameLayout holderDeviceNFilterStatus;
    public final MaterialButton howToReplace;
    public final LinearProgressIndicator progressBar;
    public final TextView progressText;
    public final TextView title;

    protected HolderDeviceNFilterStatusBinding(Object obj, View view, int i, MaterialButton materialButton, Barrier barrier, TextView textView, TextView textView2, FrameLayout frameLayout, MaterialButton materialButton2, LinearProgressIndicator linearProgressIndicator, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.buyNew = materialButton;
        this.descTextBarrier = barrier;
        this.expiredText = textView;
        this.hintText = textView2;
        this.holderDeviceNFilterStatus = frameLayout;
        this.howToReplace = materialButton2;
        this.progressBar = linearProgressIndicator;
        this.progressText = textView3;
        this.title = textView4;
    }

    public static HolderDeviceNFilterStatusBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNFilterStatusBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HolderDeviceNFilterStatusBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_n_filter_status, viewGroup, z, obj);
    }

    public static HolderDeviceNFilterStatusBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNFilterStatusBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HolderDeviceNFilterStatusBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_n_filter_status, (ViewGroup) null, false, obj);
    }

    public static HolderDeviceNFilterStatusBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNFilterStatusBinding bind(View view, Object obj) {
        return (HolderDeviceNFilterStatusBinding) bind(obj, view, R.layout.holder_device_n_filter_status);
    }
}
