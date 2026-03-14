package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;

public abstract class HolderDeviceNCleanAirEtaBinding extends ViewDataBinding {
   public final TextView cleanAirEta;

   protected HolderDeviceNCleanAirEtaBinding(Object var1, View var2, int var3, TextView var4) {
      super(var1, var2, var3);
      this.cleanAirEta = var4;
   }

   public static HolderDeviceNCleanAirEtaBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceNCleanAirEtaBinding bind(View var0, Object var1) {
      return (HolderDeviceNCleanAirEtaBinding)bind(var1, var0, R.layout.holder_device_n_clean_air_eta);
   }

   public static HolderDeviceNCleanAirEtaBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static HolderDeviceNCleanAirEtaBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceNCleanAirEtaBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (HolderDeviceNCleanAirEtaBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_n_clean_air_eta, var1, var2, var3);
   }

   @Deprecated
   public static HolderDeviceNCleanAirEtaBinding inflate(LayoutInflater var0, Object var1) {
      return (HolderDeviceNCleanAirEtaBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_n_clean_air_eta, (ViewGroup)null, false, var1);
   }
}
