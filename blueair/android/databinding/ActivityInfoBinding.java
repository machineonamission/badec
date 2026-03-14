package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;
import com.blueair.android.viewmodel.HomeViewModel;
import com.google.android.material.appbar.AppBarLayout;

public abstract class ActivityInfoBinding extends ViewDataBinding {
   public final AppBarLayout appbar;
   public final TextView errorText;
   public final FrameLayout infoContainer;
   @Bindable
   protected HomeViewModel mHomeViewModel;
   public final Toolbar toolbar;

   protected ActivityInfoBinding(Object var1, View var2, int var3, AppBarLayout var4, TextView var5, FrameLayout var6, Toolbar var7) {
      super(var1, var2, var3);
      this.appbar = var4;
      this.errorText = var5;
      this.infoContainer = var6;
      this.toolbar = var7;
   }

   public static ActivityInfoBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityInfoBinding bind(View var0, Object var1) {
      return (ActivityInfoBinding)bind(var1, var0, R.layout.activity_info);
   }

   public static ActivityInfoBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static ActivityInfoBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityInfoBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (ActivityInfoBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_info, var1, var2, var3);
   }

   @Deprecated
   public static ActivityInfoBinding inflate(LayoutInflater var0, Object var1) {
      return (ActivityInfoBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_info, (ViewGroup)null, false, var1);
   }

   public HomeViewModel getHomeViewModel() {
      return this.mHomeViewModel;
   }

   public abstract void setHomeViewModel(HomeViewModel var1);
}
