package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.adddevice.R;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public abstract class FragmentAddDeviceSuccessBinding extends ViewDataBinding {
   public final MaterialButton buttonContinue;
   public final Guideline guidelineCenter;
   public final AppCompatImageView ivDevice;
   public final AppCompatImageView ivIndicator;
   @Bindable
   protected AddDeviceViewModel mAddDeviceViewModel;
   public final ProgressBlockerView progressView;
   public final ConstraintLayout rootLayout;
   public final TextView tvContent;
   public final AppCompatTextView tvStatus;

   protected FragmentAddDeviceSuccessBinding(Object var1, View var2, int var3, MaterialButton var4, Guideline var5, AppCompatImageView var6, AppCompatImageView var7, ProgressBlockerView var8, ConstraintLayout var9, TextView var10, AppCompatTextView var11) {
      super(var1, var2, var3);
      this.buttonContinue = var4;
      this.guidelineCenter = var5;
      this.ivDevice = var6;
      this.ivIndicator = var7;
      this.progressView = var8;
      this.rootLayout = var9;
      this.tvContent = var10;
      this.tvStatus = var11;
   }

   public static FragmentAddDeviceSuccessBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentAddDeviceSuccessBinding bind(View var0, Object var1) {
      return (FragmentAddDeviceSuccessBinding)bind(var1, var0, R.layout.fragment_add_device_success);
   }

   public static FragmentAddDeviceSuccessBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static FragmentAddDeviceSuccessBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentAddDeviceSuccessBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (FragmentAddDeviceSuccessBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_add_device_success, var1, var2, var3);
   }

   @Deprecated
   public static FragmentAddDeviceSuccessBinding inflate(LayoutInflater var0, Object var1) {
      return (FragmentAddDeviceSuccessBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_add_device_success, (ViewGroup)null, false, var1);
   }

   public AddDeviceViewModel getAddDeviceViewModel() {
      return this.mAddDeviceViewModel;
   }

   public abstract void setAddDeviceViewModel(AddDeviceViewModel var1);
}
