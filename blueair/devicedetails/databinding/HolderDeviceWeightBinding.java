package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class HolderDeviceWeightBinding implements ViewBinding {
   private final FrameLayout rootView;
   public final MaterialButton tareBtn;
   public final TextView title;
   public final TextView weightValue;

   private HolderDeviceWeightBinding(FrameLayout var1, MaterialButton var2, TextView var3, TextView var4) {
      this.rootView = var1;
      this.tareBtn = var2;
      this.title = var3;
      this.weightValue = var4;
   }

   public static HolderDeviceWeightBinding bind(View var0) {
      int var1 = R.id.tare_btn;
      MaterialButton var2 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.title;
         TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            var1 = R.id.weight_value;
            TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               return new HolderDeviceWeightBinding((FrameLayout)var0, var2, var3, var4);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceWeightBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceWeightBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_weight, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
