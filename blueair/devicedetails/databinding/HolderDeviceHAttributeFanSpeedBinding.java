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

public abstract class HolderDeviceHAttributeFanSpeedBinding extends ViewDataBinding {
   public final TextView cleanAirEta;
   public final RadioGroup radioGroup;
   public final RadioButton speed0;
   public final RadioButton speed1;
   public final RadioButton speed2;
   public final RadioButton speed3;
   public final RadioButton speed4;
   public final TextView title;

   protected HolderDeviceHAttributeFanSpeedBinding(Object var1, View var2, int var3, TextView var4, RadioGroup var5, RadioButton var6, RadioButton var7, RadioButton var8, RadioButton var9, RadioButton var10, TextView var11) {
      super(var1, var2, var3);
      this.cleanAirEta = var4;
      this.radioGroup = var5;
      this.speed0 = var6;
      this.speed1 = var7;
      this.speed2 = var8;
      this.speed3 = var9;
      this.speed4 = var10;
      this.title = var11;
   }

   public static HolderDeviceHAttributeFanSpeedBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceHAttributeFanSpeedBinding bind(View var0, Object var1) {
      return (HolderDeviceHAttributeFanSpeedBinding)bind(var1, var0, R.layout.holder_device_h_attribute_fan_speed);
   }

   public static HolderDeviceHAttributeFanSpeedBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static HolderDeviceHAttributeFanSpeedBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceHAttributeFanSpeedBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (HolderDeviceHAttributeFanSpeedBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_h_attribute_fan_speed, var1, var2, var3);
   }

   @Deprecated
   public static HolderDeviceHAttributeFanSpeedBinding inflate(LayoutInflater var0, Object var1) {
      return (HolderDeviceHAttributeFanSpeedBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_h_attribute_fan_speed, (ViewGroup)null, false, var1);
   }
}
