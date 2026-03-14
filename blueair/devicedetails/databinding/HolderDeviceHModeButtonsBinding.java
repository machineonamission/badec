package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceHModeButtonsBinding implements ViewBinding {
   public final RecyclerView modeButtons;
   private final FrameLayout rootView;
   public final View separator;
   public final TextView standbyHint;
   public final HolderDeviceNModeButtonBinding standbyModeRoot;

   private HolderDeviceHModeButtonsBinding(FrameLayout var1, RecyclerView var2, View var3, TextView var4, HolderDeviceNModeButtonBinding var5) {
      this.rootView = var1;
      this.modeButtons = var2;
      this.separator = var3;
      this.standbyHint = var4;
      this.standbyModeRoot = var5;
   }

   public static HolderDeviceHModeButtonsBinding bind(View var0) {
      int var1 = R.id.mode_buttons;
      RecyclerView var4 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.separator;
         View var2 = ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.standby_hint;
            TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               var1 = R.id.standby_mode_root;
               View var5 = ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  HolderDeviceNModeButtonBinding var6 = HolderDeviceNModeButtonBinding.bind(var5);
                  return new HolderDeviceHModeButtonsBinding((FrameLayout)var0, var4, var2, var3, var6);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceHModeButtonsBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceHModeButtonsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_h_mode_buttons, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
