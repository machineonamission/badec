package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceFanPresetBinding implements ViewBinding {
   public final View arrow;
   public final ConstraintLayout contentFanPreset;
   private final FrameLayout rootView;
   public final TextView title;

   private HolderDeviceFanPresetBinding(FrameLayout var1, View var2, ConstraintLayout var3, TextView var4) {
      this.rootView = var1;
      this.arrow = var2;
      this.contentFanPreset = var3;
      this.title = var4;
   }

   public static HolderDeviceFanPresetBinding bind(View var0) {
      int var1 = R.id.arrow;
      View var3 = ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.content_fan_preset;
         ConstraintLayout var2 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.title;
            TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               return new HolderDeviceFanPresetBinding((FrameLayout)var0, var3, var2, var4);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceFanPresetBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceFanPresetBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_fan_preset, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
