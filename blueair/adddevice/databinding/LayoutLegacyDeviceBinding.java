package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;

public final class LayoutLegacyDeviceBinding implements ViewBinding {
   public final ImageView ivImage;
   private final LinearLayout rootView;
   public final TextView tvTitle;

   private LayoutLegacyDeviceBinding(LinearLayout var1, ImageView var2, TextView var3) {
      this.rootView = var1;
      this.ivImage = var2;
      this.tvTitle = var3;
   }

   public static LayoutLegacyDeviceBinding bind(View var0) {
      int var1 = R.id.iv_image;
      ImageView var3 = (ImageView)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.tv_title;
         TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            return new LayoutLegacyDeviceBinding((LinearLayout)var0, var3, var2);
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static LayoutLegacyDeviceBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static LayoutLegacyDeviceBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.layout_legacy_device, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
