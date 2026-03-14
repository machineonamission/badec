package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.google.android.material.button.MaterialButton;

public abstract class DialogfragmentDeviceLinkBinding extends ViewDataBinding {
   public final Guideline bottomGuideline;
   public final TextView chooseProductTextview;
   public final AppCompatImageView closeBtn;
   public final MaterialButton connectButton;
   public final Guideline endGuideline;
   public final AppCompatImageView linkIcon;
   public final AppCompatImageView linkPlusIcon;
   @Bindable
   protected DeviceDetailsViewModel mDeviceDetailsViewModel;
   public final RecyclerView productList;
   public final ConstraintLayout rootLayout;
   public final Guideline startGuideline;
   public final TextView subtitle;
   public final TextView title;
   public final ConstraintLayout titleIconRoot;
   public final Guideline topGuideline;

   protected DialogfragmentDeviceLinkBinding(Object var1, View var2, int var3, Guideline var4, TextView var5, AppCompatImageView var6, MaterialButton var7, Guideline var8, AppCompatImageView var9, AppCompatImageView var10, RecyclerView var11, ConstraintLayout var12, Guideline var13, TextView var14, TextView var15, ConstraintLayout var16, Guideline var17) {
      super(var1, var2, var3);
      this.bottomGuideline = var4;
      this.chooseProductTextview = var5;
      this.closeBtn = var6;
      this.connectButton = var7;
      this.endGuideline = var8;
      this.linkIcon = var9;
      this.linkPlusIcon = var10;
      this.productList = var11;
      this.rootLayout = var12;
      this.startGuideline = var13;
      this.subtitle = var14;
      this.title = var15;
      this.titleIconRoot = var16;
      this.topGuideline = var17;
   }

   public static DialogfragmentDeviceLinkBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceLinkBinding bind(View var0, Object var1) {
      return (DialogfragmentDeviceLinkBinding)bind(var1, var0, R.layout.dialogfragment_device_link);
   }

   public static DialogfragmentDeviceLinkBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static DialogfragmentDeviceLinkBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceLinkBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (DialogfragmentDeviceLinkBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_link, var1, var2, var3);
   }

   @Deprecated
   public static DialogfragmentDeviceLinkBinding inflate(LayoutInflater var0, Object var1) {
      return (DialogfragmentDeviceLinkBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_link, (ViewGroup)null, false, var1);
   }

   public DeviceDetailsViewModel getDeviceDetailsViewModel() {
      return this.mDeviceDetailsViewModel;
   }

   public abstract void setDeviceDetailsViewModel(DeviceDetailsViewModel var1);
}
