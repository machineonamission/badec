package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.antifake.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;

public final class FragmentScanDeviceBinding implements ViewBinding {
   public final MaterialButton btnCustomerSupport;
   public final RecyclerView deviceList;
   public final ProgressBlockerView progressView;
   private final ConstraintLayout rootView;
   public final TextView scanningMsg;
   public final TextView scanningSubtitle;
   public final ConstraintLayout scanningViewBottom;
   public final LinearLayout scanningViewCenter;

   private FragmentScanDeviceBinding(ConstraintLayout var1, MaterialButton var2, RecyclerView var3, ProgressBlockerView var4, TextView var5, TextView var6, ConstraintLayout var7, LinearLayout var8) {
      this.rootView = var1;
      this.btnCustomerSupport = var2;
      this.deviceList = var3;
      this.progressView = var4;
      this.scanningMsg = var5;
      this.scanningSubtitle = var6;
      this.scanningViewBottom = var7;
      this.scanningViewCenter = var8;
   }

   public static FragmentScanDeviceBinding bind(View var0) {
      int var1 = R.id.btn_customer_support;
      MaterialButton var6 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var6 != null) {
         var1 = R.id.device_list;
         RecyclerView var8 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
         if (var8 != null) {
            var1 = R.id.progressView;
            ProgressBlockerView var3 = (ProgressBlockerView)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               var1 = R.id.scanning_msg;
               TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var4 != null) {
                  var1 = R.id.scanning_subtitle;
                  TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var5 != null) {
                     var1 = R.id.scanning_view_bottom;
                     ConstraintLayout var7 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                     if (var7 != null) {
                        var1 = R.id.scanning_view_center;
                        LinearLayout var2 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                        if (var2 != null) {
                           return new FragmentScanDeviceBinding((ConstraintLayout)var0, var6, var8, var3, var4, var5, var7, var2);
                        }
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentScanDeviceBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentScanDeviceBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_scan_device, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
