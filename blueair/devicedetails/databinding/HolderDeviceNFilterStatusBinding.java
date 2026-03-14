package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public abstract class HolderDeviceNFilterStatusBinding extends ViewDataBinding {
   public final MaterialButton buyNew;
   public final Barrier descTextBarrier;
   public final TextView expiredText;
   public final TextView hintText;
   public final FrameLayout holderDeviceNFilterStatus;
   public final MaterialButton howToReplace;
   public final LinearProgressIndicator progressBar;
   public final TextView progressText;
   public final TextView title;

   protected HolderDeviceNFilterStatusBinding(Object var1, View var2, int var3, MaterialButton var4, Barrier var5, TextView var6, TextView var7, FrameLayout var8, MaterialButton var9, LinearProgressIndicator var10, TextView var11, TextView var12) {
      super(var1, var2, var3);
      this.buyNew = var4;
      this.descTextBarrier = var5;
      this.expiredText = var6;
      this.hintText = var7;
      this.holderDeviceNFilterStatus = var8;
      this.howToReplace = var9;
      this.progressBar = var10;
      this.progressText = var11;
      this.title = var12;
   }

   public static HolderDeviceNFilterStatusBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceNFilterStatusBinding bind(View var0, Object var1) {
      return (HolderDeviceNFilterStatusBinding)bind(var1, var0, R.layout.holder_device_n_filter_status);
   }

   public static HolderDeviceNFilterStatusBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static HolderDeviceNFilterStatusBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderDeviceNFilterStatusBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (HolderDeviceNFilterStatusBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_n_filter_status, var1, var2, var3);
   }

   @Deprecated
   public static HolderDeviceNFilterStatusBinding inflate(LayoutInflater var0, Object var1) {
      return (HolderDeviceNFilterStatusBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_device_n_filter_status, (ViewGroup)null, false, var1);
   }
}
