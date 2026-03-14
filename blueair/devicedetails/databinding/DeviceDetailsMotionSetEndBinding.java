package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class DeviceDetailsMotionSetEndBinding implements ViewBinding {
   public final View buttonMotionLayout;
   public final ImageView imageScrollArrow;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final ConstraintLayout sensorLayout;
   public final ConstraintLayout settingsLayout;

   private DeviceDetailsMotionSetEndBinding(ConstraintLayout var1, View var2, ImageView var3, ConstraintLayout var4, ConstraintLayout var5, ConstraintLayout var6) {
      this.rootView = var1;
      this.buttonMotionLayout = var2;
      this.imageScrollArrow = var3;
      this.rootLayout = var4;
      this.sensorLayout = var5;
      this.settingsLayout = var6;
   }

   public static DeviceDetailsMotionSetEndBinding bind(View var0) {
      int var1 = R.id.buttonMotionLayout;
      View var2 = ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.imageScrollArrow;
         ImageView var5 = (ImageView)ViewBindings.findChildViewById(var0, var1);
         if (var5 != null) {
            ConstraintLayout var3 = (ConstraintLayout)var0;
            var1 = R.id.sensorLayout;
            ConstraintLayout var4 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               var1 = R.id.settingsLayout;
               ConstraintLayout var6 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
               if (var6 != null) {
                  return new DeviceDetailsMotionSetEndBinding(var3, var2, var5, var3, var4, var6);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static DeviceDetailsMotionSetEndBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DeviceDetailsMotionSetEndBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.device_details_motion_set_end, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
