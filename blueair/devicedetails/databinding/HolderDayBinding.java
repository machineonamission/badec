package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDayBinding implements ViewBinding {
   public final Guideline bottomGuideline;
   public final TextView day;
   private final ConstraintLayout rootView;
   public final ImageView tick;
   public final Guideline topGuideline;

   private HolderDayBinding(ConstraintLayout var1, Guideline var2, TextView var3, ImageView var4, Guideline var5) {
      this.rootView = var1;
      this.bottomGuideline = var2;
      this.day = var3;
      this.tick = var4;
      this.topGuideline = var5;
   }

   public static HolderDayBinding bind(View var0) {
      int var1 = R.id.bottom_guideline;
      Guideline var3 = (Guideline)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.day;
         TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.tick;
            ImageView var2 = (ImageView)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               var1 = R.id.top_guideline;
               Guideline var5 = (Guideline)ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  return new HolderDayBinding((ConstraintLayout)var0, var3, var4, var2, var5);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDayBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDayBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_day, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
