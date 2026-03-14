package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public abstract class FragmentClassicTroubleshootingBinding extends ViewDataBinding {
   public final MaterialButton btnNext;
   public final ImageView imgWifiBlinking;
   public final ImageView imgWifiFading;
   public final ImageView imgWifiFadingFast;
   public final ImageView imgWifiSolid;
   public final RadioButton radioBtnWifiBlinking;
   public final RadioButton radioBtnWifiFading;
   public final RadioButton radioBtnWifiFadingFast;
   public final RadioButton radioBtnWifiSolid;
   public final ScrollView scrollable;
   public final TextView txtError;
   public final TextView txtHint;
   public final TextView txtTitle;

   protected FragmentClassicTroubleshootingBinding(Object var1, View var2, int var3, MaterialButton var4, ImageView var5, ImageView var6, ImageView var7, ImageView var8, RadioButton var9, RadioButton var10, RadioButton var11, RadioButton var12, ScrollView var13, TextView var14, TextView var15, TextView var16) {
      super(var1, var2, var3);
      this.btnNext = var4;
      this.imgWifiBlinking = var5;
      this.imgWifiFading = var6;
      this.imgWifiFadingFast = var7;
      this.imgWifiSolid = var8;
      this.radioBtnWifiBlinking = var9;
      this.radioBtnWifiFading = var10;
      this.radioBtnWifiFadingFast = var11;
      this.radioBtnWifiSolid = var12;
      this.scrollable = var13;
      this.txtError = var14;
      this.txtHint = var15;
      this.txtTitle = var16;
   }

   public static FragmentClassicTroubleshootingBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentClassicTroubleshootingBinding bind(View var0, Object var1) {
      return (FragmentClassicTroubleshootingBinding)bind(var1, var0, R.layout.fragment_classic_troubleshooting);
   }

   public static FragmentClassicTroubleshootingBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static FragmentClassicTroubleshootingBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentClassicTroubleshootingBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (FragmentClassicTroubleshootingBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_classic_troubleshooting, var1, var2, var3);
   }

   @Deprecated
   public static FragmentClassicTroubleshootingBinding inflate(LayoutInflater var0, Object var1) {
      return (FragmentClassicTroubleshootingBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_classic_troubleshooting, (ViewGroup)null, false, var1);
   }
}
