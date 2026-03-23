package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;

public abstract class FragmentFilterBinding extends ViewDataBinding {
    public final AppCompatImageView filterImage;
    @Bindable
    protected DeviceDetailsViewModel mDeviceDetailViewModel;

    public abstract void setDeviceDetailViewModel(DeviceDetailsViewModel deviceDetailsViewModel);

    protected FragmentFilterBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView) {
        super(obj, view, i);
        this.filterImage = appCompatImageView;
    }

    public DeviceDetailsViewModel getDeviceDetailViewModel() {
        return this.mDeviceDetailViewModel;
    }

    public static FragmentFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_filter, viewGroup, z, obj);
    }

    public static FragmentFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFilterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_filter, (ViewGroup) null, false, obj);
    }

    public static FragmentFilterBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFilterBinding bind(View view, Object obj) {
        return (FragmentFilterBinding) bind(obj, view, R.layout.fragment_filter);
    }
}
