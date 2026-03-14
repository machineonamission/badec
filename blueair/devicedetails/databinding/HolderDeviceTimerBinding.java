package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.devicedetails.R;

public final class HolderDeviceTimerBinding implements ViewBinding {
   public final ConstraintLayout contentContainer;
   public final AppCompatImageView ivClose;
   public final ImageView ivSwitch;
   public final LottieAnimationView lavProgress;
   public final AppCompatImageView leadingIcon;
   private final ConstraintLayout rootView;
   public final TextView title;
   public final AppCompatTextView tvTimer;

   private HolderDeviceTimerBinding(ConstraintLayout var1, ConstraintLayout var2, AppCompatImageView var3, ImageView var4, LottieAnimationView var5, AppCompatImageView var6, TextView var7, AppCompatTextView var8) {
      this.rootView = var1;
      this.contentContainer = var2;
      this.ivClose = var3;
      this.ivSwitch = var4;
      this.lavProgress = var5;
      this.leadingIcon = var6;
      this.title = var7;
      this.tvTimer = var8;
   }

   public static HolderDeviceTimerBinding bind(View var0) {
      ConstraintLayout var2 = (ConstraintLayout)var0;
      int var1 = R.id.iv_close;
      AppCompatImageView var8 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
      if (var8 != null) {
         var1 = R.id.iv_switch;
         ImageView var5 = (ImageView)ViewBindings.findChildViewById(var0, var1);
         if (var5 != null) {
            var1 = R.id.lav_progress;
            LottieAnimationView var6 = (LottieAnimationView)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               var1 = R.id.leading_icon;
               AppCompatImageView var7 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
               if (var7 != null) {
                  var1 = R.id.title;
                  TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var4 != null) {
                     var1 = R.id.tv_timer;
                     AppCompatTextView var3 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                     if (var3 != null) {
                        return new HolderDeviceTimerBinding(var2, var2, var8, var5, var6, var7, var4, var3);
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceTimerBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceTimerBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_timer, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
