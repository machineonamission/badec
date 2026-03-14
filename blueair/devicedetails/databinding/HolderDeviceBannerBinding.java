package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceBannerBinding implements ViewBinding {
   public final Guideline bottomGuideline;
   public final ImageButton closeBtn;
   public final Guideline endGuideline;
   public final TextView message;
   private final FrameLayout rootView;
   public final Guideline startGuideline;
   public final TextView title;
   public final Guideline topGuideline;
   public final ImageView warningIcon;

   private HolderDeviceBannerBinding(FrameLayout var1, Guideline var2, ImageButton var3, Guideline var4, TextView var5, Guideline var6, TextView var7, Guideline var8, ImageView var9) {
      this.rootView = var1;
      this.bottomGuideline = var2;
      this.closeBtn = var3;
      this.endGuideline = var4;
      this.message = var5;
      this.startGuideline = var6;
      this.title = var7;
      this.topGuideline = var8;
      this.warningIcon = var9;
   }

   public static HolderDeviceBannerBinding bind(View var0) {
      int var1 = R.id.bottom_guideline;
      Guideline var6 = (Guideline)ViewBindings.findChildViewById(var0, var1);
      if (var6 != null) {
         var1 = R.id.close_btn;
         ImageButton var5 = (ImageButton)ViewBindings.findChildViewById(var0, var1);
         if (var5 != null) {
            var1 = R.id.end_guideline;
            Guideline var4 = (Guideline)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               var1 = R.id.message;
               TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var7 != null) {
                  var1 = R.id.start_guideline;
                  Guideline var9 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                  if (var9 != null) {
                     var1 = R.id.title;
                     TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var3 != null) {
                        var1 = R.id.top_guideline;
                        Guideline var8 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                        if (var8 != null) {
                           var1 = R.id.warning_icon;
                           ImageView var2 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                           if (var2 != null) {
                              return new HolderDeviceBannerBinding((FrameLayout)var0, var6, var5, var4, var7, var9, var3, var8, var2);
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

   public static HolderDeviceBannerBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceBannerBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_banner, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
