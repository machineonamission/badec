package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;

public final class SwipeRightLayoutBinding implements ViewBinding {
   private final ConstraintLayout rootView;
   public final AppCompatImageView standbyImageview;
   public final LinearLayout standbyModeRoot;
   public final TextView standbyTitleview;

   private SwipeRightLayoutBinding(ConstraintLayout var1, AppCompatImageView var2, LinearLayout var3, TextView var4) {
      this.rootView = var1;
      this.standbyImageview = var2;
      this.standbyModeRoot = var3;
      this.standbyTitleview = var4;
   }

   public static SwipeRightLayoutBinding bind(View var0) {
      int var1 = R.id.standby_imageview;
      AppCompatImageView var2 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.standby_mode_root;
         LinearLayout var3 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            var1 = R.id.standby_titleview;
            TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               return new SwipeRightLayoutBinding((ConstraintLayout)var0, var2, var3, var4);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static SwipeRightLayoutBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static SwipeRightLayoutBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.swipe_right_layout, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
