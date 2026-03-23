package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.adddevice.R;

public abstract class HolderSsidHiddenBinding extends ViewDataBinding {
    public final AppCompatTextView ssidName;

    protected HolderSsidHiddenBinding(Object obj, View view, int i, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.ssidName = appCompatTextView;
    }

    public static HolderSsidHiddenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderSsidHiddenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HolderSsidHiddenBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_ssid_hidden, viewGroup, z, obj);
    }

    public static HolderSsidHiddenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderSsidHiddenBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HolderSsidHiddenBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_ssid_hidden, (ViewGroup) null, false, obj);
    }

    public static HolderSsidHiddenBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderSsidHiddenBinding bind(View view, Object obj) {
        return (HolderSsidHiddenBinding) bind(obj, view, R.layout.holder_ssid_hidden);
    }
}
