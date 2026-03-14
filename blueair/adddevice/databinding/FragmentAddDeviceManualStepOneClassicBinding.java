package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentAddDeviceManualStepOneClassicBinding implements ViewBinding {
   public final MaterialButton buttonNext;
   public final LottieAnimationView imageAuto;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final TextView textAddDeviceSubtitle;
   public final TextView textAddDeviceTitle;

   private FragmentAddDeviceManualStepOneClassicBinding(ConstraintLayout var1, MaterialButton var2, LottieAnimationView var3, ConstraintLayout var4, TextView var5, TextView var6) {
      this.rootView = var1;
      this.buttonNext = var2;
      this.imageAuto = var3;
      this.rootLayout = var4;
      this.textAddDeviceSubtitle = var5;
      this.textAddDeviceTitle = var6;
   }

   public static FragmentAddDeviceManualStepOneClassicBinding bind(View var0) {
      int var1 = R.id.buttonNext;
      MaterialButton var5 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var5 != null) {
         var1 = R.id.imageAuto;
         LottieAnimationView var2 = (LottieAnimationView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            ConstraintLayout var6 = (ConstraintLayout)var0;
            var1 = R.id.textAddDeviceSubtitle;
            TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               var1 = R.id.textAddDeviceTitle;
               TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var3 != null) {
                  return new FragmentAddDeviceManualStepOneClassicBinding(var6, var5, var2, var6, var4, var3);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentAddDeviceManualStepOneClassicBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentAddDeviceManualStepOneClassicBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_add_device_manual_step_one_classic, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
