package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.view.ButtonTileConstraintLayout;

public final class HolderDeviceRegularSettingBinding implements ViewBinding {
   public final Guideline leftGuideline;
   public final ButtonTileConstraintLayout regularSettingLayout;
   public final Guideline rightGuideline;
   private final ButtonTileConstraintLayout rootView;
   public final AppCompatImageView settingArrow;
   public final TextView settingTitle;
   public final TextView settingValue;

   private HolderDeviceRegularSettingBinding(ButtonTileConstraintLayout var1, Guideline var2, ButtonTileConstraintLayout var3, Guideline var4, AppCompatImageView var5, TextView var6, TextView var7) {
      this.rootView = var1;
      this.leftGuideline = var2;
      this.regularSettingLayout = var3;
      this.rightGuideline = var4;
      this.settingArrow = var5;
      this.settingTitle = var6;
      this.settingValue = var7;
   }

   public static HolderDeviceRegularSettingBinding bind(View var0) {
      int var1 = R.id.left_guideline;
      Guideline var3 = (Guideline)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         ButtonTileConstraintLayout var7 = (ButtonTileConstraintLayout)var0;
         var1 = R.id.right_guideline;
         Guideline var6 = (Guideline)ViewBindings.findChildViewById(var0, var1);
         if (var6 != null) {
            var1 = R.id.setting_arrow;
            AppCompatImageView var4 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               var1 = R.id.setting_title;
               TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  var1 = R.id.setting_value;
                  TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var5 != null) {
                     return new HolderDeviceRegularSettingBinding(var7, var3, var7, var6, var4, var2, var5);
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceRegularSettingBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceRegularSettingBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_regular_setting, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ButtonTileConstraintLayout getRoot() {
      return this.rootView;
   }
}
