package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class HolderDeviceHOfflineBinding implements ViewBinding {
   public final Guideline bottomGuideline;
   public final Guideline endGuideline;
   public final AppCompatImageView offlineImageview;
   private final FrameLayout rootView;
   public final Guideline startGuideline;
   public final TextView subtitle;
   public final TextView title;
   public final MaterialButton troubleshootBtn;

   private HolderDeviceHOfflineBinding(FrameLayout var1, Guideline var2, Guideline var3, AppCompatImageView var4, Guideline var5, TextView var6, TextView var7, MaterialButton var8) {
      this.rootView = var1;
      this.bottomGuideline = var2;
      this.endGuideline = var3;
      this.offlineImageview = var4;
      this.startGuideline = var5;
      this.subtitle = var6;
      this.title = var7;
      this.troubleshootBtn = var8;
   }

   public static HolderDeviceHOfflineBinding bind(View var0) {
      int var1 = R.id.bottom_guideline;
      Guideline var2 = (Guideline)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.end_guideline;
         Guideline var4 = (Guideline)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.offline_imageview;
            AppCompatImageView var6 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               var1 = R.id.start_guideline;
               Guideline var5 = (Guideline)ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  var1 = R.id.subtitle;
                  TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var7 != null) {
                     var1 = R.id.title;
                     TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var8 != null) {
                        var1 = R.id.troubleshoot_btn;
                        MaterialButton var3 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
                        if (var3 != null) {
                           return new HolderDeviceHOfflineBinding((FrameLayout)var0, var2, var4, var6, var5, var7, var8, var3);
                        }
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceHOfflineBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceHOfflineBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_h_offline, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
