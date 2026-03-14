package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.CirculatorFanContainer;
import com.blueair.viewcore.view.SwitchCompat;
import com.google.android.material.button.MaterialButton;

public final class DialogfragmentDeviceOscillationSheetBinding implements ViewBinding {
   public final AppCompatImageButton btnClose;
   public final LinearLayout btnGroupDirection;
   public final MaterialButton btnHorizontal;
   public final MaterialButton btnResetPosition;
   public final MaterialButton btnVertical;
   public final ConstraintLayout contentAngleAnimator;
   public final ConstraintLayout contentContainer;
   public final CirculatorFanContainer fanContainer;
   public final HolderDeviceHintBinding hintAngle;
   public final HolderDeviceHintBinding hintReset;
   public final ImageView ivInfo;
   public final NestedScrollView nsvContainer;
   public final RadioButton rbAngle120;
   public final RadioButton rbAngle30;
   public final RadioButton rbAngle60;
   public final RadioButton rbAngle90;
   public final RadioGroup rgAngle;
   private final ConstraintLayout rootView;
   public final SwitchCompat switchOscillation;
   public final AppCompatTextView title;
   public final TextView tvOscillation;
   public final TextView tvQuickSetup;
   public final TextView tvResetPos;
   public final View vSeparator1;
   public final View vSeparator2;
   public final View vTop;

   private DialogfragmentDeviceOscillationSheetBinding(ConstraintLayout var1, AppCompatImageButton var2, LinearLayout var3, MaterialButton var4, MaterialButton var5, MaterialButton var6, ConstraintLayout var7, ConstraintLayout var8, CirculatorFanContainer var9, HolderDeviceHintBinding var10, HolderDeviceHintBinding var11, ImageView var12, NestedScrollView var13, RadioButton var14, RadioButton var15, RadioButton var16, RadioButton var17, RadioGroup var18, SwitchCompat var19, AppCompatTextView var20, TextView var21, TextView var22, TextView var23, View var24, View var25, View var26) {
      this.rootView = var1;
      this.btnClose = var2;
      this.btnGroupDirection = var3;
      this.btnHorizontal = var4;
      this.btnResetPosition = var5;
      this.btnVertical = var6;
      this.contentAngleAnimator = var7;
      this.contentContainer = var8;
      this.fanContainer = var9;
      this.hintAngle = var10;
      this.hintReset = var11;
      this.ivInfo = var12;
      this.nsvContainer = var13;
      this.rbAngle120 = var14;
      this.rbAngle30 = var15;
      this.rbAngle60 = var16;
      this.rbAngle90 = var17;
      this.rgAngle = var18;
      this.switchOscillation = var19;
      this.title = var20;
      this.tvOscillation = var21;
      this.tvQuickSetup = var22;
      this.tvResetPos = var23;
      this.vSeparator1 = var24;
      this.vSeparator2 = var25;
      this.vTop = var26;
   }

   public static DialogfragmentDeviceOscillationSheetBinding bind(View var0) {
      int var1 = R.id.btn_close;
      AppCompatImageButton var2 = (AppCompatImageButton)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.btnGroup_direction;
         LinearLayout var4 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.btn_horizontal;
            MaterialButton var6 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               var1 = R.id.btn_resetPosition;
               MaterialButton var3 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
               if (var3 != null) {
                  var1 = R.id.btn_vertical;
                  MaterialButton var8 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
                  if (var8 != null) {
                     var1 = R.id.content_angle_animator;
                     ConstraintLayout var7 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                     if (var7 != null) {
                        ConstraintLayout var5 = (ConstraintLayout)var0;
                        var1 = R.id.fan_container;
                        CirculatorFanContainer var9 = (CirculatorFanContainer)ViewBindings.findChildViewById(var0, var1);
                        if (var9 != null) {
                           var1 = R.id.hint_angle;
                           View var10 = ViewBindings.findChildViewById(var0, var1);
                           if (var10 != null) {
                              HolderDeviceHintBinding var27 = HolderDeviceHintBinding.bind(var10);
                              var1 = R.id.hint_reset;
                              View var11 = ViewBindings.findChildViewById(var0, var1);
                              if (var11 != null) {
                                 HolderDeviceHintBinding var14 = HolderDeviceHintBinding.bind(var11);
                                 var1 = R.id.iv_info;
                                 ImageView var25 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                 if (var25 != null) {
                                    var1 = R.id.nsv_container;
                                    NestedScrollView var28 = (NestedScrollView)ViewBindings.findChildViewById(var0, var1);
                                    if (var28 != null) {
                                       var1 = R.id.rb_angle120;
                                       RadioButton var17 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
                                       if (var17 != null) {
                                          var1 = R.id.rb_angle30;
                                          RadioButton var13 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
                                          if (var13 != null) {
                                             var1 = R.id.rb_angle60;
                                             RadioButton var20 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
                                             if (var20 != null) {
                                                var1 = R.id.rb_angle90;
                                                RadioButton var23 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
                                                if (var23 != null) {
                                                   var1 = R.id.rg_angle;
                                                   RadioGroup var12 = (RadioGroup)ViewBindings.findChildViewById(var0, var1);
                                                   if (var12 != null) {
                                                      var1 = R.id.switch_oscillation;
                                                      SwitchCompat var18 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
                                                      if (var18 != null) {
                                                         var1 = R.id.title;
                                                         AppCompatTextView var19 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                                         if (var19 != null) {
                                                            var1 = R.id.tv_oscillation;
                                                            TextView var26 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                            if (var26 != null) {
                                                               var1 = R.id.tv_quickSetup;
                                                               TextView var21 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                               if (var21 != null) {
                                                                  var1 = R.id.tv_resetPos;
                                                                  TextView var15 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                  if (var15 != null) {
                                                                     var1 = R.id.v_separator1;
                                                                     View var22 = ViewBindings.findChildViewById(var0, var1);
                                                                     if (var22 != null) {
                                                                        var1 = R.id.v_separator2;
                                                                        View var24 = ViewBindings.findChildViewById(var0, var1);
                                                                        if (var24 != null) {
                                                                           var1 = R.id.v_top;
                                                                           View var16 = ViewBindings.findChildViewById(var0, var1);
                                                                           if (var16 != null) {
                                                                              return new DialogfragmentDeviceOscillationSheetBinding(var5, var2, var4, var6, var3, var8, var7, var5, var9, var27, var14, var25, var28, var17, var13, var20, var23, var12, var18, var19, var26, var21, var15, var22, var24, var16);
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

   public static DialogfragmentDeviceOscillationSheetBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogfragmentDeviceOscillationSheetBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialogfragment_device_oscillation_sheet, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
