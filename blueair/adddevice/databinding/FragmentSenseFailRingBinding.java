package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentSenseFailRingBinding implements ViewBinding {
   public final MaterialButton buttonNextSense;
   public final View dividerOne;
   public final View dividerThree;
   public final View dividerTwo;
   public final View dividerZero;
   public final ImageView imageBackgroundOne;
   public final ImageView imageBackgroundThree;
   public final ImageView imageBackgroundTwo;
   public final ImageView imageFailRingSolidWifiFlashingSense;
   public final ImageView imageFailRingWifiFadingSense;
   public final ImageView imageRingWifiSolidSense;
   public final AppCompatRadioButton radioBtnRingSolidWifiFlashingSense;
   public final RadioButton radioBtnRingWifiFadingSense;
   public final RadioButton radioBtnRingWifiSolidSense;
   public final ConstraintLayout rootLayout;
   private final ScrollView rootView;
   public final ScrollView scrollable;
   public final TextView textAddDeviceSubtitle;
   public final TextView textAddDeviceTitle;

   private FragmentSenseFailRingBinding(ScrollView var1, MaterialButton var2, View var3, View var4, View var5, View var6, ImageView var7, ImageView var8, ImageView var9, ImageView var10, ImageView var11, ImageView var12, AppCompatRadioButton var13, RadioButton var14, RadioButton var15, ConstraintLayout var16, ScrollView var17, TextView var18, TextView var19) {
      this.rootView = var1;
      this.buttonNextSense = var2;
      this.dividerOne = var3;
      this.dividerThree = var4;
      this.dividerTwo = var5;
      this.dividerZero = var6;
      this.imageBackgroundOne = var7;
      this.imageBackgroundThree = var8;
      this.imageBackgroundTwo = var9;
      this.imageFailRingSolidWifiFlashingSense = var10;
      this.imageFailRingWifiFadingSense = var11;
      this.imageRingWifiSolidSense = var12;
      this.radioBtnRingSolidWifiFlashingSense = var13;
      this.radioBtnRingWifiFadingSense = var14;
      this.radioBtnRingWifiSolidSense = var15;
      this.rootLayout = var16;
      this.scrollable = var17;
      this.textAddDeviceSubtitle = var18;
      this.textAddDeviceTitle = var19;
   }

   public static FragmentSenseFailRingBinding bind(View var0) {
      int var1 = R.id.buttonNextSense;
      MaterialButton var5 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var5 != null) {
         var1 = R.id.divider_one;
         View var9 = ViewBindings.findChildViewById(var0, var1);
         if (var9 != null) {
            var1 = R.id.divider_three;
            View var12 = ViewBindings.findChildViewById(var0, var1);
            if (var12 != null) {
               var1 = R.id.divider_two;
               View var16 = ViewBindings.findChildViewById(var0, var1);
               if (var16 != null) {
                  var1 = R.id.divider_zero;
                  View var8 = ViewBindings.findChildViewById(var0, var1);
                  if (var8 != null) {
                     var1 = R.id.imageBackgroundOne;
                     ImageView var17 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                     if (var17 != null) {
                        var1 = R.id.imageBackgroundThree;
                        ImageView var13 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                        if (var13 != null) {
                           var1 = R.id.imageBackgroundTwo;
                           ImageView var6 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                           if (var6 != null) {
                              var1 = R.id.imageFailRingSolidWifiFlashingSense;
                              ImageView var18 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                              if (var18 != null) {
                                 var1 = R.id.imageFailRingWifiFadingSense;
                                 ImageView var15 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                 if (var15 != null) {
                                    var1 = R.id.imageRingWifiSolidSense;
                                    ImageView var7 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                    if (var7 != null) {
                                       var1 = R.id.radioBtnRingSolidWifiFlashingSense;
                                       AppCompatRadioButton var3 = (AppCompatRadioButton)ViewBindings.findChildViewById(var0, var1);
                                       if (var3 != null) {
                                          var1 = R.id.radioBtnRingWifiFadingSense;
                                          RadioButton var2 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
                                          if (var2 != null) {
                                             var1 = R.id.radioBtnRingWifiSolidSense;
                                             RadioButton var11 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
                                             if (var11 != null) {
                                                var1 = R.id.rootLayout;
                                                ConstraintLayout var4 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                                if (var4 != null) {
                                                   ScrollView var14 = (ScrollView)var0;
                                                   var1 = R.id.textAddDeviceSubtitle;
                                                   TextView var19 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                   if (var19 != null) {
                                                      var1 = R.id.textAddDeviceTitle;
                                                      TextView var10 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                      if (var10 != null) {
                                                         return new FragmentSenseFailRingBinding(var14, var5, var9, var12, var16, var8, var17, var13, var6, var18, var15, var7, var3, var2, var11, var4, var14, var19, var10);
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
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentSenseFailRingBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentSenseFailRingBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_sense_fail_ring, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ScrollView getRoot() {
      return this.rootView;
   }
}
