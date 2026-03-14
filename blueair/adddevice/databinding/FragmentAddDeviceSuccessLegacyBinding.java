package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentAddDeviceSuccessLegacyBinding implements ViewBinding {
   public final MaterialButton buttonNext;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final TextView textAddDeviceSubtitle;
   public final TextView textAddDeviceTitle;

   private FragmentAddDeviceSuccessLegacyBinding(ConstraintLayout var1, MaterialButton var2, ConstraintLayout var3, TextView var4, TextView var5) {
      this.rootView = var1;
      this.buttonNext = var2;
      this.rootLayout = var3;
      this.textAddDeviceSubtitle = var4;
      this.textAddDeviceTitle = var5;
   }

   public static FragmentAddDeviceSuccessLegacyBinding bind(View var0) {
      int var1 = R.id.buttonNext;
      MaterialButton var3 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         ConstraintLayout var2 = (ConstraintLayout)var0;
         var1 = R.id.textAddDeviceSubtitle;
         TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.textAddDeviceTitle;
            TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               return new FragmentAddDeviceSuccessLegacyBinding(var2, var3, var2, var4, var5);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentAddDeviceSuccessLegacyBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentAddDeviceSuccessLegacyBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_add_device_success_legacy, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
