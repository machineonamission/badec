package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceWelcomeHomeViewModel;
import com.blueair.viewcore.view.SwitchCompat;
import com.google.android.material.button.MaterialButton;

public abstract class FragmentDeviceNWelcomeHomeBinding extends ViewDataBinding {
    public final MaterialButton addBtn;
    public final ConstraintLayout addressContainer;
    public final TextView addressText;
    public final View arrow;
    public final ImageView imLocation;
    @Bindable
    protected DeviceWelcomeHomeViewModel mVm;
    public final TextView radiusText;
    public final SwitchCompat switchBtn;
    public final TextView title;

    public abstract void setVm(DeviceWelcomeHomeViewModel deviceWelcomeHomeViewModel);

    protected FragmentDeviceNWelcomeHomeBinding(Object obj, View view, int i, MaterialButton materialButton, ConstraintLayout constraintLayout, TextView textView, View view2, ImageView imageView, TextView textView2, SwitchCompat switchCompat, TextView textView3) {
        super(obj, view, i);
        this.addBtn = materialButton;
        this.addressContainer = constraintLayout;
        this.addressText = textView;
        this.arrow = view2;
        this.imLocation = imageView;
        this.radiusText = textView2;
        this.switchBtn = switchCompat;
        this.title = textView3;
    }

    public DeviceWelcomeHomeViewModel getVm() {
        return this.mVm;
    }

    public static FragmentDeviceNWelcomeHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDeviceNWelcomeHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentDeviceNWelcomeHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_device_n_welcome_home, viewGroup, z, obj);
    }

    public static FragmentDeviceNWelcomeHomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDeviceNWelcomeHomeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentDeviceNWelcomeHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_device_n_welcome_home, (ViewGroup) null, false, obj);
    }

    public static FragmentDeviceNWelcomeHomeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDeviceNWelcomeHomeBinding bind(View view, Object obj) {
        return (FragmentDeviceNWelcomeHomeBinding) bind(obj, view, R.layout.fragment_device_n_welcome_home);
    }
}
