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

public final class FragmentAwareFailTwoBinding implements ViewBinding {
   public final MaterialButton buttonNextAware;
   public final View dividerOne;
   public final ImageView imageFailBlueFlash;
   public final ImageView imageFailOrangeFlash;
   public final RadioButton radioBtnBlueFlash;
   public final RadioButton radioBtnOrangeFlash;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final TextView textAddDeviceSubtitle;
   public final TextView textAddDeviceTitle;

   private FragmentAwareFailTwoBinding(ConstraintLayout var1, MaterialButton var2, View var3, ImageView var4, ImageView var5, RadioButton var6, RadioButton var7, ConstraintLayout var8, TextView var9, TextView var10) {
      this.rootView = var1;
      this.buttonNextAware = var2;
      this.dividerOne = var3;
      this.imageFailBlueFlash = var4;
      this.imageFailOrangeFlash = var5;
      this.radioBtnBlueFlash = var6;
      this.radioBtnOrangeFlash = var7;
      this.rootLayout = var8;
      this.textAddDeviceSubtitle = var9;
      this.textAddDeviceTitle = var10;
   }

   public static FragmentAwareFailTwoBinding bind(View var0) {
      int var1 = R.id.buttonNextAware;
      MaterialButton var7 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var7 != null) {
         var1 = R.id.divider_one;
         View var6 = ViewBindings.findChildViewById(var0, var1);
         if (var6 != null) {
            var1 = R.id.imageFailBlueFlash;
            ImageView var2 = (ImageView)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               var1 = R.id.imageFailOrangeFlash;
               ImageView var10 = (ImageView)ViewBindings.findChildViewById(var0, var1);
               if (var10 != null) {
                  var1 = R.id.radioBtnBlueFlash;
                  RadioButton var3 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
                  if (var3 != null) {
                     var1 = R.id.radioBtnOrangeFlash;
                     RadioButton var8 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
                     if (var8 != null) {
                        ConstraintLayout var9 = (ConstraintLayout)var0;
                        var1 = R.id.textAddDeviceSubtitle;
                        TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var4 != null) {
                           var1 = R.id.textAddDeviceTitle;
                           TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var5 != null) {
                              return new FragmentAwareFailTwoBinding(var9, var7, var6, var2, var10, var3, var8, var9, var4, var5);
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

   public static FragmentAwareFailTwoBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentAwareFailTwoBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_aware_fail_two, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
