package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

public abstract class DialogfragmentDeviceFilterSelectionBinding extends ViewDataBinding {
   public final ImageButton btnLeft;
   public final ImageButton btnRight;
   public final MaterialButton buttonSave;
   public final ScrollingPagerIndicator dotsIndicator;
   public final ViewPager2 filterPager;
   @Bindable
   protected DeviceDetailsViewModel mDeviceDetailViewModel;
   public final ConstraintLayout pagerRootLayout;
   public final ProgressBlockerView progressView;
   public final CoordinatorLayout rootLayout;
   public final TextView title;
   public final Toolbar toolbar;

   protected DialogfragmentDeviceFilterSelectionBinding(Object var1, View var2, int var3, ImageButton var4, ImageButton var5, MaterialButton var6, ScrollingPagerIndicator var7, ViewPager2 var8, ConstraintLayout var9, ProgressBlockerView var10, CoordinatorLayout var11, TextView var12, Toolbar var13) {
      super(var1, var2, var3);
      this.btnLeft = var4;
      this.btnRight = var5;
      this.buttonSave = var6;
      this.dotsIndicator = var7;
      this.filterPager = var8;
      this.pagerRootLayout = var9;
      this.progressView = var10;
      this.rootLayout = var11;
      this.title = var12;
      this.toolbar = var13;
   }

   public static DialogfragmentDeviceFilterSelectionBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceFilterSelectionBinding bind(View var0, Object var1) {
      return (DialogfragmentDeviceFilterSelectionBinding)bind(var1, var0, R.layout.dialogfragment_device_filter_selection);
   }

   public static DialogfragmentDeviceFilterSelectionBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static DialogfragmentDeviceFilterSelectionBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static DialogfragmentDeviceFilterSelectionBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (DialogfragmentDeviceFilterSelectionBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_filter_selection, var1, var2, var3);
   }

   @Deprecated
   public static DialogfragmentDeviceFilterSelectionBinding inflate(LayoutInflater var0, Object var1) {
      return (DialogfragmentDeviceFilterSelectionBinding)ViewDataBinding.inflateInternal(var0, R.layout.dialogfragment_device_filter_selection, (ViewGroup)null, false, var1);
   }

   public DeviceDetailsViewModel getDeviceDetailViewModel() {
      return this.mDeviceDetailViewModel;
   }

   public abstract void setDeviceDetailViewModel(DeviceDetailsViewModel var1);
}
