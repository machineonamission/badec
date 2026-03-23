package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;

public abstract class DialogfragmentDeviceDetailsBinding extends ViewDataBinding {
    public final FrameLayout bannersContainer;
    public final ImageButton closeBtn;
    public final LinearLayout contentContainer;
    public final AppCompatImageView deviceIcon;
    public final TextView deviceName;
    public final FrameLayout deviceSchedulesContainer;
    public final FrameLayout deviceSettingsContainer;
    public final FrameLayout devicesAttributesContainer;
    public final FrameLayout graphContainer;
    public final TextView location;
    @Bindable
    protected DeviceDetailsViewModel mDeviceDetailViewModel;
    public final LinearLayout rootLayout;
    public final NestedScrollView scrollable;
    public final ConstraintLayout titleBar;
    public final FrameLayout welcomeHomeContainer;

    public abstract void setDeviceDetailViewModel(DeviceDetailsViewModel deviceDetailsViewModel);

    protected DialogfragmentDeviceDetailsBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageButton imageButton, LinearLayout linearLayout, AppCompatImageView appCompatImageView, TextView textView, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, FrameLayout frameLayout5, TextView textView2, LinearLayout linearLayout2, NestedScrollView nestedScrollView, ConstraintLayout constraintLayout, FrameLayout frameLayout6) {
        super(obj, view, i);
        this.bannersContainer = frameLayout;
        this.closeBtn = imageButton;
        this.contentContainer = linearLayout;
        this.deviceIcon = appCompatImageView;
        this.deviceName = textView;
        this.deviceSchedulesContainer = frameLayout2;
        this.deviceSettingsContainer = frameLayout3;
        this.devicesAttributesContainer = frameLayout4;
        this.graphContainer = frameLayout5;
        this.location = textView2;
        this.rootLayout = linearLayout2;
        this.scrollable = nestedScrollView;
        this.titleBar = constraintLayout;
        this.welcomeHomeContainer = frameLayout6;
    }

    public DeviceDetailsViewModel getDeviceDetailViewModel() {
        return this.mDeviceDetailViewModel;
    }

    public static DialogfragmentDeviceDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogfragmentDeviceDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_details, viewGroup, z, obj);
    }

    public static DialogfragmentDeviceDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceDetailsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogfragmentDeviceDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_details, (ViewGroup) null, false, obj);
    }

    public static DialogfragmentDeviceDetailsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceDetailsBinding bind(View view, Object obj) {
        return (DialogfragmentDeviceDetailsBinding) bind(obj, view, R.layout.dialogfragment_device_details);
    }
}
