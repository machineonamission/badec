package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.viewcore.R;
import com.google.android.material.button.MaterialButton;

public abstract class HolderDeviceFilterBinding extends ViewDataBinding {
   public final MaterialButton btnSelect;
   public final AppCompatImageView icon;
   public final TextView name;

   protected HolderDeviceFilterBinding(Object var1, View var2, int var3, MaterialButton var4, AppCompatImageView var5, TextView var6) {
      super(var1, var2, var3);
      this.btnSelect = var4;
      this.icon = var5;
      this.name = var6;
   }

   public static HolderDeviceFilterBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceFilterBinding bind(View var0, Object var1) {
      return (HolderDeviceFilterBinding)bind(var1, var0, R.layout.holder_device_filter);
   }

   public static HolderDeviceFilterBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static HolderDeviceFilterBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceFilterBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (HolderDeviceFilterBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_filter, var1, var2, var3);
   }

   @Deprecated
   public static HolderDeviceFilterBinding inflate(LayoutInflater var0, Object var1) {
      return (HolderDeviceFilterBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_filter, (ViewGroup)null, false, var1);
   }
}
