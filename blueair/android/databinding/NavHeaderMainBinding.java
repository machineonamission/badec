package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;

public final class NavHeaderMainBinding implements ViewBinding {
   public final ImageView imageView;
   private final LinearLayout rootView;
   public final TextView textViewUserName;

   private NavHeaderMainBinding(LinearLayout var1, ImageView var2, TextView var3) {
      this.rootView = var1;
      this.imageView = var2;
      this.textViewUserName = var3;
   }

   public static NavHeaderMainBinding bind(View var0) {
      int var1 = R.id.imageView;
      ImageView var2 = (ImageView)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.textViewUserName;
         TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            return new NavHeaderMainBinding((LinearLayout)var0, var2, var3);
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static NavHeaderMainBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static NavHeaderMainBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.nav_header_main, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
