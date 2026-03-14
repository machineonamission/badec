package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.adddevice.R;

public abstract class HolderSsidRegularBinding extends ViewDataBinding {
   public final AppCompatTextView ssidName;

   protected HolderSsidRegularBinding(Object var1, View var2, int var3, AppCompatTextView var4) {
      super(var1, var2, var3);
      this.ssidName = var4;
   }

   public static HolderSsidRegularBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderSsidRegularBinding bind(View var0, Object var1) {
      return (HolderSsidRegularBinding)bind(var1, var0, R.layout.holder_ssid_regular);
   }

   public static HolderSsidRegularBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static HolderSsidRegularBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderSsidRegularBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (HolderSsidRegularBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_ssid_regular, var1, var2, var3);
   }

   @Deprecated
   public static HolderSsidRegularBinding inflate(LayoutInflater var0, Object var1) {
      return (HolderSsidRegularBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_ssid_regular, (ViewGroup)null, false, var1);
   }
}
