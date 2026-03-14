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
import com.blueair.viewcore.view.AccessibleSeekBar;

public final class HolderIcpManualModeBinding implements ViewBinding {
   public final TextView clearAirMinView;
   public final TextView clearAirMsgView;
   public final AppCompatImageView decreaseFanSpeedBg;
   public final AppCompatImageView decreaseImageview;
   public final AccessibleSeekBar fanSpeedSeekbar;
   public final TextView fanspeed1;
   public final TextView fanspeed2;
   public final TextView fanspeed3;
   public final AppCompatImageView germshieldIcon;
   public final ConstraintLayout germshieldRoot;
   public final TextView germshieldTitle;
   public final AppCompatImageView increaseFanSpeedBg;
   public final AppCompatImageView increaseImageview;
   public final Guideline leftGuideline;
   public final TextView modeTitle;
   public final Guideline rightGuideline;
   private final ConstraintLayout rootView;
   public final Guideline seekbarGuideline1;
   public final Guideline seekbarGuideline2;
   public final Guideline seekbarGuideline3;
   public final View separator;
   public final AppCompatImageView standbyBackground;
   public final AppCompatImageView standbyImageview;
   public final TextView standbyMessageView;
   public final TextView standbyTitleView;

   private HolderIcpManualModeBinding(ConstraintLayout var1, TextView var2, TextView var3, AppCompatImageView var4, AppCompatImageView var5, AccessibleSeekBar var6, TextView var7, TextView var8, TextView var9, AppCompatImageView var10, ConstraintLayout var11, TextView var12, AppCompatImageView var13, AppCompatImageView var14, Guideline var15, TextView var16, Guideline var17, Guideline var18, Guideline var19, Guideline var20, View var21, AppCompatImageView var22, AppCompatImageView var23, TextView var24, TextView var25) {
      this.rootView = var1;
      this.clearAirMinView = var2;
      this.clearAirMsgView = var3;
      this.decreaseFanSpeedBg = var4;
      this.decreaseImageview = var5;
      this.fanSpeedSeekbar = var6;
      this.fanspeed1 = var7;
      this.fanspeed2 = var8;
      this.fanspeed3 = var9;
      this.germshieldIcon = var10;
      this.germshieldRoot = var11;
      this.germshieldTitle = var12;
      this.increaseFanSpeedBg = var13;
      this.increaseImageview = var14;
      this.leftGuideline = var15;
      this.modeTitle = var16;
      this.rightGuideline = var17;
      this.seekbarGuideline1 = var18;
      this.seekbarGuideline2 = var19;
      this.seekbarGuideline3 = var20;
      this.separator = var21;
      this.standbyBackground = var22;
      this.standbyImageview = var23;
      this.standbyMessageView = var24;
      this.standbyTitleView = var25;
   }

   public static HolderIcpManualModeBinding bind(View var0) {
      int var1 = R.id.clear_air_min_view;
      TextView var25 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var25 != null) {
         var1 = R.id.clear_air_msg_view;
         TextView var21 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var21 != null) {
            var1 = R.id.decrease_fan_speed_bg;
            AppCompatImageView var11 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
            if (var11 != null) {
               var1 = R.id.decrease_imageview;
               AppCompatImageView var5 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  var1 = R.id.fan_speed_seekbar;
                  AccessibleSeekBar var7 = (AccessibleSeekBar)ViewBindings.findChildViewById(var0, var1);
                  if (var7 != null) {
                     var1 = R.id.fanspeed_1;
                     TextView var18 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var18 != null) {
                        var1 = R.id.fanspeed_2;
                        TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var6 != null) {
                           var1 = R.id.fanspeed_3;
                           TextView var24 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var24 != null) {
                              var1 = R.id.germshield_icon;
                              AppCompatImageView var17 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                              if (var17 != null) {
                                 var1 = R.id.germshield_root;
                                 ConstraintLayout var15 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                 if (var15 != null) {
                                    var1 = R.id.germshield_title;
                                    TextView var13 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                    if (var13 != null) {
                                       var1 = R.id.increase_fan_speed_bg;
                                       AppCompatImageView var2 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                                       if (var2 != null) {
                                          var1 = R.id.increase_imageview;
                                          AppCompatImageView var16 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                                          if (var16 != null) {
                                             var1 = R.id.left_guideline;
                                             Guideline var9 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                             if (var9 != null) {
                                                var1 = R.id.mode_title;
                                                TextView var23 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                if (var23 != null) {
                                                   var1 = R.id.right_guideline;
                                                   Guideline var10 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                   if (var10 != null) {
                                                      var1 = R.id.seekbar_guideline_1;
                                                      Guideline var14 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                      if (var14 != null) {
                                                         var1 = R.id.seekbar_guideline_2;
                                                         Guideline var8 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                         if (var8 != null) {
                                                            var1 = R.id.seekbar_guideline_3;
                                                            Guideline var3 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                            if (var3 != null) {
                                                               var1 = R.id.separator;
                                                               View var22 = ViewBindings.findChildViewById(var0, var1);
                                                               if (var22 != null) {
                                                                  var1 = R.id.standby_background;
                                                                  AppCompatImageView var20 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                                                                  if (var20 != null) {
                                                                     var1 = R.id.standby_imageview;
                                                                     AppCompatImageView var19 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                                                                     if (var19 != null) {
                                                                        var1 = R.id.standby_message_view;
                                                                        TextView var12 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                        if (var12 != null) {
                                                                           var1 = R.id.standby_title_view;
                                                                           TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                           if (var4 != null) {
                                                                              return new HolderIcpManualModeBinding((ConstraintLayout)var0, var25, var21, var11, var5, var7, var18, var6, var24, var17, var15, var13, var2, var16, var9, var23, var10, var14, var8, var3, var22, var20, var19, var12, var4);
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
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderIcpManualModeBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderIcpManualModeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_icp_manual_mode, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
