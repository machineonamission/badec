package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentClassicFailRingBinding implements ViewBinding {
   public final MaterialButton buttonNextClassic;
   public final View dividerOne;
   public final View dividerTwo;
   public final ImageView imageFailRingFadedClassic;
   public final ImageView imageFailRingFlashingClassic;
   public final ImageView imageFailSolidRingClassic;
   public final RadioButton radioBtnFailRingFlashingClassic;
   public final RadioButton radioBtnFailRingSolidClassic;
   public final RadioButton radioBtnFailWifiSolidClassic;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final TextView textAddDeviceSubtitle;
   public final TextView textAddDeviceTitle;

   private FragmentClassicFailRingBinding(ConstraintLayout var1, MaterialButton var2, View var3, View var4, ImageView var5, ImageView var6, ImageView var7, RadioButton var8, RadioButton var9, RadioButton var10, ConstraintLayout var11, TextView var12, TextView var13) {
      this.rootView = var1;
      this.buttonNextClassic = var2;
      this.dividerOne = var3;
      this.dividerTwo = var4;
      this.imageFailRingFadedClassic = var5;
      this.imageFailRingFlashingClassic = var6;
      this.imageFailSolidRingClassic = var7;
      this.radioBtnFailRingFlashingClassic = var8;
      this.radioBtnFailRingSolidClassic = var9;
      this.radioBtnFailWifiSolidClassic = var10;
      this.rootLayout = var11;
      this.textAddDeviceSubtitle = var12;
      this.textAddDeviceTitle = var13;
   }

   public static FragmentClassicFailRingBinding bind(View var0) {
      int var1 = R.id.buttonNextClassic;
      MaterialButton var10 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var10 != null) {
         var1 = R.id.divider_one;
         View var12 = ViewBindings.findChildViewById(var0, var1);
         if (var12 != null) {
            var1 = R.id.divider_two;
            View var9 = ViewBindings.findChildViewById(var0, var1);
            if (var9 != null) {
               var1 = R.id.imageFailRingFadedClassic;
               ImageView var2 = (ImageView)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  var1 = R.id.imageFailRingFlashingClassic;
                  ImageView var11 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                  if (var11 != null) {
                     var1 = R.id.imageFailSolidRingClassic;
                     ImageView var13 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                     if (var13 != null) {
                        var1 = R.id.radioBtnFailRingFlashingClassic;
                        RadioButton var6 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
                        if (var6 != null) {
                           var1 = R.id.radioBtnFailRingSolidClassic;
                           RadioButton var4 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
                           if (var4 != null) {
                              var1 = R.id.radioBtnFailWifiSolidClassic;
                              RadioButton var7 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
                              if (var7 != null) {
                                 ConstraintLayout var8 = (ConstraintLayout)var0;
                                 var1 = R.id.textAddDeviceSubtitle;
                                 TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var3 != null) {
                                    var1 = R.id.textAddDeviceTitle;
                                    TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                    if (var5 != null) {
                                       return new FragmentClassicFailRingBinding(var8, var10, var12, var9, var2, var11, var13, var6, var4, var7, var8, var3, var5);
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentClassicFailRingBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentClassicFailRingBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_classic_fail_ring, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
