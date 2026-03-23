package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.adddevice.R;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public abstract class FragmentAddDeviceSuccessBinding extends ViewDataBinding {
    public final MaterialButton buttonContinue;
    public final Guideline guidelineCenter;
    public final AppCompatImageView ivDevice;
    public final AppCompatImageView ivIndicator;
    @Bindable
    protected AddDeviceViewModel mAddDeviceViewModel;
    public final ProgressBlockerView progressView;
    public final ConstraintLayout rootLayout;
    public final TextView tvContent;
    public final AppCompatTextView tvStatus;

    public abstract void setAddDeviceViewModel(AddDeviceViewModel addDeviceViewModel);

    protected FragmentAddDeviceSuccessBinding(Object obj, View view, int i, MaterialButton materialButton, Guideline guideline, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ProgressBlockerView progressBlockerView, ConstraintLayout constraintLayout, TextView textView, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.buttonContinue = materialButton;
        this.guidelineCenter = guideline;
        this.ivDevice = appCompatImageView;
        this.ivIndicator = appCompatImageView2;
        this.progressView = progressBlockerView;
        this.rootLayout = constraintLayout;
        this.tvContent = textView;
        this.tvStatus = appCompatTextView;
    }

    public AddDeviceViewModel getAddDeviceViewModel() {
        return this.mAddDeviceViewModel;
    }

    public static FragmentAddDeviceSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAddDeviceSuccessBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentAddDeviceSuccessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_add_device_success, viewGroup, z, obj);
    }

    public static FragmentAddDeviceSuccessBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAddDeviceSuccessBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentAddDeviceSuccessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_add_device_success, (ViewGroup) null, false, obj);
    }

    public static FragmentAddDeviceSuccessBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAddDeviceSuccessBinding bind(View view, Object obj) {
        return (FragmentAddDeviceSuccessBinding) bind(obj, view, R.layout.fragment_add_device_success);
    }
}
