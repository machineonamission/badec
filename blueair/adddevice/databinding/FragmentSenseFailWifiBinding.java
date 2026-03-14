package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentSenseFailWifiBinding implements ViewBinding {
   public final MaterialButton buttonNextSense;
   public final View dividerOne;
   public final View dividerTwo;
   public final View dividerZero;
   public final ImageView imageBackgroundOne;
   public final ImageView imageBackgroundTwo;
   public final ImageView imageFailFlashingFasterSense;
   public final ImageView imageFailFlashingSlowerSense;
   public final RadioButton radioBtnWifiFlashingSense;
   public final RadioButton radioBtnWifiPulsingSense;
   public final ConstraintLayout rootLayout;
   private final ScrollView rootView;
   public final ScrollView scrollable;
   public final TextView textAddDeviceSubtitle;
   public final TextView textAddDeviceTitle;

   private FragmentSenseFailWifiBinding(ScrollView var1, MaterialButton var2, View var3, View var4, View var5, ImageView var6, ImageView var7, ImageView var8, ImageView var9, RadioButton var10, RadioButton var11, ConstraintLayout var12, ScrollView var13, TextView var14, TextView var15) {
      this.rootView = var1;
      this.buttonNextSense = var2;
      this.dividerOne = var3;
      this.dividerTwo = var4;
      this.dividerZero = var5;
      this.imageBackgroundOne = var6;
      this.imageBackgroundTwo = var7;
      this.imageFailFlashingFasterSense = var8;
      this.imageFailFlashingSlowerSense = var9;
      this.radioBtnWifiFlashingSense = var10;
      this.radioBtnWifiPulsingSense = var11;
      this.rootLayout = var12;
      this.scrollable = var13;
      this.textAddDeviceSubtitle = var14;
      this.textAddDeviceTitle = var15;
   }

   public static FragmentSenseFailWifiBinding bind(View var0) {
      int var1 = R.id.buttonNextSense;
      MaterialButton var14 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var14 != null) {
         var1 = R.id.divider_one;
         View var10 = ViewBindings.findChildViewById(var0, var1);
         if (var10 != null) {
            var1 = R.id.divider_two;
            View var5 = ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.divider_zero;
               View var4 = ViewBindings.findChildViewById(var0, var1);
               if (var4 != null) {
                  var1 = R.id.imageBackgroundOne;
                  ImageView var7 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                  if (var7 != null) {
                     var1 = R.id.imageBackgroundTwo;
                     ImageView var6 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                     if (var6 != null) {
                        var1 = R.id.imageFailFlashingFasterSense;
                        ImageView var12 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                        if (var12 != null) {
                           var1 = R.id.imageFailFlashingSlowerSense;
                           ImageView var8 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                           if (var8 != null) {
                              var1 = R.id.radioBtnWifiFlashingSense;
                              RadioButton var11 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
                              if (var11 != null) {
                                 var1 = R.id.radioBtnWifiPulsingSense;
                                 RadioButton var9 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
                                 if (var9 != null) {
                                    var1 = R.id.rootLayout;
                                    ConstraintLayout var13 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                    if (var13 != null) {
                                       ScrollView var3 = (ScrollView)var0;
                                       var1 = R.id.textAddDeviceSubtitle;
                                       TextView var15 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                       if (var15 != null) {
                                          var1 = R.id.textAddDeviceTitle;
                                          TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                          if (var2 != null) {
                                             return new FragmentSenseFailWifiBinding(var3, var14, var10, var5, var4, var7, var6, var12, var8, var11, var9, var13, var3, var15, var2);
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
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentSenseFailWifiBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentSenseFailWifiBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_sense_fail_wifi, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ScrollView getRoot() {
      return this.rootView;
   }
}
