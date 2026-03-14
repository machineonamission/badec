package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceNScheduleBinding implements ViewBinding {
   public final View arrow;
   public final AppCompatImageView iconMainMode;
   public final AppCompatImageView iconMode;
   public final TextView mainMode;
   public final TextView mode;
   public final TextView nameAndRepeat;
   private final ConstraintLayout rootView;
   public final TextView scheduleSwitch;
   public final TextView timeRange;

   private HolderDeviceNScheduleBinding(ConstraintLayout var1, View var2, AppCompatImageView var3, AppCompatImageView var4, TextView var5, TextView var6, TextView var7, TextView var8, TextView var9) {
      this.rootView = var1;
      this.arrow = var2;
      this.iconMainMode = var3;
      this.iconMode = var4;
      this.mainMode = var5;
      this.mode = var6;
      this.nameAndRepeat = var7;
      this.scheduleSwitch = var8;
      this.timeRange = var9;
   }

   public static HolderDeviceNScheduleBinding bind(View var0) {
      int var1 = R.id.arrow;
      View var5 = ViewBindings.findChildViewById(var0, var1);
      if (var5 != null) {
         var1 = R.id.icon_main_mode;
         AppCompatImageView var9 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
         if (var9 != null) {
            var1 = R.id.icon_mode;
            AppCompatImageView var2 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               var1 = R.id.main_mode;
               TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var4 != null) {
                  var1 = R.id.mode;
                  TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var3 != null) {
                     var1 = R.id.name_and_repeat;
                     TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var6 != null) {
                        var1 = R.id.schedule_switch;
                        TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var8 != null) {
                           var1 = R.id.time_range;
                           TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var7 != null) {
                              return new HolderDeviceNScheduleBinding((ConstraintLayout)var0, var5, var9, var2, var4, var3, var6, var8, var7);
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

   public static HolderDeviceNScheduleBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceNScheduleBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_n_schedule, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
