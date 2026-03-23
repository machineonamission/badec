package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.adddevice.R;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public abstract class FragmentEnterDeviceNameBinding extends ViewDataBinding {
    public final MaterialButton buttonDone;
    public final TextInputEditText etDeviceName;
    public final TextInputLayout inputDeviceName;
    @Bindable
    protected AddDeviceViewModel mAddDeviceViewModel;
    public final ProgressBlockerView progressView;
    public final ConstraintLayout rootLayout;
    public final AppCompatTextView tvSubtitle;
    public final AppCompatTextView tvTitle;

    public abstract void setAddDeviceViewModel(AddDeviceViewModel addDeviceViewModel);

    protected FragmentEnterDeviceNameBinding(Object obj, View view, int i, MaterialButton materialButton, TextInputEditText textInputEditText, TextInputLayout textInputLayout, ProgressBlockerView progressBlockerView, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.buttonDone = materialButton;
        this.etDeviceName = textInputEditText;
        this.inputDeviceName = textInputLayout;
        this.progressView = progressBlockerView;
        this.rootLayout = constraintLayout;
        this.tvSubtitle = appCompatTextView;
        this.tvTitle = appCompatTextView2;
    }

    public AddDeviceViewModel getAddDeviceViewModel() {
        return this.mAddDeviceViewModel;
    }

    public static FragmentEnterDeviceNameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentEnterDeviceNameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentEnterDeviceNameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_enter_device_name, viewGroup, z, obj);
    }

    public static FragmentEnterDeviceNameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentEnterDeviceNameBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentEnterDeviceNameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_enter_device_name, (ViewGroup) null, false, obj);
    }

    public static FragmentEnterDeviceNameBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentEnterDeviceNameBinding bind(View view, Object obj) {
        return (FragmentEnterDeviceNameBinding) bind(obj, view, R.layout.fragment_enter_device_name);
    }
}
