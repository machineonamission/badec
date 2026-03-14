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

public final class FragmentSearchDeviceBinding implements ViewBinding {
   public final LinearLayout bottomBar;
   public final MaterialButton btnCustomerSupport;
   public final TextView btnDeviceNotFound;
   public final RecyclerView deviceList;
   public final TextView hintText;
   public final ProgressBlockerView progressView;
   private final ConstraintLayout rootView;

   private FragmentSearchDeviceBinding(ConstraintLayout var1, LinearLayout var2, MaterialButton var3, TextView var4, RecyclerView var5, TextView var6, ProgressBlockerView var7) {
      this.rootView = var1;
      this.bottomBar = var2;
      this.btnCustomerSupport = var3;
      this.btnDeviceNotFound = var4;
      this.deviceList = var5;
      this.hintText = var6;
      this.progressView = var7;
   }

   public static FragmentSearchDeviceBinding bind(View var0) {
      int var1 = R.id.bottom_bar;
      LinearLayout var4 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.btn_customer_support;
         MaterialButton var7 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var7 != null) {
            var1 = R.id.btn_device_not_found;
            TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               var1 = R.id.device_list;
               RecyclerView var6 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
               if (var6 != null) {
                  var1 = R.id.hint_text;
                  TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var3 != null) {
                     var1 = R.id.progress_view;
                     ProgressBlockerView var5 = (ProgressBlockerView)ViewBindings.findChildViewById(var0, var1);
                     if (var5 != null) {
                        return new FragmentSearchDeviceBinding((ConstraintLayout)var0, var4, var7, var2, var6, var3, var5);
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentSearchDeviceBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentSearchDeviceBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_search_device, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
