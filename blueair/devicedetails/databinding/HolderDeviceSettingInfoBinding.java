package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public abstract class HolderDeviceSettingInfoBinding extends ViewDataBinding {
   public final TextView infoTitle;
   public final TextView infoView;
   public final Guideline leftGuideline;
   public final Guideline rightGuideline;

   protected HolderDeviceSettingInfoBinding(Object var1, View var2, int var3, TextView var4, TextView var5, Guideline var6, Guideline var7) {
      super(var1, var2, var3);
      this.infoTitle = var4;
      this.infoView = var5;
      this.leftGuideline = var6;
      this.rightGuideline = var7;
   }

   public static HolderDeviceSettingInfoBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceSettingInfoBinding bind(View var0, Object var1) {
      return (HolderDeviceSettingInfoBinding)bind(var1, var0, R.layout.holder_device_setting_info);
   }

   public static HolderDeviceSettingInfoBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static HolderDeviceSettingInfoBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceSettingInfoBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (HolderDeviceSettingInfoBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_setting_info, var1, var2, var3);
   }

   @Deprecated
   public static HolderDeviceSettingInfoBinding inflate(LayoutInflater var0, Object var1) {
      return (HolderDeviceSettingInfoBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_setting_info, (ViewGroup)null, false, var1);
   }
}
