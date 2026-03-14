package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDevicesAlarmBinding implements ViewBinding {
   public final ImageView ivDevice;
   public final ImageView ivMore;
   public final HolderDeviceOfflineV2Binding layoutOffline;
   private final ConstraintLayout rootView;
   public final RecyclerView rvAlarms;
   public final TextView tvDeviceName;

   private HolderDevicesAlarmBinding(ConstraintLayout var1, ImageView var2, ImageView var3, HolderDeviceOfflineV2Binding var4, RecyclerView var5, TextView var6) {
      this.rootView = var1;
      this.ivDevice = var2;
      this.ivMore = var3;
      this.layoutOffline = var4;
      this.rvAlarms = var5;
      this.tvDeviceName = var6;
   }

   public static HolderDevicesAlarmBinding bind(View var0) {
      int var1 = R.id.iv_device;
      ImageView var3 = (ImageView)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.iv_more;
         ImageView var2 = (ImageView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.layout_offline;
            View var4 = ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               HolderDeviceOfflineV2Binding var5 = HolderDeviceOfflineV2Binding.bind(var4);
               var1 = R.id.rv_alarms;
               RecyclerView var7 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
               if (var7 != null) {
                  var1 = R.id.tv_deviceName;
                  TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var6 != null) {
                     return new HolderDevicesAlarmBinding((ConstraintLayout)var0, var3, var2, var5, var7, var6);
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDevicesAlarmBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDevicesAlarmBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_devices_alarm, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
