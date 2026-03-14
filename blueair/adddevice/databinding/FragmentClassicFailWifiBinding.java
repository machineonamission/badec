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

public final class FragmentClassicFailWifiBinding implements ViewBinding {
   public final MaterialButton buttonNextClassic;
   public final View dividerOne;
   public final ImageView imageFailFlashingFaster;
   public final ImageView imageFailFlashingSlower;
   public final RadioButton radioBtnFailFlashFaster;
   public final RadioButton radioBtnFailFlashSlower;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final TextView textAddDeviceSubtitle;
   public final TextView textAddDeviceTitle;

   private FragmentClassicFailWifiBinding(ConstraintLayout var1, MaterialButton var2, View var3, ImageView var4, ImageView var5, RadioButton var6, RadioButton var7, ConstraintLayout var8, TextView var9, TextView var10) {
      this.rootView = var1;
      this.buttonNextClassic = var2;
      this.dividerOne = var3;
      this.imageFailFlashingFaster = var4;
      this.imageFailFlashingSlower = var5;
      this.radioBtnFailFlashFaster = var6;
      this.radioBtnFailFlashSlower = var7;
      this.rootLayout = var8;
      this.textAddDeviceSubtitle = var9;
      this.textAddDeviceTitle = var10;
   }

   public static FragmentClassicFailWifiBinding bind(View var0) {
      int var1 = R.id.buttonNextClassic;
      MaterialButton var6 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var6 != null) {
         var1 = R.id.divider_one;
         View var10 = ViewBindings.findChildViewById(var0, var1);
         if (var10 != null) {
            var1 = R.id.imageFailFlashingFaster;
            ImageView var7 = (ImageView)ViewBindings.findChildViewById(var0, var1);
            if (var7 != null) {
               var1 = R.id.imageFailFlashingSlower;
               ImageView var3 = (ImageView)ViewBindings.findChildViewById(var0, var1);
               if (var3 != null) {
                  var1 = R.id.radioBtnFailFlashFaster;
                  RadioButton var8 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
                  if (var8 != null) {
                     var1 = R.id.radioBtnFailFlashSlower;
                     RadioButton var9 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
                     if (var9 != null) {
                        ConstraintLayout var2 = (ConstraintLayout)var0;
                        var1 = R.id.textAddDeviceSubtitle;
                        TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var5 != null) {
                           var1 = R.id.textAddDeviceTitle;
                           TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var4 != null) {
                              return new FragmentClassicFailWifiBinding(var2, var6, var10, var7, var3, var8, var9, var2, var5, var4);
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

   public static FragmentClassicFailWifiBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentClassicFailWifiBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_classic_fail_wifi, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
