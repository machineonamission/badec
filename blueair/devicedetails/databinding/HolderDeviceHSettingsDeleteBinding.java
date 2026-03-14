package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public abstract class HolderDeviceHSettingsDeleteBinding extends ViewDataBinding {
   public final MaterialButton deleteBtn;

   protected HolderDeviceHSettingsDeleteBinding(Object var1, View var2, int var3, MaterialButton var4) {
      super(var1, var2, var3);
      this.deleteBtn = var4;
   }

   public static HolderDeviceHSettingsDeleteBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceHSettingsDeleteBinding bind(View var0, Object var1) {
      return (HolderDeviceHSettingsDeleteBinding)bind(var1, var0, R.layout.holder_device_h_settings_delete);
   }

   public static HolderDeviceHSettingsDeleteBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static HolderDeviceHSettingsDeleteBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceHSettingsDeleteBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (HolderDeviceHSettingsDeleteBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_h_settings_delete, var1, var2, var3);
   }

   @Deprecated
   public static HolderDeviceHSettingsDeleteBinding inflate(LayoutInflater var0, Object var1) {
      return (HolderDeviceHSettingsDeleteBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_h_settings_delete, (ViewGroup)null, false, var1);
   }
}
