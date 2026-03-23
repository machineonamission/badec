package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;

public abstract class ActivityDevicesAlarmListBinding extends ViewDataBinding {
    public final AppCompatImageButton btnBack;
    public final RecyclerView rvList;
    public final AppCompatTextView tvTitle;

    protected ActivityDevicesAlarmListBinding(Object obj, View view, int i, AppCompatImageButton appCompatImageButton, RecyclerView recyclerView, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.btnBack = appCompatImageButton;
        this.rvList = recyclerView;
        this.tvTitle = appCompatTextView;
    }

    public static ActivityDevicesAlarmListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDevicesAlarmListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityDevicesAlarmListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_devices_alarm_list, viewGroup, z, obj);
    }

    public static ActivityDevicesAlarmListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDevicesAlarmListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityDevicesAlarmListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_devices_alarm_list, (ViewGroup) null, false, obj);
    }

    public static ActivityDevicesAlarmListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDevicesAlarmListBinding bind(View view, Object obj) {
        return (ActivityDevicesAlarmListBinding) bind(obj, view, R.layout.activity_devices_alarm_list);
    }
}
