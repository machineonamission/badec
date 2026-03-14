package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class DeviceDetailsMotionSetStartBinding implements ViewBinding {
   public final View buttonMotionLayout;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final ConstraintLayout sensorLayout;
   public final ConstraintLayout settingsLayout;

   private DeviceDetailsMotionSetStartBinding(ConstraintLayout var1, View var2, ConstraintLayout var3, ConstraintLayout var4, ConstraintLayout var5) {
      this.rootView = var1;
      this.buttonMotionLayout = var2;
      this.rootLayout = var3;
      this.sensorLayout = var4;
      this.settingsLayout = var5;
   }

   public static DeviceDetailsMotionSetStartBinding bind(View var0) {
      int var1 = R.id.buttonMotionLayout;
      View var3 = ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         ConstraintLayout var5 = (ConstraintLayout)var0;
         var1 = R.id.sensorLayout;
         ConstraintLayout var4 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.settingsLayout;
            ConstraintLayout var2 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               return new DeviceDetailsMotionSetStartBinding(var5, var3, var5, var4, var2);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static DeviceDetailsMotionSetStartBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DeviceDetailsMotionSetStartBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.device_details_motion_set_start, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
