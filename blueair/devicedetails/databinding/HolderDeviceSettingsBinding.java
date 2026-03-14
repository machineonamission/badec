package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceSettingsBinding implements ViewBinding {
   public final ImageView actionIcon;
   public final ConstraintLayout contentContainer;
   public final ImageView leadingIcon;
   private final ConstraintLayout rootView;
   public final TextView title;

   private HolderDeviceSettingsBinding(ConstraintLayout var1, ImageView var2, ConstraintLayout var3, ImageView var4, TextView var5) {
      this.rootView = var1;
      this.actionIcon = var2;
      this.contentContainer = var3;
      this.leadingIcon = var4;
      this.title = var5;
   }

   public static HolderDeviceSettingsBinding bind(View var0) {
      int var1 = R.id.action_icon;
      ImageView var5 = (ImageView)ViewBindings.findChildViewById(var0, var1);
      if (var5 != null) {
         ConstraintLayout var2 = (ConstraintLayout)var0;
         var1 = R.id.leading_icon;
         ImageView var4 = (ImageView)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.title;
            TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               return new HolderDeviceSettingsBinding(var2, var5, var2, var4, var3);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceSettingsBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceSettingsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_settings, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
