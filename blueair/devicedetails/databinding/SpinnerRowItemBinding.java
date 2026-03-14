package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class SpinnerRowItemBinding implements ViewBinding {
   private final LinearLayout rootView;
   public final TextView row;
   public final LinearLayout spinnerLayout;

   private SpinnerRowItemBinding(LinearLayout var1, TextView var2, LinearLayout var3) {
      this.rootView = var1;
      this.row = var2;
      this.spinnerLayout = var3;
   }

   public static SpinnerRowItemBinding bind(View var0) {
      int var1 = R.id.row;
      TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         LinearLayout var3 = (LinearLayout)var0;
         return new SpinnerRowItemBinding(var3, var2, var3);
      } else {
         throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
      }
   }

   public static SpinnerRowItemBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static SpinnerRowItemBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.spinner_row_item, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
