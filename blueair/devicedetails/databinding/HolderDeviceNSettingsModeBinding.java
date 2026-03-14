package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SwitchCompat;

public abstract class HolderDeviceNSettingsModeBinding extends ViewDataBinding {
   public final TextView descText;
   public final Barrier descTopLine;
   public final View separator;
   public final SwitchCompat switchBtn;
   public final TextView title;

   protected HolderDeviceNSettingsModeBinding(Object var1, View var2, int var3, TextView var4, Barrier var5, View var6, SwitchCompat var7, TextView var8) {
      super(var1, var2, var3);
      this.descText = var4;
      this.descTopLine = var5;
      this.separator = var6;
      this.switchBtn = var7;
      this.title = var8;
   }

   public static HolderDeviceNSettingsModeBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceNSettingsModeBinding bind(View var0, Object var1) {
      return (HolderDeviceNSettingsModeBinding)bind(var1, var0, R.layout.holder_device_n_settings_mode);
   }

   public static HolderDeviceNSettingsModeBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static HolderDeviceNSettingsModeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceNSettingsModeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (HolderDeviceNSettingsModeBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_n_settings_mode, var1, var2, var3);
   }

   @Deprecated
   public static HolderDeviceNSettingsModeBinding inflate(LayoutInflater var0, Object var1) {
      return (HolderDeviceNSettingsModeBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_n_settings_mode, (ViewGroup)null, false, var1);
   }
}
