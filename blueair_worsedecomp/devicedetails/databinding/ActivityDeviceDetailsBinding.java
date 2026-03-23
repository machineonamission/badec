package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;

public abstract class ActivityDeviceDetailsBinding extends ViewDataBinding {
    public final View blocker;
    public final Group blockerGroup;
    public final FrameLayout contentFragment;
    @Bindable
    protected DeviceDetailsViewModel mDeviceDetailViewModel;
    public final ProgressBar progressUpdating;
    public final TextView textModel;
    public final TextView textName;
    public final TextView textUpdating;
    public final TextView textUpdatingDescription;
    public final Toolbar toolbar;

    public abstract void setDeviceDetailViewModel(DeviceDetailsViewModel deviceDetailsViewModel);

    protected ActivityDeviceDetailsBinding(Object obj, View view, int i, View view2, Group group, FrameLayout frameLayout, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, Toolbar toolbar2) {
        super(obj, view, i);
        this.blocker = view2;
        this.blockerGroup = group;
        this.contentFragment = frameLayout;
        this.progressUpdating = progressBar;
        this.textModel = textView;
        this.textName = textView2;
        this.textUpdating = textView3;
        this.textUpdatingDescription = textView4;
        this.toolbar = toolbar2;
    }

    public DeviceDetailsViewModel getDeviceDetailViewModel() {
        return this.mDeviceDetailViewModel;
    }

    public static ActivityDeviceDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDeviceDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityDeviceDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_device_details, viewGroup, z, obj);
    }

    public static ActivityDeviceDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDeviceDetailsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityDeviceDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_device_details, (ViewGroup) null, false, obj);
    }

    public static ActivityDeviceDetailsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDeviceDetailsBinding bind(View view, Object obj) {
        return (ActivityDeviceDetailsBinding) bind(obj, view, R.layout.activity_device_details);
    }
}
