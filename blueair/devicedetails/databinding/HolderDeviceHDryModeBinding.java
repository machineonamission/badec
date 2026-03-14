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

public final class HolderDeviceHDryModeBinding implements ViewBinding {
   public final TextView cancelDryMode;
   public final ConstraintLayout contentDryMode;
   public final TextView countdownNumber;
   public final ImageView dryModeIcon;
   public final TextView dryModeTitle;
   private final ConstraintLayout rootView;

   private HolderDeviceHDryModeBinding(ConstraintLayout var1, TextView var2, ConstraintLayout var3, TextView var4, ImageView var5, TextView var6) {
      this.rootView = var1;
      this.cancelDryMode = var2;
      this.contentDryMode = var3;
      this.countdownNumber = var4;
      this.dryModeIcon = var5;
      this.dryModeTitle = var6;
   }

   public static HolderDeviceHDryModeBinding bind(View var0) {
      int var1 = R.id.cancel_dry_mode;
      TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.content_dry_mode;
         ConstraintLayout var2 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.countdown_number;
            TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               var1 = R.id.dry_mode_icon;
               ImageView var5 = (ImageView)ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  var1 = R.id.dry_mode_title;
                  TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var6 != null) {
                     return new HolderDeviceHDryModeBinding((ConstraintLayout)var0, var4, var2, var3, var5, var6);
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceHDryModeBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceHDryModeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_h_dry_mode, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
