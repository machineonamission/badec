package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel;
import com.blueair.graph.view.FanHistoryGraphView;
import com.blueair.graph.view.IndoorGraphView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

public abstract class FragmentDeviceSensorsBinding extends ViewDataBinding {
   public final MaterialButton buttonCollapse;
   public final IndoorGraphView deviceGraph;
   public final ConstraintLayout deviceGraphFooter;
   public final FanHistoryGraphView fanGraph;
   public final TextView fanValue;
   @Bindable
   protected DeviceSensorsViewModel mDeviceSensorViewModel;
   public final TabLayout sensorTabs;
   public final View separator;

   protected FragmentDeviceSensorsBinding(Object var1, View var2, int var3, MaterialButton var4, IndoorGraphView var5, ConstraintLayout var6, FanHistoryGraphView var7, TextView var8, TabLayout var9, View var10) {
      super(var1, var2, var3);
      this.buttonCollapse = var4;
      this.deviceGraph = var5;
      this.deviceGraphFooter = var6;
      this.fanGraph = var7;
      this.fanValue = var8;
      this.sensorTabs = var9;
      this.separator = var10;
   }

   public static FragmentDeviceSensorsBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentDeviceSensorsBinding bind(View var0, Object var1) {
      return (FragmentDeviceSensorsBinding)bind(var1, var0, R.layout.fragment_device_sensors);
   }

   public static FragmentDeviceSensorsBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static FragmentDeviceSensorsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static FragmentDeviceSensorsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (FragmentDeviceSensorsBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_device_sensors, var1, var2, var3);
   }

   @Deprecated
   public static FragmentDeviceSensorsBinding inflate(LayoutInflater var0, Object var1) {
      return (FragmentDeviceSensorsBinding)ViewDataBinding.inflateInternal(var0, R.layout.fragment_device_sensors, (ViewGroup)null, false, var1);
   }

   public DeviceSensorsViewModel getDeviceSensorViewModel() {
      return this.mDeviceSensorViewModel;
   }

   public abstract void setDeviceSensorViewModel(DeviceSensorsViewModel var1);
}
