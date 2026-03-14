package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.R;

public final class HolderCommonDeviceNameBinding implements ViewBinding {
   public final RadioButton root;
   private final RadioButton rootView;

   private HolderCommonDeviceNameBinding(RadioButton var1, RadioButton var2) {
      this.rootView = var1;
      this.root = var2;
   }

   public static HolderCommonDeviceNameBinding bind(View var0) {
      if (var0 != null) {
         RadioButton var1 = (RadioButton)var0;
         return new HolderCommonDeviceNameBinding(var1, var1);
      } else {
         throw new NullPointerException("rootView");
      }
   }

   public static HolderCommonDeviceNameBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderCommonDeviceNameBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_common_device_name, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public RadioButton getRoot() {
      return this.rootView;
   }
}
