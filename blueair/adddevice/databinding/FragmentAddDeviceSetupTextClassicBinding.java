package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentAddDeviceSetupTextClassicBinding implements ViewBinding {
   public final MaterialButton buttonNext;
   public final ConstraintLayout rootLayout;
   private final ScrollView rootView;
   public final ScrollView scrollable;
   public final TextView textAddDeviceSubtitle;
   public final TextView textAddDeviceTitle;
   public final TextView textBulletFour;
   public final TextView textBulletOne;
   public final TextView textBulletThree;
   public final TextView textBulletTwo;
   public final TextView textWrongWifi;

   private FragmentAddDeviceSetupTextClassicBinding(ScrollView var1, MaterialButton var2, ConstraintLayout var3, ScrollView var4, TextView var5, TextView var6, TextView var7, TextView var8, TextView var9, TextView var10, TextView var11) {
      this.rootView = var1;
      this.buttonNext = var2;
      this.rootLayout = var3;
      this.scrollable = var4;
      this.textAddDeviceSubtitle = var5;
      this.textAddDeviceTitle = var6;
      this.textBulletFour = var7;
      this.textBulletOne = var8;
      this.textBulletThree = var9;
      this.textBulletTwo = var10;
      this.textWrongWifi = var11;
   }

   public static FragmentAddDeviceSetupTextClassicBinding bind(View var0) {
      int var1 = R.id.buttonNext;
      MaterialButton var7 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var7 != null) {
         var1 = R.id.rootLayout;
         ConstraintLayout var6 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
         if (var6 != null) {
            ScrollView var3 = (ScrollView)var0;
            var1 = R.id.textAddDeviceSubtitle;
            TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               var1 = R.id.textAddDeviceTitle;
               TextView var11 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var11 != null) {
                  var1 = R.id.textBulletFour;
                  TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var8 != null) {
                     var1 = R.id.textBulletOne;
                     TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var2 != null) {
                        var1 = R.id.textBulletThree;
                        TextView var10 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var10 != null) {
                           var1 = R.id.textBulletTwo;
                           TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var9 != null) {
                              var1 = R.id.textWrongWifi;
                              TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                              if (var5 != null) {
                                 return new FragmentAddDeviceSetupTextClassicBinding(var3, var7, var6, var3, var4, var11, var8, var2, var10, var9, var5);
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

   public static FragmentAddDeviceSetupTextClassicBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentAddDeviceSetupTextClassicBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_add_device_setup_text_classic, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ScrollView getRoot() {
      return this.rootView;
   }
}
