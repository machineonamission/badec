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

public abstract class FragmentDeviceWelcomeHomeBinding extends ViewDataBinding {
   public final MaterialButton btnAddHome;
   public final TextView homeAddress;
   public final ImageView imLocation;
   public final ConstraintLayout layoutAddress;
   @Bindable
   protected DeviceWelcomeHomeViewModel mVm;
   public final TextView radius;
   public final TextView radiusValue;
   public final SwitchCompat welcomeHomeSwitch;
   public final TextView welcomeHomeTitle;

   protected FragmentDeviceWelcomeHomeBinding(Object var1, View var2, int var3, MaterialButton var4, TextView var5, ImageView var6, ConstraintLayout var7, TextView var8, TextView var9, SwitchCompat var10, TextView var11) {
      super(var1, var2, var3);
      this.btnAddHome = var4;
      this.homeAddress = var5;
      this.imLocation = var6;
      this.layoutAddress = var7;
      this.radius = var8;
      this.radiusValue = var9;
      this.welcomeHomeSwitch = var10;
      this.welcomeHomeTitle = var11;
   }

   public static FragmentDeviceWelcomeHomeBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentDeviceWelcomeHomeBinding bind(View var0, Object var1) {
      return (FragmentDeviceWelcomeHomeBinding)bind(var1, var0, R.layout.fragment_device_welcome_home);
   }

   public static FragmentDeviceWelcomeHomeBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static FragmentDeviceWelcomeHomeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentDeviceWelcomeHomeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (FragmentDeviceWelcomeHomeBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_device_welcome_home, var1, var2, var3);
   }

   @Deprecated
   public static FragmentDeviceWelcomeHomeBinding inflate(LayoutInflater var0, Object var1) {
      return (FragmentDeviceWelcomeHomeBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_device_welcome_home, (ViewGroup)null, false, var1);
   }

   public DeviceWelcomeHomeViewModel getVm() {
      return this.mVm;
   }

   public abstract void setVm(DeviceWelcomeHomeViewModel var1);
}
