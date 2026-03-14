package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public abstract class HolderDeviceNSettingsBinding extends ViewDataBinding {
   public final View arrow;
   public final View separator;
   public final TextView title;
   public final TextView value;

   protected HolderDeviceNSettingsBinding(Object var1, View var2, int var3, View var4, View var5, TextView var6, TextView var7) {
      super(var1, var2, var3);
      this.arrow = var4;
      this.separator = var5;
      this.title = var6;
      this.value = var7;
   }

   public static HolderDeviceNSettingsBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceNSettingsBinding bind(View var0, Object var1) {
      return (HolderDeviceNSettingsBinding)bind(var1, var0, R.layout.holder_device_n_settings);
   }

   public static HolderDeviceNSettingsBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static HolderDeviceNSettingsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceNSettingsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (HolderDeviceNSettingsBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_n_settings, var1, var2, var3);
   }

   @Deprecated
   public static HolderDeviceNSettingsBinding inflate(LayoutInflater var0, Object var1) {
      return (HolderDeviceNSettingsBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_n_settings, (ViewGroup)null, false, var1);
   }
}
