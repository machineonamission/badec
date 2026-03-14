package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.dd.ShadowLayout;

public final class HolderScannedDeviceBinding implements ViewBinding {
   public final ConstraintLayout clRoot;
   public final TextView connectedLabel;
   public final AppCompatImageView deviceImg;
   public final Group groupMac;
   public final TextView macNumber;
   public final TextView macNumberTitle;
   public final TextView model;
   public final TextView name;
   private final ShadowLayout rootView;
   public final ShadowLayout slRoot;
   public final TextView tvOnlineStatus;

   private HolderScannedDeviceBinding(ShadowLayout var1, ConstraintLayout var2, TextView var3, AppCompatImageView var4, Group var5, TextView var6, TextView var7, TextView var8, TextView var9, ShadowLayout var10, TextView var11) {
      this.rootView = var1;
      this.clRoot = var2;
      this.connectedLabel = var3;
      this.deviceImg = var4;
      this.groupMac = var5;
      this.macNumber = var6;
      this.macNumberTitle = var7;
      this.model = var8;
      this.name = var9;
      this.slRoot = var10;
      this.tvOnlineStatus = var11;
   }

   public static HolderScannedDeviceBinding bind(View var0) {
      int var1 = R.id.cl_root;
      ConstraintLayout var8 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
      if (var8 != null) {
         var1 = R.id.connected_label;
         TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var9 != null) {
            var1 = R.id.device_img;
            AppCompatImageView var10 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
            if (var10 != null) {
               var1 = R.id.group_mac;
               Group var4 = (Group)ViewBindings.findChildViewById(var0, var1);
               if (var4 != null) {
                  var1 = R.id.mac_number;
                  TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var3 != null) {
                     var1 = R.id.mac_number_title;
                     TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var2 != null) {
                        var1 = R.id.model;
                        TextView var11 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var11 != null) {
                           var1 = R.id.name;
                           TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var7 != null) {
                              ShadowLayout var5 = (ShadowLayout)var0;
                              var1 = R.id.tv_onlineStatus;
                              TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                              if (var6 != null) {
                                 return new HolderScannedDeviceBinding(var5, var8, var9, var10, var4, var3, var2, var11, var7, var5, var6);
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

   public static HolderScannedDeviceBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderScannedDeviceBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_scanned_device, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ShadowLayout getRoot() {
      return this.rootView;
   }
}
