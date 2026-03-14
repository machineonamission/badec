package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.antifake.R;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public final class ActivityResetBinding implements ViewBinding {
   public final AppCompatImageView btnBack;
   public final AppCompatImageView btnClose;
   public final FrameLayout containerFragment;
   public final ConstraintLayout headerBar;
   public final LinearProgressIndicator headerProgress;
   public final TextView headerTitle;
   public final LinearLayout main;
   private final LinearLayout rootView;
   public final TextView step1;
   public final TextView step2;
   public final TextView step3;
   public final TextView title;
   public final ConstraintLayout titleBar;

   private ActivityResetBinding(LinearLayout var1, AppCompatImageView var2, AppCompatImageView var3, FrameLayout var4, ConstraintLayout var5, LinearProgressIndicator var6, TextView var7, LinearLayout var8, TextView var9, TextView var10, TextView var11, TextView var12, ConstraintLayout var13) {
      this.rootView = var1;
      this.btnBack = var2;
      this.btnClose = var3;
      this.containerFragment = var4;
      this.headerBar = var5;
      this.headerProgress = var6;
      this.headerTitle = var7;
      this.main = var8;
      this.step1 = var9;
      this.step2 = var10;
      this.step3 = var11;
      this.title = var12;
      this.titleBar = var13;
   }

   public static ActivityResetBinding bind(View var0) {
      int var1 = R.id.btn_back;
      AppCompatImageView var9 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
      if (var9 != null) {
         var1 = R.id.btn_close;
         AppCompatImageView var4 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.container_fragment;
            FrameLayout var7 = (FrameLayout)ViewBindings.findChildViewById(var0, var1);
            if (var7 != null) {
               var1 = R.id.header_bar;
               ConstraintLayout var13 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
               if (var13 != null) {
                  var1 = R.id.header_progress;
                  LinearProgressIndicator var12 = (LinearProgressIndicator)ViewBindings.findChildViewById(var0, var1);
                  if (var12 != null) {
                     var1 = R.id.header_title;
                     TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var6 != null) {
                        LinearLayout var8 = (LinearLayout)var0;
                        var1 = R.id.step1;
                        TextView var11 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var11 != null) {
                           var1 = R.id.step2;
                           TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var3 != null) {
                              var1 = R.id.step3;
                              TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                              if (var5 != null) {
                                 var1 = R.id.title;
                                 TextView var10 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var10 != null) {
                                    var1 = R.id.title_bar;
                                    ConstraintLayout var2 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                    if (var2 != null) {
                                       return new ActivityResetBinding(var8, var9, var4, var7, var13, var12, var6, var8, var11, var3, var5, var10, var2);
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static ActivityResetBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ActivityResetBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.activity_reset, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
