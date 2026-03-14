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

public final class FragmentAddDeviceSetNameClassicBinding implements ViewBinding {
   public final MaterialButton buttonNext;
   public final TextInputLayout deviceNameViewContainer;
   public final TextInputEditText editTextDeviceName;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final TextView textAddDeviceTitle;

   private FragmentAddDeviceSetNameClassicBinding(ConstraintLayout var1, MaterialButton var2, TextInputLayout var3, TextInputEditText var4, ConstraintLayout var5, TextView var6) {
      this.rootView = var1;
      this.buttonNext = var2;
      this.deviceNameViewContainer = var3;
      this.editTextDeviceName = var4;
      this.rootLayout = var5;
      this.textAddDeviceTitle = var6;
   }

   public static FragmentAddDeviceSetNameClassicBinding bind(View var0) {
      int var1 = R.id.buttonNext;
      MaterialButton var4 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.deviceNameViewContainer;
         TextInputLayout var5 = (TextInputLayout)ViewBindings.findChildViewById(var0, var1);
         if (var5 != null) {
            var1 = R.id.editTextDeviceName;
            TextInputEditText var6 = (TextInputEditText)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               ConstraintLayout var3 = (ConstraintLayout)var0;
               var1 = R.id.textAddDeviceTitle;
               TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  return new FragmentAddDeviceSetNameClassicBinding(var3, var4, var5, var6, var3, var2);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentAddDeviceSetNameClassicBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentAddDeviceSetNameClassicBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_add_device_set_name_classic, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
