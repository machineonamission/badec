package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;

public final class HolderDeviceSeparatorBinding implements ViewBinding {
   private final View rootView;
   public final View separator;

   private HolderDeviceSeparatorBinding(View var1, View var2) {
      this.rootView = var1;
      this.separator = var2;
   }

   public static HolderDeviceSeparatorBinding bind(View var0) {
      if (var0 != null) {
         return new HolderDeviceSeparatorBinding(var0, var0);
      } else {
         throw new NullPointerException("rootView");
      }
   }

   public static HolderDeviceSeparatorBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceSeparatorBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_separator, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public View getRoot() {
      return this.rootView;
   }
}
