package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;
import io.apptik.widget.MultiSlider;

public final class DialogfragmentDeviceFanPresetBinding implements ViewBinding {
   public final MaterialButton btnApply;
   public final MaterialButton btnReset;
   public final ImageButton closeBtn;
   public final ConstraintLayout contentContainer;
   public final ConstraintLayout contentPresetDetail;
   public final TextView currentUpdateTemp;
   public final TextView fanPresetInfo;
   public final TextView fanSpeedTitle1;
   public final TextView fanSpeedTitle2;
   public final TextView fanSpeedTitle3;
   public final TextView fanSpeedTitle4;
   public final TextView fanSpeedTrigger;
   public final TextView maxTemp;
   public final TextView minTemp;
   public final MultiSlider rangeSlider;
   private final FrameLayout rootView;
   public final View separator1;
   public final View separator2;
   public final View separator3;
   public final View separator4;
   public final View separator5;
   public final TextView timerSelect1;
   public final TextView timerSelect2;
   public final TextView timerSelect3;
   public final TextView timerSelect4;
   public final TextView timerTriggerSelect;
   public final TextView title;

   private DialogfragmentDeviceFanPresetBinding(FrameLayout var1, MaterialButton var2, MaterialButton var3, ImageButton var4, ConstraintLayout var5, ConstraintLayout var6, TextView var7, TextView var8, TextView var9, TextView var10, TextView var11, TextView var12, TextView var13, TextView var14, TextView var15, MultiSlider var16, View var17, View var18, View var19, View var20, View var21, TextView var22, TextView var23, TextView var24, TextView var25, TextView var26, TextView var27) {
      this.rootView = var1;
      this.btnApply = var2;
      this.btnReset = var3;
      this.closeBtn = var4;
      this.contentContainer = var5;
      this.contentPresetDetail = var6;
      this.currentUpdateTemp = var7;
      this.fanPresetInfo = var8;
      this.fanSpeedTitle1 = var9;
      this.fanSpeedTitle2 = var10;
      this.fanSpeedTitle3 = var11;
      this.fanSpeedTitle4 = var12;
      this.fanSpeedTrigger = var13;
      this.maxTemp = var14;
      this.minTemp = var15;
      this.rangeSlider = var16;
      this.separator1 = var17;
      this.separator2 = var18;
      this.separator3 = var19;
      this.separator4 = var20;
      this.separator5 = var21;
      this.timerSelect1 = var22;
      this.timerSelect2 = var23;
      this.timerSelect3 = var24;
      this.timerSelect4 = var25;
      this.timerTriggerSelect = var26;
      this.title = var27;
   }

   public static DialogfragmentDeviceFanPresetBinding bind(View var0) {
      int var1 = R.id.btn_apply;
      MaterialButton var17 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var17 != null) {
         var1 = R.id.btn_reset;
         MaterialButton var16 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var16 != null) {
            var1 = R.id.close_btn;
            ImageButton var27 = (ImageButton)ViewBindings.findChildViewById(var0, var1);
            if (var27 != null) {
               var1 = R.id.content_container;
               ConstraintLayout var7 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
               if (var7 != null) {
                  var1 = R.id.content_preset_detail;
                  ConstraintLayout var26 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                  if (var26 != null) {
                     var1 = R.id.current_update_temp;
                     TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var9 != null) {
                        var1 = R.id.fan_preset_info;
                        TextView var15 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var15 != null) {
                           var1 = R.id.fan_speed_title_1;
                           TextView var18 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var18 != null) {
                              var1 = R.id.fan_speed_title_2;
                              TextView var25 = (TextView)ViewBindings.findChildViewById(var0, var1);
                              if (var25 != null) {
                                 var1 = R.id.fan_speed_title_3;
                                 TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var2 != null) {
                                    var1 = R.id.fan_speed_title_4;
                                    TextView var10 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                    if (var10 != null) {
                                       var1 = R.id.fan_speed_trigger;
                                       TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                       if (var4 != null) {
                                          var1 = R.id.max_temp;
                                          TextView var23 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                          if (var23 != null) {
                                             var1 = R.id.min_temp;
                                             TextView var20 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                             if (var20 != null) {
                                                var1 = R.id.range_slider;
                                                MultiSlider var22 = (MultiSlider)ViewBindings.findChildViewById(var0, var1);
                                                if (var22 != null) {
                                                   var1 = R.id.separator_1;
                                                   View var5 = ViewBindings.findChildViewById(var0, var1);
                                                   if (var5 != null) {
                                                      var1 = R.id.separator_2;
                                                      View var24 = ViewBindings.findChildViewById(var0, var1);
                                                      if (var24 != null) {
                                                         var1 = R.id.separator_3;
                                                         View var6 = ViewBindings.findChildViewById(var0, var1);
                                                         if (var6 != null) {
                                                            var1 = R.id.separator_4;
                                                            View var21 = ViewBindings.findChildViewById(var0, var1);
                                                            if (var21 != null) {
                                                               var1 = R.id.separator_5;
                                                               View var19 = ViewBindings.findChildViewById(var0, var1);
                                                               if (var19 != null) {
                                                                  var1 = R.id.timer_select_1;
                                                                  TextView var14 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                  if (var14 != null) {
                                                                     var1 = R.id.timer_select_2;
                                                                     TextView var12 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                     if (var12 != null) {
                                                                        var1 = R.id.timer_select_3;
                                                                        TextView var11 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                        if (var11 != null) {
                                                                           var1 = R.id.timer_select_4;
                                                                           TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                           if (var8 != null) {
                                                                              var1 = R.id.timer_trigger_select;
                                                                              TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                              if (var3 != null) {
                                                                                 var1 = R.id.title;
                                                                                 TextView var13 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                 if (var13 != null) {
                                                                                    return new DialogfragmentDeviceFanPresetBinding((FrameLayout)var0, var17, var16, var27, var7, var26, var9, var15, var18, var25, var2, var10, var4, var23, var20, var22, var5, var24, var6, var21, var19, var14, var12, var11, var8, var3, var13);
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

   public static DialogfragmentDeviceFanPresetBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogfragmentDeviceFanPresetBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialogfragment_device_fan_preset, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
