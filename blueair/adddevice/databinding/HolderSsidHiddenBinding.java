package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.adddevice.R;

public abstract class HolderSsidHiddenBinding extends ViewDataBinding {
   public final AppCompatTextView ssidName;

   protected HolderSsidHiddenBinding(Object var1, View var2, int var3, AppCompatTextView var4) {
      super(var1, var2, var3);
      this.ssidName = var4;
   }

   public static HolderSsidHiddenBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderSsidHiddenBinding bind(View var0, Object var1) {
      return (HolderSsidHiddenBinding)bind(var1, var0, R.layout.holder_ssid_hidden);
   }

   public static HolderSsidHiddenBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static HolderSsidHiddenBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderSsidHiddenBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (HolderSsidHiddenBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_ssid_hidden, var1, var2, var3);
   }

   @Deprecated
   public static HolderSsidHiddenBinding inflate(LayoutInflater var0, Object var1) {
      return (HolderSsidHiddenBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_ssid_hidden, (ViewGroup)null, false, var1);
   }
}
