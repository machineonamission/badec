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

public final class FragmentRegionMismatchBinding implements ViewBinding {
   public final MaterialButton buttonClose;
   public final MaterialButton buttonRegister;
   public final ConstraintLayout rootLayout;
   private final ConstraintLayout rootView;
   public final TextView textError;
   public final TextView textTitle;

   private FragmentRegionMismatchBinding(ConstraintLayout var1, MaterialButton var2, MaterialButton var3, ConstraintLayout var4, TextView var5, TextView var6) {
      this.rootView = var1;
      this.buttonClose = var2;
      this.buttonRegister = var3;
      this.rootLayout = var4;
      this.textError = var5;
      this.textTitle = var6;
   }

   public static FragmentRegionMismatchBinding bind(View var0) {
      int var1 = R.id.buttonClose;
      MaterialButton var2 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.buttonRegister;
         MaterialButton var6 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var6 != null) {
            ConstraintLayout var3 = (ConstraintLayout)var0;
            var1 = R.id.textError;
            TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.textTitle;
               TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var4 != null) {
                  return new FragmentRegionMismatchBinding(var3, var2, var6, var3, var5, var4);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static FragmentRegionMismatchBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentRegionMismatchBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_region_mismatch, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
