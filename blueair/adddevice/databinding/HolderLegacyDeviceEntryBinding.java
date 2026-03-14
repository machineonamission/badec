package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.dd.ShadowLayout;

public final class HolderLegacyDeviceEntryBinding implements ViewBinding {
   public final ConstraintLayout clRoot;
   public final LayoutLegacyDeviceBinding layoutAware;
   public final LayoutLegacyDeviceBinding layoutClassic;
   public final LayoutLegacyDeviceBinding layoutIcp;
   public final LayoutLegacyDeviceBinding layoutSense;
   public final TextView name;
   private final ShadowLayout rootView;
   public final ShadowLayout slRoot;
   public final TextView tvSelect;

   private HolderLegacyDeviceEntryBinding(ShadowLayout var1, ConstraintLayout var2, LayoutLegacyDeviceBinding var3, LayoutLegacyDeviceBinding var4, LayoutLegacyDeviceBinding var5, LayoutLegacyDeviceBinding var6, TextView var7, ShadowLayout var8, TextView var9) {
      this.rootView = var1;
      this.clRoot = var2;
      this.layoutAware = var3;
      this.layoutClassic = var4;
      this.layoutIcp = var5;
      this.layoutSense = var6;
      this.name = var7;
      this.slRoot = var8;
      this.tvSelect = var9;
   }

   public static HolderLegacyDeviceEntryBinding bind(View var0) {
      int var1 = R.id.cl_root;
      ConstraintLayout var2 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.layout_aware;
         View var3 = ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            LayoutLegacyDeviceBinding var10 = LayoutLegacyDeviceBinding.bind(var3);
            var1 = R.id.layout_classic;
            View var4 = ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               LayoutLegacyDeviceBinding var11 = LayoutLegacyDeviceBinding.bind(var4);
               var1 = R.id.layout_icp;
               View var5 = ViewBindings.findChildViewById(var0, var1);
               if (var5 != null) {
                  LayoutLegacyDeviceBinding var12 = LayoutLegacyDeviceBinding.bind(var5);
                  var1 = R.id.layout_sense;
                  View var6 = ViewBindings.findChildViewById(var0, var1);
                  if (var6 != null) {
                     LayoutLegacyDeviceBinding var13 = LayoutLegacyDeviceBinding.bind(var6);
                     var1 = R.id.name;
                     TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var8 != null) {
                        ShadowLayout var7 = (ShadowLayout)var0;
                        var1 = R.id.tv_select;
                        TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var9 != null) {
                           return new HolderLegacyDeviceEntryBinding(var7, var2, var10, var11, var12, var13, var8, var7, var9);
                        }
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderLegacyDeviceEntryBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderLegacyDeviceEntryBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_legacy_device_entry, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ShadowLayout getRoot() {
      return this.rootView;
   }
}
