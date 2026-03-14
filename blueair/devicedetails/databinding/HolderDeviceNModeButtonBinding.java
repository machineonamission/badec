package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public abstract class HolderDeviceNModeButtonBinding extends ViewDataBinding {
   public final AppCompatImageView infoView;
   public final AppCompatImageView modeIcon;
   public final LinearLayout modeRoot;
   public final TextView modeText;

   protected HolderDeviceNModeButtonBinding(Object var1, View var2, int var3, AppCompatImageView var4, AppCompatImageView var5, LinearLayout var6, TextView var7) {
      super(var1, var2, var3);
      this.infoView = var4;
      this.modeIcon = var5;
      this.modeRoot = var6;
      this.modeText = var7;
   }

   public static HolderDeviceNModeButtonBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceNModeButtonBinding bind(View var0, Object var1) {
      return (HolderDeviceNModeButtonBinding)bind(var1, var0, R.layout.holder_device_n_mode_button);
   }

   public static HolderDeviceNModeButtonBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static HolderDeviceNModeButtonBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceNModeButtonBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (HolderDeviceNModeButtonBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_n_mode_button, var1, var2, var3);
   }

   @Deprecated
   public static HolderDeviceNModeButtonBinding inflate(LayoutInflater var0, Object var1) {
      return (HolderDeviceNModeButtonBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_n_mode_button, (ViewGroup)null, false, var1);
   }
}
