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
import com.google.android.material.button.MaterialButton;

public final class HolderDeviceOfflineBinding implements ViewBinding {
   public final Guideline bottomGuideline;
   public final Guideline endGuideline;
   public final AppCompatImageView offlineImageview;
   private final ConstraintLayout rootView;
   public final View separator;
   public final Guideline startGuideline;
   public final TextView subtitle;
   public final TextView title;
   public final MaterialButton troubleshootBtn;

   private HolderDeviceOfflineBinding(ConstraintLayout var1, Guideline var2, Guideline var3, AppCompatImageView var4, View var5, Guideline var6, TextView var7, TextView var8, MaterialButton var9) {
      this.rootView = var1;
      this.bottomGuideline = var2;
      this.endGuideline = var3;
      this.offlineImageview = var4;
      this.separator = var5;
      this.startGuideline = var6;
      this.subtitle = var7;
      this.title = var8;
      this.troubleshootBtn = var9;
   }

   public static HolderDeviceOfflineBinding bind(View var0) {
      int var1 = R.id.bottom_guideline;
      Guideline var3 = (Guideline)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.end_guideline;
         Guideline var6 = (Guideline)ViewBindings.findChildViewById(var0, var1);
         if (var6 != null) {
            var1 = R.id.offline_imageview;
            AppCompatImageView var7 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
            if (var7 != null) {
               var1 = R.id.separator;
               View var8 = ViewBindings.findChildViewById(var0, var1);
               if (var8 != null) {
                  var1 = R.id.start_guideline;
                  Guideline var4 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                  if (var4 != null) {
                     var1 = R.id.subtitle;
                     TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var2 != null) {
                        var1 = R.id.title;
                        TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var5 != null) {
                           var1 = R.id.troubleshoot_btn;
                           MaterialButton var9 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
                           if (var9 != null) {
                              return new HolderDeviceOfflineBinding((ConstraintLayout)var0, var3, var6, var7, var8, var4, var2, var5, var9);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceOfflineBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceOfflineBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_offline, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
