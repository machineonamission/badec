package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.FanView;
import com.blueair.viewcore.view.SwitchCompat;

public final class HolderDeviceOscillationBinding implements ViewBinding {
   public final TextView angle;
   public final AppCompatImageView angleDirection;
   public final View arrow;
   public final ConstraintLayout contentAngleSetting;
   public final LinearLayout contentContainer;
   public final ConstraintLayout contentOscillationFanView;
   public final ConstraintLayout contentOscillationSettings;
   public final ConstraintLayout contentTitle;
   public final TextView direction;
   public final TextView directionTitle;
   public final AppCompatImageView fanDirection;
   public final FanView fanView;
   public final TextView oscillationAngleTitle;
   public final TextView oscillationSettingsTitle;
   private final FrameLayout rootView;
   public final View spacer1;
   public final View spacer2;
   public final TextView speed;
   public final TextView speedTitle;
   public final SwitchCompat switchBtn;
   public final TextView title;

   private HolderDeviceOscillationBinding(FrameLayout var1, TextView var2, AppCompatImageView var3, View var4, ConstraintLayout var5, LinearLayout var6, ConstraintLayout var7, ConstraintLayout var8, ConstraintLayout var9, TextView var10, TextView var11, AppCompatImageView var12, FanView var13, TextView var14, TextView var15, View var16, View var17, TextView var18, TextView var19, SwitchCompat var20, TextView var21) {
      this.rootView = var1;
      this.angle = var2;
      this.angleDirection = var3;
      this.arrow = var4;
      this.contentAngleSetting = var5;
      this.contentContainer = var6;
      this.contentOscillationFanView = var7;
      this.contentOscillationSettings = var8;
      this.contentTitle = var9;
      this.direction = var10;
      this.directionTitle = var11;
      this.fanDirection = var12;
      this.fanView = var13;
      this.oscillationAngleTitle = var14;
      this.oscillationSettingsTitle = var15;
      this.spacer1 = var16;
      this.spacer2 = var17;
      this.speed = var18;
      this.speedTitle = var19;
      this.switchBtn = var20;
      this.title = var21;
   }

   public static HolderDeviceOscillationBinding bind(View var0) {
      int var1 = R.id.angle;
      TextView var13 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var13 != null) {
         var1 = R.id.angle_direction;
         AppCompatImageView var6 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
         if (var6 != null) {
            var1 = R.id.arrow;
            View var5 = ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.content_angle_setting;
               ConstraintLayout var14 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
               if (var14 != null) {
                  var1 = R.id.content_container;
                  LinearLayout var8 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                  if (var8 != null) {
                     var1 = R.id.content_oscillation_fan_view;
                     ConstraintLayout var4 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                     if (var4 != null) {
                        var1 = R.id.content_oscillation_settings;
                        ConstraintLayout var7 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                        if (var7 != null) {
                           var1 = R.id.content_title;
                           ConstraintLayout var9 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                           if (var9 != null) {
                              var1 = R.id.direction;
                              TextView var20 = (TextView)ViewBindings.findChildViewById(var0, var1);
                              if (var20 != null) {
                                 var1 = R.id.direction_title;
                                 TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var3 != null) {
                                    var1 = R.id.fan_direction;
                                    AppCompatImageView var12 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                                    if (var12 != null) {
                                       var1 = R.id.fan_view;
                                       FanView var15 = (FanView)ViewBindings.findChildViewById(var0, var1);
                                       if (var15 != null) {
                                          var1 = R.id.oscillation_angle_title;
                                          TextView var18 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                          if (var18 != null) {
                                             var1 = R.id.oscillation_settings_title;
                                             TextView var19 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                             if (var19 != null) {
                                                var1 = R.id.spacer_1;
                                                View var10 = ViewBindings.findChildViewById(var0, var1);
                                                if (var10 != null) {
                                                   var1 = R.id.spacer_2;
                                                   View var17 = ViewBindings.findChildViewById(var0, var1);
                                                   if (var17 != null) {
                                                      var1 = R.id.speed;
                                                      TextView var21 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                      if (var21 != null) {
                                                         var1 = R.id.speed_title;
                                                         TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                         if (var2 != null) {
                                                            var1 = R.id.switch_btn;
                                                            SwitchCompat var16 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
                                                            if (var16 != null) {
                                                               var1 = R.id.title;
                                                               TextView var11 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                               if (var11 != null) {
                                                                  return new HolderDeviceOscillationBinding((FrameLayout)var0, var13, var6, var5, var14, var8, var4, var7, var9, var20, var3, var12, var15, var18, var19, var10, var17, var21, var2, var16, var11);
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
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceOscillationBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceOscillationBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_oscillation, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
