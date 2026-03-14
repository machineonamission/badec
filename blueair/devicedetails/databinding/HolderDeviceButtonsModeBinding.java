package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceButtonsModeBinding implements ViewBinding {
   public final AppCompatImageView automodeImageview;
   public final LinearLayout automodeRoot;
   public final TextView automodeTitleview;
   public final AppCompatImageView childLockImageview;
   public final LinearLayout childLockRoot;
   public final AppCompatTextView childLockTitleview;
   public final AppCompatImageView disinfectionImageview;
   public final LinearLayout disinfectionRoot;
   public final AppCompatTextView disinfectionTitleview;
   public final AppCompatImageView manualModeImageview;
   public final LinearLayout manualModeRoot;
   public final AppCompatTextView manualModeTitleview;
   public final AppCompatImageView nightmodeImageview;
   public final LinearLayout nightmodeRoot;
   public final TextView nightmodeTitleview;
   private final ConstraintLayout rootView;
   public final AppCompatImageView standbyModeImageview;
   public final LinearLayout standbyModeRoot;
   public final TextView standbyModeTitleview;

   private HolderDeviceButtonsModeBinding(ConstraintLayout var1, AppCompatImageView var2, LinearLayout var3, TextView var4, AppCompatImageView var5, LinearLayout var6, AppCompatTextView var7, AppCompatImageView var8, LinearLayout var9, AppCompatTextView var10, AppCompatImageView var11, LinearLayout var12, AppCompatTextView var13, AppCompatImageView var14, LinearLayout var15, TextView var16, AppCompatImageView var17, LinearLayout var18, TextView var19) {
      this.rootView = var1;
      this.automodeImageview = var2;
      this.automodeRoot = var3;
      this.automodeTitleview = var4;
      this.childLockImageview = var5;
      this.childLockRoot = var6;
      this.childLockTitleview = var7;
      this.disinfectionImageview = var8;
      this.disinfectionRoot = var9;
      this.disinfectionTitleview = var10;
      this.manualModeImageview = var11;
      this.manualModeRoot = var12;
      this.manualModeTitleview = var13;
      this.nightmodeImageview = var14;
      this.nightmodeRoot = var15;
      this.nightmodeTitleview = var16;
      this.standbyModeImageview = var17;
      this.standbyModeRoot = var18;
      this.standbyModeTitleview = var19;
   }

   public static HolderDeviceButtonsModeBinding bind(View var0) {
      int var1 = R.id.automode_imageview;
      AppCompatImageView var18 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
      if (var18 != null) {
         var1 = R.id.automode_root;
         LinearLayout var4 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.automode_titleview;
            TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var7 != null) {
               var1 = R.id.child_lock_imageview;
               AppCompatImageView var2 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  var1 = R.id.child_lock_root;
                  LinearLayout var6 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                  if (var6 != null) {
                     var1 = R.id.child_lock_titleview;
                     AppCompatTextView var16 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                     if (var16 != null) {
                        var1 = R.id.disinfection_imageview;
                        AppCompatImageView var11 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                        if (var11 != null) {
                           var1 = R.id.disinfection_root;
                           LinearLayout var5 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                           if (var5 != null) {
                              var1 = R.id.disinfection_titleview;
                              AppCompatTextView var3 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                              if (var3 != null) {
                                 var1 = R.id.manual_mode_imageview;
                                 AppCompatImageView var12 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                                 if (var12 != null) {
                                    var1 = R.id.manual_mode_root;
                                    LinearLayout var17 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                                    if (var17 != null) {
                                       var1 = R.id.manual_mode_titleview;
                                       AppCompatTextView var13 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                       if (var13 != null) {
                                          var1 = R.id.nightmode_imageview;
                                          AppCompatImageView var8 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                                          if (var8 != null) {
                                             var1 = R.id.nightmode_root;
                                             LinearLayout var14 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                                             if (var14 != null) {
                                                var1 = R.id.nightmode_titleview;
                                                TextView var19 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                if (var19 != null) {
                                                   var1 = R.id.standby_mode_imageview;
                                                   AppCompatImageView var9 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                                                   if (var9 != null) {
                                                      var1 = R.id.standby_mode_root;
                                                      LinearLayout var15 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                                                      if (var15 != null) {
                                                         var1 = R.id.standby_mode_titleview;
                                                         TextView var10 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                         if (var10 != null) {
                                                            return new HolderDeviceButtonsModeBinding((ConstraintLayout)var0, var18, var4, var7, var2, var6, var16, var11, var5, var3, var12, var17, var13, var8, var14, var19, var9, var15, var10);
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
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceButtonsModeBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceButtonsModeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_buttons_mode, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
