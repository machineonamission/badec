package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import com.blueair.viewcore.view.SwitchCompat;

public final class HolderDeviceFanspeedV2Binding implements ViewBinding {
   public final ConstraintLayout clIndicator;
   public final View clickView;
   public final ConstraintLayout contentContainer;
   public final LinearLayout etaContainer;
   public final ImageView etaIcon;
   public final TextView etaText;
   public final TextView etaValue;
   public final SwitchCompat expendSwitch;
   public final Group expendedContent;
   public final ImageView leadingIcon;
   public final TextView progressText;
   private final ConstraintLayout rootView;
   public final AccessibleSeekBar seekbar;
   public final View separator0;
   public final View separator1;
   public final View separator2;
   public final View separator3;
   public final View separator4;
   public final View separator5;
   public final View separator6;
   public final TextView title;
   public final TextView tvProgress0;
   public final TextView tvProgress1;
   public final TextView tvProgress2;
   public final TextView tvProgress3;
   public final TextView tvProgress4;
   public final TextView tvProgress5;
   public final TextView tvProgress6;

   private HolderDeviceFanspeedV2Binding(ConstraintLayout var1, ConstraintLayout var2, View var3, ConstraintLayout var4, LinearLayout var5, ImageView var6, TextView var7, TextView var8, SwitchCompat var9, Group var10, ImageView var11, TextView var12, AccessibleSeekBar var13, View var14, View var15, View var16, View var17, View var18, View var19, View var20, TextView var21, TextView var22, TextView var23, TextView var24, TextView var25, TextView var26, TextView var27, TextView var28) {
      this.rootView = var1;
      this.clIndicator = var2;
      this.clickView = var3;
      this.contentContainer = var4;
      this.etaContainer = var5;
      this.etaIcon = var6;
      this.etaText = var7;
      this.etaValue = var8;
      this.expendSwitch = var9;
      this.expendedContent = var10;
      this.leadingIcon = var11;
      this.progressText = var12;
      this.seekbar = var13;
      this.separator0 = var14;
      this.separator1 = var15;
      this.separator2 = var16;
      this.separator3 = var17;
      this.separator4 = var18;
      this.separator5 = var19;
      this.separator6 = var20;
      this.title = var21;
      this.tvProgress0 = var22;
      this.tvProgress1 = var23;
      this.tvProgress2 = var24;
      this.tvProgress3 = var25;
      this.tvProgress4 = var26;
      this.tvProgress5 = var27;
      this.tvProgress6 = var28;
   }

   public static HolderDeviceFanspeedV2Binding bind(View var0) {
      int var1 = R.id.cl_indicator;
      ConstraintLayout var4 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.click_view;
         View var25 = ViewBindings.findChildViewById(var0, var1);
         if (var25 != null) {
            ConstraintLayout var17 = (ConstraintLayout)var0;
            var1 = R.id.eta_container;
            LinearLayout var16 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
            if (var16 != null) {
               var1 = R.id.eta_icon;
               ImageView var26 = (ImageView)ViewBindings.findChildViewById(var0, var1);
               if (var26 != null) {
                  var1 = R.id.eta_text;
                  TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var2 != null) {
                     var1 = R.id.eta_value;
                     TextView var20 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var20 != null) {
                        var1 = R.id.expend_switch;
                        SwitchCompat var11 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
                        if (var11 != null) {
                           var1 = R.id.expended_content;
                           Group var6 = (Group)ViewBindings.findChildViewById(var0, var1);
                           if (var6 != null) {
                              var1 = R.id.leading_icon;
                              ImageView var28 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                              if (var28 != null) {
                                 var1 = R.id.progress_text;
                                 TextView var23 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var23 != null) {
                                    var1 = R.id.seekbar;
                                    AccessibleSeekBar var5 = (AccessibleSeekBar)ViewBindings.findChildViewById(var0, var1);
                                    if (var5 != null) {
                                       var1 = R.id.separator_0;
                                       View var3 = ViewBindings.findChildViewById(var0, var1);
                                       if (var3 != null) {
                                          var1 = R.id.separator_1;
                                          View var24 = ViewBindings.findChildViewById(var0, var1);
                                          if (var24 != null) {
                                             var1 = R.id.separator_2;
                                             View var12 = ViewBindings.findChildViewById(var0, var1);
                                             if (var12 != null) {
                                                var1 = R.id.separator_3;
                                                View var10 = ViewBindings.findChildViewById(var0, var1);
                                                if (var10 != null) {
                                                   var1 = R.id.separator_4;
                                                   View var19 = ViewBindings.findChildViewById(var0, var1);
                                                   if (var19 != null) {
                                                      var1 = R.id.separator_5;
                                                      View var14 = ViewBindings.findChildViewById(var0, var1);
                                                      if (var14 != null) {
                                                         var1 = R.id.separator_6;
                                                         View var18 = ViewBindings.findChildViewById(var0, var1);
                                                         if (var18 != null) {
                                                            var1 = R.id.title;
                                                            TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                            if (var8 != null) {
                                                               var1 = R.id.tv_progress_0;
                                                               TextView var15 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                               if (var15 != null) {
                                                                  var1 = R.id.tv_progress_1;
                                                                  TextView var22 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                  if (var22 != null) {
                                                                     var1 = R.id.tv_progress_2;
                                                                     TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                     if (var9 != null) {
                                                                        var1 = R.id.tv_progress_3;
                                                                        TextView var13 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                        if (var13 != null) {
                                                                           var1 = R.id.tv_progress_4;
                                                                           TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                           if (var7 != null) {
                                                                              var1 = R.id.tv_progress_5;
                                                                              TextView var21 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                              if (var21 != null) {
                                                                                 var1 = R.id.tv_progress_6;
                                                                                 TextView var27 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                 if (var27 != null) {
                                                                                    return new HolderDeviceFanspeedV2Binding(var17, var4, var25, var17, var16, var26, var2, var20, var11, var6, var28, var23, var5, var3, var24, var12, var10, var19, var14, var18, var8, var15, var22, var9, var13, var7, var21, var27);
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

   public static HolderDeviceFanspeedV2Binding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceFanspeedV2Binding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_fanspeed_v2, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
