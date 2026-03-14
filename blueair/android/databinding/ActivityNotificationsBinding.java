package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.R;
import com.blueair.android.viewmodel.NotificationsViewModel;

public abstract class ActivityNotificationsBinding extends ViewDataBinding {
   public final AppCompatImageButton btnBack;
   @Bindable
   protected NotificationsViewModel mViewModel;
   public final RecyclerView rvList;
   public final AppCompatTextView tvDismissAll;
   public final AppCompatTextView tvIndoorDeviceNum;
   public final AppCompatTextView tvLabelNew;
   public final AppCompatTextView tvTitle;

   protected ActivityNotificationsBinding(Object var1, View var2, int var3, AppCompatImageButton var4, RecyclerView var5, AppCompatTextView var6, AppCompatTextView var7, AppCompatTextView var8, AppCompatTextView var9) {
      super(var1, var2, var3);
      this.btnBack = var4;
      this.rvList = var5;
      this.tvDismissAll = var6;
      this.tvIndoorDeviceNum = var7;
      this.tvLabelNew = var8;
      this.tvTitle = var9;
   }

   public static ActivityNotificationsBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityNotificationsBinding bind(View var0, Object var1) {
      return (ActivityNotificationsBinding)bind(var1, var0, R.layout.activity_notifications);
   }

   public static ActivityNotificationsBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static ActivityNotificationsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityNotificationsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (ActivityNotificationsBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_notifications, var1, var2, var3);
   }

   @Deprecated
   public static ActivityNotificationsBinding inflate(LayoutInflater var0, Object var1) {
      return (ActivityNotificationsBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_notifications, (ViewGroup)null, false, var1);
   }

   public NotificationsViewModel getViewModel() {
      return this.mViewModel;
   }

   public abstract void setViewModel(NotificationsViewModel var1);
}
