package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.view.ProgressBlockerView;

public abstract class DialogfragmentDeviceFilterPageBinding extends ViewDataBinding {
   public final RecyclerView filterWidgets;
   @Bindable
   protected DeviceDetailsViewModel mDeviceDetailViewModel;
   public final ProgressBlockerView progressView;
   public final CoordinatorLayout rootLayout;
   public final TextView title;
   public final Toolbar toolbar;

   protected DialogfragmentDeviceFilterPageBinding(Object var1, View var2, int var3, RecyclerView var4, ProgressBlockerView var5, CoordinatorLayout var6, TextView var7, Toolbar var8) {
      super(var1, var2, var3);
      this.filterWidgets = var4;
      this.progressView = var5;
      this.rootLayout = var6;
      this.title = var7;
      this.toolbar = var8;
   }

   public static DialogfragmentDeviceFilterPageBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceFilterPageBinding bind(View var0, Object var1) {
      return (DialogfragmentDeviceFilterPageBinding)bind(var1, var0, R.layout.dialogfragment_device_filter_page);
   }

   public static DialogfragmentDeviceFilterPageBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static DialogfragmentDeviceFilterPageBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceFilterPageBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (DialogfragmentDeviceFilterPageBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_filter_page, var1, var2, var3);
   }

   @Deprecated
   public static DialogfragmentDeviceFilterPageBinding inflate(LayoutInflater var0, Object var1) {
      return (DialogfragmentDeviceFilterPageBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_filter_page, (ViewGroup)null, false, var1);
   }

   public DeviceDetailsViewModel getDeviceDetailViewModel() {
      return this.mDeviceDetailViewModel;
   }

   public abstract void setDeviceDetailViewModel(DeviceDetailsViewModel var1);
}
