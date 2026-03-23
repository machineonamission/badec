package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.adddevice.R;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;

public abstract class ActivityAddDeviceBinding extends ViewDataBinding {
    public final Barrier bottomButtonsBarrier;
    public final FrameLayout contentFragment;
    public final AppCompatTextView helpButton;
    @Bindable
    protected AddDeviceViewModel mAddDeviceViewModel;
    public final ViewcoreAppbarBinding viewcoreAppbar;

    public abstract void setAddDeviceViewModel(AddDeviceViewModel addDeviceViewModel);

    protected ActivityAddDeviceBinding(Object obj, View view, int i, Barrier barrier, FrameLayout frameLayout, AppCompatTextView appCompatTextView, ViewcoreAppbarBinding viewcoreAppbarBinding) {
        super(obj, view, i);
        this.bottomButtonsBarrier = barrier;
        this.contentFragment = frameLayout;
        this.helpButton = appCompatTextView;
        this.viewcoreAppbar = viewcoreAppbarBinding;
    }

    public AddDeviceViewModel getAddDeviceViewModel() {
        return this.mAddDeviceViewModel;
    }

    public static ActivityAddDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAddDeviceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityAddDeviceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_add_device, viewGroup, z, obj);
    }

    public static ActivityAddDeviceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAddDeviceBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityAddDeviceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_add_device, (ViewGroup) null, false, obj);
    }

    public static ActivityAddDeviceBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAddDeviceBinding bind(View view, Object obj) {
        return (ActivityAddDeviceBinding) bind(obj, view, R.layout.activity_add_device);
    }
}
