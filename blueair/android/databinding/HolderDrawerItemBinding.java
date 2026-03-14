package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;

public final class HolderDrawerItemBinding implements ViewBinding {
   public final AppCompatImageView ivLeading;
   private final LinearLayout rootView;
   public final AppCompatTextView tvName;

   private HolderDrawerItemBinding(LinearLayout var1, AppCompatImageView var2, AppCompatTextView var3) {
      this.rootView = var1;
      this.ivLeading = var2;
      this.tvName = var3;
   }

   public static HolderDrawerItemBinding bind(View var0) {
      int var1 = R.id.iv_leading;
      AppCompatImageView var2 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.tv_name;
         AppCompatTextView var3 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            return new HolderDrawerItemBinding((LinearLayout)var0, var2, var3);
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDrawerItemBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDrawerItemBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_drawer_item, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
