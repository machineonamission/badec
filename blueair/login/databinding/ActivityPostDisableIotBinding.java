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
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

public abstract class ActivityPostDisableIotBinding extends ViewDataBinding {
   public final AppCompatImageButton btnClose;
   public final MaterialButton btnOkay;
   public final TextView description;
   public final ImageView icon;
   public final ScrollView scrollableRoot;
   public final MaterialToolbar toolbar;

   protected ActivityPostDisableIotBinding(Object var1, View var2, int var3, AppCompatImageButton var4, MaterialButton var5, TextView var6, ImageView var7, ScrollView var8, MaterialToolbar var9) {
      super(var1, var2, var3);
      this.btnClose = var4;
      this.btnOkay = var5;
      this.description = var6;
      this.icon = var7;
      this.scrollableRoot = var8;
      this.toolbar = var9;
   }

   public static ActivityPostDisableIotBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityPostDisableIotBinding bind(View var0, Object var1) {
      return (ActivityPostDisableIotBinding)bind(var1, var0, R.layout.activity_post_disable_iot);
   }

   public static ActivityPostDisableIotBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static ActivityPostDisableIotBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityPostDisableIotBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (ActivityPostDisableIotBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_post_disable_iot, var1, var2, var3);
   }

   @Deprecated
   public static ActivityPostDisableIotBinding inflate(LayoutInflater var0, Object var1) {
      return (ActivityPostDisableIotBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_post_disable_iot, (ViewGroup)null, false, var1);
   }
}
