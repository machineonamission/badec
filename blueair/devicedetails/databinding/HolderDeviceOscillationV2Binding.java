package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.FanView;
import com.blueair.viewcore.view.SwitchCompat;
import com.google.android.material.button.MaterialButton;

public final class HolderDeviceOscillationV2Binding implements ViewBinding {
   public final TextView angle;
   public final AppCompatImageView angleDirection;
   public final MaterialButton btnSettings;
   public final LinearLayout contentContainer;
   public final ConstraintLayout contentOscillationFanView;
   public final ConstraintLayout contentTitle;
   public final TextView direction;
   public final TextView directionTitle;
   public final FanView fanView;
   public final ImageView leadingIcon;
   public final TextView oscillationAngleTitle;
   private final LinearLayout rootView;
   public final View spacer1;
   public final TextView speed;
   public final TextView speedTitle;
   public final SwitchCompat switchBtn;
   public final TextView title;

   private HolderDeviceOscillationV2Binding(LinearLayout var1, TextView var2, AppCompatImageView var3, MaterialButton var4, LinearLayout var5, ConstraintLayout var6, ConstraintLayout var7, TextView var8, TextView var9, FanView var10, ImageView var11, TextView var12, View var13, TextView var14, TextView var15, SwitchCompat var16, TextView var17) {
      this.rootView = var1;
      this.angle = var2;
      this.angleDirection = var3;
      this.btnSettings = var4;
      this.contentContainer = var5;
      this.contentOscillationFanView = var6;
      this.contentTitle = var7;
      this.direction = var8;
      this.directionTitle = var9;
      this.fanView = var10;
      this.leadingIcon = var11;
      this.oscillationAngleTitle = var12;
      this.spacer1 = var13;
      this.speed = var14;
      this.speedTitle = var15;
      this.switchBtn = var16;
      this.title = var17;
   }

   public static HolderDeviceOscillationV2Binding bind(View var0) {
      int var1 = R.id.angle;
      TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var9 != null) {
         var1 = R.id.angle_direction;
         AppCompatImageView var15 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
         if (var15 != null) {
            var1 = R.id.btn_settings;
            MaterialButton var7 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
            if (var7 != null) {
               LinearLayout var4 = (LinearLayout)var0;
               var1 = R.id.content_oscillation_fan_view;
               ConstraintLayout var10 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
               if (var10 != null) {
                  var1 = R.id.content_title;
                  ConstraintLayout var3 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                  if (var3 != null) {
                     var1 = R.id.direction;
                     TextView var11 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var11 != null) {
                        var1 = R.id.direction_title;
                        TextView var16 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var16 != null) {
                           var1 = R.id.fan_view;
                           FanView var12 = (FanView)ViewBindings.findChildViewById(var0, var1);
                           if (var12 != null) {
                              var1 = R.id.leading_icon;
                              ImageView var8 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                              if (var8 != null) {
                                 var1 = R.id.oscillation_angle_title;
                                 TextView var14 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var14 != null) {
                                    var1 = R.id.spacer_1;
                                    View var13 = ViewBindings.findChildViewById(var0, var1);
                                    if (var13 != null) {
                                       var1 = R.id.speed;
                                       TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                       if (var5 != null) {
                                          var1 = R.id.speed_title;
                                          TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                          if (var2 != null) {
                                             var1 = R.id.switch_btn;
                                             SwitchCompat var6 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
                                             if (var6 != null) {
                                                var1 = R.id.title;
                                                TextView var17 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                if (var17 != null) {
                                                   return new HolderDeviceOscillationV2Binding(var4, var9, var15, var7, var4, var10, var3, var11, var16, var12, var8, var14, var13, var5, var2, var6, var17);
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

   public static HolderDeviceOscillationV2Binding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceOscillationV2Binding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_oscillation_v2, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
