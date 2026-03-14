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

public abstract class HolderDeviceHFanSpeedBinding extends ViewDataBinding {
   public final RadioGroup radioGroup;
   public final RadioButton speed0;
   public final RadioButton speed1;
   public final RadioButton speed2;
   public final RadioButton speed3;
   public final RadioButton speed4;
   public final TextView title;

   protected HolderDeviceHFanSpeedBinding(Object var1, View var2, int var3, RadioGroup var4, RadioButton var5, RadioButton var6, RadioButton var7, RadioButton var8, RadioButton var9, TextView var10) {
      super(var1, var2, var3);
      this.radioGroup = var4;
      this.speed0 = var5;
      this.speed1 = var6;
      this.speed2 = var7;
      this.speed3 = var8;
      this.speed4 = var9;
      this.title = var10;
   }

   public static HolderDeviceHFanSpeedBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceHFanSpeedBinding bind(View var0, Object var1) {
      return (HolderDeviceHFanSpeedBinding)bind(var1, var0, R.layout.holder_device_h_fan_speed);
   }

   public static HolderDeviceHFanSpeedBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static HolderDeviceHFanSpeedBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceHFanSpeedBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (HolderDeviceHFanSpeedBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_h_fan_speed, var1, var2, var3);
   }

   @Deprecated
   public static HolderDeviceHFanSpeedBinding inflate(LayoutInflater var0, Object var1) {
      return (HolderDeviceHFanSpeedBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_h_fan_speed, (ViewGroup)null, false, var1);
   }
}
