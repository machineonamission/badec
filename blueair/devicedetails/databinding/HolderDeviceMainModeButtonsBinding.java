package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceMainModeButtonsBinding implements ViewBinding {
   public final TextView heatHint;
   public final RecyclerView mainModeButtons;
   private final LinearLayout rootView;
   public final View separator;
   public final RecyclerView subModeButtons;

   private HolderDeviceMainModeButtonsBinding(LinearLayout var1, TextView var2, RecyclerView var3, View var4, RecyclerView var5) {
      this.rootView = var1;
      this.heatHint = var2;
      this.mainModeButtons = var3;
      this.separator = var4;
      this.subModeButtons = var5;
   }

   public static HolderDeviceMainModeButtonsBinding bind(View var0) {
      int var1 = R.id.heat_hint;
      TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.main_mode_buttons;
         RecyclerView var4 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.separator;
            View var3 = ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               var1 = R.id.sub_mode_buttons;
               RecyclerView var5 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  return new HolderDeviceMainModeButtonsBinding((LinearLayout)var0, var2, var4, var3, var5);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceMainModeButtonsBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceMainModeButtonsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_main_mode_buttons, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
