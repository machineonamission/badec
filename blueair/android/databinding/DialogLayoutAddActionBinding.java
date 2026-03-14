package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;

public final class DialogLayoutAddActionBinding implements ViewBinding {
   private final LinearLayoutCompat rootView;
   public final AppCompatTextView tvAddProduct;
   public final AppCompatTextView tvScanFilter;

   private DialogLayoutAddActionBinding(LinearLayoutCompat var1, AppCompatTextView var2, AppCompatTextView var3) {
      this.rootView = var1;
      this.tvAddProduct = var2;
      this.tvScanFilter = var3;
   }

   public static DialogLayoutAddActionBinding bind(View var0) {
      int var1 = R.id.tv_addProduct;
      AppCompatTextView var2 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.tv_scanFilter;
         AppCompatTextView var3 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            return new DialogLayoutAddActionBinding((LinearLayoutCompat)var0, var2, var3);
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static DialogLayoutAddActionBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogLayoutAddActionBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialog_layout_add_action, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayoutCompat getRoot() {
      return this.rootView;
   }
}
