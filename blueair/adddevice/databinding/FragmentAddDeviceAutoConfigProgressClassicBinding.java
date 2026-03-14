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

public final class FragmentAddDeviceAutoConfigProgressClassicBinding implements ViewBinding {
   public final LottieAnimationView imageAuto;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final TextView textAddDeviceTitle;

   private FragmentAddDeviceAutoConfigProgressClassicBinding(ConstraintLayout var1, LottieAnimationView var2, ConstraintLayout var3, TextView var4) {
      this.rootView = var1;
      this.imageAuto = var2;
      this.rootLayout = var3;
      this.textAddDeviceTitle = var4;
   }

   public static FragmentAddDeviceAutoConfigProgressClassicBinding bind(View var0) {
      int var1 = R.id.imageAuto;
      LottieAnimationView var3 = (LottieAnimationView)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         ConstraintLayout var4 = (ConstraintLayout)var0;
         var1 = R.id.textAddDeviceTitle;
         TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            return new FragmentAddDeviceAutoConfigProgressClassicBinding(var4, var3, var4, var2);
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentAddDeviceAutoConfigProgressClassicBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentAddDeviceAutoConfigProgressClassicBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_add_device_auto_config_progress_classic, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
