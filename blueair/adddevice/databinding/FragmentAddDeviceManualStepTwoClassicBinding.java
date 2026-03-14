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

public final class FragmentAddDeviceManualStepTwoClassicBinding implements ViewBinding {
   public final MaterialButton btnSettings;
   public final MaterialButton buttonNext;
   public final ImageView imageAuto;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final TextView textAddDeviceSubtitle;
   public final TextView textAddDeviceTitle;
   public final TextView txtNextTitle;

   private FragmentAddDeviceManualStepTwoClassicBinding(ConstraintLayout var1, MaterialButton var2, MaterialButton var3, ImageView var4, ConstraintLayout var5, TextView var6, TextView var7, TextView var8) {
      this.rootView = var1;
      this.btnSettings = var2;
      this.buttonNext = var3;
      this.imageAuto = var4;
      this.rootLayout = var5;
      this.textAddDeviceSubtitle = var6;
      this.textAddDeviceTitle = var7;
      this.txtNextTitle = var8;
   }

   public static FragmentAddDeviceManualStepTwoClassicBinding bind(View var0) {
      int var1 = R.id.btnSettings;
      MaterialButton var8 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var8 != null) {
         var1 = R.id.buttonNext;
         MaterialButton var5 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var5 != null) {
            var1 = R.id.imageAuto;
            ImageView var6 = (ImageView)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               ConstraintLayout var3 = (ConstraintLayout)var0;
               var1 = R.id.textAddDeviceSubtitle;
               TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var4 != null) {
                  var1 = R.id.textAddDeviceTitle;
                  TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var7 != null) {
                     var1 = R.id.txtNextTitle;
                     TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var2 != null) {
                        return new FragmentAddDeviceManualStepTwoClassicBinding(var3, var8, var5, var6, var3, var4, var7, var2);
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentAddDeviceManualStepTwoClassicBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentAddDeviceManualStepTwoClassicBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_add_device_manual_step_two_classic, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
