package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.GradientProgressBar;
import com.dd.ShadowLayout;

public final class HolderDeviceNightSleepBinding implements ViewBinding {
   public final ConstraintLayout contentContainer;
   public final HolderDeviceHintBinding hintSleep;
   public final ImageView ivInfo;
   public final Layer layerSleep;
   public final ImageView leadingIcon;
   public final GradientProgressBar progressIndicator;
   private final ShadowLayout rootView;
   public final ShadowLayout slContainer;
   public final TextView title;
   public final AppCompatTextView tvDuration;
   public final AppCompatTextView tvLeft;
   public final TextView tvSleepLabel;

   private HolderDeviceNightSleepBinding(ShadowLayout var1, ConstraintLayout var2, HolderDeviceHintBinding var3, ImageView var4, Layer var5, ImageView var6, GradientProgressBar var7, ShadowLayout var8, TextView var9, AppCompatTextView var10, AppCompatTextView var11, TextView var12) {
      this.rootView = var1;
      this.contentContainer = var2;
      this.hintSleep = var3;
      this.ivInfo = var4;
      this.layerSleep = var5;
      this.leadingIcon = var6;
      this.progressIndicator = var7;
      this.slContainer = var8;
      this.title = var9;
      this.tvDuration = var10;
      this.tvLeft = var11;
      this.tvSleepLabel = var12;
   }

   public static HolderDeviceNightSleepBinding bind(View var0) {
      int var1 = R.id.content_container;
      ConstraintLayout var2 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.hint_sleep;
         View var3 = ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            HolderDeviceHintBinding var11 = HolderDeviceHintBinding.bind(var3);
            var1 = R.id.iv_info;
            ImageView var10 = (ImageView)ViewBindings.findChildViewById(var0, var1);
            if (var10 != null) {
               var1 = R.id.layer_sleep;
               Layer var5 = (Layer)ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  var1 = R.id.leading_icon;
                  ImageView var13 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                  if (var13 != null) {
                     var1 = R.id.progress_indicator;
                     GradientProgressBar var6 = (GradientProgressBar)ViewBindings.findChildViewById(var0, var1);
                     if (var6 != null) {
                        ShadowLayout var7 = (ShadowLayout)var0;
                        var1 = R.id.title;
                        TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var8 != null) {
                           var1 = R.id.tv_duration;
                           AppCompatTextView var9 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                           if (var9 != null) {
                              var1 = R.id.tv_left;
                              AppCompatTextView var4 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                              if (var4 != null) {
                                 var1 = R.id.tv_sleepLabel;
                                 TextView var12 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var12 != null) {
                                    return new HolderDeviceNightSleepBinding(var7, var2, var11, var10, var5, var13, var6, var7, var8, var9, var4, var12);
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

   public static HolderDeviceNightSleepBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceNightSleepBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_night_sleep, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ShadowLayout getRoot() {
      return this.rootView;
   }
}
