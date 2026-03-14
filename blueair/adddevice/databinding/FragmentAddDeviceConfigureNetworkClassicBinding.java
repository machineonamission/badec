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
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public final class FragmentAddDeviceConfigureNetworkClassicBinding implements ViewBinding {
   public final MaterialButton buttonNext;
   public final TextInputEditText editTextPassword;
   public final TextView editTextSSID;
   public final TextInputLayout passwordViewContainer;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final TextView textAddDeviceSubtitle;
   public final TextView textAddDeviceTitle;

   private FragmentAddDeviceConfigureNetworkClassicBinding(ConstraintLayout var1, MaterialButton var2, TextInputEditText var3, TextView var4, TextInputLayout var5, ConstraintLayout var6, TextView var7, TextView var8) {
      this.rootView = var1;
      this.buttonNext = var2;
      this.editTextPassword = var3;
      this.editTextSSID = var4;
      this.passwordViewContainer = var5;
      this.rootLayout = var6;
      this.textAddDeviceSubtitle = var7;
      this.textAddDeviceTitle = var8;
   }

   public static FragmentAddDeviceConfigureNetworkClassicBinding bind(View var0) {
      int var1 = R.id.buttonNext;
      MaterialButton var2 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.editTextPassword;
         TextInputEditText var7 = (TextInputEditText)ViewBindings.findChildViewById(var0, var1);
         if (var7 != null) {
            var1 = R.id.editTextSSID;
            TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               var1 = R.id.passwordViewContainer;
               TextInputLayout var8 = (TextInputLayout)ViewBindings.findChildViewById(var0, var1);
               if (var8 != null) {
                  ConstraintLayout var5 = (ConstraintLayout)var0;
                  var1 = R.id.textAddDeviceSubtitle;
                  TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var3 != null) {
                     var1 = R.id.textAddDeviceTitle;
                     TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var4 != null) {
                        return new FragmentAddDeviceConfigureNetworkClassicBinding(var5, var2, var7, var6, var8, var5, var3, var4);
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentAddDeviceConfigureNetworkClassicBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentAddDeviceConfigureNetworkClassicBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_add_device_configure_network_classic, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
