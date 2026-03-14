package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;

public abstract class FragmentFilterBinding extends ViewDataBinding {
   public final AppCompatImageView filterImage;
   @Bindable
   protected DeviceDetailsViewModel mDeviceDetailViewModel;

   protected FragmentFilterBinding(Object var1, View var2, int var3, AppCompatImageView var4) {
      super(var1, var2, var3);
      this.filterImage = var4;
   }

   public static FragmentFilterBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentFilterBinding bind(View var0, Object var1) {
      return (FragmentFilterBinding)bind(var1, var0, R.layout.fragment_filter);
   }

   public static FragmentFilterBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static FragmentFilterBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentFilterBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (FragmentFilterBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_filter, var1, var2, var3);
   }

   @Deprecated
   public static FragmentFilterBinding inflate(LayoutInflater var0, Object var1) {
      return (FragmentFilterBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_filter, (ViewGroup)null, false, var1);
   }

   public DeviceDetailsViewModel getDeviceDetailViewModel() {
      return this.mDeviceDetailViewModel;
   }

   public abstract void setDeviceDetailViewModel(DeviceDetailsViewModel var1);
}
