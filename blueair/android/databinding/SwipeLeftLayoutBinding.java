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

public final class SwipeLeftLayoutBinding implements ViewBinding {
   public final AppCompatImageView automodeImageview;
   public final LinearLayout automodeRoot;
   public final TextView automodeTitleview;
   public final AppCompatImageView nightmodeImageview;
   public final LinearLayout nightmodeRoot;
   public final TextView nightmodeTitleview;
   private final ConstraintLayout rootView;

   private SwipeLeftLayoutBinding(ConstraintLayout var1, AppCompatImageView var2, LinearLayout var3, TextView var4, AppCompatImageView var5, LinearLayout var6, TextView var7) {
      this.rootView = var1;
      this.automodeImageview = var2;
      this.automodeRoot = var3;
      this.automodeTitleview = var4;
      this.nightmodeImageview = var5;
      this.nightmodeRoot = var6;
      this.nightmodeTitleview = var7;
   }

   public static SwipeLeftLayoutBinding bind(View var0) {
      int var1 = R.id.automode_imageview;
      AppCompatImageView var3 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.automode_root;
         LinearLayout var4 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.automode_titleview;
            TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               var1 = R.id.nightmode_imageview;
               AppCompatImageView var2 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  var1 = R.id.nightmode_root;
                  LinearLayout var5 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                  if (var5 != null) {
                     var1 = R.id.nightmode_titleview;
                     TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var7 != null) {
                        return new SwipeLeftLayoutBinding((ConstraintLayout)var0, var3, var4, var6, var2, var5, var7);
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static SwipeLeftLayoutBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static SwipeLeftLayoutBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.swipe_left_layout, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
