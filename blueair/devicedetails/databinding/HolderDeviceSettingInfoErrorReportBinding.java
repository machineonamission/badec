package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public abstract class HolderDeviceSettingInfoErrorReportBinding extends ViewDataBinding {
   public final TextView infoTitle;
   public final TextView infoView;

   protected HolderDeviceSettingInfoErrorReportBinding(Object var1, View var2, int var3, TextView var4, TextView var5) {
      super(var1, var2, var3);
      this.infoTitle = var4;
      this.infoView = var5;
   }

   public static HolderDeviceSettingInfoErrorReportBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceSettingInfoErrorReportBinding bind(View var0, Object var1) {
      return (HolderDeviceSettingInfoErrorReportBinding)bind(var1, var0, R.layout.holder_device_setting_info_error_report);
   }

   public static HolderDeviceSettingInfoErrorReportBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static HolderDeviceSettingInfoErrorReportBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceSettingInfoErrorReportBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (HolderDeviceSettingInfoErrorReportBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_setting_info_error_report, var1, var2, var3);
   }

   @Deprecated
   public static HolderDeviceSettingInfoErrorReportBinding inflate(LayoutInflater var0, Object var1) {
      return (HolderDeviceSettingInfoErrorReportBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_setting_info_error_report, (ViewGroup)null, false, var1);
   }
}
