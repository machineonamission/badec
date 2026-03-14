package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class HolderDeviceFilterPurchaseBinding implements ViewBinding {
   public final MaterialButton buttonFilterPurchase;
   private final RelativeLayout rootView;

   private HolderDeviceFilterPurchaseBinding(RelativeLayout var1, MaterialButton var2) {
      this.rootView = var1;
      this.buttonFilterPurchase = var2;
   }

   public static HolderDeviceFilterPurchaseBinding bind(View var0) {
      int var1 = R.id.buttonFilterPurchase;
      MaterialButton var2 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         return new HolderDeviceFilterPurchaseBinding((RelativeLayout)var0, var2);
      } else {
         throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
      }
   }

   public static HolderDeviceFilterPurchaseBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceFilterPurchaseBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_filter_purchase, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public RelativeLayout getRoot() {
      return this.rootView;
   }
}
