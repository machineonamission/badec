package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel;
import com.google.android.material.button.MaterialButton;

public abstract class FragmentDeviceSchedulesBinding extends ViewDataBinding {
    public final MaterialButton addSchedule;
    public final TextView deviceScheduleTitle;
    public final Guideline endGuideline;
    @Bindable
    protected DeviceSchedulesViewModel mDeviceSchedulesViewModel;
    public final RecyclerView recyclerViewDeviceSchedules;
    public final Guideline startGuideline;

    public abstract void setDeviceSchedulesViewModel(DeviceSchedulesViewModel deviceSchedulesViewModel);

    protected FragmentDeviceSchedulesBinding(Object obj, View view, int i, MaterialButton materialButton, TextView textView, Guideline guideline, RecyclerView recyclerView, Guideline guideline2) {
        super(obj, view, i);
        this.addSchedule = materialButton;
        this.deviceScheduleTitle = textView;
        this.endGuideline = guideline;
        this.recyclerViewDeviceSchedules = recyclerView;
        this.startGuideline = guideline2;
    }

    public DeviceSchedulesViewModel getDeviceSchedulesViewModel() {
        return this.mDeviceSchedulesViewModel;
    }

    public static FragmentDeviceSchedulesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDeviceSchedulesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentDeviceSchedulesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_device_schedules, viewGroup, z, obj);
    }

    public static FragmentDeviceSchedulesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDeviceSchedulesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentDeviceSchedulesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_device_schedules, (ViewGroup) null, false, obj);
    }

    public static FragmentDeviceSchedulesBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDeviceSchedulesBinding bind(View view, Object obj) {
        return (FragmentDeviceSchedulesBinding) bind(obj, view, R.layout.fragment_device_schedules);
    }
}
