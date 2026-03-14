package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;

public abstract class ActivityDeviceDetailsBinding extends ViewDataBinding {
   public final View blocker;
   public final Group blockerGroup;
   public final FrameLayout contentFragment;
   @Bindable
   protected DeviceDetailsViewModel mDeviceDetailViewModel;
   public final ProgressBar progressUpdating;
   public final TextView textModel;
   public final TextView textName;
   public final TextView textUpdating;
   public final TextView textUpdatingDescription;
   public final Toolbar toolbar;

   protected ActivityDeviceDetailsBinding(Object var1, View var2, int var3, View var4, Group var5, FrameLayout var6, ProgressBar var7, TextView var8, TextView var9, TextView var10, TextView var11, Toolbar var12) {
      super(var1, var2, var3);
      this.blocker = var4;
      this.blockerGroup = var5;
      this.contentFragment = var6;
      this.progressUpdating = var7;
      this.textModel = var8;
      this.textName = var9;
      this.textUpdating = var10;
      this.textUpdatingDescription = var11;
      this.toolbar = var12;
   }

   public static ActivityDeviceDetailsBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityDeviceDetailsBinding bind(View var0, Object var1) {
      return (ActivityDeviceDetailsBinding)bind(var1, var0, R.layout.activity_device_details);
   }

   public static ActivityDeviceDetailsBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static ActivityDeviceDetailsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityDeviceDetailsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (ActivityDeviceDetailsBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_device_details, var1, var2, var3);
   }

   @Deprecated
   public static ActivityDeviceDetailsBinding inflate(LayoutInflater var0, Object var1) {
      return (ActivityDeviceDetailsBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_device_details, (ViewGroup)null, false, var1);
   }

   public DeviceDetailsViewModel getDeviceDetailViewModel() {
      return this.mDeviceDetailViewModel;
   }

   public abstract void setDeviceDetailViewModel(DeviceDetailsViewModel var1);
}
