package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceScheduleBinding implements ViewBinding {
   public final Guideline bottomGuideline;
   public final Guideline endGuideline;
   public final TextView mode;
   public final TextView nameAndRepeat;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final Guideline startGuideline;
   public final LinearLayout timeContainer;
   public final TextView timeRange;
   public final Guideline topGuideline;

   private HolderDeviceScheduleBinding(ConstraintLayout var1, Guideline var2, Guideline var3, TextView var4, TextView var5, ConstraintLayout var6, Guideline var7, LinearLayout var8, TextView var9, Guideline var10) {
      this.rootView = var1;
      this.bottomGuideline = var2;
      this.endGuideline = var3;
      this.mode = var4;
      this.nameAndRepeat = var5;
      this.rootLayout = var6;
      this.startGuideline = var7;
      this.timeContainer = var8;
      this.timeRange = var9;
      this.topGuideline = var10;
   }

   public static HolderDeviceScheduleBinding bind(View var0) {
      int var1 = R.id.bottom_guideline;
      Guideline var8 = (Guideline)ViewBindings.findChildViewById(var0, var1);
      if (var8 != null) {
         var1 = R.id.end_guideline;
         Guideline var2 = (Guideline)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.mode;
            TextView var10 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var10 != null) {
               var1 = R.id.name_and_repeat;
               TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var9 != null) {
                  ConstraintLayout var5 = (ConstraintLayout)var0;
                  var1 = R.id.start_guideline;
                  Guideline var4 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                  if (var4 != null) {
                     var1 = R.id.time_container;
                     LinearLayout var6 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                     if (var6 != null) {
                        var1 = R.id.time_range;
                        TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var3 != null) {
                           var1 = R.id.top_guideline;
                           Guideline var7 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                           if (var7 != null) {
                              return new HolderDeviceScheduleBinding(var5, var8, var2, var10, var9, var5, var4, var6, var3, var7);
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

   public static HolderDeviceScheduleBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceScheduleBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_schedule, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
