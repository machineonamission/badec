package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;

public final class HolderDeviceNModeButtonsBinding implements ViewBinding {
   public final RecyclerView modeButtons;
   private final RecyclerView rootView;

   private HolderDeviceNModeButtonsBinding(RecyclerView var1, RecyclerView var2) {
      this.rootView = var1;
      this.modeButtons = var2;
   }

   public static HolderDeviceNModeButtonsBinding bind(View var0) {
      if (var0 != null) {
         RecyclerView var1 = (RecyclerView)var0;
         return new HolderDeviceNModeButtonsBinding(var1, var1);
      } else {
         throw new NullPointerException("rootView");
      }
   }

   public static HolderDeviceNModeButtonsBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceNModeButtonsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_n_mode_buttons, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public RecyclerView getRoot() {
      return this.rootView;
   }
}
