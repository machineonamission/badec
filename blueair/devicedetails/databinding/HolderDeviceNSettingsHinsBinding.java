package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SwitchCompat;

public abstract class HolderDeviceNSettingsHinsBinding extends ViewDataBinding {
   public final SwitchCompat daySwitchBtn;
   public final TextView descText;
   public final SwitchCompat nightSwitchBtn;
   public final View separator;
   public final TextView title;

   protected HolderDeviceNSettingsHinsBinding(Object var1, View var2, int var3, SwitchCompat var4, TextView var5, SwitchCompat var6, View var7, TextView var8) {
      super(var1, var2, var3);
      this.daySwitchBtn = var4;
      this.descText = var5;
      this.nightSwitchBtn = var6;
      this.separator = var7;
      this.title = var8;
   }

   public static HolderDeviceNSettingsHinsBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceNSettingsHinsBinding bind(View var0, Object var1) {
      return (HolderDeviceNSettingsHinsBinding)bind(var1, var0, R.layout.holder_device_n_settings_hins);
   }

   public static HolderDeviceNSettingsHinsBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static HolderDeviceNSettingsHinsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceNSettingsHinsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (HolderDeviceNSettingsHinsBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_n_settings_hins, var1, var2, var3);
   }

   @Deprecated
   public static HolderDeviceNSettingsHinsBinding inflate(LayoutInflater var0, Object var1) {
      return (HolderDeviceNSettingsHinsBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_n_settings_hins, (ViewGroup)null, false, var1);
   }
}
