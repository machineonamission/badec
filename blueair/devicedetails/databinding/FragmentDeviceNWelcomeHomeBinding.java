package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceWelcomeHomeViewModel;
import com.blueair.viewcore.view.SwitchCompat;
import com.google.android.material.button.MaterialButton;

public abstract class FragmentDeviceNWelcomeHomeBinding extends ViewDataBinding {
   public final MaterialButton addBtn;
   public final ConstraintLayout addressContainer;
   public final TextView addressText;
   public final View arrow;
   public final ImageView imLocation;
   @Bindable
   protected DeviceWelcomeHomeViewModel mVm;
   public final TextView radiusText;
   public final SwitchCompat switchBtn;
   public final TextView title;

   protected FragmentDeviceNWelcomeHomeBinding(Object var1, View var2, int var3, MaterialButton var4, ConstraintLayout var5, TextView var6, View var7, ImageView var8, TextView var9, SwitchCompat var10, TextView var11) {
      super(var1, var2, var3);
      this.addBtn = var4;
      this.addressContainer = var5;
      this.addressText = var6;
      this.arrow = var7;
      this.imLocation = var8;
      this.radiusText = var9;
      this.switchBtn = var10;
      this.title = var11;
   }

   public static FragmentDeviceNWelcomeHomeBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentDeviceNWelcomeHomeBinding bind(View var0, Object var1) {
      return (FragmentDeviceNWelcomeHomeBinding)bind(var1, var0, R.layout.fragment_device_n_welcome_home);
   }

   public static FragmentDeviceNWelcomeHomeBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static FragmentDeviceNWelcomeHomeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentDeviceNWelcomeHomeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (FragmentDeviceNWelcomeHomeBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_device_n_welcome_home, var1, var2, var3);
   }

   @Deprecated
   public static FragmentDeviceNWelcomeHomeBinding inflate(LayoutInflater var0, Object var1) {
      return (FragmentDeviceNWelcomeHomeBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_device_n_welcome_home, (ViewGroup)null, false, var1);
   }

   public DeviceWelcomeHomeViewModel getVm() {
      return this.mVm;
   }

   public abstract void setVm(DeviceWelcomeHomeViewModel var1);
}
