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
import com.blueair.viewcore.view.SwitchCompat;
import com.dd.ShadowLayout;

public final class HolderDeviceHinsPureBinding implements ViewBinding {
   public final ConstraintLayout clContainer;
   public final ImageView ivInfo;
   public final ImageView leadingIcon;
   private final ShadowLayout rootView;
   public final SwitchCompat switchMode;
   public final TextView title;

   private HolderDeviceHinsPureBinding(ShadowLayout var1, ConstraintLayout var2, ImageView var3, ImageView var4, SwitchCompat var5, TextView var6) {
      this.rootView = var1;
      this.clContainer = var2;
      this.ivInfo = var3;
      this.leadingIcon = var4;
      this.switchMode = var5;
      this.title = var6;
   }

   public static HolderDeviceHinsPureBinding bind(View var0) {
      int var1 = R.id.cl_container;
      ConstraintLayout var4 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.iv_info;
         ImageView var2 = (ImageView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.leading_icon;
            ImageView var5 = (ImageView)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.switch_mode;
               SwitchCompat var3 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
               if (var3 != null) {
                  var1 = R.id.title;
                  TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var6 != null) {
                     return new HolderDeviceHinsPureBinding((ShadowLayout)var0, var4, var2, var5, var3, var6);
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceHinsPureBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceHinsPureBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_hins_pure, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ShadowLayout getRoot() {
      return this.rootView;
   }
}
