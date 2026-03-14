package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.adddevice.R;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;

public abstract class ActivityAddDeviceBinding extends ViewDataBinding {
   public final Barrier bottomButtonsBarrier;
   public final FrameLayout contentFragment;
   public final AppCompatTextView helpButton;
   @Bindable
   protected AddDeviceViewModel mAddDeviceViewModel;
   public final ViewcoreAppbarBinding viewcoreAppbar;

   protected ActivityAddDeviceBinding(Object var1, View var2, int var3, Barrier var4, FrameLayout var5, AppCompatTextView var6, ViewcoreAppbarBinding var7) {
      super(var1, var2, var3);
      this.bottomButtonsBarrier = var4;
      this.contentFragment = var5;
      this.helpButton = var6;
      this.viewcoreAppbar = var7;
   }

   public static ActivityAddDeviceBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityAddDeviceBinding bind(View var0, Object var1) {
      return (ActivityAddDeviceBinding)bind(var1, var0, R.layout.activity_add_device);
   }

   public static ActivityAddDeviceBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static ActivityAddDeviceBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityAddDeviceBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (ActivityAddDeviceBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_add_device, var1, var2, var3);
   }

   @Deprecated
   public static ActivityAddDeviceBinding inflate(LayoutInflater var0, Object var1) {
      return (ActivityAddDeviceBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_add_device, (ViewGroup)null, false, var1);
   }

   public AddDeviceViewModel getAddDeviceViewModel() {
      return this.mAddDeviceViewModel;
   }

   public abstract void setAddDeviceViewModel(AddDeviceViewModel var1);
}
