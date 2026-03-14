package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;
import com.blueair.viewcore.view.SimpleIconTextView;
import com.blueair.viewcore.view.SwitchCompat;
import com.dd.ShadowLayout;

public final class HolderDeviceBinding implements ViewBinding {
   public final View airQualityIndicator;
   public final Barrier barrierQuality;
   public final ImageView childLockIcon;
   public final ImageView deviceImg;
   public final TextView deviceName;
   public final Flow flowStatus;
   public final ConstraintLayout foregroundLayout;
   public final SimpleIconTextView itvAlarm;
   public final View ivDegreeIndicator;
   public final ImageView ivOfflineInfo;
   public final ImageView ivTimer;
   public final AppCompatImageView ivWarning;
   public final LinearLayout llMode1;
   public final LinearLayout llMode2;
   public final LinearLayout llTimer;
   public final ImageView modeIcon1;
   public final ImageView modeIcon2;
   public final AppCompatTextView modeText1;
   public final AppCompatTextView modeText2;
   private final ShadowLayout rootView;
   public final TextView safetySwitchText;
   public final ShadowLayout shadowLayout;
   public final SwitchCompat standbySwitch;
   public final TextView tvAirFilterStatus;
   public final TextView tvAirQuality;
   public final TextView tvDegree;
   public final AppCompatTextView tvTimer;
   public final TextView tvWickFilterStatus;

   private HolderDeviceBinding(ShadowLayout var1, View var2, Barrier var3, ImageView var4, ImageView var5, TextView var6, Flow var7, ConstraintLayout var8, SimpleIconTextView var9, View var10, ImageView var11, ImageView var12, AppCompatImageView var13, LinearLayout var14, LinearLayout var15, LinearLayout var16, ImageView var17, ImageView var18, AppCompatTextView var19, AppCompatTextView var20, TextView var21, ShadowLayout var22, SwitchCompat var23, TextView var24, TextView var25, TextView var26, AppCompatTextView var27, TextView var28) {
      this.rootView = var1;
      this.airQualityIndicator = var2;
      this.barrierQuality = var3;
      this.childLockIcon = var4;
      this.deviceImg = var5;
      this.deviceName = var6;
      this.flowStatus = var7;
      this.foregroundLayout = var8;
      this.itvAlarm = var9;
      this.ivDegreeIndicator = var10;
      this.ivOfflineInfo = var11;
      this.ivTimer = var12;
      this.ivWarning = var13;
      this.llMode1 = var14;
      this.llMode2 = var15;
      this.llTimer = var16;
      this.modeIcon1 = var17;
      this.modeIcon2 = var18;
      this.modeText1 = var19;
      this.modeText2 = var20;
      this.safetySwitchText = var21;
      this.shadowLayout = var22;
      this.standbySwitch = var23;
      this.tvAirFilterStatus = var24;
      this.tvAirQuality = var25;
      this.tvDegree = var26;
      this.tvTimer = var27;
      this.tvWickFilterStatus = var28;
   }

   public static HolderDeviceBinding bind(View var0) {
      int var1 = R.id.air_quality_indicator;
      View var27 = ViewBindings.findChildViewById(var0, var1);
      if (var27 != null) {
         var1 = R.id.barrier_quality;
         Barrier var11 = (Barrier)ViewBindings.findChildViewById(var0, var1);
         if (var11 != null) {
            var1 = R.id.child_lock_icon;
            ImageView var23 = (ImageView)ViewBindings.findChildViewById(var0, var1);
            if (var23 != null) {
               var1 = R.id.device_img;
               ImageView var15 = (ImageView)ViewBindings.findChildViewById(var0, var1);
               if (var15 != null) {
                  var1 = R.id.device_name;
                  TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var7 != null) {
                     var1 = R.id.flow_status;
                     Flow var8 = (Flow)ViewBindings.findChildViewById(var0, var1);
                     if (var8 != null) {
                        var1 = R.id.foregroundLayout;
                        ConstraintLayout var2 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                        if (var2 != null) {
                           var1 = R.id.itv_alarm;
                           SimpleIconTextView var6 = (SimpleIconTextView)ViewBindings.findChildViewById(var0, var1);
                           if (var6 != null) {
                              var1 = R.id.iv_degree_indicator;
                              View var20 = ViewBindings.findChildViewById(var0, var1);
                              if (var20 != null) {
                                 var1 = R.id.iv_offline_info;
                                 ImageView var5 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                 if (var5 != null) {
                                    var1 = R.id.iv_timer;
                                    ImageView var17 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                    if (var17 != null) {
                                       var1 = R.id.iv_warning;
                                       AppCompatImageView var3 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                                       if (var3 != null) {
                                          var1 = R.id.ll_mode1;
                                          LinearLayout var10 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                                          if (var10 != null) {
                                             var1 = R.id.ll_mode2;
                                             LinearLayout var25 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                                             if (var25 != null) {
                                                var1 = R.id.ll_timer;
                                                LinearLayout var16 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                                                if (var16 != null) {
                                                   var1 = R.id.mode_icon_1;
                                                   ImageView var9 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                                   if (var9 != null) {
                                                      var1 = R.id.mode_icon_2;
                                                      ImageView var26 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                                      if (var26 != null) {
                                                         var1 = R.id.mode_text_1;
                                                         AppCompatTextView var22 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                                         if (var22 != null) {
                                                            var1 = R.id.mode_text_2;
                                                            AppCompatTextView var12 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                                            if (var12 != null) {
                                                               var1 = R.id.safety_switch_text;
                                                               TextView var14 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                               if (var14 != null) {
                                                                  ShadowLayout var13 = (ShadowLayout)var0;
                                                                  var1 = R.id.standby_switch;
                                                                  SwitchCompat var4 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
                                                                  if (var4 != null) {
                                                                     var1 = R.id.tv_air_filterStatus;
                                                                     TextView var19 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                     if (var19 != null) {
                                                                        var1 = R.id.tv_air_quality;
                                                                        TextView var21 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                        if (var21 != null) {
                                                                           var1 = R.id.tv_degree;
                                                                           TextView var28 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                           if (var28 != null) {
                                                                              var1 = R.id.tv_timer;
                                                                              AppCompatTextView var24 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                                                              if (var24 != null) {
                                                                                 var1 = R.id.tv_wick_filterStatus;
                                                                                 TextView var18 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                 if (var18 != null) {
                                                                                    return new HolderDeviceBinding(var13, var27, var11, var23, var15, var7, var8, var2, var6, var20, var5, var17, var3, var10, var25, var16, var9, var26, var22, var12, var14, var13, var4, var19, var21, var28, var24, var18);
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

   public static HolderDeviceBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ShadowLayout getRoot() {
      return this.rootView;
   }
}
