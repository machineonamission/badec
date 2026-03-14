package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.AccessibleSeekBar;

public final class HolderDeviceTargetTemperatureBinding implements ViewBinding {
   public final ConstraintLayout contentContainer;
   public final TextView endTemp;
   public final TextView progressText;
   private final FrameLayout rootView;
   public final AccessibleSeekBar seekbar;
   public final TextView startTemp;
   public final TextView title;

   private HolderDeviceTargetTemperatureBinding(FrameLayout var1, ConstraintLayout var2, TextView var3, TextView var4, AccessibleSeekBar var5, TextView var6, TextView var7) {
      this.rootView = var1;
      this.contentContainer = var2;
      this.endTemp = var3;
      this.progressText = var4;
      this.seekbar = var5;
      this.startTemp = var6;
      this.title = var7;
   }

   public static HolderDeviceTargetTemperatureBinding bind(View var0) {
      int var1 = R.id.content_container;
      ConstraintLayout var7 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
      if (var7 != null) {
         var1 = R.id.end_temp;
         TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.progressText;
            TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               var1 = R.id.seekbar;
               AccessibleSeekBar var2 = (AccessibleSeekBar)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  var1 = R.id.start_temp;
                  TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var3 != null) {
                     var1 = R.id.title;
                     TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var5 != null) {
                        return new HolderDeviceTargetTemperatureBinding((FrameLayout)var0, var7, var4, var6, var2, var3, var5);
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceTargetTemperatureBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceTargetTemperatureBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_target_temperature, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
