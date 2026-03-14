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

public final class FragmentAddDeviceAutoStepOneIcpBinding implements ViewBinding {
   public final MaterialButton buttonNext;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final TextView textAddDeviceSubtitle;
   public final TextView textAddDeviceTitle;
   public final TextView textBulletOne;
   public final TextView textBulletThree;
   public final TextView textBulletTwo;

   private FragmentAddDeviceAutoStepOneIcpBinding(ConstraintLayout var1, MaterialButton var2, ConstraintLayout var3, TextView var4, TextView var5, TextView var6, TextView var7, TextView var8) {
      this.rootView = var1;
      this.buttonNext = var2;
      this.rootLayout = var3;
      this.textAddDeviceSubtitle = var4;
      this.textAddDeviceTitle = var5;
      this.textBulletOne = var6;
      this.textBulletThree = var7;
      this.textBulletTwo = var8;
   }

   public static FragmentAddDeviceAutoStepOneIcpBinding bind(View var0) {
      int var1 = R.id.buttonNext;
      MaterialButton var4 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         ConstraintLayout var6 = (ConstraintLayout)var0;
         var1 = R.id.textAddDeviceSubtitle;
         TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.textAddDeviceTitle;
            TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               var1 = R.id.textBulletOne;
               TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var7 != null) {
                  var1 = R.id.textBulletThree;
                  TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var5 != null) {
                     var1 = R.id.textBulletTwo;
                     TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var8 != null) {
                        return new FragmentAddDeviceAutoStepOneIcpBinding(var6, var4, var6, var2, var3, var7, var5, var8);
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentAddDeviceAutoStepOneIcpBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentAddDeviceAutoStepOneIcpBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_add_device_auto_step_one_icp, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
