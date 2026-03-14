package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class HolderDeviceAutolevelBinding implements ViewBinding {
   public final LinearLayout btnGroupLevel;
   public final MaterialButton btnHigh;
   public final MaterialButton btnLow;
   public final MaterialButton btnMedium;
   public final ConstraintLayout contentContainer;
   public final HolderDeviceHintBinding hintLevel;
   public final ImageView ivInfo;
   public final ImageView leadingIcon;
   private final ConstraintLayout rootView;
   public final TextView title;
   public final TextView tvFanspeed;
   public final TextView tvSpeedValue;

   private HolderDeviceAutolevelBinding(ConstraintLayout var1, LinearLayout var2, MaterialButton var3, MaterialButton var4, MaterialButton var5, ConstraintLayout var6, HolderDeviceHintBinding var7, ImageView var8, ImageView var9, TextView var10, TextView var11, TextView var12) {
      this.rootView = var1;
      this.btnGroupLevel = var2;
      this.btnHigh = var3;
      this.btnLow = var4;
      this.btnMedium = var5;
      this.contentContainer = var6;
      this.hintLevel = var7;
      this.ivInfo = var8;
      this.leadingIcon = var9;
      this.title = var10;
      this.tvFanspeed = var11;
      this.tvSpeedValue = var12;
   }

   public static HolderDeviceAutolevelBinding bind(View var0) {
      int var1 = R.id.btnGroup_level;
      LinearLayout var6 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
      if (var6 != null) {
         var1 = R.id.btn_high;
         MaterialButton var4 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.btn_low;
            MaterialButton var2 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               var1 = R.id.btn_medium;
               MaterialButton var5 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  ConstraintLayout var3 = (ConstraintLayout)var0;
                  var1 = R.id.hint_level;
                  View var7 = ViewBindings.findChildViewById(var0, var1);
                  if (var7 != null) {
                     HolderDeviceHintBinding var10 = HolderDeviceHintBinding.bind(var7);
                     var1 = R.id.iv_info;
                     ImageView var8 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                     if (var8 != null) {
                        var1 = R.id.leading_icon;
                        ImageView var12 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                        if (var12 != null) {
                           var1 = R.id.title;
                           TextView var11 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var11 != null) {
                              var1 = R.id.tv_fanspeed;
                              TextView var13 = (TextView)ViewBindings.findChildViewById(var0, var1);
                              if (var13 != null) {
                                 var1 = R.id.tv_speedValue;
                                 TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var9 != null) {
                                    return new HolderDeviceAutolevelBinding(var3, var6, var4, var2, var5, var3, var10, var8, var12, var11, var13, var9);
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceAutolevelBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceAutolevelBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_autolevel, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
