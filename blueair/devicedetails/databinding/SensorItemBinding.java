package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class SensorItemBinding implements ViewBinding {
   private final LinearLayout rootView;
   public final TextView sensorAltVal;
   public final ImageView sensorColor;
   public final TextView sensorLabel;
   public final LinearLayout sensorLayout;
   public final TextView sensorVal;

   private SensorItemBinding(LinearLayout var1, TextView var2, ImageView var3, TextView var4, LinearLayout var5, TextView var6) {
      this.rootView = var1;
      this.sensorAltVal = var2;
      this.sensorColor = var3;
      this.sensorLabel = var4;
      this.sensorLayout = var5;
      this.sensorVal = var6;
   }

   public static SensorItemBinding bind(View var0) {
      int var1 = R.id.sensor_alt_val;
      TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.sensor_color;
         ImageView var4 = (ImageView)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.sensor_label;
            TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               LinearLayout var5 = (LinearLayout)var0;
               var1 = R.id.sensor_val;
               TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var6 != null) {
                  return new SensorItemBinding(var5, var2, var4, var3, var5, var6);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static SensorItemBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static SensorItemBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.sensor_item, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
