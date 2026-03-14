package com.blueair.graph.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.graph.R;
import com.google.android.material.button.MaterialButton;

public final class RangeSelectBinding implements ViewBinding {
   public final Guideline guideTimeEnd;
   public final MaterialButton rangeClose;
   public final MaterialButton rangeDay;
   public final MaterialButton rangeMonth;
   public final ConstraintLayout rangeSelectLayout;
   public final MaterialButton rangeWeek;
   private final ConstraintLayout rootView;
   public final MaterialButton timeButton;

   private RangeSelectBinding(ConstraintLayout var1, Guideline var2, MaterialButton var3, MaterialButton var4, MaterialButton var5, ConstraintLayout var6, MaterialButton var7, MaterialButton var8) {
      this.rootView = var1;
      this.guideTimeEnd = var2;
      this.rangeClose = var3;
      this.rangeDay = var4;
      this.rangeMonth = var5;
      this.rangeSelectLayout = var6;
      this.rangeWeek = var7;
      this.timeButton = var8;
   }

   public static RangeSelectBinding bind(View var0) {
      int var1 = R.id.guide_time_end;
      Guideline var2 = (Guideline)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.range_close;
         MaterialButton var5 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var5 != null) {
            var1 = R.id.range_day;
            MaterialButton var3 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               var1 = R.id.range_month;
               MaterialButton var8 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
               if (var8 != null) {
                  var1 = R.id.range_select_layout;
                  ConstraintLayout var6 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                  if (var6 != null) {
                     var1 = R.id.range_week;
                     MaterialButton var4 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
                     if (var4 != null) {
                        var1 = R.id.time_button;
                        MaterialButton var7 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
                        if (var7 != null) {
                           return new RangeSelectBinding((ConstraintLayout)var0, var2, var5, var3, var8, var6, var4, var7);
                        }
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static RangeSelectBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static RangeSelectBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.range_select, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
