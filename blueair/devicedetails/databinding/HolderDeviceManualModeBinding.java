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

public final class HolderDeviceManualModeBinding implements ViewBinding {
   public final TextView clearAirMinView;
   public final TextView clearAirMsgView;
   public final AppCompatImageView decreaseFanSpeedBg;
   public final AppCompatImageView decreaseImageview;
   public final AccessibleSeekBar fanSpeedSeekbar;
   public final TextView fanspeed0;
   public final TextView fanspeed1;
   public final TextView fanspeed1Blue;
   public final TextView fanspeed2;
   public final TextView fanspeed2Icp;
   public final TextView fanspeed3;
   public final TextView fanspeed3Blue;
   public final AppCompatImageView germshieldIcon;
   public final ConstraintLayout germshieldRoot;
   public final TextView germshieldTitle;
   public final AppCompatImageView increaseFanSpeedBg;
   public final AppCompatImageView increaseImageview;
   public final Guideline leftGuideline;
   public final TextView modeTitle;
   public final Guideline rightGuideline;
   private final ConstraintLayout rootView;
   public final Guideline seekbarGuideline0;
   public final Guideline seekbarGuideline1;
   public final Guideline seekbarGuideline2;
   public final Guideline seekbarGuideline3;
   public final Guideline seekbarGuideline35;
   public final Guideline seekbarGuideline65;
   public final Guideline seekbarGuidelineHalf;
   public final View separator;
   public final AppCompatImageView standbyBackground;
   public final AppCompatImageView standbyImageview;
   public final TextView standbyMessageView;
   public final TextView standbyTitleView;

   private HolderDeviceManualModeBinding(ConstraintLayout var1, TextView var2, TextView var3, AppCompatImageView var4, AppCompatImageView var5, AccessibleSeekBar var6, TextView var7, TextView var8, TextView var9, TextView var10, TextView var11, TextView var12, TextView var13, AppCompatImageView var14, ConstraintLayout var15, TextView var16, AppCompatImageView var17, AppCompatImageView var18, Guideline var19, TextView var20, Guideline var21, Guideline var22, Guideline var23, Guideline var24, Guideline var25, Guideline var26, Guideline var27, Guideline var28, View var29, AppCompatImageView var30, AppCompatImageView var31, TextView var32, TextView var33) {
      this.rootView = var1;
      this.clearAirMinView = var2;
      this.clearAirMsgView = var3;
      this.decreaseFanSpeedBg = var4;
      this.decreaseImageview = var5;
      this.fanSpeedSeekbar = var6;
      this.fanspeed0 = var7;
      this.fanspeed1 = var8;
      this.fanspeed1Blue = var9;
      this.fanspeed2 = var10;
      this.fanspeed2Icp = var11;
      this.fanspeed3 = var12;
      this.fanspeed3Blue = var13;
      this.germshieldIcon = var14;
      this.germshieldRoot = var15;
      this.germshieldTitle = var16;
      this.increaseFanSpeedBg = var17;
      this.increaseImageview = var18;
      this.leftGuideline = var19;
      this.modeTitle = var20;
      this.rightGuideline = var21;
      this.seekbarGuideline0 = var22;
      this.seekbarGuideline1 = var23;
      this.seekbarGuideline2 = var24;
      this.seekbarGuideline3 = var25;
      this.seekbarGuideline35 = var26;
      this.seekbarGuideline65 = var27;
      this.seekbarGuidelineHalf = var28;
      this.separator = var29;
      this.standbyBackground = var30;
      this.standbyImageview = var31;
      this.standbyMessageView = var32;
      this.standbyTitleView = var33;
   }

