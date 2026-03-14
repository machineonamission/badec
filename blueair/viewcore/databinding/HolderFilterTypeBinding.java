package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.viewcore.R;
import com.dd.ShadowLayout;

public abstract class HolderFilterTypeBinding extends ViewDataBinding {
   public final FrameLayout flIcon;
   public final AppCompatImageView icon;
   public final ImageView ivInfo;
   public final AppCompatTextView name;
   public final ShadowLayout slIcon;

   protected HolderFilterTypeBinding(Object var1, View var2, int var3, FrameLayout var4, AppCompatImageView var5, ImageView var6, AppCompatTextView var7, ShadowLayout var8) {
      super(var1, var2, var3);
      this.flIcon = var4;
      this.icon = var5;
      this.ivInfo = var6;
      this.name = var7;
      this.slIcon = var8;
   }

   public static HolderFilterTypeBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderFilterTypeBinding bind(View var0, Object var1) {
      return (HolderFilterTypeBinding)bind(var1, var0, R.layout.holder_filter_type);
   }

   public static HolderFilterTypeBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static HolderFilterTypeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static HolderFilterTypeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (HolderFilterTypeBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_filter_type, var1, var2, var3);
   }

   @Deprecated
   public static HolderFilterTypeBinding inflate(LayoutInflater var0, Object var1) {
      return (HolderFilterTypeBinding)ViewDataBinding.inflateInternal(var0, R.layout.holder_filter_type, (ViewGroup)null, false, var1);
   }
}
