package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.adddevice.R;

public abstract class FragmentBluetoothScanningBinding extends ViewDataBinding {
   public final LottieAnimationView icon;
   public final ConstraintLayout root;
   public final TextView scanningSubtitle;
   public final TextView scanningTitle;

   protected FragmentBluetoothScanningBinding(Object var1, View var2, int var3, LottieAnimationView var4, ConstraintLayout var5, TextView var6, TextView var7) {
      super(var1, var2, var3);
      this.icon = var4;
      this.root = var5;
      this.scanningSubtitle = var6;
      this.scanningTitle = var7;
   }

   public static FragmentBluetoothScanningBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentBluetoothScanningBinding bind(View var0, Object var1) {
      return (FragmentBluetoothScanningBinding)bind(var1, var0, R.layout.fragment_bluetooth_scanning);
   }

   public static FragmentBluetoothScanningBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static FragmentBluetoothScanningBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentBluetoothScanningBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (FragmentBluetoothScanningBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_bluetooth_scanning, var1, var2, var3);
   }

   @Deprecated
   public static FragmentBluetoothScanningBinding inflate(LayoutInflater var0, Object var1) {
      return (FragmentBluetoothScanningBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_bluetooth_scanning, (ViewGroup)null, false, var1);
   }
}
