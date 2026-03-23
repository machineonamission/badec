package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.google.android.material.button.MaterialButton;

public abstract class DialogfragmentDeviceLinkBinding extends ViewDataBinding {
    public final Guideline bottomGuideline;
    public final TextView chooseProductTextview;
    public final AppCompatImageView closeBtn;
    public final MaterialButton connectButton;
    public final Guideline endGuideline;
    public final AppCompatImageView linkIcon;
    public final AppCompatImageView linkPlusIcon;
    @Bindable
    protected DeviceDetailsViewModel mDeviceDetailsViewModel;
    public final RecyclerView productList;
    public final ConstraintLayout rootLayout;
    public final Guideline startGuideline;
    public final TextView subtitle;
    public final TextView title;
    public final ConstraintLayout titleIconRoot;
    public final Guideline topGuideline;

    public abstract void setDeviceDetailsViewModel(DeviceDetailsViewModel deviceDetailsViewModel);

    protected DialogfragmentDeviceLinkBinding(Object obj, View view, int i, Guideline guideline, TextView textView, AppCompatImageView appCompatImageView, MaterialButton materialButton, Guideline guideline2, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, RecyclerView recyclerView, ConstraintLayout constraintLayout, Guideline guideline3, TextView textView2, TextView textView3, ConstraintLayout constraintLayout2, Guideline guideline4) {
        super(obj, view, i);
        this.bottomGuideline = guideline;
        this.chooseProductTextview = textView;
        this.closeBtn = appCompatImageView;
        this.connectButton = materialButton;
        this.endGuideline = guideline2;
        this.linkIcon = appCompatImageView2;
        this.linkPlusIcon = appCompatImageView3;
        this.productList = recyclerView;
        this.rootLayout = constraintLayout;
        this.startGuideline = guideline3;
        this.subtitle = textView2;
        this.title = textView3;
        this.titleIconRoot = constraintLayout2;
        this.topGuideline = guideline4;
    }

    public DeviceDetailsViewModel getDeviceDetailsViewModel() {
        return this.mDeviceDetailsViewModel;
    }

    public static DialogfragmentDeviceLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogfragmentDeviceLinkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_link, viewGroup, z, obj);
    }

    public static DialogfragmentDeviceLinkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceLinkBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogfragmentDeviceLinkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialogfragment_device_link, (ViewGroup) null, false, obj);
    }

    public static DialogfragmentDeviceLinkBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogfragmentDeviceLinkBinding bind(View view, Object obj) {
        return (DialogfragmentDeviceLinkBinding) bind(obj, view, R.layout.dialogfragment_device_link);
    }
}
