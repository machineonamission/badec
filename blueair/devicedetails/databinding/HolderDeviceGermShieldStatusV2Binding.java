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

public final class HolderDeviceGermShieldStatusV2Binding implements ViewBinding {
   public final ConstraintLayout clContainer;
   public final ImageView ivInfo;
   public final ImageView leadingIcon;
   private final ShadowLayout rootView;
   public final ShadowLayout slContainer;
   public final SwitchCompat switchMode;
   public final TextView tvTitle;

   private HolderDeviceGermShieldStatusV2Binding(ShadowLayout var1, ConstraintLayout var2, ImageView var3, ImageView var4, ShadowLayout var5, SwitchCompat var6, TextView var7) {
      this.rootView = var1;
      this.clContainer = var2;
      this.ivInfo = var3;
      this.leadingIcon = var4;
      this.slContainer = var5;
      this.switchMode = var6;
      this.tvTitle = var7;
   }

   public static HolderDeviceGermShieldStatusV2Binding bind(View var0) {
      int var1 = R.id.cl_container;
      ConstraintLayout var5 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
      if (var5 != null) {
         var1 = R.id.iv_info;
         ImageView var4 = (ImageView)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.leading_icon;
            ImageView var2 = (ImageView)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               ShadowLayout var7 = (ShadowLayout)var0;
               var1 = R.id.switch_mode;
               SwitchCompat var3 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
               if (var3 != null) {
                  var1 = R.id.tv_title;
                  TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var6 != null) {
                     return new HolderDeviceGermShieldStatusV2Binding(var7, var5, var4, var2, var7, var3, var6);
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceGermShieldStatusV2Binding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceGermShieldStatusV2Binding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_germ_shield_status_v2, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ShadowLayout getRoot() {
      return this.rootView;
   }
}
