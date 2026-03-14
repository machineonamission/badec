package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.blueair.adddevice.R;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public abstract class FragmentAddDeviceWifiBinding extends ViewDataBinding {
   public final MaterialButton btnRefresh;
   @Bindable
   protected AddDeviceViewModel mAddDeviceViewModel;
   public final ProgressBlockerView progressView;
   public final RecyclerView recyclerViewSsid;
   public final ConstraintLayout rootLayout;
   public final SwipeRefreshLayout swipeToRefresh;
   public final AppCompatTextView tvSubtitle;
   public final AppCompatTextView tvTitle;

   protected FragmentAddDeviceWifiBinding(Object var1, View var2, int var3, MaterialButton var4, ProgressBlockerView var5, RecyclerView var6, ConstraintLayout var7, SwipeRefreshLayout var8, AppCompatTextView var9, AppCompatTextView var10) {
      super(var1, var2, var3);
      this.btnRefresh = var4;
      this.progressView = var5;
      this.recyclerViewSsid = var6;
      this.rootLayout = var7;
      this.swipeToRefresh = var8;
      this.tvSubtitle = var9;
      this.tvTitle = var10;
   }

   public static FragmentAddDeviceWifiBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentAddDeviceWifiBinding bind(View var0, Object var1) {
      return (FragmentAddDeviceWifiBinding)bind(var1, var0, R.layout.fragment_add_device_wifi);
   }

   public static FragmentAddDeviceWifiBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static FragmentAddDeviceWifiBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentAddDeviceWifiBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (FragmentAddDeviceWifiBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_add_device_wifi, var1, var2, var3);
   }

   @Deprecated
   public static FragmentAddDeviceWifiBinding inflate(LayoutInflater var0, Object var1) {
      return (FragmentAddDeviceWifiBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_add_device_wifi, (ViewGroup)null, false, var1);
   }

   public AddDeviceViewModel getAddDeviceViewModel() {
      return this.mAddDeviceViewModel;
   }

   public abstract void setAddDeviceViewModel(AddDeviceViewModel var1);
}
