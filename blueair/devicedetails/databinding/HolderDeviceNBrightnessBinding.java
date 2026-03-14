package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.AccessibleSeekBar;

public abstract class HolderDeviceNBrightnessBinding extends ViewDataBinding {
   public final ConstraintLayout contentContainer;
   public final TextView progressText;
   public final AccessibleSeekBar seekbar;
   public final TextView title;

   protected HolderDeviceNBrightnessBinding(Object var1, View var2, int var3, ConstraintLayout var4, TextView var5, AccessibleSeekBar var6, TextView var7) {
      super(var1, var2, var3);
      this.contentContainer = var4;
      this.progressText = var5;
      this.seekbar = var6;
      this.title = var7;
   }

   public static HolderDeviceNBrightnessBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceNBrightnessBinding bind(View var0, Object var1) {
      return (HolderDeviceNBrightnessBinding)bind(var1, var0, R.layout.holder_device_n_brightness);
   }

   public static HolderDeviceNBrightnessBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static HolderDeviceNBrightnessBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceNBrightnessBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (HolderDeviceNBrightnessBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_n_brightness, var1, var2, var3);
   }

   @Deprecated
   public static HolderDeviceNBrightnessBinding inflate(LayoutInflater var0, Object var1) {
      return (HolderDeviceNBrightnessBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_n_brightness, (ViewGroup)null, false, var1);
   }
}
