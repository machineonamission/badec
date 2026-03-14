package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.dd.ShadowLayout;

public final class HolderDeviceModelBinding implements ViewBinding {
   public final LinearLayout layoutModel;
   public final AppCompatImageView modelImage;
   public final TextView modelName;
   private final ShadowLayout rootView;
   public final ShadowLayout slRoot;

   private HolderDeviceModelBinding(ShadowLayout var1, LinearLayout var2, AppCompatImageView var3, TextView var4, ShadowLayout var5) {
      this.rootView = var1;
      this.layoutModel = var2;
      this.modelImage = var3;
      this.modelName = var4;
      this.slRoot = var5;
   }

   public static HolderDeviceModelBinding bind(View var0) {
      int var1 = R.id.layout_model;
      LinearLayout var3 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.model_image;
         AppCompatImageView var4 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.model_name;
            TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               ShadowLayout var5 = (ShadowLayout)var0;
               return new HolderDeviceModelBinding(var5, var3, var4, var2, var5);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceModelBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceModelBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_model, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ShadowLayout getRoot() {
      return this.rootView;
   }
}
