package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceGermShieldStatusBinding implements ViewBinding {
   public final TextView attributeTitle;
   public final AppCompatImageView germshieldIcon;
   private final ConstraintLayout rootView;
   public final View separator;

   private HolderDeviceGermShieldStatusBinding(ConstraintLayout var1, TextView var2, AppCompatImageView var3, View var4) {
      this.rootView = var1;
      this.attributeTitle = var2;
      this.germshieldIcon = var3;
      this.separator = var4;
   }

   public static HolderDeviceGermShieldStatusBinding bind(View var0) {
      int var1 = R.id.attribute_title;
      TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.germshield_icon;
         AppCompatImageView var2 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.separator;
            View var3 = ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               return new HolderDeviceGermShieldStatusBinding((ConstraintLayout)var0, var4, var2, var3);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceGermShieldStatusBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceGermShieldStatusBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_germ_shield_status, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
