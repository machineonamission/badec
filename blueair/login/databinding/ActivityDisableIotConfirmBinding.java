package com.blueair.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.login.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

public abstract class ActivityDisableIotConfirmBinding extends ViewDataBinding {
   public final AppCompatImageButton btnClose;
   public final MaterialButton btnDelete;
   public final TextView description;
   public final ImageView icon;
   public final ProgressBlockerView loading;
   public final ScrollView scrollableRoot;
   public final MaterialToolbar toolbar;

   protected ActivityDisableIotConfirmBinding(Object var1, View var2, int var3, AppCompatImageButton var4, MaterialButton var5, TextView var6, ImageView var7, ProgressBlockerView var8, ScrollView var9, MaterialToolbar var10) {
      super(var1, var2, var3);
      this.btnClose = var4;
      this.btnDelete = var5;
      this.description = var6;
      this.icon = var7;
      this.loading = var8;
      this.scrollableRoot = var9;
      this.toolbar = var10;
   }

   public static ActivityDisableIotConfirmBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityDisableIotConfirmBinding bind(View var0, Object var1) {
      return (ActivityDisableIotConfirmBinding)bind(var1, var0, R.layout.activity_disable_iot_confirm);
   }

   public static ActivityDisableIotConfirmBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static ActivityDisableIotConfirmBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityDisableIotConfirmBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (ActivityDisableIotConfirmBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_disable_iot_confirm, var1, var2, var3);
   }

   @Deprecated
   public static ActivityDisableIotConfirmBinding inflate(LayoutInflater var0, Object var1) {
      return (ActivityDisableIotConfirmBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_disable_iot_confirm, (ViewGroup)null, false, var1);
   }
}
