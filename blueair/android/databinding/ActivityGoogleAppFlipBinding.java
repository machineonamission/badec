package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public abstract class ActivityGoogleAppFlipBinding extends ViewDataBinding {
   public final MaterialButton btnAgree;
   public final MaterialButton btnCancel;
   public final ScrollView dataUsageContent;
   public final AppCompatImageView imgLogo;
   public final ProgressBlockerView loading;
   public final TextView reviewPolicy;
   public final TextView signedInAs;
   public final TextView title;
   public final TextView unlinkHint;

   protected ActivityGoogleAppFlipBinding(Object var1, View var2, int var3, MaterialButton var4, MaterialButton var5, ScrollView var6, AppCompatImageView var7, ProgressBlockerView var8, TextView var9, TextView var10, TextView var11, TextView var12) {
      super(var1, var2, var3);
      this.btnAgree = var4;
      this.btnCancel = var5;
      this.dataUsageContent = var6;
      this.imgLogo = var7;
      this.loading = var8;
      this.reviewPolicy = var9;
      this.signedInAs = var10;
      this.title = var11;
      this.unlinkHint = var12;
   }

   public static ActivityGoogleAppFlipBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityGoogleAppFlipBinding bind(View var0, Object var1) {
      return (ActivityGoogleAppFlipBinding)bind(var1, var0, R.layout.activity_google_app_flip);
   }

   public static ActivityGoogleAppFlipBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static ActivityGoogleAppFlipBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityGoogleAppFlipBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (ActivityGoogleAppFlipBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_google_app_flip, var1, var2, var3);
   }

   @Deprecated
   public static ActivityGoogleAppFlipBinding inflate(LayoutInflater var0, Object var1) {
      return (ActivityGoogleAppFlipBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_google_app_flip, (ViewGroup)null, false, var1);
   }
}
