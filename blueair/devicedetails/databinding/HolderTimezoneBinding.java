package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderTimezoneBinding implements ViewBinding {
   public final ImageView checkMark;
   public final TextView displayName;
   private final ConstraintLayout rootView;
   public final TextView timezone;

   private HolderTimezoneBinding(ConstraintLayout var1, ImageView var2, TextView var3, TextView var4) {
      this.rootView = var1;
      this.checkMark = var2;
      this.displayName = var3;
      this.timezone = var4;
   }

   public static HolderTimezoneBinding bind(View var0) {
      int var1 = R.id.check_mark;
      ImageView var4 = (ImageView)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.display_name;
         TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            var1 = R.id.timezone;
            TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               return new HolderTimezoneBinding((ConstraintLayout)var0, var4, var3, var2);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderTimezoneBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderTimezoneBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_timezone, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
