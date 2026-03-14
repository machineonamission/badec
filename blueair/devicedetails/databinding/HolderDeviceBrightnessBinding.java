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
import com.blueair.viewcore.view.AccessibleSeekBar;

public final class HolderDeviceBrightnessBinding implements ViewBinding {
   public final AccessibleSeekBar brightnessSeekbar;
   public final Guideline leftGuideline;
   public final Guideline rightGuideline;
   private final ConstraintLayout rootView;
   public final View separator;
   public final TextView settingTitle;
   public final TextView settingValue;

   private HolderDeviceBrightnessBinding(ConstraintLayout var1, AccessibleSeekBar var2, Guideline var3, Guideline var4, View var5, TextView var6, TextView var7) {
      this.rootView = var1;
      this.brightnessSeekbar = var2;
      this.leftGuideline = var3;
      this.rightGuideline = var4;
      this.separator = var5;
      this.settingTitle = var6;
      this.settingValue = var7;
   }

   public static HolderDeviceBrightnessBinding bind(View var0) {
      int var1 = R.id.brightness_seekbar;
      AccessibleSeekBar var5 = (AccessibleSeekBar)ViewBindings.findChildViewById(var0, var1);
      if (var5 != null) {
         var1 = R.id.left_guideline;
         Guideline var4 = (Guideline)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.right_guideline;
            Guideline var7 = (Guideline)ViewBindings.findChildViewById(var0, var1);
            if (var7 != null) {
               var1 = R.id.separator;
               View var3 = ViewBindings.findChildViewById(var0, var1);
               if (var3 != null) {
                  var1 = R.id.setting_title;
                  TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var2 != null) {
                     var1 = R.id.setting_value;
                     TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var6 != null) {
                        return new HolderDeviceBrightnessBinding((ConstraintLayout)var0, var5, var4, var7, var3, var2, var6);
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceBrightnessBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceBrightnessBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_brightness, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
