package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public abstract class HolderDeviceNCleanAirEtaBinding extends ViewDataBinding {
    public final TextView cleanAirEta;

    protected HolderDeviceNCleanAirEtaBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.cleanAirEta = textView;
    }

    public static HolderDeviceNCleanAirEtaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNCleanAirEtaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (HolderDeviceNCleanAirEtaBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_n_clean_air_eta, viewGroup, z, obj);
    }

    public static HolderDeviceNCleanAirEtaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNCleanAirEtaBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (HolderDeviceNCleanAirEtaBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.holder_device_n_clean_air_eta, (ViewGroup) null, false, obj);
    }

    public static HolderDeviceNCleanAirEtaBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HolderDeviceNCleanAirEtaBinding bind(View view, Object obj) {
        return (HolderDeviceNCleanAirEtaBinding) bind(obj, view, R.layout.holder_device_n_clean_air_eta);
    }
}
