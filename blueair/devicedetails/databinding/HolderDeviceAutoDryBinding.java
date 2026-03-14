package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public final class HolderDeviceAutoDryBinding implements ViewBinding {
   public final MaterialButton btnCancel;
   public final ConstraintLayout clContainer;
   public final TextView durationText;
   public final Group expendedContent;
   public final ImageView infoIcon;
   public final ImageView leadingIcon;
   public final LinearProgressIndicator progressIndicator;
   private final ShadowLayout rootView;
   public final TextView title;
   public final TextView tvLeft;

   private HolderDeviceAutoDryBinding(ShadowLayout var1, MaterialButton var2, ConstraintLayout var3, TextView var4, Group var5, ImageView var6, ImageView var7, LinearProgressIndicator var8, TextView var9, TextView var10) {
      this.rootView = var1;
      this.btnCancel = var2;
      this.clContainer = var3;
      this.durationText = var4;
      this.expendedContent = var5;
      this.infoIcon = var6;
      this.leadingIcon = var7;
      this.progressIndicator = var8;
      this.title = var9;
      this.tvLeft = var10;
   }

   public static HolderDeviceAutoDryBinding bind(View var0) {
      int var1 = R.id.btn_cancel;
      MaterialButton var4 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.cl_container;
         ConstraintLayout var3 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            var1 = R.id.duration_text;
            TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               var1 = R.id.expended_content;
               Group var9 = (Group)ViewBindings.findChildViewById(var0, var1);
               if (var9 != null) {
                  var1 = R.id.info_icon;
                  ImageView var5 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                  if (var5 != null) {
                     var1 = R.id.leading_icon;
                     ImageView var7 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                     if (var7 != null) {
                        var1 = R.id.progress_indicator;
                        LinearProgressIndicator var10 = (LinearProgressIndicator)ViewBindings.findChildViewById(var0, var1);
                        if (var10 != null) {
                           var1 = R.id.title;
                           TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var8 != null) {
                              var1 = R.id.tv_left;
                              TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                              if (var6 != null) {
                                 return new HolderDeviceAutoDryBinding((ShadowLayout)var0, var4, var3, var2, var9, var5, var7, var10, var8, var6);
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

   public static HolderDeviceAutoDryBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceAutoDryBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_auto_dry, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ShadowLayout getRoot() {
      return this.rootView;
   }
}
