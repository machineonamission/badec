package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import com.blueair.viewcore.view.FanView;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;

public final class DialogfragmentDeviceOscillationSettingsBinding implements ViewBinding {
   public final TextView angleLevel1;
   public final TextView angleLevel2;
   public final TextView angleLevel3;
   public final TextView angleLevel4;
   public final TextView angleLevel5;
   public final TextView angleTitle;
   public final AppCompatImageView arrowLeft;
   public final AppCompatImageView arrowRight;
   public final AppCompatImageView arrowStraight;
   public final AppCompatImageButton btnClose;
   public final MaterialButton btnDone;
   public final AppCompatImageView centerBackground;
   public final ConstraintLayout clAdjust;
   public final ConstraintLayout contentAngleAnimator;
   public final ConstraintLayout contentContainer;
   public final AppCompatImageView deviceImage;
   public final FanView fanView;
   public final LinearLayout llContainer;
   public final NestedScrollView nsvContainer;
   public final TextView oscillationDiagramAngle;
   private final ConstraintLayout rootView;
   public final AccessibleSeekBar seekbarAngle;
   public final AccessibleSeekBar seekbarSpeed;
   public final View separator2;
   public final View separatorAngle1;
   public final View separatorAngle2;
   public final View separatorAngle3;
   public final View separatorAngle4;
   public final View separatorAngle5;
   public final View separatorSpeed1;
   public final View separatorSpeed2;
   public final View separatorSpeed3;
   public final ShadowLayout slAdjust;
   public final TextView speedLevel1;
   public final TextView speedLevel2;
   public final TextView speedLevel3;
   public final AppCompatTextView title;
   public final TextView tvAngleValue;
   public final TextView tvSpeedLabel;
   public final TextView tvSpeedValue;
   public final View vTop;

   private DialogfragmentDeviceOscillationSettingsBinding(ConstraintLayout var1, TextView var2, TextView var3, TextView var4, TextView var5, TextView var6, TextView var7, AppCompatImageView var8, AppCompatImageView var9, AppCompatImageView var10, AppCompatImageButton var11, MaterialButton var12, AppCompatImageView var13, ConstraintLayout var14, ConstraintLayout var15, ConstraintLayout var16, AppCompatImageView var17, FanView var18, LinearLayout var19, NestedScrollView var20, TextView var21, AccessibleSeekBar var22, AccessibleSeekBar var23, View var24, View var25, View var26, View var27, View var28, View var29, View var30, View var31, View var32, ShadowLayout var33, TextView var34, TextView var35, TextView var36, AppCompatTextView var37, TextView var38, TextView var39, TextView var40, View var41) {
      this.rootView = var1;
      this.angleLevel1 = var2;
      this.angleLevel2 = var3;
      this.angleLevel3 = var4;
      this.angleLevel4 = var5;
      this.angleLevel5 = var6;
      this.angleTitle = var7;
      this.arrowLeft = var8;
      this.arrowRight = var9;
      this.arrowStraight = var10;
      this.btnClose = var11;
      this.btnDone = var12;
      this.centerBackground = var13;
      this.clAdjust = var14;
      this.contentAngleAnimator = var15;
      this.contentContainer = var16;
      this.deviceImage = var17;
      this.fanView = var18;
      this.llContainer = var19;
      this.nsvContainer = var20;
      this.oscillationDiagramAngle = var21;
      this.seekbarAngle = var22;
      this.seekbarSpeed = var23;
      this.separator2 = var24;
      this.separatorAngle1 = var25;
      this.separatorAngle2 = var26;
      this.separatorAngle3 = var27;
      this.separatorAngle4 = var28;
      this.separatorAngle5 = var29;
      this.separatorSpeed1 = var30;
      this.separatorSpeed2 = var31;
      this.separatorSpeed3 = var32;
      this.slAdjust = var33;
      this.speedLevel1 = var34;
      this.speedLevel2 = var35;
      this.speedLevel3 = var36;
      this.title = var37;
      this.tvAngleValue = var38;
      this.tvSpeedLabel = var39;
      this.tvSpeedValue = var40;
      this.vTop = var41;
   }

