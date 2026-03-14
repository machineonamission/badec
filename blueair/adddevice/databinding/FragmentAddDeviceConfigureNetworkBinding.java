package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public final class FragmentAddDeviceConfigureNetworkBinding implements ViewBinding {
   public final MaterialButton buttonNext;
   public final EditText editTextPassword;
   public final TextView editTextSSID;
   public final TextInputLayout passwordViewContainer;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final TextView textAddDeviceSubtitle;
   public final TextView textAddDeviceTitle;

   private FragmentAddDeviceConfigureNetworkBinding(ConstraintLayout var1, MaterialButton var2, EditText var3, TextView var4, TextInputLayout var5, ConstraintLayout var6, TextView var7, TextView var8) {
      this.rootView = var1;
      this.buttonNext = var2;
      this.editTextPassword = var3;
      this.editTextSSID = var4;
      this.passwordViewContainer = var5;
      this.rootLayout = var6;
      this.textAddDeviceSubtitle = var7;
      this.textAddDeviceTitle = var8;
   }

   public static FragmentAddDeviceConfigureNetworkBinding bind(View var0) {
      int var1 = R.id.buttonNext;
      MaterialButton var4 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.editTextPassword;
         EditText var2 = (EditText)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.editTextSSID;
            TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.passwordViewContainer;
               TextInputLayout var3 = (TextInputLayout)ViewBindings.findChildViewById(var0, var1);
               if (var3 != null) {
                  ConstraintLayout var7 = (ConstraintLayout)var0;
                  var1 = R.id.textAddDeviceSubtitle;
                  TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var8 != null) {
                     var1 = R.id.textAddDeviceTitle;
                     TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var6 != null) {
                        return new FragmentAddDeviceConfigureNetworkBinding(var7, var4, var2, var5, var3, var7, var8, var6);
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentAddDeviceConfigureNetworkBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentAddDeviceConfigureNetworkBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_add_device_configure_network, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
