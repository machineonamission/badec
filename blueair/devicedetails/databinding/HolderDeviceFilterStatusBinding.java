package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public final class HolderDeviceFilterStatusBinding implements ViewBinding {
   public final TextView attributeTitle;
   public final Barrier barrierDescript;
   public final Barrier barrierLifetime;
   public final MaterialButton buyNew;
   public final TextView filterChangeView;
   public final MaterialButton filterReplacement;
   public final TextView filterTimeLeftView;
   public final TextView filterTimePercentView;
   public final ConstraintLayout holderDeviceFilterStatus;
   public final MaterialButton howToReplace;
   public final Guideline leftGuideline;
   public final LinearProgressIndicator progress;
   public final Guideline rightGuideline;
   private final ConstraintLayout rootView;

   private HolderDeviceFilterStatusBinding(ConstraintLayout var1, TextView var2, Barrier var3, Barrier var4, MaterialButton var5, TextView var6, MaterialButton var7, TextView var8, TextView var9, ConstraintLayout var10, MaterialButton var11, Guideline var12, LinearProgressIndicator var13, Guideline var14) {
      this.rootView = var1;
      this.attributeTitle = var2;
      this.barrierDescript = var3;
      this.barrierLifetime = var4;
      this.buyNew = var5;
      this.filterChangeView = var6;
      this.filterReplacement = var7;
      this.filterTimeLeftView = var8;
      this.filterTimePercentView = var9;
      this.holderDeviceFilterStatus = var10;
      this.howToReplace = var11;
      this.leftGuideline = var12;
      this.progress = var13;
      this.rightGuideline = var14;
   }

   public static HolderDeviceFilterStatusBinding bind(View var0) {
      int var1 = R.id.attribute_title;
      TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.barrier_descript;
         Barrier var10 = (Barrier)ViewBindings.findChildViewById(var0, var1);
         if (var10 != null) {
            var1 = R.id.barrier_lifetime;
            Barrier var7 = (Barrier)ViewBindings.findChildViewById(var0, var1);
            if (var7 != null) {
               var1 = R.id.buy_new;
               MaterialButton var4 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
               if (var4 != null) {
                  var1 = R.id.filter_change_view;
                  TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var3 != null) {
                     var1 = R.id.filter_replacement;
                     MaterialButton var14 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
                     if (var14 != null) {
                        var1 = R.id.filter_time_left_view;
                        TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var5 != null) {
                           var1 = R.id.filter_time_percent_view;
                           TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var9 != null) {
                              ConstraintLayout var11 = (ConstraintLayout)var0;
                              var1 = R.id.how_to_replace;
                              MaterialButton var13 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
                              if (var13 != null) {
                                 var1 = R.id.left_guideline;
                                 Guideline var8 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                 if (var8 != null) {
                                    var1 = R.id.progress;
                                    LinearProgressIndicator var6 = (LinearProgressIndicator)ViewBindings.findChildViewById(var0, var1);
                                    if (var6 != null) {
                                       var1 = R.id.right_guideline;
                                       Guideline var12 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                       if (var12 != null) {
                                          return new HolderDeviceFilterStatusBinding(var11, var2, var10, var7, var4, var3, var14, var5, var9, var11, var13, var8, var6, var12);
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

   public static HolderDeviceFilterStatusBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceFilterStatusBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_filter_status, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
