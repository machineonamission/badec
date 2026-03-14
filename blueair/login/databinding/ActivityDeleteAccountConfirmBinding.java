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

public abstract class ActivityDeleteAccountConfirmBinding extends ViewDataBinding {
   public final AppCompatImageButton btnClose;
   public final MaterialButton btnDelete;
   public final TextView description;
   public final ImageView icon;
   public final ProgressBlockerView loading;
   public final TextView notice;
   public final ScrollView scrollableRoot;
   public final MaterialToolbar toolbar;

   protected ActivityDeleteAccountConfirmBinding(Object var1, View var2, int var3, AppCompatImageButton var4, MaterialButton var5, TextView var6, ImageView var7, ProgressBlockerView var8, TextView var9, ScrollView var10, MaterialToolbar var11) {
      super(var1, var2, var3);
      this.btnClose = var4;
      this.btnDelete = var5;
      this.description = var6;
      this.icon = var7;
      this.loading = var8;
      this.notice = var9;
      this.scrollableRoot = var10;
      this.toolbar = var11;
   }

   public static ActivityDeleteAccountConfirmBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityDeleteAccountConfirmBinding bind(View var0, Object var1) {
      return (ActivityDeleteAccountConfirmBinding)bind(var1, var0, R.layout.activity_delete_account_confirm);
   }

   public static ActivityDeleteAccountConfirmBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static ActivityDeleteAccountConfirmBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityDeleteAccountConfirmBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (ActivityDeleteAccountConfirmBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_delete_account_confirm, var1, var2, var3);
   }

   @Deprecated
   public static ActivityDeleteAccountConfirmBinding inflate(LayoutInflater var0, Object var1) {
      return (ActivityDeleteAccountConfirmBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_delete_account_confirm, (ViewGroup)null, false, var1);
   }
}
