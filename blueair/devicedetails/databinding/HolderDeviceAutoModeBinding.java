package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceAutoModeBinding implements ViewBinding {
   public final TextView germshieldTitle;
   public final TextView modeTitle;
   private final ConstraintLayout rootView;
   public final View separator;

   private HolderDeviceAutoModeBinding(ConstraintLayout var1, TextView var2, TextView var3, View var4) {
      this.rootView = var1;
      this.germshieldTitle = var2;
      this.modeTitle = var3;
      this.separator = var4;
   }

   public static HolderDeviceAutoModeBinding bind(View var0) {
      int var1 = R.id.germshield_title;
      TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.mode_title;
         TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.separator;
            View var3 = ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               return new HolderDeviceAutoModeBinding((ConstraintLayout)var0, var2, var4, var3);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceAutoModeBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceAutoModeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_auto_mode, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
