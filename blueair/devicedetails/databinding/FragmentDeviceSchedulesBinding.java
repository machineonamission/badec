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

   protected FragmentDeviceSchedulesBinding(Object var1, View var2, int var3, MaterialButton var4, TextView var5, Guideline var6, RecyclerView var7, Guideline var8) {
      super(var1, var2, var3);
      this.addSchedule = var4;
      this.deviceScheduleTitle = var5;
      this.endGuideline = var6;
      this.recyclerViewDeviceSchedules = var7;
      this.startGuideline = var8;
   }

   public static FragmentDeviceSchedulesBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentDeviceSchedulesBinding bind(View var0, Object var1) {
      return (FragmentDeviceSchedulesBinding)bind(var1, var0, R.layout.fragment_device_schedules);
   }

   public static FragmentDeviceSchedulesBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static FragmentDeviceSchedulesBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentDeviceSchedulesBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (FragmentDeviceSchedulesBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_device_schedules, var1, var2, var3);
   }

   @Deprecated
   public static FragmentDeviceSchedulesBinding inflate(LayoutInflater var0, Object var1) {
      return (FragmentDeviceSchedulesBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_device_schedules, (ViewGroup)null, false, var1);
   }

   public DeviceSchedulesViewModel getDeviceSchedulesViewModel() {
      return this.mDeviceSchedulesViewModel;
   }

   public abstract void setDeviceSchedulesViewModel(DeviceSchedulesViewModel var1);
}