   public static DialogfragmentDeviceOscillationSettingsBinding bind(View var0) {
      int var1 = R.id.angle_level_1;
      TextView var22 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var22 != null) {
         var1 = R.id.angle_level_2;
         TextView var11 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var11 != null) {
            var1 = R.id.angle_level_3;
            TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               var1 = R.id.angle_level_4;
               TextView var34 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var34 != null) {
                  var1 = R.id.angle_level_5;
                  TextView var36 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var36 != null) {
                     var1 = R.id.angle_title;
                     TextView var10 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var10 != null) {
                        var1 = R.id.arrow_left;
                        AppCompatImageView var26 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                        if (var26 != null) {
                           var1 = R.id.arrow_right;
                           AppCompatImageView var21 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                           if (var21 != null) {
                              var1 = R.id.arrow_straight;
                              AppCompatImageView var17 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                              if (var17 != null) {
                                 var1 = R.id.btn_close;
                                 AppCompatImageButton var15 = (AppCompatImageButton)ViewBindings.findChildViewById(var0, var1);
                                 if (var15 != null) {
                                    var1 = R.id.btn_done;
                                    MaterialButton var18 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
                                    if (var18 != null) {
                                       var1 = R.id.center_background;
                                       AppCompatImageView var3 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                                       if (var3 != null) {
                                          var1 = R.id.cl_adjust;
                                          ConstraintLayout var14 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                          if (var14 != null) {
                                             var1 = R.id.content_angle_animator;
                                             ConstraintLayout var35 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                             if (var35 != null) {
                                                ConstraintLayout var30 = (ConstraintLayout)var0;
                                                var1 = R.id.device_image;
                                                AppCompatImageView var38 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                                                if (var38 != null) {
                                                   var1 = R.id.fan_view;
                                                   FanView var25 = (FanView)ViewBindings.findChildViewById(var0, var1);
                                                   if (var25 != null) {
                                                      var1 = R.id.ll_container;
                                                      LinearLayout var27 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                                                      if (var27 != null) {
                                                         var1 = R.id.nsv_container;
                                                         NestedScrollView var31 = (NestedScrollView)ViewBindings.findChildViewById(var0, var1);
                                                         if (var31 != null) {
                                                            var1 = R.id.oscillation_diagram_angle;
                                                            TextView var20 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                            if (var20 != null) {
                                                               var1 = R.id.seekbar_angle;
                                                               AccessibleSeekBar var7 = (AccessibleSeekBar)ViewBindings.findChildViewById(var0, var1);
                                                               if (var7 != null) {
                                                                  var1 = R.id.seekbar_speed;
                                                                  AccessibleSeekBar var6 = (AccessibleSeekBar)ViewBindings.findChildViewById(var0, var1);
                                                                  if (var6 != null) {
                                                                     var1 = R.id.separator_2;
                                                                     View var4 = ViewBindings.findChildViewById(var0, var1);
                                                                     if (var4 != null) {
                                                                        var1 = R.id.separator_angle_1;
                                                                        View var5 = ViewBindings.findChildViewById(var0, var1);
                                                                        if (var5 != null) {
                                                                           var1 = R.id.separator_angle_2;
                                                                           View var29 = ViewBindings.findChildViewById(var0, var1);
                                                                           if (var29 != null) {
                                                                              var1 = R.id.separator_angle_3;
                                                                              View var16 = ViewBindings.findChildViewById(var0, var1);
                                                                              if (var16 != null) {
                                                                                 var1 = R.id.separator_angle_4;
                                                                                 View var24 = ViewBindings.findChildViewById(var0, var1);
                                                                                 if (var24 != null) {
                                                                                    var1 = R.id.separator_angle_5;
                                                                                    View var28 = ViewBindings.findChildViewById(var0, var1);
                                                                                    if (var28 != null) {
                                                                                       var1 = R.id.separator_speed_1;
                                                                                       View var40 = ViewBindings.findChildViewById(var0, var1);
                                                                                       if (var40 != null) {
                                                                                          var1 = R.id.separator_speed_2;
                                                                                          View var13 = ViewBindings.findChildViewById(var0, var1);
                                                                                          if (var13 != null) {
                                                                                             var1 = R.id.separator_speed_3;
                                                                                             View var41 = ViewBindings.findChildViewById(var0, var1);
                                                                                             if (var41 != null) {
                                                                                                var1 = R.id.sl_adjust;
                                                                                                ShadowLayout var8 = (ShadowLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                                if (var8 != null) {
                                                                                                   var1 = R.id.speed_level_1;
                                                                                                   TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                   if (var9 != null) {
                                                                                                      var1 = R.id.speed_level_2;
                                                                                                      TextView var32 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                      if (var32 != null) {
                                                                                                         var1 = R.id.speed_level_3;
                                                                                                         TextView var37 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                         if (var37 != null) {
                                                                                                            var1 = R.id.title;
                                                                                                            AppCompatTextView var33 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                            if (var33 != null) {
                                                                                                               var1 = R.id.tv_angleValue;
                                                                                                               TextView var19 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                               if (var19 != null) {
                                                                                                                  var1 = R.id.tv_speedLabel;
                                                                                                                  TextView var39 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                  if (var39 != null) {
                                                                                                                     var1 = R.id.tv_speedValue;
                                                                                                                     TextView var23 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                     if (var23 != null) {
                                                                                                                        var1 = R.id.v_top;
                                                                                                                        View var12 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                        if (var12 != null) {
                                                                                                                           return new DialogfragmentDeviceOscillationSettingsBinding(var30, var22, var11, var2, var34, var36, var10, var26, var21, var17, var15, var18, var3, var14, var35, var30, var38, var25, var27, var31, var20, var7, var6, var4, var5, var29, var16, var24, var28, var40, var13, var41, var8, var9, var32, var37, var33, var19, var39, var23, var12);
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
                        }
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static DialogfragmentDeviceOscillationSettingsBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogfragmentDeviceOscillationSettingsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialogfragment_device_oscillation_settings, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
