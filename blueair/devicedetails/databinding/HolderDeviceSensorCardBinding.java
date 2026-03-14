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

public final class HolderDeviceSensorCardBinding implements ViewBinding {
   public final ImageView aqiIcon;
   public final TextView aqiValue;
   public final ConstraintLayout cardContainer;
   private final ShadowLayout rootView;
   public final ImageView sensorIcon;
   public final TextView sensorLabel;

   private HolderDeviceSensorCardBinding(ShadowLayout var1, ImageView var2, TextView var3, ConstraintLayout var4, ImageView var5, TextView var6) {
      this.rootView = var1;
      this.aqiIcon = var2;
      this.aqiValue = var3;
      this.cardContainer = var4;
      this.sensorIcon = var5;
      this.sensorLabel = var6;
   }

   public static HolderDeviceSensorCardBinding bind(View var0) {
      int var1 = R.id.aqi_icon;
      ImageView var5 = (ImageView)ViewBindings.findChildViewById(var0, var1);
      if (var5 != null) {
         var1 = R.id.aqi_value;
         TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var6 != null) {
            var1 = R.id.card_container;
            ConstraintLayout var3 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               var1 = R.id.sensor_icon;
               ImageView var2 = (ImageView)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  var1 = R.id.sensor_label;
                  TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var4 != null) {
                     return new HolderDeviceSensorCardBinding((ShadowLayout)var0, var5, var6, var3, var2, var4);
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceSensorCardBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceSensorCardBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_sensor_card, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ShadowLayout getRoot() {
      return this.rootView;
   }
}
