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

public final class FragmentAddDeviceManualConfigProgressClassicBinding implements ViewBinding {
   public final LottieAnimationView imageAuto;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final TextView textAddDeviceSubtitle;
   public final TextView textAddDeviceTitle;

   private FragmentAddDeviceManualConfigProgressClassicBinding(ConstraintLayout var1, LottieAnimationView var2, ConstraintLayout var3, TextView var4, TextView var5) {
      this.rootView = var1;
      this.imageAuto = var2;
      this.rootLayout = var3;
      this.textAddDeviceSubtitle = var4;
      this.textAddDeviceTitle = var5;
   }

   public static FragmentAddDeviceManualConfigProgressClassicBinding bind(View var0) {
      int var1 = R.id.imageAuto;
      LottieAnimationView var4 = (LottieAnimationView)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         ConstraintLayout var5 = (ConstraintLayout)var0;
         var1 = R.id.textAddDeviceSubtitle;
         TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.textAddDeviceTitle;
            TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               return new FragmentAddDeviceManualConfigProgressClassicBinding(var5, var4, var5, var2, var3);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentAddDeviceManualConfigProgressClassicBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentAddDeviceManualConfigProgressClassicBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_add_device_manual_config_progress_classic, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
