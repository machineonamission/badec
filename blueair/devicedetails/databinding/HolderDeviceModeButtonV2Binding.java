package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceModeButtonV2Binding implements ViewBinding {
   public final AppCompatImageView modeIcon;
   public final LinearLayout modeRoot;
   public final TextView modeText;
   private final FrameLayout rootView;

   private HolderDeviceModeButtonV2Binding(FrameLayout var1, AppCompatImageView var2, LinearLayout var3, TextView var4) {
      this.rootView = var1;
      this.modeIcon = var2;
      this.modeRoot = var3;
      this.modeText = var4;
   }

   public static HolderDeviceModeButtonV2Binding bind(View var0) {
      int var1 = R.id.mode_icon;
      AppCompatImageView var2 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.mode_root;
         LinearLayout var3 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            var1 = R.id.mode_text;
            TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               return new HolderDeviceModeButtonV2Binding((FrameLayout)var0, var2, var3, var4);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceModeButtonV2Binding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceModeButtonV2Binding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_mode_button_v2, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
