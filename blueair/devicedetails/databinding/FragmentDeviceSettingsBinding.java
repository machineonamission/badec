package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentDeviceSettingsBinding implements ViewBinding {
   public final MaterialButton buttonProductSettings;
   private final MaterialButton rootView;

   private FragmentDeviceSettingsBinding(MaterialButton var1, MaterialButton var2) {
      this.rootView = var1;
      this.buttonProductSettings = var2;
   }

   public static FragmentDeviceSettingsBinding bind(View var0) {
      if (var0 != null) {
         MaterialButton var1 = (MaterialButton)var0;
         return new FragmentDeviceSettingsBinding(var1, var1);
      } else {
         throw new NullPointerException("rootView");
      }
   }

   public static FragmentDeviceSettingsBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentDeviceSettingsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_device_settings, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public MaterialButton getRoot() {
      return this.rootView;
   }
}
