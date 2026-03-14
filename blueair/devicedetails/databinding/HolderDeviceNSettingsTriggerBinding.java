package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public abstract class HolderDeviceNSettingsTriggerBinding extends ViewDataBinding {
   public final RadioButton radioButtonPm;
   public final RadioButton radioButtonPmTvoc;
   public final RadioGroup radioGroupTrigger;
   public final View separator;
   public final TextView title;

   protected HolderDeviceNSettingsTriggerBinding(Object var1, View var2, int var3, RadioButton var4, RadioButton var5, RadioGroup var6, View var7, TextView var8) {
      super(var1, var2, var3);
      this.radioButtonPm = var4;
      this.radioButtonPmTvoc = var5;
      this.radioGroupTrigger = var6;
      this.separator = var7;
      this.title = var8;
   }

   public static HolderDeviceNSettingsTriggerBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceNSettingsTriggerBinding bind(View var0, Object var1) {
      return (HolderDeviceNSettingsTriggerBinding)bind(var1, var0, R.layout.holder_device_n_settings_trigger);
   }

   public static HolderDeviceNSettingsTriggerBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static HolderDeviceNSettingsTriggerBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceNSettingsTriggerBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (HolderDeviceNSettingsTriggerBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_n_settings_trigger, var1, var2, var3);
   }

   @Deprecated
   public static HolderDeviceNSettingsTriggerBinding inflate(LayoutInflater var0, Object var1) {
      return (HolderDeviceNSettingsTriggerBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_n_settings_trigger, (ViewGroup)null, false, var1);
   }
}
