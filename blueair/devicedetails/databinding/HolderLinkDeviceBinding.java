package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderLinkDeviceBinding implements ViewBinding {
   public final Guideline bottomGuideline;
   public final TextView deviceName;
   public final AppCompatImageView deviceTick;
   public final Guideline endGuideline;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final Guideline startGuideline;
   public final Guideline topGuideline;

   private HolderLinkDeviceBinding(ConstraintLayout var1, Guideline var2, TextView var3, AppCompatImageView var4, Guideline var5, ConstraintLayout var6, Guideline var7, Guideline var8) {
      this.rootView = var1;
      this.bottomGuideline = var2;
      this.deviceName = var3;
      this.deviceTick = var4;
      this.endGuideline = var5;
      this.rootLayout = var6;
      this.startGuideline = var7;
      this.topGuideline = var8;
   }

   public static HolderLinkDeviceBinding bind(View var0) {
      int var1 = R.id.bottom_guideline;
      Guideline var6 = (Guideline)ViewBindings.findChildViewById(var0, var1);
      if (var6 != null) {
         var1 = R.id.device_name;
         TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var7 != null) {
            var1 = R.id.device_tick;
            AppCompatImageView var5 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.end_guideline;
               Guideline var2 = (Guideline)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  ConstraintLayout var4 = (ConstraintLayout)var0;
                  var1 = R.id.start_guideline;
                  Guideline var8 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                  if (var8 != null) {
                     var1 = R.id.top_guideline;
                     Guideline var3 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                     if (var3 != null) {
                        return new HolderLinkDeviceBinding(var4, var6, var7, var5, var2, var4, var8, var3);
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderLinkDeviceBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderLinkDeviceBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_link_device, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
