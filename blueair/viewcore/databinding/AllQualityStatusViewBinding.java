package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.QualityStatusView;

public final class AllQualityStatusViewBinding implements ViewBinding {
   private final ConstraintLayout rootView;
   public final QualityStatusView sensorCoLayout;
   public final QualityStatusView sensorPm10Layout;
   public final QualityStatusView sensorPm25Layout;
   public final QualityStatusView sensorSo2OrElseLayout;
   public final ConstraintLayout sensorView;

   private AllQualityStatusViewBinding(ConstraintLayout var1, QualityStatusView var2, QualityStatusView var3, QualityStatusView var4, QualityStatusView var5, ConstraintLayout var6) {
      this.rootView = var1;
      this.sensorCoLayout = var2;
      this.sensorPm10Layout = var3;
      this.sensorPm25Layout = var4;
      this.sensorSo2OrElseLayout = var5;
      this.sensorView = var6;
   }

   public static AllQualityStatusViewBinding bind(View var0) {
      int var1 = R.id.sensor_co_layout;
      QualityStatusView var3 = (QualityStatusView)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.sensor_pm10_layout;
         QualityStatusView var2 = (QualityStatusView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.sensor_pm25_layout;
            QualityStatusView var4 = (QualityStatusView)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               var1 = R.id.sensor_so2_or_else_layout;
               QualityStatusView var5 = (QualityStatusView)ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  ConstraintLayout var6 = (ConstraintLayout)var0;
                  return new AllQualityStatusViewBinding(var6, var3, var2, var4, var5, var6);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static AllQualityStatusViewBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static AllQualityStatusViewBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.all_quality_status_view, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
