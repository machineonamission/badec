package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.AccessibleSeekBar;

public final class HolderDeviceC3FanSpeedBinding implements ViewBinding {
   public final TextView cleanAirEta;
   public final ConstraintLayout contentContainer;
   public final ConstraintLayout contentSpeedLevel;
   public final AppCompatImageView downIcon;
   public final TextView fanSpeedLevel0;
   public final TextView fanSpeedLevel1;
   public final TextView fanSpeedLevel2;
   public final TextView fanSpeedLevel3;
   public final TextView fanSpeedLevel4;
   private final FrameLayout rootView;
   public final AccessibleSeekBar seekbar;
   public final TextView title;
   public final AppCompatImageView upIcon;

   private HolderDeviceC3FanSpeedBinding(FrameLayout var1, TextView var2, ConstraintLayout var3, ConstraintLayout var4, AppCompatImageView var5, TextView var6, TextView var7, TextView var8, TextView var9, TextView var10, AccessibleSeekBar var11, TextView var12, AppCompatImageView var13) {
      this.rootView = var1;
      this.cleanAirEta = var2;
      this.contentContainer = var3;
      this.contentSpeedLevel = var4;
      this.downIcon = var5;
      this.fanSpeedLevel0 = var6;
      this.fanSpeedLevel1 = var7;
      this.fanSpeedLevel2 = var8;
      this.fanSpeedLevel3 = var9;
      this.fanSpeedLevel4 = var10;
      this.seekbar = var11;
      this.title = var12;
      this.upIcon = var13;
   }

   public static HolderDeviceC3FanSpeedBinding bind(View var0) {
      int var1 = R.id.clean_air_eta;
      TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var7 != null) {
         var1 = R.id.content_container;
         ConstraintLayout var13 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
         if (var13 != null) {
            var1 = R.id.content_speed_level;
            ConstraintLayout var10 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
            if (var10 != null) {
               var1 = R.id.down_icon;
               AppCompatImageView var4 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
               if (var4 != null) {
                  var1 = R.id.fan_speed_level_0;
                  TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var8 != null) {
                     var1 = R.id.fan_speed_level_1;
                     TextView var12 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var12 != null) {
                        var1 = R.id.fan_speed_level_2;
                        TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var6 != null) {
                           var1 = R.id.fan_speed_level_3;
                           TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var9 != null) {
                              var1 = R.id.fan_speed_level_4;
                              TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                              if (var5 != null) {
                                 var1 = R.id.seekbar;
                                 AccessibleSeekBar var11 = (AccessibleSeekBar)ViewBindings.findChildViewById(var0, var1);
                                 if (var11 != null) {
                                    var1 = R.id.title;
                                    TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                    if (var3 != null) {
                                       var1 = R.id.up_icon;
                                       AppCompatImageView var2 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                                       if (var2 != null) {
                                          return new HolderDeviceC3FanSpeedBinding((FrameLayout)var0, var7, var13, var10, var4, var8, var12, var6, var9, var5, var11, var3, var2);
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

   public static HolderDeviceC3FanSpeedBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceC3FanSpeedBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_c3_fan_speed, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
