package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.camera.view.PreviewView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.antifake.R;

public final class ActivityScanBinding implements ViewBinding {
   public final AppCompatImageView btnBack;
   public final AppCompatImageView btnInfo;
   public final ConstraintLayout containerScanner;
   public final ConstraintLayout main;
   public final PreviewView previewView;
   public final LottieAnimationView progressView;
   private final ConstraintLayout rootView;
   public final TextView scanTip;
   public final TextView titleScan;

   private ActivityScanBinding(ConstraintLayout var1, AppCompatImageView var2, AppCompatImageView var3, ConstraintLayout var4, ConstraintLayout var5, PreviewView var6, LottieAnimationView var7, TextView var8, TextView var9) {
      this.rootView = var1;
      this.btnBack = var2;
      this.btnInfo = var3;
      this.containerScanner = var4;
      this.main = var5;
      this.previewView = var6;
      this.progressView = var7;
      this.scanTip = var8;
      this.titleScan = var9;
   }

   public static ActivityScanBinding bind(View var0) {
      int var1 = R.id.btn_back;
      AppCompatImageView var7 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
      if (var7 != null) {
         var1 = R.id.btn_info;
         AppCompatImageView var5 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
         if (var5 != null) {
            var1 = R.id.container_scanner;
            ConstraintLayout var2 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               ConstraintLayout var3 = (ConstraintLayout)var0;
               var1 = R.id.previewView;
               PreviewView var6 = (PreviewView)ViewBindings.findChildViewById(var0, var1);
               if (var6 != null) {
                  var1 = R.id.progress_view;
                  LottieAnimationView var8 = (LottieAnimationView)ViewBindings.findChildViewById(var0, var1);
                  if (var8 != null) {
                     var1 = R.id.scan_tip;
                     TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var4 != null) {
                        var1 = R.id.title_scan;
                        TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var9 != null) {
                           return new ActivityScanBinding(var3, var7, var5, var2, var3, var6, var8, var4, var9);
                        }
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static ActivityScanBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ActivityScanBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.activity_scan, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
