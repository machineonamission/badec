package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentAddDeviceAutoStepSetupIcpBinding implements ViewBinding {
   public final MaterialButton buttonNext;
   public final ImageView imageAuto;
   private final ConstraintLayout rootView;
   public final TextView textAddDeviceSubtitle;
   public final TextView textAddDeviceTitle;

   private FragmentAddDeviceAutoStepSetupIcpBinding(ConstraintLayout var1, MaterialButton var2, ImageView var3, TextView var4, TextView var5) {
      this.rootView = var1;
      this.buttonNext = var2;
      this.imageAuto = var3;
      this.textAddDeviceSubtitle = var4;
      this.textAddDeviceTitle = var5;
   }

   public static FragmentAddDeviceAutoStepSetupIcpBinding bind(View var0) {
      int var1 = R.id.buttonNext;
      MaterialButton var4 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.imageAuto;
         ImageView var2 = (ImageView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.textAddDeviceSubtitle;
            TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.textAddDeviceTitle;
               TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var3 != null) {
                  return new FragmentAddDeviceAutoStepSetupIcpBinding((ConstraintLayout)var0, var4, var2, var5, var3);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentAddDeviceAutoStepSetupIcpBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentAddDeviceAutoStepSetupIcpBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_add_device_auto_step_setup_icp, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
