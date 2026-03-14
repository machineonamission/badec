package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class BottomSheetFilterOrderBinding implements ViewBinding {
   public final MaterialButton btnCancel;
   public final MaterialButton buttonFilterOneTimePurchase;
   public final MaterialButton buttonFilterSubscription;
   private final LinearLayout rootView;

   private BottomSheetFilterOrderBinding(LinearLayout var1, MaterialButton var2, MaterialButton var3, MaterialButton var4) {
      this.rootView = var1;
      this.btnCancel = var2;
      this.buttonFilterOneTimePurchase = var3;
      this.buttonFilterSubscription = var4;
   }

   public static BottomSheetFilterOrderBinding bind(View var0) {
      int var1 = R.id.btnCancel;
      MaterialButton var4 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.buttonFilterOneTimePurchase;
         MaterialButton var3 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            var1 = R.id.buttonFilterSubscription;
            MaterialButton var2 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               return new BottomSheetFilterOrderBinding((LinearLayout)var0, var4, var3, var2);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static BottomSheetFilterOrderBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static BottomSheetFilterOrderBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.bottom_sheet_filter_order, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
