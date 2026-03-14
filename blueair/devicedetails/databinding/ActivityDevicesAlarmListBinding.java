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

   protected ActivityDevicesAlarmListBinding(Object var1, View var2, int var3, AppCompatImageButton var4, RecyclerView var5, AppCompatTextView var6) {
      super(var1, var2, var3);
      this.btnBack = var4;
      this.rvList = var5;
      this.tvTitle = var6;
   }

   public static ActivityDevicesAlarmListBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityDevicesAlarmListBinding bind(View var0, Object var1) {
      return (ActivityDevicesAlarmListBinding)bind(var1, var0, R.layout.activity_devices_alarm_list);
   }

   public static ActivityDevicesAlarmListBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static ActivityDevicesAlarmListBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityDevicesAlarmListBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (ActivityDevicesAlarmListBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_devices_alarm_list, var1, var2, var3);
   }

   @Deprecated
   public static ActivityDevicesAlarmListBinding inflate(LayoutInflater var0, Object var1) {
      return (ActivityDevicesAlarmListBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_devices_alarm_list, (ViewGroup)null, false, var1);
   }
}
