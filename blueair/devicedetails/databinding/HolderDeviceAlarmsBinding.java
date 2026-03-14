package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.dd.ShadowLayout;

public final class HolderDeviceAlarmsBinding implements ViewBinding {
   public final ConstraintLayout contentContainer;
   public final ImageView ivAlarm;
   private final ShadowLayout rootView;
   public final ShadowLayout slContainer;
   public final TextView tvAlarmLabel;
   public final TextView tvAlarmValue;

   private HolderDeviceAlarmsBinding(ShadowLayout var1, ConstraintLayout var2, ImageView var3, ShadowLayout var4, TextView var5, TextView var6) {
      this.rootView = var1;
      this.contentContainer = var2;
      this.ivAlarm = var3;
      this.slContainer = var4;
      this.tvAlarmLabel = var5;
      this.tvAlarmValue = var6;
   }

   public static HolderDeviceAlarmsBinding bind(View var0) {
      int var1 = R.id.content_container;
      ConstraintLayout var2 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.iv_alarm;
         ImageView var3 = (ImageView)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            ShadowLayout var4 = (ShadowLayout)var0;
            var1 = R.id.tv_alarmLabel;
            TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               var1 = R.id.tv_alarmValue;
               TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  return new HolderDeviceAlarmsBinding(var4, var2, var3, var4, var6, var5);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceAlarmsBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceAlarmsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_alarms, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ShadowLayout getRoot() {
      return this.rootView;
   }
}
