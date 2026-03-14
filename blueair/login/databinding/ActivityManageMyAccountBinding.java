package com.blueair.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.login.R;
import com.google.android.material.appbar.MaterialToolbar;

public abstract class ActivityManageMyAccountBinding extends ViewDataBinding {
   public final ConstraintLayout deleteAccountCell;
   public final ImageView deleteAccountChevron;
   public final TextView deleteAccountSummary;
   public final TextView deleteAccountTitle;
   public final ScrollView scrollableRoot;
   public final MaterialToolbar toolbar;

   protected ActivityManageMyAccountBinding(Object var1, View var2, int var3, ConstraintLayout var4, ImageView var5, TextView var6, TextView var7, ScrollView var8, MaterialToolbar var9) {
      super(var1, var2, var3);
      this.deleteAccountCell = var4;
      this.deleteAccountChevron = var5;
      this.deleteAccountSummary = var6;
      this.deleteAccountTitle = var7;
      this.scrollableRoot = var8;
      this.toolbar = var9;
   }

   public static ActivityManageMyAccountBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityManageMyAccountBinding bind(View var0, Object var1) {
      return (ActivityManageMyAccountBinding)bind(var1, var0, R.layout.activity_manage_my_account);
   }

   public static ActivityManageMyAccountBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static ActivityManageMyAccountBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityManageMyAccountBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (ActivityManageMyAccountBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_manage_my_account, var1, var2, var3);
   }

   @Deprecated
   public static ActivityManageMyAccountBinding inflate(LayoutInflater var0, Object var1) {
      return (ActivityManageMyAccountBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_manage_my_account, (ViewGroup)null, false, var1);
   }
}
