package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SwitchCompat;
import com.dd.ShadowLayout;

public final class HolderDeviceDualOscillationBinding implements ViewBinding {
   public final ConstraintLayout clHorizontal;
   public final ConstraintLayout clVertical;
   public final View clickView;
   public final SwitchCompat expendSwitch;
   public final Group expendedContent;
   public final HolderDeviceHintBinding hintLoop;
   public final ImageView ivHorizontal;
   public final ImageView ivInfo;
   public final ImageView ivVertical;
   public final ImageView leadingIcon;
   private final ShadowLayout rootView;
   public final ShadowLayout slContainer;
   public final ShadowLayout slHorizontal;
   public final ShadowLayout slVertical;
   public final SwitchCompat switchLoop;
   public final TextView title;
   public final TextView tvHorizontal;
   public final TextView tvHorizontalAngle;
   public final TextView tvLoop;
   public final TextView tvVertical;
   public final TextView tvVerticalAngle;
   public final View vSeparator;

   private HolderDeviceDualOscillationBinding(ShadowLayout var1, ConstraintLayout var2, ConstraintLayout var3, View var4, SwitchCompat var5, Group var6, HolderDeviceHintBinding var7, ImageView var8, ImageView var9, ImageView var10, ImageView var11, ShadowLayout var12, ShadowLayout var13, ShadowLayout var14, SwitchCompat var15, TextView var16, TextView var17, TextView var18, TextView var19, TextView var20, TextView var21, View var22) {
      this.rootView = var1;
      this.clHorizontal = var2;
      this.clVertical = var3;
      this.clickView = var4;
      this.expendSwitch = var5;
      this.expendedContent = var6;
      this.hintLoop = var7;
      this.ivHorizontal = var8;
      this.ivInfo = var9;
      this.ivVertical = var10;
      this.leadingIcon = var11;
      this.slContainer = var12;
      this.slHorizontal = var13;
      this.slVertical = var14;
      this.switchLoop = var15;
      this.title = var16;
      this.tvHorizontal = var17;
      this.tvHorizontalAngle = var18;
      this.tvLoop = var19;
      this.tvVertical = var20;
      this.tvVerticalAngle = var21;
      this.vSeparator = var22;
   }

   public static HolderDeviceDualOscillationBinding bind(View var0) {
      int var1 = R.id.cl_horizontal;
      ConstraintLayout var5 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
      if (var5 != null) {
         var1 = R.id.cl_vertical;
         ConstraintLayout var4 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.click_view;
            View var2 = ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               var1 = R.id.expend_switch;
               SwitchCompat var3 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
               if (var3 != null) {
                  var1 = R.id.expended_content;
                  Group var6 = (Group)ViewBindings.findChildViewById(var0, var1);
                  if (var6 != null) {
                     var1 = R.id.hint_loop;
                     View var7 = ViewBindings.findChildViewById(var0, var1);
                     if (var7 != null) {
                        HolderDeviceHintBinding var20 = HolderDeviceHintBinding.bind(var7);
                        var1 = R.id.iv_horizontal;
                        ImageView var8 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                        if (var8 != null) {
                           var1 = R.id.iv_info;
                           ImageView var11 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                           if (var11 != null) {
                              var1 = R.id.iv_vertical;
                              ImageView var10 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                              if (var10 != null) {
                                 var1 = R.id.leading_icon;
                                 ImageView var13 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                 if (var13 != null) {
                                    ShadowLayout var21 = (ShadowLayout)var0;
                                    var1 = R.id.sl_horizontal;
                                    ShadowLayout var12 = (ShadowLayout)ViewBindings.findChildViewById(var0, var1);
                                    if (var12 != null) {
                                       var1 = R.id.sl_vertical;
                                       ShadowLayout var23 = (ShadowLayout)ViewBindings.findChildViewById(var0, var1);
                                       if (var23 != null) {
                                          var1 = R.id.switch_loop;
                                          SwitchCompat var16 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
                                          if (var16 != null) {
                                             var1 = R.id.title;
                                             TextView var17 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                             if (var17 != null) {
                                                var1 = R.id.tv_horizontal;
                                                TextView var18 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                if (var18 != null) {
                                                   var1 = R.id.tv_horizontalAngle;
                                                   TextView var19 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                   if (var19 != null) {
                                                      var1 = R.id.tv_loop;
                                                      TextView var15 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                      if (var15 != null) {
                                                         var1 = R.id.tv_vertical;
                                                         TextView var14 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                         if (var14 != null) {
                                                            var1 = R.id.tv_verticalAngle;
                                                            TextView var22 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                            if (var22 != null) {
                                                               var1 = R.id.v_separator;
                                                               View var9 = ViewBindings.findChildViewById(var0, var1);
                                                               if (var9 != null) {
                                                                  return new HolderDeviceDualOscillationBinding(var21, var5, var4, var2, var3, var6, var20, var8, var11, var10, var13, var21, var12, var23, var16, var17, var18, var19, var15, var14, var22, var9);
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

   public static HolderDeviceDualOscillationBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceDualOscillationBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_dual_oscillation, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ShadowLayout getRoot() {
      return this.rootView;
   }
}
