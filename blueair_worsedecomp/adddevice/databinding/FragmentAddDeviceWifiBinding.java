package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.blueair.adddevice.R;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public abstract class FragmentAddDeviceWifiBinding extends ViewDataBinding {
    public final MaterialButton btnRefresh;
    @Bindable
    protected AddDeviceViewModel mAddDeviceViewModel;
    public final ProgressBlockerView progressView;
    public final RecyclerView recyclerViewSsid;
    public final ConstraintLayout rootLayout;
    public final SwipeRefreshLayout swipeToRefresh;
    public final AppCompatTextView tvSubtitle;
    public final AppCompatTextView tvTitle;

    public abstract void setAddDeviceViewModel(AddDeviceViewModel addDeviceViewModel);

    protected FragmentAddDeviceWifiBinding(Object obj, View view, int i, MaterialButton materialButton, ProgressBlockerView progressBlockerView, RecyclerView recyclerView, ConstraintLayout constraintLayout, SwipeRefreshLayout swipeRefreshLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.btnRefresh = materialButton;
        this.progressView = progressBlockerView;
        this.recyclerViewSsid = recyclerView;
        this.rootLayout = constraintLayout;
        this.swipeToRefresh = swipeRefreshLayout;
        this.tvSubtitle = appCompatTextView;
        this.tvTitle = appCompatTextView2;
    }

    public AddDeviceViewModel getAddDeviceViewModel() {
        return this.mAddDeviceViewModel;
    }

    public static FragmentAddDeviceWifiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAddDeviceWifiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentAddDeviceWifiBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_add_device_wifi, viewGroup, z, obj);
    }

    public static FragmentAddDeviceWifiBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAddDeviceWifiBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentAddDeviceWifiBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_add_device_wifi, (ViewGroup) null, false, obj);
    }

    public static FragmentAddDeviceWifiBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAddDeviceWifiBinding bind(View view, Object obj) {
        return (FragmentAddDeviceWifiBinding) bind(obj, view, R.layout.fragment_add_device_wifi);
    }
}
