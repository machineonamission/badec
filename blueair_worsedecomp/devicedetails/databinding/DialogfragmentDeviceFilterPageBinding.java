package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.view.ProgressBlockerView;

public abstract class DialogfragmentDeviceFilterPageBinding extends ViewDataBinding {
    public final RecyclerView filterWidgets;
    @Bindable
    protected DeviceDetailsViewModel mDeviceDetailViewModel;
    public final ProgressBlockerView progressView;
    public final CoordinatorLayout rootLayout;
    public final TextView title;
    public final Toolbar toolbar;

    public abstract void setDeviceDetailViewModel(DeviceDetailsViewModel deviceDetailsViewModel);

    protected DialogfragmentDeviceFilterPageBinding(Object obj, View view, int i, RecyclerView recyclerView, ProgressBlockerView progressBlockerView, CoordinatorLayout coordinatorLayout, TextView textView, Toolbar toolbar2) {
        super(obj, view, i);
        this.filterWidgets = recyclerView;
        this.progressView = progressBlockerView;
        this.rootLayout = coordinatorLayout;
        this.title = textView;
        this.toolbar = toolbar2;
    }

    public DeviceDetailsViewModel getDeviceDetailViewModel() {
        return this.mDeviceDetailViewModel;
    }

    public static DialogfragmentDeviceFilterPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceFilterPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogfragmentDeviceFilterPageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_filter_page, viewGroup, z, obj);
    }

    public static DialogfragmentDeviceFilterPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceFilterPageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogfragmentDeviceFilterPageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_filter_page, (ViewGroup) null, false, obj);
    }

    public static DialogfragmentDeviceFilterPageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceFilterPageBinding bind(View view, Object obj) {
        return (DialogfragmentDeviceFilterPageBinding) bind(obj, view, R.layout.dialogfragment_device_filter_page);
    }
}
