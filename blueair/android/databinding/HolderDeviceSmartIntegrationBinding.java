package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;

public final class HolderDeviceSmartIntegrationBinding implements ViewBinding {
   public final ConstraintLayout clickview;
   public final AppCompatImageView deviceImageView;
   public final TextView deviceName;
   private final ConstraintLayout rootView;

   private HolderDeviceSmartIntegrationBinding(ConstraintLayout var1, ConstraintLayout var2, AppCompatImageView var3, TextView var4) {
      this.rootView = var1;
      this.clickview = var2;
      this.deviceImageView = var3;
      this.deviceName = var4;
   }

   public static HolderDeviceSmartIntegrationBinding bind(View var0) {
      ConstraintLayout var4 = (ConstraintLayout)var0;
      int var1 = R.id.device_image_view;
      AppCompatImageView var2 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.device_name;
         TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            return new HolderDeviceSmartIntegrationBinding(var4, var4, var2, var3);
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceSmartIntegrationBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceSmartIntegrationBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_smart_integration, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
