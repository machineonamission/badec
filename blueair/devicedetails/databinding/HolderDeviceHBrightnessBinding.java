package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.AccessibleSeekBar;

public abstract class HolderDeviceHBrightnessBinding extends ViewDataBinding {
   public final ConstraintLayout contentContainer;
   public final ImageView endIcon;
   public final TextView progressText;
   public final AccessibleSeekBar seekbar;
   public final ImageView startIcon;
   public final TextView title;

   protected HolderDeviceHBrightnessBinding(Object var1, View var2, int var3, ConstraintLayout var4, ImageView var5, TextView var6, AccessibleSeekBar var7, ImageView var8, TextView var9) {
      super(var1, var2, var3);
      this.contentContainer = var4;
      this.endIcon = var5;
      this.progressText = var6;
      this.seekbar = var7;
      this.startIcon = var8;
      this.title = var9;
   }

   public static HolderDeviceHBrightnessBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceHBrightnessBinding bind(View var0, Object var1) {
      return (HolderDeviceHBrightnessBinding)bind(var1, var0, R.layout.holder_device_h_brightness);
   }

   public static HolderDeviceHBrightnessBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static HolderDeviceHBrightnessBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceHBrightnessBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (HolderDeviceHBrightnessBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_h_brightness, var1, var2, var3);
   }

   @Deprecated
   public static HolderDeviceHBrightnessBinding inflate(LayoutInflater var0, Object var1) {
      return (HolderDeviceHBrightnessBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_h_brightness, (ViewGroup)null, false, var1);
   }
}
