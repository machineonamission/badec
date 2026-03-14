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

public final class FragmentAwareFailOneBinding implements ViewBinding {
   public final MaterialButton buttonNextAware;
   public final View dividerOne;
   public final View dividerTwo;
   public final ImageView imageFailFadingSlowAware;
   public final ImageView imageFailFlashingFastAware;
   public final ImageView imageFailSolidAware;
   public final RadioButton radioBtnFailFadingAware;
   public final RadioButton radioBtnFailFlashingAware;
   public final RadioButton radioBtnFailSolidAware;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final TextView textAddDeviceSubtitle;
   public final TextView textAddDeviceTitle;

   private FragmentAwareFailOneBinding(ConstraintLayout var1, MaterialButton var2, View var3, View var4, ImageView var5, ImageView var6, ImageView var7, RadioButton var8, RadioButton var9, RadioButton var10, ConstraintLayout var11, TextView var12, TextView var13) {
      this.rootView = var1;
      this.buttonNextAware = var2;
      this.dividerOne = var3;
      this.dividerTwo = var4;
      this.imageFailFadingSlowAware = var5;
      this.imageFailFlashingFastAware = var6;
      this.imageFailSolidAware = var7;
      this.radioBtnFailFadingAware = var8;
      this.radioBtnFailFlashingAware = var9;
      this.radioBtnFailSolidAware = var10;
      this.rootLayout = var11;
      this.textAddDeviceSubtitle = var12;
      this.textAddDeviceTitle = var13;
   }

   public static FragmentAwareFailOneBinding bind(View var0) {
      int var1 = R.id.buttonNextAware;
      MaterialButton var8 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var8 != null) {
         var1 = R.id.divider_one;
         View var5 = ViewBindings.findChildViewById(var0, var1);
         if (var5 != null) {
            var1 = R.id.divider_two;
            View var3 = ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               var1 = R.id.imageFailFadingSlowAware;
               ImageView var4 = (ImageView)ViewBindings.findChildViewById(var0, var1);
               if (var4 != null) {
                  var1 = R.id.imageFailFlashingFastAware;
                  ImageView var10 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                  if (var10 != null) {
                     var1 = R.id.imageFailSolidAware;
                     ImageView var11 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                     if (var11 != null) {
                        var1 = R.id.radioBtnFailFadingAware;
                        RadioButton var9 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
                        if (var9 != null) {
                           var1 = R.id.radioBtnFailFlashingAware;
                           RadioButton var13 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
                           if (var13 != null) {
                              var1 = R.id.radioBtnFailSolidAware;
                              RadioButton var7 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
                              if (var7 != null) {
                                 ConstraintLayout var12 = (ConstraintLayout)var0;
                                 var1 = R.id.textAddDeviceSubtitle;
                                 TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var6 != null) {
                                    var1 = R.id.textAddDeviceTitle;
                                    TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                    if (var2 != null) {
                                       return new FragmentAwareFailOneBinding(var12, var8, var5, var3, var4, var10, var11, var9, var13, var7, var12, var6, var2);
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

   public static FragmentAwareFailOneBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentAwareFailOneBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_aware_fail_one, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