   public static HolderDeviceManualModeBinding bind(View var0) {
      int var1 = R.id.clear_air_min_view;
      TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var8 != null) {
         var1 = R.id.clear_air_msg_view;
         TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.decrease_fan_speed_bg;
            AppCompatImageView var16 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
            if (var16 != null) {
               var1 = R.id.decrease_imageview;
               AppCompatImageView var28 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
               if (var28 != null) {
                  var1 = R.id.fan_speed_seekbar;
                  AccessibleSeekBar var29 = (AccessibleSeekBar)ViewBindings.findChildViewById(var0, var1);
                  if (var29 != null) {
                     var1 = R.id.fanspeed_0;
                     TextView var15 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var15 != null) {
                        var1 = R.id.fanspeed_1;
                        TextView var23 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var23 != null) {
                           var1 = R.id.fanspeed_1_blue;
                           TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var9 != null) {
                              var1 = R.id.fanspeed_2;
                              TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                              if (var3 != null) {
                                 var1 = R.id.fanspeed_2_icp;
                                 TextView var19 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var19 != null) {
                                    var1 = R.id.fanspeed_3;
                                    TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                    if (var6 != null) {
                                       var1 = R.id.fanspeed_3_blue;
                                       TextView var33 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                       if (var33 != null) {
                                          var1 = R.id.germshield_icon;
                                          AppCompatImageView var27 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                                          if (var27 != null) {
                                             var1 = R.id.germshield_root;
                                             ConstraintLayout var12 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                             if (var12 != null) {
                                                var1 = R.id.germshield_title;
                                                TextView var26 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                if (var26 != null) {
                                                   var1 = R.id.increase_fan_speed_bg;
                                                   AppCompatImageView var22 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                                                   if (var22 != null) {
                                                      var1 = R.id.increase_imageview;
                                                      AppCompatImageView var11 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                                                      if (var11 != null) {
                                                         var1 = R.id.left_guideline;
                                                         Guideline var20 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                         if (var20 != null) {
                                                            var1 = R.id.mode_title;
                                                            TextView var21 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                            if (var21 != null) {
                                                               var1 = R.id.right_guideline;
                                                               Guideline var10 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                               if (var10 != null) {
                                                                  var1 = R.id.seekbar_guideline_0;
                                                                  Guideline var24 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                                  if (var24 != null) {
                                                                     var1 = R.id.seekbar_guideline_1;
                                                                     Guideline var7 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                                     if (var7 != null) {
                                                                        var1 = R.id.seekbar_guideline_2;
                                                                        Guideline var4 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                                        if (var4 != null) {
                                                                           var1 = R.id.seekbar_guideline_3;
                                                                           Guideline var30 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                                           if (var30 != null) {
                                                                              var1 = R.id.seekbar_guideline_35;
                                                                              Guideline var32 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                                              if (var32 != null) {
                                                                                 var1 = R.id.seekbar_guideline_65;
                                                                                 Guideline var18 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                                                 if (var18 != null) {
                                                                                    var1 = R.id.seekbar_guideline_half;
                                                                                    Guideline var13 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                                                    if (var13 != null) {
                                                                                       var1 = R.id.separator;
                                                                                       View var31 = ViewBindings.findChildViewById(var0, var1);
                                                                                       if (var31 != null) {
                                                                                          var1 = R.id.standby_background;
                                                                                          AppCompatImageView var14 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                                                                                          if (var14 != null) {
                                                                                             var1 = R.id.standby_imageview;
                                                                                             AppCompatImageView var17 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                                                                                             if (var17 != null) {
                                                                                                var1 = R.id.standby_message_view;
                                                                                                TextView var25 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                if (var25 != null) {
                                                                                                   var1 = R.id.standby_title_view;
                                                                                                   TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                   if (var5 != null) {
                                                                                                      return new HolderDeviceManualModeBinding((ConstraintLayout)var0, var8, var2, var16, var28, var29, var15, var23, var9, var3, var19, var6, var33, var27, var12, var26, var22, var11, var20, var21, var10, var24, var7, var4, var30, var32, var18, var13, var31, var14, var17, var25, var5);
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

   public static HolderDeviceManualModeBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceManualModeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_manual_mode, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
