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
import com.dd.ShadowLayout;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public final class HolderDeviceDisinfectingBinding implements ViewBinding {
   public final ConstraintLayout clContainer;
   public final TextView durationText;
   public final ImageView infoIcon;
   public final ImageView leadingIcon;
   public final LinearProgressIndicator progressIndicator;
   private final ShadowLayout rootView;
   public final TextView title;
   public final TextView tvLeft;

   private HolderDeviceDisinfectingBinding(ShadowLayout var1, ConstraintLayout var2, TextView var3, ImageView var4, ImageView var5, LinearProgressIndicator var6, TextView var7, TextView var8) {
      this.rootView = var1;
      this.clContainer = var2;
      this.durationText = var3;
      this.infoIcon = var4;
      this.leadingIcon = var5;
      this.progressIndicator = var6;
      this.title = var7;
      this.tvLeft = var8;
   }

   public static HolderDeviceDisinfectingBinding bind(View var0) {
      int var1 = R.id.cl_container;
      ConstraintLayout var2 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.duration_text;
         TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var5 != null) {
            var1 = R.id.info_icon;
            ImageView var4 = (ImageView)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               var1 = R.id.leading_icon;
               ImageView var7 = (ImageView)ViewBindings.findChildViewById(var0, var1);
               if (var7 != null) {
                  var1 = R.id.progress_indicator;
                  LinearProgressIndicator var3 = (LinearProgressIndicator)ViewBindings.findChildViewById(var0, var1);
                  if (var3 != null) {
                     var1 = R.id.title;
                     TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var8 != null) {
                        var1 = R.id.tv_left;
                        TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var6 != null) {
                           return new HolderDeviceDisinfectingBinding((ShadowLayout)var0, var2, var5, var4, var7, var3, var8, var6);
                        }
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceDisinfectingBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceDisinfectingBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_disinfecting, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ShadowLayout getRoot() {
      return this.rootView;
   }
}
