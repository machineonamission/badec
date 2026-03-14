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

public final class HolderDeviceGermShieldNightModeBinding implements ViewBinding {
   public final TextView gsnmDescription;
   public final SwitchCompat gsnmSwitch;
   public final Guideline leftGuideline;
   public final Guideline rightGuideline;
   private final ConstraintLayout rootView;

   private HolderDeviceGermShieldNightModeBinding(ConstraintLayout var1, TextView var2, SwitchCompat var3, Guideline var4, Guideline var5) {
      this.rootView = var1;
      this.gsnmDescription = var2;
      this.gsnmSwitch = var3;
      this.leftGuideline = var4;
      this.rightGuideline = var5;
   }

   public static HolderDeviceGermShieldNightModeBinding bind(View var0) {
      int var1 = R.id.gsnm_description;
      TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.gsnm_switch;
         SwitchCompat var3 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
         if (var3 != null) {
            var1 = R.id.left_guideline;
            Guideline var5 = (Guideline)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.right_guideline;
               Guideline var2 = (Guideline)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  return new HolderDeviceGermShieldNightModeBinding((ConstraintLayout)var0, var4, var3, var5, var2);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceGermShieldNightModeBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceGermShieldNightModeBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_germ_shield_night_mode, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
