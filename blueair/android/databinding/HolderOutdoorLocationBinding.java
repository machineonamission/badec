package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.android.R;

public final class HolderOutdoorLocationBinding implements ViewBinding {
   public final View airQualityIndicator;
   public final Group groupInfo;
   public final LottieAnimationView progressView;
   private final ConstraintLayout rootView;
   public final TextView tvAirQuality;
   public final AppCompatTextView tvEnableLocation;
   public final AppCompatTextView tvLocation;

   private HolderOutdoorLocationBinding(ConstraintLayout var1, View var2, Group var3, LottieAnimationView var4, TextView var5, AppCompatTextView var6, AppCompatTextView var7) {
      this.rootView = var1;
      this.airQualityIndicator = var2;
      this.groupInfo = var3;
      this.progressView = var4;
      this.tvAirQuality = var5;
      this.tvEnableLocation = var6;
      this.tvLocation = var7;
   }

   public static HolderOutdoorLocationBinding bind(View var0) {
      int var1 = R.id.air_quality_indicator;
      View var2 = ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.group_info;
         Group var5 = (Group)ViewBindings.findChildViewById(var0, var1);
         if (var5 != null) {
            var1 = R.id.progress_view;
            LottieAnimationView var6 = (LottieAnimationView)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               var1 = R.id.tv_air_quality;
               TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var3 != null) {
                  var1 = R.id.tv_enable_location;
                  AppCompatTextView var4 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                  if (var4 != null) {
                     var1 = R.id.tv_location;
                     AppCompatTextView var7 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                     if (var7 != null) {
                        return new HolderOutdoorLocationBinding((ConstraintLayout)var0, var2, var5, var6, var3, var4, var7);
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderOutdoorLocationBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderOutdoorLocationBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_outdoor_location, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
