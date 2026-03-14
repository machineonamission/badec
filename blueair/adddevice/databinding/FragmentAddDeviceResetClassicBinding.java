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

public final class FragmentAddDeviceResetClassicBinding implements ViewBinding {
   public final MaterialButton buttonNext;
   public final ImageView imageAuto;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final TextView textAddDeviceSubtitle;
   public final TextView textAddDeviceTitle;

   private FragmentAddDeviceResetClassicBinding(ConstraintLayout var1, MaterialButton var2, ImageView var3, ConstraintLayout var4, TextView var5, TextView var6) {
      this.rootView = var1;
      this.buttonNext = var2;
      this.imageAuto = var3;
      this.rootLayout = var4;
      this.textAddDeviceSubtitle = var5;
      this.textAddDeviceTitle = var6;
   }

   public static FragmentAddDeviceResetClassicBinding bind(View var0) {
      int var1 = R.id.buttonNext;
      MaterialButton var3 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.imageAuto;
         ImageView var4 = (ImageView)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            ConstraintLayout var5 = (ConstraintLayout)var0;
            var1 = R.id.textAddDeviceSubtitle;
            TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               var1 = R.id.textAddDeviceTitle;
               TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var6 != null) {
                  return new FragmentAddDeviceResetClassicBinding(var5, var3, var4, var5, var2, var6);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentAddDeviceResetClassicBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentAddDeviceResetClassicBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_add_device_reset_classic, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
