package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderScheduleDeviceButtonsModeBinding implements ViewBinding {
   public final AppCompatImageView automodeImageview;
   public final ConstraintLayout automodeRoot;
   public final TextView automodeTitleview;
   public final AppCompatImageView manualModeImageview;
   public final ConstraintLayout manualModeRoot;
   public final AppCompatTextView manualModeTitleview;
   public final AppCompatImageView nightmodeImageview;
   public final ConstraintLayout nightmodeRoot;
   public final TextView nightmodeTitleview;
   private final ConstraintLayout rootView;
   public final AppCompatImageView standbyModeImageview;
   public final ConstraintLayout standbyModeRoot;
   public final AppCompatTextView standbyModeTitleview;

   private HolderScheduleDeviceButtonsModeBinding(ConstraintLayout var1, AppCompatImageView var2, ConstraintLayout var3, TextView var4, AppCompatImageView var5, ConstraintLayout var6, AppCompatTextView var7, AppCompatImageView var8, ConstraintLayout var9, TextView var10, AppCompatImageView var11, ConstraintLayout var12, AppCompatTextView var13) {
      this.rootView = var1;
      this.automodeImageview = var2;
      this.automodeRoot = var3;
      this.automodeTitleview = var4;
      this.manualModeImageview = var5;
      this.manualModeRoot = var6;
      this.manualModeTitleview = var7;
      this.nightmodeImageview = var8;
      this.nightmodeRoot = var9;
      this.nightmodeTitleview = var10;
      this.standbyModeImageview = var11;
      this.standbyModeRoot = var12;
      this.standbyModeTitleview = var13;
   }

   public static HolderScheduleDeviceButtonsModeBinding bind(View var0) {
      int var1 = R.id.automode_imageview;
      AppCompatImageView var10 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
      if (var10 != null) {
         var1 = R.id.automode_root;
         ConstraintLayout var13 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
         if (var13 != null) {
            var1 = R.id.automode_titleview;
            TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.manual_mode_imageview;
               AppCompatImageView var3 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
               if (var3 != null) {
                  var1 = R.id.manual_mode_root;
                  ConstraintLayout var8 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                  if (var8 != null) {
                     var1 = R.id.manual_mode_titleview;
                     AppCompatTextView var12 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                     if (var12 != null) {
                        var1 = R.id.nightmode_imageview;
                        AppCompatImageView var7 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                        if (var7 != null) {
                           var1 = R.id.nightmode_root;
                           ConstraintLayout var2 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                           if (var2 != null) {
                              var1 = R.id.nightmode_titleview;
                              TextView var11 = (TextView)ViewBindings.findChildViewById(var0, var1);
                              if (var11 != null) {
                                 var1 = R.id.standby_mode_imageview;
                                 AppCompatImageView var4 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                                 if (var4 != null) {
                                    var1 = R.id.standby_mode_root;
                                    ConstraintLayout var9 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                    if (var9 != null) {
                                       var1 = R.id.standby_mode_titleview;
                                       AppCompatTextView var6 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                       if (var6 != null) {
                                          return new HolderScheduleDeviceButtonsModeBinding((ConstraintLayout)var0, var10, var13, var5, var3, var8, var12, var7, var2, var11, var4, var9, var6);
                                       }
                                    }
                                 }
                              }
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

   public static HolderScheduleDeviceButtonsModeBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderScheduleDeviceButtonsModeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_schedule_device_buttons_mode, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
