package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;

public final class DrawerHeaderBinding implements ViewBinding {
   public final AppCompatImageView blueairIcon;
   public final AppCompatImageView blueairIconDot;
   public final AppCompatImageView drawerCloseView;
   public final Guideline leftGuideline;
   public final Guideline middleGuideline;
   private final ConstraintLayout rootView;

   private DrawerHeaderBinding(ConstraintLayout var1, AppCompatImageView var2, AppCompatImageView var3, AppCompatImageView var4, Guideline var5, Guideline var6) {
      this.rootView = var1;
      this.blueairIcon = var2;
      this.blueairIconDot = var3;
      this.drawerCloseView = var4;
      this.leftGuideline = var5;
      this.middleGuideline = var6;
   }

   public static DrawerHeaderBinding bind(View var0) {
      int var1 = R.id.blueair_icon;
      AppCompatImageView var2 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.blueair_icon_dot;
         AppCompatImageView var4 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.drawer_close_view;
            AppCompatImageView var5 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.left_guideline;
               Guideline var3 = (Guideline)ViewBindings.findChildViewById(var0, var1);
               if (var3 != null) {
                  var1 = R.id.middle_guideline;
                  Guideline var6 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                  if (var6 != null) {
                     return new DrawerHeaderBinding((ConstraintLayout)var0, var2, var4, var5, var3, var6);
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static DrawerHeaderBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DrawerHeaderBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.drawer_header, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
