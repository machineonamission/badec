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

public abstract class FragmentDeviceWelcomeHomeBinding extends ViewDataBinding {
    public final MaterialButton btnAddHome;
    public final TextView homeAddress;
    public final ImageView imLocation;
    public final ConstraintLayout layoutAddress;
    @Bindable
    protected DeviceWelcomeHomeViewModel mVm;
    public final TextView radius;
    public final TextView radiusValue;
    public final SwitchCompat welcomeHomeSwitch;
    public final TextView welcomeHomeTitle;

    public abstract void setVm(DeviceWelcomeHomeViewModel deviceWelcomeHomeViewModel);

    protected FragmentDeviceWelcomeHomeBinding(Object obj, View view, int i, MaterialButton materialButton, TextView textView, ImageView imageView, ConstraintLayout constraintLayout, TextView textView2, TextView textView3, SwitchCompat switchCompat, TextView textView4) {
        super(obj, view, i);
        this.btnAddHome = materialButton;
        this.homeAddress = textView;
        this.imLocation = imageView;
        this.layoutAddress = constraintLayout;
        this.radius = textView2;
        this.radiusValue = textView3;
        this.welcomeHomeSwitch = switchCompat;
        this.welcomeHomeTitle = textView4;
    }

    public DeviceWelcomeHomeViewModel getVm() {
        return this.mVm;
    }

    public static FragmentDeviceWelcomeHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDeviceWelcomeHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentDeviceWelcomeHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_device_welcome_home, viewGroup, z, obj);
    }

    public static FragmentDeviceWelcomeHomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDeviceWelcomeHomeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentDeviceWelcomeHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_device_welcome_home, (ViewGroup) null, false, obj);
    }

    public static FragmentDeviceWelcomeHomeBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDeviceWelcomeHomeBinding bind(View view, Object obj) {
        return (FragmentDeviceWelcomeHomeBinding) bind(obj, view, R.layout.fragment_device_welcome_home);
    }
}
