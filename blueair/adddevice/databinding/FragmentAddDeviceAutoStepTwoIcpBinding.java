package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentAddDeviceAutoStepTwoIcpBinding implements ViewBinding {
   public final MaterialButton buttonNext;
   public final LottieAnimationView connectingProgress;
   public final ImageView imageAuto;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final TextView textAddDeviceSubtitle;
   public final TextView textAddDeviceTitle;

   private FragmentAddDeviceAutoStepTwoIcpBinding(ConstraintLayout var1, MaterialButton var2, LottieAnimationView var3, ImageView var4, ConstraintLayout var5, TextView var6, TextView var7) {
      this.rootView = var1;
      this.buttonNext = var2;
      this.connectingProgress = var3;
      this.imageAuto = var4;
      this.rootLayout = var5;
      this.textAddDeviceSubtitle = var6;
      this.textAddDeviceTitle = var7;
   }

   public static FragmentAddDeviceAutoStepTwoIcpBinding bind(View var0) {
      int var1 = R.id.buttonNext;
      MaterialButton var5 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var5 != null) {
         var1 = R.id.connecting_progress;
         LottieAnimationView var3 = (LottieAnimationView)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            var1 = R.id.imageAuto;
            ImageView var4 = (ImageView)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               ConstraintLayout var7 = (ConstraintLayout)var0;
               var1 = R.id.textAddDeviceSubtitle;
               TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  var1 = R.id.textAddDeviceTitle;
                  TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var6 != null) {
                     return new FragmentAddDeviceAutoStepTwoIcpBinding(var7, var5, var3, var4, var7, var2, var6);
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentAddDeviceAutoStepTwoIcpBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentAddDeviceAutoStepTwoIcpBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_add_device_auto_step_two_icp, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
