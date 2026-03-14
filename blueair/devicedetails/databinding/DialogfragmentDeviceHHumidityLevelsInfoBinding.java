package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public abstract class DialogfragmentDeviceHHumidityLevelsInfoBinding extends ViewDataBinding {
   public final ConstraintLayout contentContainer;
   public final Button doneBtn;
   public final TextView levelRangesText;
   public final TextView levelsText;
   public final TextView optimalHumiditySettings;
   public final View separator;
   public final TextView title;

   protected DialogfragmentDeviceHHumidityLevelsInfoBinding(Object var1, View var2, int var3, ConstraintLayout var4, Button var5, TextView var6, TextView var7, TextView var8, View var9, TextView var10) {
      super(var1, var2, var3);
      this.contentContainer = var4;
      this.doneBtn = var5;
      this.levelRangesText = var6;
      this.levelsText = var7;
      this.optimalHumiditySettings = var8;
      this.separator = var9;
      this.title = var10;
   }

   public static DialogfragmentDeviceHHumidityLevelsInfoBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceHHumidityLevelsInfoBinding bind(View var0, Object var1) {
      return (DialogfragmentDeviceHHumidityLevelsInfoBinding)bind(var1, var0, R.layout.dialogfragment_device_h_humidity_levels_info);
   }

   public static DialogfragmentDeviceHHumidityLevelsInfoBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static DialogfragmentDeviceHHumidityLevelsInfoBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceHHumidityLevelsInfoBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (DialogfragmentDeviceHHumidityLevelsInfoBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_h_humidity_levels_info, var1, var2, var3);
   }

   @Deprecated
   public static DialogfragmentDeviceHHumidityLevelsInfoBinding inflate(LayoutInflater var0, Object var1) {
      return (DialogfragmentDeviceHHumidityLevelsInfoBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_h_humidity_levels_info, (ViewGroup)null, false, var1);
   }
}
