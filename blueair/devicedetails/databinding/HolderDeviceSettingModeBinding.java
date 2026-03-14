package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SwitchCompat;

public final class HolderDeviceSettingModeBinding implements ViewBinding {
   public final Guideline leftGuideline;
   public final Guideline rightGuideline;
   private final ConstraintLayout rootView;
   public final TextView settingSummary;
   public final SwitchCompat settingSwitch;
   public final TextView settingTitle;

   private HolderDeviceSettingModeBinding(ConstraintLayout var1, Guideline var2, Guideline var3, TextView var4, SwitchCompat var5, TextView var6) {
      this.rootView = var1;
      this.leftGuideline = var2;
      this.rightGuideline = var3;
      this.settingSummary = var4;
      this.settingSwitch = var5;
      this.settingTitle = var6;
   }

   public static HolderDeviceSettingModeBinding bind(View var0) {
      int var1 = R.id.left_guideline;
      Guideline var2 = (Guideline)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.right_guideline;
         Guideline var3 = (Guideline)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            var1 = R.id.setting_summary;
            TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.setting_switch;
               SwitchCompat var6 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
               if (var6 != null) {
                  var1 = R.id.setting_title;
                  TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var4 != null) {
                     return new HolderDeviceSettingModeBinding((ConstraintLayout)var0, var2, var3, var5, var6, var4);
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceSettingModeBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceSettingModeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_setting_mode, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
