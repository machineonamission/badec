package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.github.mikephil.charting.charts.LineChart;

public final class DeviceGraphBinding implements ViewBinding {
   public final LineChart lineChart;
   public final ProgressBlockerView progressView;
   private final ConstraintLayout rootView;
   public final TextView scaleDayButton;
   public final TextView scaleMonthButton;
   public final TextView scaleWeekButton;

   private DeviceGraphBinding(ConstraintLayout var1, LineChart var2, ProgressBlockerView var3, TextView var4, TextView var5, TextView var6) {
      this.rootView = var1;
      this.lineChart = var2;
      this.progressView = var3;
      this.scaleDayButton = var4;
      this.scaleMonthButton = var5;
      this.scaleWeekButton = var6;
   }

   public static DeviceGraphBinding bind(View var0) {
      int var1 = R.id.lineChart;
      LineChart var4 = (LineChart)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.progressView;
         ProgressBlockerView var2 = (ProgressBlockerView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.scaleDayButton;
            TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               var1 = R.id.scaleMonthButton;
               TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var3 != null) {
                  var1 = R.id.scaleWeekButton;
                  TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var5 != null) {
                     return new DeviceGraphBinding((ConstraintLayout)var0, var4, var2, var6, var3, var5);
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static DeviceGraphBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DeviceGraphBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.device_graph, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
