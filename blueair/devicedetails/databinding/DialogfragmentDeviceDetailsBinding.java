package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;

public abstract class DialogfragmentDeviceDetailsBinding extends ViewDataBinding {
   public final FrameLayout bannersContainer;
   public final ImageButton closeBtn;
   public final LinearLayout contentContainer;
   public final AppCompatImageView deviceIcon;
   public final TextView deviceName;
   public final FrameLayout deviceSchedulesContainer;
   public final FrameLayout deviceSettingsContainer;
   public final FrameLayout devicesAttributesContainer;
   public final FrameLayout graphContainer;
   public final TextView location;
   @Bindable
   protected DeviceDetailsViewModel mDeviceDetailViewModel;
   public final LinearLayout rootLayout;
   public final NestedScrollView scrollable;
   public final ConstraintLayout titleBar;
   public final FrameLayout welcomeHomeContainer;

   protected DialogfragmentDeviceDetailsBinding(Object var1, View var2, int var3, FrameLayout var4, ImageButton var5, LinearLayout var6, AppCompatImageView var7, TextView var8, FrameLayout var9, FrameLayout var10, FrameLayout var11, FrameLayout var12, TextView var13, LinearLayout var14, NestedScrollView var15, ConstraintLayout var16, FrameLayout var17) {
      super(var1, var2, var3);
      this.bannersContainer = var4;
      this.closeBtn = var5;
      this.contentContainer = var6;
      this.deviceIcon = var7;
      this.deviceName = var8;
      this.deviceSchedulesContainer = var9;
      this.deviceSettingsContainer = var10;
      this.devicesAttributesContainer = var11;
      this.graphContainer = var12;
      this.location = var13;
      this.rootLayout = var14;
      this.scrollable = var15;
      this.titleBar = var16;
      this.welcomeHomeContainer = var17;
   }

   public static DialogfragmentDeviceDetailsBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceDetailsBinding bind(View var0, Object var1) {
      return (DialogfragmentDeviceDetailsBinding)bind(var1, var0, R.layout.dialogfragment_device_details);
   }

   public static DialogfragmentDeviceDetailsBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static DialogfragmentDeviceDetailsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceDetailsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (DialogfragmentDeviceDetailsBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_details, var1, var2, var3);
   }

   @Deprecated
   public static DialogfragmentDeviceDetailsBinding inflate(LayoutInflater var0, Object var1) {
      return (DialogfragmentDeviceDetailsBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_details, (ViewGroup)null, false, var1);
   }

   public DeviceDetailsViewModel getDeviceDetailViewModel() {
      return this.mDeviceDetailViewModel;
   }

   public abstract void setDeviceDetailViewModel(DeviceDetailsViewModel var1);
}
