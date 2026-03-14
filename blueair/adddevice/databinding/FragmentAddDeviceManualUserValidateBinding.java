package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentAddDeviceManualUserValidateBinding implements ViewBinding {
   public final MaterialButton buttonNo;
   public final MaterialButton buttonYes;
   public final ImageView imageAuto;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final TextView textAddDeviceSubtitle;
   public final TextView textAddDeviceSubtitleThree;
   public final TextView textAddDeviceSubtitleTwo;
   public final TextView textAddDeviceTitle;

   private FragmentAddDeviceManualUserValidateBinding(ConstraintLayout var1, MaterialButton var2, MaterialButton var3, ImageView var4, ConstraintLayout var5, TextView var6, TextView var7, TextView var8, TextView var9) {
      this.rootView = var1;
      this.buttonNo = var2;
      this.buttonYes = var3;
      this.imageAuto = var4;
      this.rootLayout = var5;
      this.textAddDeviceSubtitle = var6;
      this.textAddDeviceSubtitleThree = var7;
      this.textAddDeviceSubtitleTwo = var8;
      this.textAddDeviceTitle = var9;
   }

   public static FragmentAddDeviceManualUserValidateBinding bind(View var0) {
      int var1 = R.id.buttonNo;
      MaterialButton var6 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var6 != null) {
         var1 = R.id.buttonYes;
         MaterialButton var9 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var9 != null) {
            var1 = R.id.imageAuto;
            ImageView var7 = (ImageView)ViewBindings.findChildViewById(var0, var1);
            if (var7 != null) {
               ConstraintLayout var4 = (ConstraintLayout)var0;
               var1 = R.id.textAddDeviceSubtitle;
               TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var8 != null) {
                  var1 = R.id.textAddDeviceSubtitleThree;
                  TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var2 != null) {
                     var1 = R.id.textAddDeviceSubtitleTwo;
                     TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var3 != null) {
                        var1 = R.id.textAddDeviceTitle;
                        TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var5 != null) {
                           return new FragmentAddDeviceManualUserValidateBinding(var4, var6, var9, var7, var4, var8, var2, var3, var5);
                        }
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentAddDeviceManualUserValidateBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentAddDeviceManualUserValidateBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_add_device_manual_user_validate, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
