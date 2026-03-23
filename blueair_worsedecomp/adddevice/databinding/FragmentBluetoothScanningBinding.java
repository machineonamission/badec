package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.adddevice.R;

public abstract class FragmentBluetoothScanningBinding extends ViewDataBinding {
    public final LottieAnimationView icon;
    public final ConstraintLayout root;
    public final TextView scanningSubtitle;
    public final TextView scanningTitle;

    protected FragmentBluetoothScanningBinding(Object obj, View view, int i, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.icon = lottieAnimationView;
        this.root = constraintLayout;
        this.scanningSubtitle = textView;
        this.scanningTitle = textView2;
    }

    public static FragmentBluetoothScanningBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBluetoothScanningBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentBluetoothScanningBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_bluetooth_scanning, viewGroup, z, obj);
    }

    public static FragmentBluetoothScanningBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBluetoothScanningBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentBluetoothScanningBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_bluetooth_scanning, (ViewGroup) null, false, obj);
    }

    public static FragmentBluetoothScanningBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBluetoothScanningBinding bind(View view, Object obj) {
        return (FragmentBluetoothScanningBinding) bind(obj, view, R.layout.fragment_bluetooth_scanning);
    }
}
