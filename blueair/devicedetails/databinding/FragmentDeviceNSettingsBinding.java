package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class FragmentDeviceNSettingsBinding implements ViewBinding {
   public final View arrow;
   private final FrameLayout rootView;
   public final TextView title;

   private FragmentDeviceNSettingsBinding(FrameLayout var1, View var2, TextView var3) {
      this.rootView = var1;
      this.arrow = var2;
      this.title = var3;
   }

   public static FragmentDeviceNSettingsBinding bind(View var0) {
      int var1 = R.id.arrow;
      View var2 = ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.title;
         TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            return new FragmentDeviceNSettingsBinding((FrameLayout)var0, var2, var3);
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentDeviceNSettingsBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentDeviceNSettingsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_device_n_settings, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
