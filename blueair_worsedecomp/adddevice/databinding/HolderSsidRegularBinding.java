package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.adddevice.R;

public abstract class HolderSsidRegularBinding extends ViewDataBinding {
    public final AppCompatTextView ssidName;

    protected HolderSsidRegularBinding(Object obj, View view, int i, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.ssidName = appCompatTextView;
    }

    public static HolderSsidRegularBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderSsidRegularBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HolderSsidRegularBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_ssid_regular, viewGroup, z, obj);
    }

    public static HolderSsidRegularBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderSsidRegularBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HolderSsidRegularBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_ssid_regular, (ViewGroup) null, false, obj);
    }

    public static HolderSsidRegularBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderSsidRegularBinding bind(View view, Object obj) {
        return (HolderSsidRegularBinding) bind(obj, view, R.layout.holder_ssid_regular);
    }
}
