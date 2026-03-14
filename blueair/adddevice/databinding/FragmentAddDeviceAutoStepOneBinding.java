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

public final class FragmentAddDeviceAutoStepOneBinding implements ViewBinding {
   public final MaterialButton buttonNext;
   public final ImageView imageAuto;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final TextView textAddDeviceSubtitle;
   public final TextView textAddDeviceTitle;

   private FragmentAddDeviceAutoStepOneBinding(ConstraintLayout var1, MaterialButton var2, ImageView var3, ConstraintLayout var4, TextView var5, TextView var6) {
      this.rootView = var1;
      this.buttonNext = var2;
      this.imageAuto = var3;
      this.rootLayout = var4;
      this.textAddDeviceSubtitle = var5;
      this.textAddDeviceTitle = var6;
   }

   public static FragmentAddDeviceAutoStepOneBinding bind(View var0) {
      int var1 = R.id.buttonNext;
      MaterialButton var2 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.imageAuto;
         ImageView var6 = (ImageView)ViewBindings.findChildViewById(var0, var1);
         if (var6 != null) {
            ConstraintLayout var3 = (ConstraintLayout)var0;
            var1 = R.id.textAddDeviceSubtitle;
            TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               var1 = R.id.textAddDeviceTitle;
               TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  return new FragmentAddDeviceAutoStepOneBinding(var3, var2, var6, var3, var4, var5);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentAddDeviceAutoStepOneBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentAddDeviceAutoStepOneBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_add_device_auto_step_one, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
