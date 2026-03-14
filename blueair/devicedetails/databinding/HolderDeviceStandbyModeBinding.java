package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class HolderDeviceStandbyModeBinding implements ViewBinding {
   public final Guideline bottomGuideline;
   public final AppCompatImageView germshieldIcon;
   public final Guideline leftGuideline;
   public final Guideline rightGuideline;
   private final ConstraintLayout rootView;
   public final View separator;
   public final TextView standbyMessageView;

   private HolderDeviceStandbyModeBinding(ConstraintLayout var1, Guideline var2, AppCompatImageView var3, Guideline var4, Guideline var5, View var6, TextView var7) {
      this.rootView = var1;
      this.bottomGuideline = var2;
      this.germshieldIcon = var3;
      this.leftGuideline = var4;
      this.rightGuideline = var5;
      this.separator = var6;
      this.standbyMessageView = var7;
   }

   public static HolderDeviceStandbyModeBinding bind(View var0) {
      int var1 = R.id.bottom_guideline;
      Guideline var3 = (Guideline)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.germshield_icon;
         AppCompatImageView var6 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
         if (var6 != null) {
            var1 = R.id.left_guideline;
            Guideline var7 = (Guideline)ViewBindings.findChildViewById(var0, var1);
            if (var7 != null) {
               var1 = R.id.right_guideline;
               Guideline var4 = (Guideline)ViewBindings.findChildViewById(var0, var1);
               if (var4 != null) {
                  var1 = R.id.separator;
                  View var5 = ViewBindings.findChildViewById(var0, var1);
                  if (var5 != null) {
                     var1 = R.id.standby_message_view;
                     TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var2 != null) {
                        return new HolderDeviceStandbyModeBinding((ConstraintLayout)var0, var3, var6, var7, var4, var5, var2);
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceStandbyModeBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceStandbyModeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_standby_mode, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
