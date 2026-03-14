package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderScheduleTitleHeaderBinding implements ViewBinding {
   public final Guideline bottomGuideline;
   private final ConstraintLayout rootView;
   public final TextView title;
   public final Guideline topGuideline;

   private HolderScheduleTitleHeaderBinding(ConstraintLayout var1, Guideline var2, TextView var3, Guideline var4) {
      this.rootView = var1;
      this.bottomGuideline = var2;
      this.title = var3;
      this.topGuideline = var4;
   }

   public static HolderScheduleTitleHeaderBinding bind(View var0) {
      int var1 = R.id.bottom_guideline;
      Guideline var4 = (Guideline)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.title;
         TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            var1 = R.id.top_guideline;
            Guideline var2 = (Guideline)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               return new HolderScheduleTitleHeaderBinding((ConstraintLayout)var0, var4, var3, var2);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderScheduleTitleHeaderBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderScheduleTitleHeaderBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_schedule_title_header, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
